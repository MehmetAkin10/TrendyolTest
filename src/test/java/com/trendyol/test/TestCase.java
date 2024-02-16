package com.trendyol.test;

import Methods.Methods;
import com.trendyol.selenium.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class TestCase extends BaseTest{


    @Test
    public void TrendyolTest() throws InterruptedException, AWTException {
        Methods methods = new Methods();

        BasePage basePage = new BasePage(driver);
        basePage.getLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginInfo();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.SearchBar();

        ProdcutPage prodcutPage = new ProdcutPage(driver);
        prodcutPage.ProductSelect();
        prodcutPage.AddBasket();
        prodcutPage.GoBasket();

        BasketPage basketPage = new BasketPage(driver);
        basketPage.AnlandimButton();
        basketPage.PlusProduct();
        Thread.sleep(1000);

        String basariliKontrol = driver.findElement(By.xpath("//div[@class='toastrElement success']")).getText();
        Assertions.assertEquals("Sepet başarıyla güncellendi", basariliKontrol );
        System.out.println("Yazı : "+ basariliKontrol);

        basketPage.AcceptBasket();

        CardPage cardPage = new CardPage(driver);
        cardPage.CardInfo();
        Thread.sleep(1000);

        String sonKontrol = driver.findElement(By.xpath("//div[@class='p-wm-primary-content']")).getText();
        Assertions.assertEquals("Kart numarası geçerli değil.", sonKontrol );
        System.out.println("Yaziiiii : "+ sonKontrol);








    }


}
