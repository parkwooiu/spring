package org.zerock.mapper;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.EventVO;

import lombok.extern.log4j.Log4j;
import net.bytebuddy.asm.Advice.Local;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class EventMapperTests {
	
    @Autowired
    private EventMapper eventMapper;

    public class EventMapperTest {

        @Autowired
        private EventMapper eventMapper;

        @Test
        public void testCreateEvent() {
            // 테스트용 이벤트 데이터 생성
            EventVO event = new EventVO(0, null, null, null, null, null);
            event.setEventName("Test Event");
            event.setDescription("This is a test event");
            event.setEventID(LocalDateTime.now());
            event.setLocation("Test Location");
            event.setPhoto("test_photo.jpg");

            // 이벤트 생성 쿼리 실행
            eventMapper.createEvent(event);

            // 생성된 이벤트의 ID가 null이 아닌지 확인
            assertNotNull(event.getEventID());

            // 생성된 이벤트의 ID를 사용하여 해당 이벤트를 가져와서 값이 일치하는지 확인
            EventVO createdEvent = eventMapper.getEvent(event.getEventID());
            assertEquals("Test Event", createdEvent.getEventName());
            assertEquals("This is a test event", createdEvent.getDescription());
            assertEquals(event.getEventDate(), createdEvent.getEventDate());
            assertEquals("Test Location", createdEvent.getLocation());
            assertEquals("test_photo.jpg", createdEvent.getPhoto());
        }
    }
}
