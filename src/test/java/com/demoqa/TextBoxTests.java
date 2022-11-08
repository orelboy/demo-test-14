package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void config (){
        Configuration.baseUrl = "https://russpass.ru/";
//        Configuration.timeout = 10000; //10 sec
//        Configuration.browser = "safari";
    }

    @Test
    void fillFormTest(){
        Configuration.holdBrowserOpen = true;
        open("login");
        $("#username").setValue("russpass_test@mail.ru");
        $("#auth_ok").click();
        $("#password").setValue("Test1234!");
        $("#auth_ok").click();
    }
}
