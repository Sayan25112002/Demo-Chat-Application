package com.example.ChatApplication.entity;

import com.example.ChatApplication.entity.ennum.MessageType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String sender;

    @Enumerated(EnumType.STRING)
    private MessageType type;

}
