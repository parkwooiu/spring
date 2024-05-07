package kr.com.ezen.mapper;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.ezen.dto.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTests {

	@Autowired
	private MemberMapper mapper;
	
	
	@Test
	public void test() {
		log.info(mapper);
	}
	
	@Test
	public void testInsert() {
		
		MemberVO vo = MemberVO.builder()
				.id(100)
				.name("강조")
				.phone("010-2222-1111")
				.address("수원시 팔달구")
				.build();
		log.info(mapper.insertMember(vo));
	}
	
	@Test
	public void testUpdate() {

		MemberVO vo = MemberVO.builder()
				.id(100)
				.name("장합")
				.phone("010-9999-1111")
				.address("수원시 팔달구")
				.build();
		log.info(mapper.insertMember(vo));
		}
	
	@Test	
	public void testDelete() {
    	log.info(mapper.deleteMember(100));	
	}
	
	@Test
	public void testSelectOne() {
		MemberVO vo = mapper.selectOneMember(18);
		log.info(vo);
	}
	
	@Test
	public void testSelectList() {
		mapper.selectAllMember().forEach(vo ->log.info(vo));
	}
}
