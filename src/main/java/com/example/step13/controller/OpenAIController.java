package com.example.step13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.step13.model.Answer;
import com.example.step13.model.Question;
import com.example.step13.service.OpenAIService;

@RestController
@RequestMapping("/api/openai")
public class OpenAIController {

    @Autowired
    private OpenAIService openAIService;

    @PostMapping
    public Answer getAnswer(@RequestBody Question question) {
        return openAIService.getResult(question);
    }
}
