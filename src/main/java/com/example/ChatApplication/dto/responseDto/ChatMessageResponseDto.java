package com.example.ChatApplication.dto.responseDto;

import com.example.ChatApplication.entity.ennum.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessageResponseDto {

    private Long id;

    private String content;

    private String sender;

    private MessageType type;

}
