package cz.cvut.fel.ts11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"kontaktniAdresa\"]/div[2]/div[2]/div[1]/input")
    WebElement actStreet;

    @FindBy(xpath = "//*[@id=\"kontaktniAdresa\"]/div[2]/div[2]/div[2]/input")
    WebElement actCity;

    @FindBy(xpath = "//*[@id=\"kontaktniAdresa\"]/div[2]/div[2]/div[3]/input")
    WebElement actPSC;

    @FindBy(xpath = "//*[@id=\"kontaktniAdresa\"]/div[3]/button")
    WebElement actButton;

    @FindBy(xpath = "//*[@id=\"msgSpace\"]/div[2]/a")
    WebElement okay;



    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setActCity(String city) {
        actCity.click();
        actCity.clear();
        actCity.sendKeys(city);
    }

    public void setActStreet(String street) {
        actStreet.click();
        actStreet.clear();
        actStreet.sendKeys(street);
    }

    public void setActPSC(String psc) {
        actPSC.click();
        actPSC.clear();
        actPSC.sendKeys(psc);
    }

    public ProfilePage actualizace(String street, String city, String psc){
        setActStreet(street);
        setActCity(city);
        setActPSC(psc);
        actButton.click();
        okay.click();

        return new ProfilePage(driver);
    }

}
