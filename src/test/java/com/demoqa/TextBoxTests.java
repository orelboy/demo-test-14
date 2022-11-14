package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class TextBoxTests {

    static AuthorizationUtils authorizationUtils;

    @BeforeAll
    static void setUp() {
        authorizationUtils = new AuthorizationUtils();
    }

    @BeforeEach
     void config (){
        Configuration.baseUrl = "https://portal.dev01.russpass.dev/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000; //10 sec
//        Configuration.browser = "safari";
    }

    @AfterEach
    void closeWebSite(){
        sleep(5000L);
        closeWindow();
    }

    @Test
    void fillFormTest(){
//        Configuration.holdBrowserOpen = true; // Оставлять браузер открытым
//        open("login");
//        $("#username").setValue("russpass_test@mail.ru");
//        $("#auth_ok").click();
//        $("#password").setValue("Test1234!");
//        $("#auth_ok").click();

        authorizationUtils.authorizationByEmail();
//------------------------------------------------------------------
        $("[class = 'button button--primary button--full-width cookie-banner-new__btn-ok']").click();   //закрыть банер
        $x("//div[text()='Основные данные']").click();

        $("#firstName").sendKeys(HOME, chord(SHIFT, END), BACK_SPACE); //Очистка поля
        $("#lastName").sendKeys(HOME, chord(SHIFT, END), BACK_SPACE);
        $("#middleName").sendKeys(HOME, chord(SHIFT, END), BACK_SPACE);
        $("#birthDate").sendKeys(HOME, chord(SHIFT, END), BACK_SPACE);

        $("#firstName").setValue(DataRusMan.FIRSTNAME);
        $("#lastName").setValue(DataRusMan.LASTNAME);
        $("#middleName").setValue(DataRusMan.MIDDLENAME);
        $("#birthDate").setValue(DataRusMan.BIRTHDATE);

//      $x("//span [@class = 'radio-group__item']").click(); // рабочий переключатель по классу
//      $x("//span [contains(text(), 'Мужской')]").click(); // рабочий переключатель по тексту
//      sleep(5000); //ожидание 5 сек

        $x("//span [contains(text(), '" + DataRusMan.GENDER + "')]").click();
        $x("//span [contains(text(), '" + DataRusMan.PASSPORT + "')]").click();
        $x("//*[@id = 'document.numberPassport']").setValue(DataRusMan.NUMBERPASSPORT);
        $("[class = 'button button--primary']").click();

//------------------------------------------------------------------------- Проверка на то что изменения применились
        $("[class = 'button button--third button--square-md']").click();
        sleep(3000);
        $x("//div[text()='Основные данные']").click();

        $("#firstName").shouldHave(value(DataRusMan.FIRSTNAME));
        $("#lastName").shouldHave(value(DataRusMan.LASTNAME));
        $("#middleName").shouldHave(value(DataRusMan.MIDDLENAME));
        $("#birthDate").shouldHave(value(DataRusMan.BIRTHDATE));

        $x("//*[contains(text(), 'Пол')]/..//*[@class = 'radio-group__item radio-group__item--active']").shouldHave(text(DataRusMan.GENDER));
        $x("//*[contains(text(), 'Тип документа')]/..//*[@class = 'radio-group__item radio-group__item--active']").shouldHave(text(DataRusMan.PASSPORT));

        $x("//*[@id = 'document.numberPassport']").shouldHave(value(DataRusMan.NUMBERPASSPORT));




    }
}
