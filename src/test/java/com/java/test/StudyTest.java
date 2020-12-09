package com.java.test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {
    @Test
    void create(){
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }

    @Test
    @Disabled
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