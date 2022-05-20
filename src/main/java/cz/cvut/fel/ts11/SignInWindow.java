package cz.cvut.fel.ts11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class SignInWindow {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"loginLi\"]")
    WebElement loginInput;

    @FindBy(id = "passLi")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/form/div[3]/button")
    WebElement checkBox;
    @FindBy(xpath = "//*[@id=\"prihlLi\"]/div[3]/div[1]/div[1]/button")
    WebElement btnLogin;

    @FindBy(xpath = "//*[@id=\"loged-box\"]/div/div/div[1]/span")
    WebElement succeslogin;









    public SignInWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void setEmail(String email) {
        loginInput.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickButton(){
        btnLogin.click();
    }

    public SignInWindow signIn(String email, String password) {
        setEmail(email);
        setPassword(password);
        btnLogin.click();

        return new SignInWindow(driver);
    }





}
