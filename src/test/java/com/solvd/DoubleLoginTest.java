package com.solvd;


import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DoubleLoginTest {
    public static LoginPage loginPage;
    public static WebDriver driver;

    @BeforeMethod
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginPage"));
    }




    @DataProvider(name = "validLogPass")
    public Object [][] validLogPass() {
        return new Object[][] {
                {"kulik9997854@mail.ru", "sout7685jdk"},
                {"kulik9998754@mail.ru", "434322"}
        };
    }


    @Test(testName = "hfd", dataProvider = "validLogPass")
    public void loginTest(String login,String password) throws InterruptedException {
        loginPage.clickLoginButton();
        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        loginPage.clickEnterButton();
        Thread.sleep(2000);
        }

    @AfterMethod
    public static void tearDown() {
       driver.quit();
    }

}