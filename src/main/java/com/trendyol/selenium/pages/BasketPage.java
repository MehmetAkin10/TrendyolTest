package com.trendyol.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends WebDriverHelper{
    By anladimButon = By.xpath("//button[text()='Anladım']");
    By plusProduct = By.xpath("//button[@class='ty-numeric-counter-button']");
    By acceptBasket = By.xpath("(//a[@class='ty-link-btn-primary'])[2]");

    By kutucukTik = By.xpath("(//span[@class='p-checkbox-text'])[2]");

    By saveAndMove = By.xpath("(//button[@class='ty-primary-btn ty-btn-large'])[1]");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public void AnlandimButton(){
        click(anladimButon,10);
    }

    public void PlusProduct() throws InterruptedException {
        //scrollWithJs(plusProduct);
        click(plusProduct,10);
    }

    public void AcceptBasket(){
        click(acceptBasket,10);
        click(kutucukTik,10);
        click(saveAndMove,10);
    }


}
