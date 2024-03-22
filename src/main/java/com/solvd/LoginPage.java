package com.solvd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"userbar\"]/div[1]/div/div/div[1]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div/div/input")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div/div/div/input")
    private WebElement passwordField;

    @FindBy(xpath ="//*[text()='\n" +
            "                Войти\n" +
            "            ']")
    private WebElement enterButton;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void clickEnterButton(){
        enterButton.click();
    }
}
