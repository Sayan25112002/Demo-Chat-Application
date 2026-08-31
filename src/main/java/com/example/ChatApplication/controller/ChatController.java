package com.example.ChatApplication.controller;

import com.example.ChatApplication.dto.requestDto.ChatMessageRequestDto;
import com.example.ChatApplication.dto.responseDto.ChatMessageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessageSendingOperations simpMessageSendingOperations;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessageResponseDto sendMessage(@Payload ChatMessageRequestDto chatMessageRequestDto) {

    }
}
