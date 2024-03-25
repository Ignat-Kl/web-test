package com.solvd;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NegativePage {
    public WebDriver driver;

    public NegativePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
    private WebElement signButton;

    @FindBy(xpath = "//*[@id=\"createAccountSubmit\"]")
    private WebElement createButton;

    @FindBy(xpath = "//*[@id=\"ap_customer_name\"]")
    private WebElement nameField;

    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"ap_password_check\"]")
    private WebElement rePasswordField;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    private WebElement continueButton;


    public void signIn () {
        signButton.click();
    }

    public void createButton(){
        createButton.click();
    }

    public void name (String name){
        nameField.sendKeys(name);
    }

    public void email (String email){
        emailField.sendKeys(email);
    }
    public void password (String password){
        passwordField.sendKeys(password);
    }
    public void rePassword (String rePassword){
        rePasswordField.sendKeys(rePassword);
    }
    public void continueBtn (){
        continueButton.click();
    }
//    public void isVerifySuccess () {
//        try {
//            verifyButton.getText();
//            System.out.println("The form was completed successfully");
//        } catch (NoSuchElementException e) {
//            System.out.println("The form was filled out with an error");
//        }
//    }
}
