package com.example.ChatApplication.service.implementation;

import com.example.ChatApplication.dto.requestDto.ChatMessageRequestDto;
import com.example.ChatApplication.dto.responseDto.ChatMessageResponseDto;
import com.example.ChatApplication.entity.ChatMessage;
import com.example.ChatApplication.mapper.ChatMapper;
import com.example.ChatApplication.repository.ChatRepository;
import com.example.ChatApplication.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final ChatMapper chatMapper;

    @Override
    public ChatMessageResponseDto sendMessage(ChatMessageRequestDto chatMessageRequestDto) {
        ChatMessage chatMessage = chatMapper.toChatMessage(chatMessageRequestDto);
        ChatMessage savedChatMessage = chatRepository.save(chatMessage);
        return chatMapper.toChatMessageResponseDto(savedChatMessage);
    }

    @Override
    public ChatMessageResponseDto addUser(ChatMessageRequestDto chatMessageRequestDto, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", headerAccessor.getSessionAttributes().get("username"));
        return chatMapper.toChatMessageResponseDto(chatRepository.save(chatMapper.toChatMessage(chatMessageRequestDto)));
    }
}
