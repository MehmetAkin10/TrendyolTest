package Methods;

import com.trendyol.test.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    //tanımladığımız zaman aralığında birden fazla test imkanı sunuyor

    public Methods() {
        driver = BaseTest.driver;
        wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
        System.out.println(by+ "tiklandi");
    }

    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(seconds+ " saniye beklendi");
    }

    public void iframe(){
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        driver.switchTo().defaultContent();
    }

    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void scrollWithAction(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    // public Select getSelect(By by) { return new Select(findElement(by));}

    public Select getSelect(By by){
        return new Select(findElement(by));}

    public void selectByText(By by , String text){
        getSelect(by).selectByVisibleText(text);
    }

    public String getAttribute(By by, String attributeName){
        return findElement(by).getAttribute(attributeName);
    }
    public String getText(By by){
        return findElement(by).getText();

    }
    public String getValue(By by){
        return jsdriver.executeScript("return arguments[0].value", findElement(by)).toString();
    }


    public void MouseMove (By by){
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        //WebElement logout = driver.findElement(By.xpath("//a[.='Merhaba Mehmet Akın']"));
        //actions.moveToElement(logout).perform();
        actions.moveToElement(findElement(by)).perform();
    }

    public void random(){

        String a = "//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11467672/wi:100/wh:true']";
        String b = "//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:19776/wi:100/wh:true']";
        String c = "//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11245143/wi:100/wh:true']";
        String d = "//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:62170/wi:100/wh:true']";
        String e = "//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11439039/wi:100/wh:true']";
        String[] dizi = new String[5];
        dizi[0]=a;
        dizi[1]=b;
        dizi[2]=c;
        dizi[3]=d;
        dizi[4]=e;

        //Rastgele seçim için
        Random sec = new Random();
        int kacinciEleman = sec.nextInt(dizi.length);

        String randomElement = dizi[kacinciEleman];


        findElement(By.xpath(randomElement)).click();

    }
    public void randomSelect(){
        // get all products whose quanity >0
        List<WebElement> productElems = driver.findElements(By.cssSelector("div[class=\"c4mnd7m dir dir-ltr\"]"));
        // get the len of productElems
        int maxProducts = productElems.size();
        // get random number
        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);
        // Select the list item
        productElems.get(randomProduct).click();
    }
    public void ifElementExistClickElseSkip(){
        List<WebElement> element = driver.findElements(By.xpath("(//button[@class=\"l1j9v1wn czcfm7x dir dir-ltr\"])[3]"));
        if (element.size() > 0){
            waitBySeconds(2);
            element.get(0).click();
        }
        else{
            System.out.println("Element is not found");
        }
    }
    public void switchWindow(){
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

// Perform the click operation that opens new window

// Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }




}