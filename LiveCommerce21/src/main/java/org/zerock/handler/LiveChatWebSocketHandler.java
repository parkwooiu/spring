package org.zerock.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.zerock.domain.LiveChatVO;
import org.zerock.service.LiveChatService;

@Controller
public class LiveChatWebSocketHandler {
    
    private final LiveChatService liveChatService;

    @Autowired
    public LiveChatWebSocketHandler(LiveChatService liveChatService) {
        this.liveChatService = liveChatService;
    }


}
