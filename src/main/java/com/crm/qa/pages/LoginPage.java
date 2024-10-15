package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory / OR (Object Repository)
    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(linkText="Sign Up")
    WebElement signUpBtn;

    @FindBy(xpath="//img[contains(@class, 'img-responsive')]")
    WebElement crmLogo;

    //Initializing the Page Objects
    public LoginPage() {

        //initialize page factory using initElements method of PageFactory class
        PageFactory.initElements(driver, this); //this is pointing to current class object
        //this means its pointing to current class object
        //PageFactory.initElements(driver, LoginPage.class); //we can also write like this
    }

    //Actions:
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateCRMImage() {
        return crmLogo.isDisplayed();
    }

    //landing page of LoginPage is HomePage, therefore return type is object of HomePage
    public HomePage login(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

        //landing page of LoginPage is HomePage, therefore return type is object of HomePage
        return new HomePage();
    }



}
