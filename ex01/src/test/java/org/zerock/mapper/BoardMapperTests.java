package org.zerock.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {

	
	@Autowired
	private BoardMapper mapper;
	@Test
	public void testlist() {
		mapper.getList().forEach(board -> log.info(board));
		
	}
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("홍길동");
		
		mapper.insert(board);
		log.info(board);
	}
	@Test
	public void testInsertSelectKey() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("새로 작성하는 글 select Key");
		vo.setContent("새로 작성하는 내용 select Key");
		vo.setWriter("홍길동2");
		
		mapper.insertSelectKey(vo);
		log.info(vo);
	}
	@Test
	public void testget() {
		log.info(mapper.read(1L));
	}
	@Test
	public void delete() {
		mapper.delete(14L);
	}
	@Test
	public void update() {
		BoardVO vo = new BoardVO();
		
		vo.setBno(5L);
		vo.setTitle("수정된 제목");
		vo.setContent("수정된 내용");
		vo.setWriter("홍길동");
		
		int count = mapper.update(vo);
		log.info("count: " + count);
	}
	

}
