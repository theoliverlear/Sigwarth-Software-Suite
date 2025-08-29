package com.sigwarthsoftware.openai.model;

//=================================-Imports-==================================
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AiModel {
    //============================-Variables-=================================
    private String modelType;
    private String urlPath;
    //============================-Constants-=================================
    public static final AiModel GPT_4 = new AiModel("gpt-4", "https://api.openai.com/v1/chat/completions");
    public static final AiModel GPT_TURBO = new AiModel("gpt-3.5-turbo-instruct", "https://api.openai.com/v1/completions");
    //===========================-Constructors-===============================
    AiModel(String modelType, String urlPath) {
        this.modelType = modelType;
        this.urlPath = urlPath;
    }
}