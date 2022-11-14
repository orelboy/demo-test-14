package com.demoqa;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;

public class AuthorizationUtils  {
    public static String EMAIL = "russpass_test@mail.ru";
    public static String PASSWORD = "Test1234!";
    public static String NUMBER = "88005559595";

    void authorizationByEmail() {
//        $x("//*[text()='Вход']").click();
        open("login");
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

