package com.demoqa;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPage {
    public static String EMAIL = "russpass_test@mail.ru";
    public static String PASSWORD = "Test1234!";
    public static String NUMBER = "88005559595";
    private final SelenideElement enterButton = $x("//*[@class = 'header-new__end']//button[@class = 'header-button']");
    private final SelenideElement loginForm = $("#username");
    private final SelenideElement approvingLoginButton = $("#auth_ok");
    private final SelenideElement passwordForm = $("#password");

    public void authorize(String login, String password) {
        enterButton.click();
        loginForm.setValue(login);
        approvingLoginButton.click();
        passwordForm.setValue(password).pressEnter();
    }

    public void authorizeByEmailByDefaultUser() {
        authorize(EMAIL, PASSWORD);
    }

    void authorizeByNumberByDefaultUser() {
        authorize(NUMBER, PASSWORD);
    }
}

