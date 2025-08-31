package com.sigwarthsoftware.changelog;

import com.sigwarthsoftware.changelog.prompt.ChangelogPrompt;
import com.sigwarthsoftware.changelog.version.PomParser;
import com.sigwarthsoftware.changelog.version.models.module.ModuleLibrary;
import com.sigwarthsoftware.openai.OpenAiChat;
import com.sigwarthsoftware.promo.github.commit.CommitCapture;
import com.sigwarthsoftware.promo.github.commit.CommitRange;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class ReleaseChangelogGenerator {
    public static String getTemplateFromFile(String path) {
        try {
            String content = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
            return content;
        } catch (IOException exception) {
            throw new IllegalStateException("Error in reading changelog file.", exception);
        }
    }
    
    public static String getTemplateFromUrl() {
        String[] possibleBranches = {"main", "master"};
        String response = null;
        for (String branch : possibleBranches) {
            // https://raw.githubusercontent.com/theoliverlear/Sigwarth-Software-Suite/refs/heads/master/CHANGELOG.md
            String url = "https://raw.githubusercontent.com/theoliverlear/%s/refs/heads/%s/CHANGELOG.md".formatted(System.getenv("REPO_NAME"), branch);
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("User-Agent", "Sigwarth-Changelog/0.0.2 (+https://github.com/theoliverlear)");
            httpGet.addHeader("Accept", "text/plain; charset=utf-8");
            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
                    System.out.println(httpResponse.getEntity().getContent().toString());
                    int statusCode = httpResponse.getStatusLine().getStatusCode();
                    if (statusCode == 200 && httpResponse.getEntity() != null) {
                        response = EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8);
                        break;
                    }
                }

            } catch (IOException exception) {
                continue;
            }
        }
        if (response == null || response.isBlank()) {
            throw new IllegalStateException("Unable to find changelog file in any of the branches.");
        }
        return response;
    }

    public static String getChangelog(CommitRange commitRange, String releaseVersion) {
        return getChangelog(commitRange, releaseVersion, getTemplateFromUrl());
    }
    
    public static String getChangelog(CommitRange commitRange, String releaseVersion, String changelogFormat) {
        String systemPrompt = ChangelogPrompt.SYSTEM.getText().formatted(changelogFormat);
        CommitCapture capture = new CommitCapture(commitRange);
        String allVersions = PomParser.getVersionString();
        String userPrompt = ChangelogPrompt.USER.getText().formatted(allVersions, releaseVersion, LocalDate.now().toString());
        List<String> messages = capture.getMessages();
        userPrompt += String.join("\n", messages);
        OpenAiChat chat = new OpenAiChat();
        String response = chat.chat(systemPrompt, userPrompt);
        writeVersionedFile(response, releaseVersion);
        return response;
    }
    
    private static void writeVersionedFile(String markdown, String releaseVersion) {
        String fileName = "%s.md".formatted(releaseVersion);
        try {
            Files.writeString(Paths.get(fileName), markdown, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new IllegalStateException("Error in writing changelog file.", exception);
        }
    }
}
