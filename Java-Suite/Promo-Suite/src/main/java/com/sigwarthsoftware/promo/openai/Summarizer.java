package com.sigwarthsoftware.promo.openai;

import com.sigwarthsoftware.promo.github.commit.CommitCapture;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Summarizer {
    //============================-Constants-=================================
    private static final int MAX_RETRIES = 5;
    private static final int MAX_POST_LENGTH = 280;
    //============================-Variables-=================================
    private TwitterAiChat chat;
    //===========================-Constructors-===============================
    public Summarizer() {
        this.chat = new TwitterAiChat();
    }

    public static String fromMessagesList(List<String> messages) {
        return "\nCommits:\n" + messages.stream().map(message -> {
            return "- " + message;
        }).collect(Collectors.joining("\n"));
    }
    
    public String summarize(@NotNull CommitCapture commits, String systemMessage, String userMessage) {
        List<String> messages = commits.getMessages();
        return this.summarize(messages, systemMessage, userMessage);
    }

    public String summarize(List<String> commits, String systemMessage, String userMessage) {
        String commitsText = fromMessagesList(commits);
        return this.chat.chat(systemMessage, userMessage + commitsText);
    }
    
    public String summarize(String summarizedContent, String systemMessage, String userMessage) {
        String response = this.chat.chat(systemMessage, userMessage + summarizedContent);
        if (response.length() > 280) {
            return this.summarize(summarizedContent, systemMessage, userMessage, 2);
        }
        return response;
    }
    //-----------------------------Summarize----------------------------------
    public String summarize(String textToSummarize, String systemMessage, String userMessage, int numTries) {
        String response = this.chat.chat(systemMessage, userMessage + textToSummarize);
        log.info("Num tries for summary: {}", numTries);
        if (numTries >= MAX_RETRIES) {
            throw new IllegalStateException("Failed to summarize content after 5 tries.");
        }
        if (response.length() > MAX_POST_LENGTH) {
            return this.summarize(textToSummarize, systemMessage, userMessage, numTries + 1);
        }
        return response;
    }
}
