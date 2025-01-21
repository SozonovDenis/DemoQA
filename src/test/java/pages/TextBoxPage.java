package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage {

    WebDriver driver;

    By fullNameField = By.xpath("//input[@id='userName']");
    By emailField = By.xpath("//input[@id='userEmail']");
    By currentAddressField = By.xpath("//textarea[@id='currentAddress']");
    By permanentAddressField = By.xpath("//textarea[@id='permanentAddress']");
    By submitButton = By.cssSelector("[id=submit]");
    By fullNameOutput = By.xpath("//p[@id='name']");
    By emailOutput = By.xpath("//p[@id='email']");
    By currentAddressOutput = By.xpath("//p[@id='currentAddress']");
    By permanentAddressOutput = By.xpath("//p[@id='permanentAddress']");
    By EmailFieldError = By.xpath("//input[@class='mr-sm-2 field-error form-control']");

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openTextBoxPage() {
        driver.get("https://demoqa.com/text-box");
    }

    public void fillFields(String fullName, String email, String currentAdress, String permanentAdress) {
        driver.findElement(fullNameField).sendKeys(fullName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(currentAddressField).sendKeys(currentAdress);
        driver.findElement(permanentAddressField).sendKeys(permanentAdress);
    }

    public void submitButton() {
        driver.findElement(submitButton).click();
    }

    //Метод получения массива выведенных строк
    public String[] outputData(String fullName, String email, String currentAddress, String permanentAddress) {
        String[] outputDataArray = {"", "", "", ""};
        if (!fullName.isEmpty()) {
            outputDataArray[0] = driver.findElement(fullNameOutput).getText();
        }
        if (!email.isEmpty()) {
            outputDataArray[1] = driver.findElement(emailOutput).getText();
        }
        if (!currentAddress.isEmpty()) {
            outputDataArray[2] = driver.findElement(currentAddressOutput).getText();
        }
        if (!permanentAddress.isEmpty()) {
            outputDataArray[3] = driver.findElement(permanentAddressOutput).getText();
        }
        return outputDataArray;
    }

    //Метод получения массива с ожидаемыми строками в выводе
    public String[] expectedOutputData(String fullName, String email, String currentAddress, String permanentAddress) {
        String[] expectedOutputDataArray = {"", "", "", ""};
        if (!fullName.isEmpty()) {
            expectedOutputDataArray[0] = "Name:" + fullName;
        }
        if (!email.isEmpty()) {
            expectedOutputDataArray[1] = "Email:" + email;
        }
        if (!currentAddress.isEmpty()) {
            expectedOutputDataArray[2] = "Current Address :" + currentAddress;
        }
        if (!permanentAddress.isEmpty()) {
            expectedOutputDataArray[3] = "Permananet Address :" + permanentAddress;
        }
        return expectedOutputDataArray;
    }

    //Возвращает true если находит ошибку поля емейла в DOM
    public boolean isEmailFieldErrorPresent() {
        return !driver.findElements(EmailFieldError).isEmpty();
    }

}
