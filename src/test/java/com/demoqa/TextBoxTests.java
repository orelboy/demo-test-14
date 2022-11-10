package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.Keys.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class TextBoxTests {

    @BeforeAll
    static void config (){
        Configuration.baseUrl = "https://portal.dev01.russpass.dev/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000; //10 sec
//        Configuration.browser = "safari";
    }

//    @AfterAll
//    static void closeWebSite (){
//        sleep(5000L);
//        closeWindow();
//    }

    @Test
    void fillFormTest(){
        Configuration.holdBrowserOpen = true; // Оставлять браузер открытым
        open("login");
        $("#username").setValue("russpass_test@mail.ru");
        $("#auth_ok").click();
        $("#password").setValue("Test1234!");
        $("#auth_ok").click();
//------------------------------------------------------------------
        $("[class = 'button button--primary button--full-width cookie-banner-new__btn-ok']").click();   //закрыть банер
        $x("//div[text()='Основные данные']").click();

        $("#firstName").sendKeys(HOME, chord(SHIFT, END), BACK_SPACE); //Очистка поля
        $("#lastName").sendKeys(HOME, chord(SHIFT, END), BACK_SPACE);
        $("#middleName").sendKeys(HOME, chord(SHIFT, END), BACK_SPACE);
        $("#birthDate").sendKeys(HOME, chord(SHIFT, END), BACK_SPACE);

        $("#firstName").setValue("Иван");
        $("#lastName").setValue("Иванов");
        $("#middleName").setValue("Иванович");
        $("#birthDate").setValue("01.02.1987");

//      $x("//span [@class = 'radio-group__item']").click(); // рабочий переключатель по классу
        $x("//span [contains(text(), 'Женский')]").click(); // рабочий переключатель по тексту
        sleep(5000); //ожидание 5 сек
        $x("//span [@class = 'radio-group__item']").click();



    }
}
