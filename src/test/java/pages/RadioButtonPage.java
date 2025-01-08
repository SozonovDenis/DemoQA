package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage {
    WebDriver driver;

    By outputBlock = By.xpath("//p/span");

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openRadioButtonPage() {
        driver.get("https://demoqa.com/radio-button");
    }

    public void clickRadioButton(String radioButtonName) {
        radioButtonName = radioButtonName.toLowerCase();
        driver.findElement(By.xpath(String.format("//input[@id='%sRadio']/parent::div/label", radioButtonName))).click();
    }

    public boolean isOutputDisplayed() {
        return !driver.findElements(outputBlock).isEmpty();
    }

    public String getOutputText() {
        return (driver.findElement(By.xpath("//p/span/parent::*")).getText());
    }

}
