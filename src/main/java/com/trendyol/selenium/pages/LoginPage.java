package com.trendyol.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends WebDriverHelper{

    By loginbtn = By.xpath("//div[@class='link account-user']");
    By userName = By.cssSelector("#login-email");
    By passWord = By.cssSelector("#login-password-input");
    By loginbtn2 = By.xpath("//button[@class='q-primary q-fluid q-button-medium q-button submit']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void LoginInfo() throws InterruptedException {
        Thread.sleep(2000);
        click(loginbtn,10);
        Thread.sleep(4000);
        driver.findElement(userName).sendKeys("mehmetaknn@hotmail.com");
        driver.findElement(passWord).sendKeys("Mehmet.1998");
        click(loginbtn2,10);
    }

}
