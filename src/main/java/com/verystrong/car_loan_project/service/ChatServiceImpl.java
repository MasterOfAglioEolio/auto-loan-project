package com.verystrong.car_loan_project.service;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService{

    private final ChatgptService chatgptService;

    @Override
    public String getChatResponse(String prompt) {
        return chatgptService.sendMessage(prompt);
    }
}
