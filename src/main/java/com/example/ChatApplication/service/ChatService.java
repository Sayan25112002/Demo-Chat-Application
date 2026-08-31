package com.example.ChatApplication.service;

import com.example.ChatApplication.dto.requestDto.ChatMessageRequestDto;
import com.example.ChatApplication.dto.responseDto.ChatMessageResponseDto;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

public interface ChatService {

    ChatMessageResponseDto sendMessage(@Payload ChatMessageRequestDto chatMessageRequestDto);

    ChatMessageResponseDto addUser(@Payload ChatMessageRequestDto chatMessageRequestDto, SimpMessageHeaderAccessor headerAccessor);

}
