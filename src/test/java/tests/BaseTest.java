package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    TextBoxPage textBoxPage;
    CheckBoxPage checkBoxPage;
    RadioButtonPage radioButtonPage;
    ButtonsPage buttonsPage;
    WebTablesPage webTablesPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("srart-maximized");
        options.setCapability("pageLoadStrategy", "eager"); // Не ждать загрузку
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        textBoxPage = new TextBoxPage(driver);
        checkBoxPage = new CheckBoxPage(driver);
        radioButtonPage = new RadioButtonPage(driver);
        buttonsPage = new ButtonsPage(driver);
        webTablesPage = new WebTablesPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
