package com.java.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AssertTest {
    @Test
    void create_new_study(){
        Study study = new Study(1);
        assertNotNull(study);

        /**
         *   assertEquals(기대하는 값, 실제 값,에러메시지);
         */
        assertEquals(StudyStatus.DRAFT, study.getStatus(),"스터디를 처음 만들면 상태값이 DRAFT여야 한다.");

        assertTrue(study.getLimit()>0,"스터디 최대 참석인원은 0보다 커야 한다.");

    }
    @Test
    @Disabled
    void create_new_study_all_test(){
        Study study = new Study(1);
        assertAll(
                ()->assertNotNull(study),
                ()->assertEquals(StudyStatus.DRAFT, study.getStatus(),"스터디를 처음 만들면 상태값이 DRAFT여야 한다."),
                ()->assertTrue(study.getLimit()>0,"스터디 최대 참석인원은 0보다 커야 한다.")
        );
    }

    @Test
    void create_new_study_throw(){
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,()->new Study(-1));
        String message = exception.getMessage();
        assertEquals("0보다 커야한다.",message);
    }

    @Test
    void create_time_out(){
        assertTimeout(Duration.ofMillis(100),()->{
            new Study(10);
            //Thread.sleep(300);
        });
    }

    /**
     * 실패 즉시 테스트 종료
     * 주의해서 써야 함. Timeout을 쓰는게 안전 -> ThreadLocal 공부해볼 것
     */
    @Test
    void create_time_out_preemtively(){
        //TODO ThreadLocal
        assertTimeoutPreemptively(Duration.ofMillis(100),()->{
            new Study(10);
            Thread.sleep(300);
        });

    }

}
