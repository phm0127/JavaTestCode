package com.java.test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)   // 클래스 내 전체 이름 전략
class StudyTest {


    @Test
    void create_new_study(){
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }

    @Test
    @DisplayName("스터디 만들기 \uD83D\uDE31")        // @DisplayNameGeneration 보다 우선순위 높음
    void create_new_study_again(){
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }

    @Test
    @Disabled       //무시 됨
    void create1(){
        System.out.println("create1");
    }

    @BeforeAll  // static으로 작성.
    static void beforeAll(){
        System.out.println("Before All");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After All");
    }

    @BeforeEach //static일 필요 x
    void beforeEach(){
        System.out.println("before Each");
    }

    @AfterEach
    void afterEach(){
        System.out.println("after Each");
    }
}