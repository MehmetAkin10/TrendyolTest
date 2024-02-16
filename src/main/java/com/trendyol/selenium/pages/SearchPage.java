package com.trendyol.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends WebDriverHelper{

    By Searchbar = By.xpath("//input[@data-testid='suggestion']");
    By Searchbutton = By.xpath("//i[@data-testid='search-icon']");
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void SearchBar() throws InterruptedException {
        Thread.sleep(1000);
        click(Searchbar,30);
        driver.findElement(Searchbar).sendKeys("Bilgisayar");
        click(Searchbutton,10);

    }
}
