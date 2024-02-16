package com.trendyol.test;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;



public class BaseTest {
    public static WebDriver driver;
    @BeforeEach
    public void setUp(){
        System.out.println("Program Çalışmaya Başladı");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");


        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(false);
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to Windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-in-process-stack-traces");
        options.addArguments("--disable-logging");
        options.addArguments("--log-level=3");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome 13");
        caps.setCapability("os", "Windows");
        caps.merge(caps);

        driver.get("https://www.trendyol.com/");
    }
    @AfterEach
    public void tearDown(){
        System.out.println("Sonda Çalışır, Test başarılı çalıştı ve kapandı");
        if(driver !=null){
            //driver.close();
            //driver.quit();
        }
    }
}
