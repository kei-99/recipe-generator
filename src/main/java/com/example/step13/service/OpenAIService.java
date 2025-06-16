package com.example.step13.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.step13.model.Answer;
import com.example.step13.model.Question;

@Service
public class OpenAIService {

    @Autowired
    private ChatModel chatModel;

    public Answer getResult(Question question) {
    	Prompt prompt = new PromptTemplate(question.question()).create();

        ChatResponse response = chatModel.call(prompt);

        if (response != null && !response.getResults().isEmpty()) {
            return new Answer(response.getResults().get(0).getOutput().getText());
        }

        return new Answer("No response received!!");
    }
}
