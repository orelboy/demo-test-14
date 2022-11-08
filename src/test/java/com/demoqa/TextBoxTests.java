package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @Test
    void fillFormTest(){
        Configuration.holdBrowserOpen = true;
        open("https://portal.dev01.russpass.dev/");
    }
}
