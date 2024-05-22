package org.zerock.mapper;

import java.util.List;
import org.zerock.domain.LiveChatVO;
import org.zerock.domain.UserLiveChatVO;

public interface LiveChatMapper {

    // 특정 사용자와 제품에 대한 라이브 채팅 조회
    List<LiveChatVO> getLiveChat(int userID, int productID);

    // 특정 제품에 대한 채팅 기록 조회
    List<LiveChatVO> getChatHistoryByProductID(int productID);

    // 채팅 메시지 삽입
    void insertMessage(LiveChatVO chat);

    // 모든 라이브 채팅 조회
    List<LiveChatVO> getAllLiveChats();

    // 특정 사용자의 채팅 기록 조회
    List<LiveChatVO> getChatHistoryByUserID(int userID);

    // 라이브 채팅 삽입
    void insertLiveChat(LiveChatVO chat);

    // 라이브 채팅 업데이트
    void updateLiveChat(LiveChatVO chat);

    // 특정 사용자와 제품에 대한 채팅 삭제
    void deleteLiveChat(int userID, int productID);

    // 모든 라이브 채팅 레코드 조회
    List<LiveChatVO> getChatRecords();

    // 사용자 아이디로부터 사용자 이름 조회
    String getUsernameByUserId(int userID);
}
