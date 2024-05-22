package org.zerock.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.zerock.domain.LiveChatVO;
import org.zerock.service.LiveChatService;

@Controller
public class LiveChatController {

    @Autowired
    private LiveChatService liveChatService;

    @MessageMapping("/live.chat")
    public void handleChatMessage(LiveChatVO livechat) {
        // 받은 채팅 정보를 데이터베이스에 저장
        liveChatService.insertLiveChat(livechat);
    }
    
}