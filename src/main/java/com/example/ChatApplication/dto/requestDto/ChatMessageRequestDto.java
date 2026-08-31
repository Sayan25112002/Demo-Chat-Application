package com.example.ChatApplication.dto.requestDto;

import com.example.ChatApplication.entity.ennum.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessageRequestDto {

    private String content;

    private String sender;

    private MessageType type;

}
