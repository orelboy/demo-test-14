package com.demoqa;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class AuthorizationUtils  {
    public static String EMAIL = "russpass_test@mail.ru";
    public static String PASSWORD = "Test1234!";
    public static String NUMBER = "88005559595";

    void authorizationByEmail() {
        $x("//*[@class = 'header-new__end']//button[@class = 'header-button']").click();
        $("#username").setValue(AuthorizationUtils.EMAIL);
        $("#auth_ok").click();
        $("#password").setValue(AuthorizationUtils.PASSWORD).pressEnter();
    }

    void authorizationByNumber() {
        $x("//*[text()='Вход']").click();
        $("#username").setValue(AuthorizationUtils.NUMBER);
        $("#auth_ok").click();
        $("#password").setValue(AuthorizationUtils.PASSWORD).pressEnter();
    }
}

