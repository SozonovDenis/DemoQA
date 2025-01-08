package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage {
    WebDriver driver;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openButtonsPage() {
        driver.get("https://demoqa.com/buttons");
    }

    public void clickButton(String buttonName, String typeOfClick) {
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.xpath(String.format("//button[text()='%s']", buttonName)));
        try { //Без этого прерывания кнопка не находится корректно
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Восстановление статуса прерывания
        }
        if (typeOfClick.equals("Left click"))
            actions.click(button).perform();
        if (typeOfClick.equals("Right click"))
            actions.contextClick(button).perform();
        if (typeOfClick.equals("Double click"))
            actions.doubleClick(button).perform();
    }

    public boolean checkOutput(String buttonPressed) {
        String replacingText = "";
        if (buttonPressed.equals("Click Me"))
            replacingText = "dynamic";
        if (buttonPressed.equals("Right Click Me"))
            replacingText = "right";
        if (buttonPressed.equals("Double Click Me"))
            replacingText = "double";
        return !driver.findElements(By.xpath(String.format("//p[text()='You have done a %s click']", replacingText))).isEmpty();
    }

}
