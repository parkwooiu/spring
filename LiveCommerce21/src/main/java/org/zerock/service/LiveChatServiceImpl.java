package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.LiveChatVO;
import org.zerock.mapper.LiveChatMapper;

import java.util.List;

@Service
public class LiveChatServiceImpl implements LiveChatService {

    private final LiveChatMapper mapper;

    @Autowired
    public LiveChatServiceImpl(LiveChatMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<LiveChatVO> getLiveChat(int userID, int productID) {
        // 특정 사용자와 제품에 대한 라이브 채팅 조회
        return mapper.getLiveChat(userID, productID);
    }

    @Override
    public List<LiveChatVO> getChatHistoryByProductID(int productID) {
        // 특정 제품에 대한 채팅 기록 조회
        return mapper.getChatHistoryByProductID(productID);
    }

    @Override
    public void insertMessage(LiveChatVO chat) {
        // 채팅 메시지 삽입
        mapper.insertMessage(chat);
    }

    @Override
    public List<LiveChatVO> getAllLiveChats() {
        // 모든 라이브 채팅 조회
        return mapper.getAllLiveChats();
    }

    @Override
    public List<LiveChatVO> getChatHistoryByUserID(int userID) {
        // 특정 사용자의 채팅 기록 조회
        return mapper.getChatHistoryByUserID(userID);
    }

    @Override
    public void insertLiveChat(LiveChatVO chat) {
        // 라이브 채팅 삽입
        mapper.insertLiveChat(chat);
    }

    @Override
    public void updateLiveChat(LiveChatVO chat) {
        // 라이브 채팅 업데이트
        mapper.updateLiveChat(chat);
    }

    @Override
    public void deleteLiveChat(int userID, int productID) {
        // 특정 사용자와 제품에 대한 채팅 삭제
        mapper.deleteLiveChat(userID, productID);
    }

    @Override
    public List<LiveChatVO> getChatRecords() {
        // 모든 라이브 채팅 레코드 조회
        return mapper.getChatRecords();
    }

    @Override
    public String getUsernameByUserId(int userID) {
        // 사용자 아이디로부터 사용자 이름 조회
        return mapper.getUsernameByUserId(userID);
    }
}
