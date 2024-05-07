package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {

	public void register(BoardVO board);  //등록
	
	public BoardVO get(Long bno);   //조회
	
	public boolean modify(BoardVO board);  //수정
	
	public boolean remove(Long bno);  //삭제
	
	public List<BoardVO> getList();  //전체 리스트 조회
	
	
	
}
