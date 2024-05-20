package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.zerock.domain.LiveChatVO;
import org.zerock.service.LiveChatService;

@Controller
public class LiveChatController {
    
    @Autowired
    private LiveChatService liveChatService;

    // 클라이언트가 /chat로 메시지를 보내면 이 메소드가 호출됩니다.
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public LiveChatVO sendMessage(LiveChatVO chatVO) {
        // 받은 메시지를 DB에 저장하고, 저장된 메시지를 다시 클라이언트에게 전송합니다.
        return liveChatService.saveMessage(chatVO);
    }
}
