package com.trendyol.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CardPage extends WebDriverHelper{

    By cardNumber = By.xpath("(//input[@id=\"card-number\"])[1]");
    By cvvCard = By.xpath("(//input[@id='card-cvv'])[1]");
    By mountSelect = By.xpath("(//select[@id='card-date-month'])[1]");
    By yearSelect = By.xpath("(//select[@id='card-date-year'])[1]");
    By toPay = By.xpath("(//button[@class='ty-primary-btn ty-btn-large'])[1]");

    By iframe = By.xpath("//iframe[@id='payment-fragment']");
    By iframe2= By.id("payment-fragment");


    public CardPage(WebDriver driver) {
        super(driver);
    }

    public void CardInfo() throws InterruptedException {
        switchToFrame(iframe);
        click(cardNumber,10);
        driver.findElement(cardNumber).sendKeys("1273623471804127");
        click(mountSelect,10);
        driver.findElement(mountSelect).sendKeys("01");
        click(yearSelect,10);
        driver.findElement(yearSelect).sendKeys("2058");
        click(cvvCard,10);
        driver.findElement(cvvCard).sendKeys("237");
        Thread.sleep(1000);
        switchtoMainFrame();
        Thread.sleep(1000);
        click(toPay,10);

    }
}
