package com.sigwarthsoftware.openai.message;

import com.sigwarthsoftware.openai.model.AiModel;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Getter
@Setter
public class ApiCall {
    //============================-Variables-=================================
    String content;
    AiModel aiModel;
    ApiSettings apiSettings;
    String response;
    //===========================-Constructors-===============================
    public ApiCall() {
        this.content = "";
        this.aiModel = AiModel.GPT_4;
        this.apiSettings = ApiSettings.DEFAULT;
        this.content = "";
        this.response = "";
    }
    public ApiCall(AiModel aiModel, ApiSettings apiSettings, String content) {
        this.aiModel = aiModel;
        this.apiSettings = apiSettings;
        this.content = content;
        this.response = "";
    }
    //=============================-Methods-==================================

    //------------------------Fetch-Name-Response-----------------------------
    public void fetchResponse() {
        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(this.aiModel.getUrlPath()))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.apiSettings.getApiKey())
                    .header("Cache-Control", "no-cache")
                    .header("X-Content-Type-Options", "nosniff")
                    .POST(HttpRequest.BodyPublishers.ofString(this.getRequestBody()))
                    .build();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (httpResponse != null) {
                this.response = httpResponse.body();
            } else {
                this.response = "Error";
                throw new RuntimeException("Failed to fetch name response");
            }
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException("Failed to fetch name response", ex);
        }
    }
    //--------------------------Get-Request-Body------------------------------
    public String getRequestBody() {
        return """
                {
                    "model": "%s",
                    "messages": [
                        {
                            "role": "user",
                            "content": "%s"
                        }
                    ],
                    "max_tokens": %d,
                    "temperature": %f
                }""".formatted(this.aiModel.getModelType(),
                this.content,
                this.apiSettings.getMaxTokens(),
                this.apiSettings.getTemperature());
    }
}