package com.example.ChatApplication.repository;

import com.example.ChatApplication.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatMessage,Long> {
}
