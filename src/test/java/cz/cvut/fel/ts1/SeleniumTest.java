package cz.cvut.fel.ts1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import cz.cvut.fel.ts11.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.domstorage.model.Item;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.time.Duration;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumTest {
    WebDriver driver;
    HomePage homePage;

    private static class OrderDetails {
        String itemCount;
        String itemName;
        String total;

        private OrderDetails(String itemCount, String itemName, String total) {
            this.itemCount = itemCount;
            this.itemName = itemName;
            this.total = total;
        }

        @Override
        public String toString() {
            return String.format("%s, %s, %s", itemName, itemCount, total);
        }
    }
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.kasa.cz/");
    }

    @AfterEach
    public void close() {
        driver.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/cz.cvut.fel.ts1/forSignUP.csv")
    @Test
    @Order(1)
    public void Sign_in() throws InterruptedIOException, IOException, CsvValidationException, InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickToSignUP();
        CSVReader reader = new CSVReader(new FileReader("src/test/resources/cz.cvut.fel.ts1/forSignUP.csv"));
        String[] cell;
        while ((cell = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String name = cell[i];
                String password = cell[i + 1];
                SignInWindow signInWindow = new SignInWindow(driver);
                signInWindow.setEmail(name);
                signInWindow.setPassword(password);
                signInWindow.clickButton();
                homePage.clickToProf();
                Thread.sleep(5000);
                assertEquals("Dastan Sadyraliyev", driver.findElement(By.xpath("//*[@id=\"loged-box\"]/div/div/div[1]/span")).getText());


            }
        }
    }

    @Test
    @Order(2)
    public void Aktualizovat() throws IOException, CsvValidationException {
        homePage = new HomePage(driver);
        SignInWindow signInWindow = homePage.clickToSignUP().signIn("dastangta29@gmail.com", "obelom2542a");
        ProfilePage profilePage = homePage.clickToProfile();
        profilePage.actualizace("Technicka 2", "Praha", "169 00");
        assertEquals("Změna osobních údajů proběhla uspěšně", driver.findElement(By.xpath("//*[@id=\"msgSpace\"]/div[1]")).getText());
    }
    @Test
    @Order(3)
    public void detalniSearch(){
        homePage = new HomePage(driver);
        SignInWindow signInWindow = homePage.clickToSignUP().signIn("dastangta29@gmail.com", "obelom2542a");
        driver.navigate().refresh();
        SearchPage searchPage = homePage.makeSearch();
        assertEquals("Mobily, Nositelná elektronika", driver.findElement(By.xpath("//*[@id=\"pbL\"]/div[5]/div/div/div[2]/h1")).getText());
        driver.navigate().refresh();
        searchPage.setMobil();
        assertEquals("", driver.findElement(By.xpath("//*[@id=\"cboxLoadedContent\"]/div/div[3]/div[2]/a/span")).getText());
        BasketPage basketPage = searchPage.showBasket();
        assertEquals("17 990 Kč", driver.findElement(By.xpath("//*[@id=\"obsahContainer\"]/form/table/tfoot/tr/td[3]")).getText());
        assertEquals("Mobilní telefon Apple iPhone 12 64 GB - Black (MGJ53CN/A)", driver.findElement(By.xpath("//*[@id=\"obsahContainer\"]/form/table/tbody/tr[1]/td[2]/a")).getText());
    }

    @Test
    @Order(4)
    public void doprava() {
        detalniSearch();
        BasketPage basketPage = homePage.toBasket();
        basketPage.setBtnDoprava();
        basketPage.setOdber();
        basketPage.setVyberKraj();
        basketPage.setPraha();
        assertEquals("Praha", driver.findElement(By.xpath("//*[@id=\"deliveryOption\"]/div[2]/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/div[2]/p")).getText());
        basketPage.setMisto();
        basketPage.scrollToBtn();
        basketPage.setBtnToForm();
        basketPage.setForm("Olympijska 1902/5", "Praha", "" );
        assertEquals("povinné údaje", driver.findElement(By.xpath("//*[@id=\"frm-select-addresss\"]/div/div/div[2]/div[4]/div[3]/div[2]/span[2]")).getText());

    }

//    @ParameterizedTest
//    @CsvFileSource(resources = "src/test/java/cz/cvut/fel/ts1/forHeslo.csv")
    @Test
    @Order(5)
    public void zmenitheslo() throws CsvValidationException, IOException, InterruptedException {
        HomePage homePage = new HomePage(driver);
        SignInWindow signInWindow = homePage.clickToSignUP().signIn("dastangta29@gmail.com", "obelom2542a");
        driver.navigate().refresh();
        ZmenaHesla zmenaHesla = homePage.clicToPage();
        zmenaHesla.zmenitHeslo("obelom2542a", "obelom2542a", "obelom2542");
        Thread.sleep(4000);
        assertEquals("Nové heslo je potřeba zadat dvakrát" , driver.findElement(By.xpath("//*[@id=\"msgSpace\"]/div[1]")).getText());



        //zmenaHesla.setOk();

//        CSVReader reader = new CSVReader(new FileReader("src/test/java/cz/cvut/fel/ts1/forHeslo.csv"));
//        String[] cell;
//        while ((cell = reader.readNext())!=null){
//            for (int i = 0; i < 1; i++) {
//                String oldPass = cell[i];
//                String newPass = cell[i+1];
//                zmenaHesla.setOldPassInput(oldPass);
//                zmenaHesla.setNewPassInput(newPass);
//                zmenaHesla.setNewPassAgainInput(newPass);
//            }
//

//        }
    }

}
