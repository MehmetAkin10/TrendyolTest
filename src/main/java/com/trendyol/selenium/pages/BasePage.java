package com.trendyol.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends WebDriverHelper{

    By popUp  = By.cssSelector("div>#onetrust-accept-btn-handler");

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public BasePage getLoginPage(){
        click(popUp,10);
        return new BasePage(driver);
    }
}
