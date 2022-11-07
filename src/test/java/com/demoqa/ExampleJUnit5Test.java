package com.demoqa;

import org.junit.jupiter.api.*;

import java.lang.module.Configuration;

public class ExampleJUnit5Test {

    @BeforeAll  //метод выполняется один раз ПЕРЕД первым тестом в классе
    static  void configure() {
        System.out.println ("   this is the @BeforeAll");
    }

    @AfterAll  //метод выполняется один раз ПОСЛЕ последнего тест в классе
    static  void tearDown() {
        System.out.println ("   this is the @AfterAll");
    }

    //--------------------------------------------------------------------

    @BeforeEach  //метод выполняется  ПЕРЕД КАЖДЫМ тестами в классе
    void beforeTest() {  //не static
        System.out.println ("       this is the @BeforeEach");
    }

    @AfterEach  //метод выполняется  ПЕРЕД КАЖДЫМ тестами в классе
    void afterTest() {  //не static
        System.out.println ("       this is the @AfterEach");
    }

    @Test
    void firstTest1(){
        System.out.println ("         this is the @Test 1");
    }

    @Test
    void firstTest2(){
        System.out.println ("         this is the @Test 2");
    }

}
