package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.zerock.domain.LiveChatVO;
import org.zerock.service.LiveChatService;

@Controller
public class ChatController {

    private final LiveChatService chatService;

    @Autowired
    public ChatController(LiveChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public String chat(Model model) {
        List<LiveChatVO> chatList = chatService.getAllLiveChats();
        model.addAttribute("chatList", chatList);
        return "chat"; // chat.jsp와 연결
    }

    // 필요한 다른 요청 매핑을 추가할 수 있습니다.
}