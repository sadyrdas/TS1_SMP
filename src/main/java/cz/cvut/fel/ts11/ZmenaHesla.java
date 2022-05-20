package cz.cvut.fel.ts11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZmenaHesla {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"client_section\"]/div/div/div/form/div[1]/input")
    WebElement oldPassInput;

    @FindBy(xpath = "//*[@id=\"client_section\"]/div/div/div/form/div[2]/input")
    WebElement newPassInput;

    @FindBy(xpath = "//*[@id=\"pass22\"]")
    WebElement newPassAgainInput;

    @FindBy(xpath = "//*[@id=\"client_section\"]/div/div/div/form/div[4]/input")
    WebElement zmenaButton;

    @FindBy(xpath = "//*[@id=\"msgSpace\"]/div[2]/a")
    WebElement ok;

    public void setOldPassInput(String password1){
        oldPassInput.sendKeys(password1);
    }

    public void setNewPassInput(String password2) {
        newPassInput.sendKeys(password2);
    }

    public void setNewPassAgainInput(String password2) {
        newPassAgainInput.sendKeys(password2);
    }

    public void setOk(){
        ok.click();
    }

    public void zmenitHeslo(String pass, String newPass, String newPassAgain) {
        setOldPassInput(pass);
        setNewPassInput(newPass);
        setNewPassAgainInput(newPassAgain);
        zmenaButton.click();
    }

    public ZmenaHesla(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
