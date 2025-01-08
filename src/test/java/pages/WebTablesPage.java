package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


public class WebTablesPage {
    WebDriver driver;

    By addButton = By.xpath("//button[@id='addNewRecordButton']");
    By addMenuFirstName = By.xpath("//input[@id='firstName']");
    By addMenuLastName = By.xpath("//input[@id='lastName']");
    By addMenuEmail = By.xpath("//input[@id='userEmail']");
    By addMenuAge = By.xpath("//input[@id='age']");
    By addMenuSalary = By.xpath("//input[@id='salary']");
    By addMenuDepartment = By.xpath("//input[@id='department']");
    By submitButton = By.xpath("//button[@id='submit']");


    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebTablesPage() {
        driver.get("https://demoqa.com/webtables");
    }

    public int countOfFilledRows() {
        List<WebElement> listOfRaws = driver.findElements(By.xpath("//div[@class='rt-td'][text()]"));
        return (listOfRaws.size()) / 6;
    }

    public int countOfEmptyRows() {
        List<WebElement> listOfRaws = driver.findElements(By.xpath("//div/span[parent::div[@class='rt-td']]"));
        return (listOfRaws.size()) / 7;
    }

    public void deleteRow(int numberOfRow) {
        ++numberOfRow; //увеличиваем на один т.к. числа в id в локаторах на один больше чем номер строки (например у строки номер 1, id="delete-record-2"
        driver.findElement(By.xpath(String.format("//span[@id='delete-record-%s']", numberOfRow))).click();
    }

    public void changeQuantityOfRows(int quantityOfRows) {
        driver.findElement(By.xpath(String.format("//option[@value=%s]", quantityOfRows))).click();
    }

    public void addNewRow() {
        String[] surnames = {"Иванов", "Петров", "Сидоров"};
        String[] names = {"Иван", "Петр", "Сидор"};
        String[] email = {"ivan@gmail.com", "petr@yandex.ru", "sidor@mail.ru"};
        String[] department = {"ivanovs", "petrovs", "sidorovs"};
        Random random = new Random();
        driver.findElement(addButton).click();
        driver.findElement(addMenuFirstName).sendKeys(surnames[random.nextInt(surnames.length)]);
        driver.findElement(addMenuLastName).sendKeys(names[random.nextInt(names.length)]);
        driver.findElement(addMenuEmail).sendKeys(email[random.nextInt(email.length)]);
        driver.findElement(addMenuAge).sendKeys(Integer.toString(random.nextInt((99 - 18) + 1) + 18)); //заполнение поля Age числом от 18 до 99
        driver.findElement(addMenuSalary).sendKeys(Long.toString(Math.abs(random.nextLong()) % 10_000_000_000L));
        driver.findElement(addMenuDepartment).sendKeys(department[random.nextInt(department.length)]);
        driver.findElement(submitButton).click();
    }

}
