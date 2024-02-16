package com.trendyol.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class ProdcutPage extends WebDriverHelper{
    By Productselect = By.xpath("(//div[@class='p-card-wrppr with-campaign-view'])[6]");
    String product1 = "(//div[@class='p-card-wrppr with-campaign-view'])[5]";
    String product2 = "(//div[@class='p-card-wrppr with-campaign-view'])[6]";
    String product3 = "(//div[@class='p-card-wrppr with-campaign-view'])[7]";
    String product4 = "(//div[@class='p-card-wrppr with-campaign-view'])[8]";

    By basketAdd = By.xpath("//div[@class='add-to-basket-button-text']");
    By scrollBasket = By.xpath("//div[@class='product-button-container']");
    By goBasket = By.cssSelector("a.go-basket-button");
    private WebElement element;


    public ProdcutPage(WebDriver driver) {
        super(driver);
    }

    public void ProductSelect() throws InterruptedException, AWTException {
        Thread.sleep(1000);
        scrollWithJs(Productselect);
        clickAnyWhere();
        Thread.sleep(1000);
        random(product1, product2, product3, product4);
    }

    public void AddBasket () throws InterruptedException {
        switchWindow(element);
        Thread.sleep(2000);
        scrollWithJs(scrollBasket);
        click(basketAdd,10);
    }


    public void GoBasket(){
        click(goBasket,10);
    }
}
