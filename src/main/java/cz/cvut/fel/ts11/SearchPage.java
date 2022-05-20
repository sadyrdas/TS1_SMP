package cz.cvut.fel.ts11;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"pbL\"]/div[5]/div/div/div[2]/div[3]/div/div/div[1]/div/a")
    WebElement mobil;

    @FindBy(xpath = "//*[@id=\"pbL\"]/div[5]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/a")
    WebElement IOS;

    @FindBy(xpath = "//*[@id=\"aContent\"]/div[3]/div[1]/div[2]/article/a")
    WebElement selectedPhone;

    @FindBy(xpath = "//*[@id=\"big_basket\"]")
    WebElement btnBuy;

    @FindBy(xpath = "//*[@id=\"cboxLoadedContent\"]/div/div[3]/div[2]/a")
    WebElement basket;



    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setMobil() {
        mobil.click();
        IOS.click();
        driver.navigate().refresh();
        selectedPhone.click();
        btnBuy.click();
    }

    public BasketPage showBasket(){
        basket.click();
        return new BasketPage(driver);

    }
}
