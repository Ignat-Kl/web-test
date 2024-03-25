package com.solvd;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

public class NegativeTest {
    public static NegativePage negativePage;
    public static WebDriver driver;
    private String registrationPageUrl = "https://www.amazon.com/ap/cvf/request?arb=660bce82-8e38-4083-b683-962d5834bd89";

    @BeforeMethod
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));
        driver = new ChromeDriver();
        negativePage = new NegativePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("negativePage"));
    }

    @DataProvider(name = "invalidInf")
    public Object [][] invalidInf() {
        return new Object[][] {
                {"5454", "----","....."},
                {"Kiril", "kiril2290@mail.ru", "!weR4TUhgn/J"}
        };
    }


    @Test(testName = "negativeForm", dataProvider = "invalidInf")
    public void NegativeTest(String name, String email, String password) throws InterruptedException {
        negativePage.signIn();
        negativePage.createButton();
        negativePage.name(name);
        negativePage.email(email);
        negativePage.password(password);
        negativePage.rePassword(password);
        negativePage.continueBtn();
        Thread.sleep(2000);
       if(!driver.getCurrentUrl().equals(registrationPageUrl)) {
           System.out.println("Error: The registration form was filled out incorrectly");
       }
       Assert.assertEquals(driver.getCurrentUrl(), registrationPageUrl, "Success: The registration form was completed correctly");
    }

    @AfterMethod
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
