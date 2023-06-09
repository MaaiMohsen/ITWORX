package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By emailBox = By.id("Email");
    private By passwordBox = By.id("inputPassword");
    private By loginButton = By.id("btnLogin");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email){
        driver.findElement(emailBox).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(passwordBox).sendKeys(password);
    }

    public HomePage clickLogin(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
