package com.example.step13.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    private ChatModel chatModel;

    public String generateRecipe(String ingredients) {
        String promptText = "You are a professional chef. Based on the following ingredients, generate a simple and delicious Japanese recipe:\n" +
                            ingredients + "\n" +
                            "Include a title, ingredients list, and cooking steps in Japanese.";

        Prompt prompt = new PromptTemplate(promptText).create();
        ChatResponse response = chatModel.call(prompt);

        if (response != null && !response.getResults().isEmpty()) {
            return response.getResults().get(0).getOutput().getText();
        }

        return "レシピを生成できませんでした。";
    }
}
