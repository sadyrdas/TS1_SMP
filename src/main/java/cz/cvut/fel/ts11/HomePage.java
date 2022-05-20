package cz.cvut.fel.ts11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"basket-top\"]/li[1]/a")
    WebElement signUP;

    @FindBy(xpath = "//*[@id=\"c-p-bn\"]")
    WebElement btnCookie;

    @FindBy(xpath = "//*[@id=\"js-user-loged\"]")
    WebElement profile;

    @FindBy(xpath = "//*[@id=\"loged-box\"]/div/div/div[2]/div/div[2]/ul/li[1]/a")
    WebElement info;

    @FindBy(xpath = "//*[@id=\"loged-box\"]/div/div/div[2]/div/div[2]/ul/li[2]/a")
    WebElement zmenaHesla;


    @FindBy(xpath = "//*[@id=\"basic-navi-4-0\"]")
    WebElement telefon;



    @FindBy(xpath = "//*[@id=\"basket-top\"]/li[4]/a")
    WebElement basket;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignInWindow clickToSignUP() {
        btnCookie.click();
        signUP.click();
        return new SignInWindow(driver);
    }

    public void clickToProf(){
        profile.click();
    }

    public ProfilePage clickToProfile() {
        profile.click();
        info.click();
        return new ProfilePage(driver);
    }

    public ZmenaHesla clicToPage() {
        driver.navigate().refresh();
        profile.click();
        zmenaHesla.click();
        return new ZmenaHesla(driver);
    }


    public SearchPage makeSearch() {
        telefon.click();
        return new SearchPage(driver);
    }

    public BasketPage toBasket() {
        basket.click();
        return new BasketPage(driver);

    }

}
