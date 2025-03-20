package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

WebDriver driver;

@FindBy(id = "user-name")
public WebElement userid;


@FindBy(id = "password")
public  WebElement pwd;

@FindBy(id = "login-button")
public WebElement login_btn;



public Login_Page(WebDriver driver){
this.driver = driver;
    PageFactory.initElements(driver,this);
}
}
