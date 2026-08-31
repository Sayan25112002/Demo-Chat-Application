package com.example.ChatApplication.mapper;

import com.example.ChatApplication.dto.requestDto.ChatMessageRequestDto;
import com.example.ChatApplication.dto.responseDto.ChatMessageResponseDto;
import com.example.ChatApplication.entity.ChatMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    ChatMessage toChatMessage(ChatMessageRequestDto chatMessageRequestDto);

    ChatMessageResponseDto toChatMessageResponseDto(ChatMessage chatMessage);

    List<ChatMessageResponseDto> toChatMessageResponseDtoList(List<ChatMessage> chatMessages);

}
