package com.trendyol.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class WebDriverHelper {

    WebDriver driver;
    WebDriverWait wait;

    public WebDriverHelper(WebDriver driver){
        this.driver=driver;
    }

    public void click(By byElement, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).click();
    }

    public void scrollWithJs(By byElement) throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement el = driver.findElement(byElement);
        js.executeScript("arguments[0].scrollIntoView(true);",el);
        Thread.sleep(2000);

    }

    public void randomSelect(By byElement){
        // get all products whose quanity >0
        List<WebElement> productElems = driver.findElements(byElement);
        // get the len of productElems
        int maxProducts = productElems.size();
        // get random number
        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);
        // Select the list item
        productElems.get(randomProduct).click();
    }

    public void random(String Element1, String Element2, String Element3, String Element4){

        String a = Element1;
        String b = Element2;
        String c = Element3;
        String d = Element4;

        String[] dizi = new String[4];
        dizi[0]=a;
        dizi[1]=b;
        dizi[2]=c;
        dizi[3]=d;


        //Rastgele seçim için
        Random sec = new Random();
        int kacinciEleman = sec.nextInt(dizi.length);

        String randomElement = dizi[kacinciEleman];


        driver.findElement(By.xpath(randomElement)).click();
    }

    public void switchWindow (WebElement element){
        String winHandleBefore = driver.getWindowHandle();

// Perform the click operation that opens new window

// Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    public void clickAnyWhere() throws AWTException {
        Actions actions = new Actions(driver);

        Robot robot = new Robot();

        robot.mouseMove(50,50);

        actions.click().build().perform();
    }


    public void Assert (By byElement){
        String basariliKontrol = driver.findElement(byElement).getText();

    }
    public void switchToFrame(By element) {
        WebElement element1 = driver.findElement(element);
        driver.switchTo().frame(element1);
    }

    public void switchtoMainFrame(){
        driver.switchTo().defaultContent();
    }




}
