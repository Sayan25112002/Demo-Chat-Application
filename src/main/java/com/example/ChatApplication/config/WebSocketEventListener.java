package com.example.ChatApplication.config;

import com.example.ChatApplication.dto.requestDto.ChatMessageRequestDto;
import com.example.ChatApplication.entity.ChatMessage;
import com.example.ChatApplication.entity.ennum.MessageType;
import com.example.ChatApplication.mapper.ChatMapper;
import com.example.ChatApplication.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messagingTemplate;
    private final ChatMapper chatMapper;
    private final ChatRepository chatRepository;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String userName = (String) accessor.getSessionAttributes().get("userName");
        if(userName!=null){
            log.info("User Disconnected: {}",userName);
            var chatMessageRequestDto = ChatMessageRequestDto.builder()
                    .type(MessageType.LEAVE)
                    .sender(userName)
                    .build();
            ChatMessage chatMessage = chatMapper.toChatMessage(chatMessageRequestDto);
            chatRepository.save(chatMessage);
            messagingTemplate.convertAndSend("/topic/public", chatMessageRequestDto);

        }
    }
}
