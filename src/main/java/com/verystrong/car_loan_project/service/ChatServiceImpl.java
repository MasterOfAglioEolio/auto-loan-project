package com.verystrong.car_loan_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService{
    @Override
    public String getChatResponse(String prompt) {
        return null;
    }

//    private final ChatgptService chatgptService;
//
//    @Override
//    public String getChatResponse(String prompt) {
//        return chatgptService.sendMessage(prompt);
//    }
}
