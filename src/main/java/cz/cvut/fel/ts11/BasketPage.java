package cz.cvut.fel.ts11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"submit_step\"]")
    WebElement btnDoprava;

    @FindBy(xpath = "//*[@id=\"deliveryOption\"]/div[2]/div[1]")
    WebElement CheckBoxOdber;

    @FindBy(xpath = "//*[@id=\"deliveryOption\"]/div[2]/div[2]/div[2]/div[1]/div[3]/div/div[2]/div")
    WebElement vyberKraj;

    @FindBy(xpath = "//*[@id=\"deliveryOption\"]/div[2]/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/div[3]/div/ul/li[2]")
    WebElement praha;

    @FindBy(xpath = "//*[@id=\"deliveryType-430657-430657\"]/div[1]")
    WebElement misto;

    @FindBy(xpath = "//*[@id=\"submit_step\"]")
    WebElement button;

    @FindBy(xpath = "//*[@id=\"frm-select-addresss\"]/div/div/div[1]/p/label/strong")
    WebElement btnToForm;

    @FindBy(xpath = "//*[@id=\"frm-select-addresss-street\"]")
    WebElement streetForm;

    @FindBy(xpath = "//*[@id=\"frm-select-addresss-city\"]")
    WebElement cityForm;

    @FindBy(xpath = "//*[@id=\"frm-select-addresss-zip\"]")
    WebElement pscForm;

    @FindBy(xpath = "//*[@id=\"submit_step\"]")
    WebElement dangerButton;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setBtnDoprava() {
        btnDoprava.click();
    }

    public void setOdber() {
        CheckBoxOdber.click();
    }

    public void setVyberKraj() {
        vyberKraj.click();
    }

    public void setPraha(){
        praha.click();
    }
    public void setMisto(){
        misto.click();
    }

    public void scrollToBtn(){
        Actions actions = new Actions(driver);
        actions.moveToElement(button);
        actions.perform();
        button.click();
    }

    public void setBtnToForm(){
        btnToForm.click();
    }

    public void setForm(String street, String city, String psc) {
        streetForm.clear();
        streetForm.sendKeys(street);
        cityForm.clear();
        cityForm.sendKeys(city);
        pscForm.clear();
        pscForm.sendKeys(psc);
        dangerButton.click();

    }
}
