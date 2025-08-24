package com.sigwarthsoftware.openai.message;
//=================================-Imports-==================================
import com.sigwarthsoftware.openai.model.AiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiSettings {
    //============================-Variables-=================================
    private AiModel aiModel;
    private int maxTokens;
    private float temperature;
    private String apiKey;
    //============================-Constants-=================================
    public static final ApiSettings DEFAULT = new ApiSettings(AiModel.GPT_4, 100, 0.7f);
    //===========================-Constructors-===============================
    public ApiSettings(AiModel aiModel, int maxTokens, float temperature) {
        this.aiModel = aiModel;
        this.maxTokens = maxTokens;
        this.temperature = temperature;
        this.apiKey = System.getenv("OPENAI_KEY");
    }
}