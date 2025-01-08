package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxPage {
    WebDriver driver;
    By expandAllButton = By.xpath("//button[@title='Expand all']");
    By collapseAllButton = By.xpath("//button[@title='Collapse all']");

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCheckBoxPage() {
        driver.get("https://demoqa.com/checkbox");
    }

    public void clickExpandAllButton() {
        driver.findElement(expandAllButton).click();
    }

    public void clickCollapseAllButton() {
        driver.findElement(collapseAllButton).click();
    }

    public void clickOnCheckBoxes(String[] checkBoxesToClick) {
        for (String checkBox : checkBoxesToClick) {
            driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", checkBox))).click();
        }
    }

    public boolean isCheckBoxesDisplayed(String[] checkBoxesToCheckDisplay) {
        boolean isAllExpectedCheckBoxesDisplayed = true;
        for (String s : checkBoxesToCheckDisplay) {
            boolean currentCheckBoxDisplayed;
            currentCheckBoxDisplayed = !driver.findElements(By.xpath(String.format("//span[contains(text(), '%s')]", s))).isEmpty();
            isAllExpectedCheckBoxesDisplayed = isAllExpectedCheckBoxesDisplayed & currentCheckBoxDisplayed;
        }
        return isAllExpectedCheckBoxesDisplayed;
    }

    public boolean checkOutputArrayOfCheckedCheckBoxes(String[] arrayOfExpectedCheckBoxesOutput) {
        boolean isAllExpectedCheckBoxesOutputed = true;
        for (String s : arrayOfExpectedCheckBoxesOutput) {
            boolean currentCheckBoxOutputed;
            currentCheckBoxOutputed = !driver.findElements(By.xpath(String.format("//span[contains(text(), '%s')]",
                    s))).isEmpty();
            isAllExpectedCheckBoxesOutputed = isAllExpectedCheckBoxesOutputed & currentCheckBoxOutputed;
        }
        return isAllExpectedCheckBoxesOutputed;
    }

    public int countOfOtputedCheckBoxes() {
        List<WebElement> outputedElements = driver.findElements(By.xpath("//span[@class='text-success']"));
        return outputedElements.size();
    }

    //Метод проверяет что состояние иконки чекбокса соответствует ожидаемому.
    //Во входных параметрах метод принимает массив подмассивов с двумя значениями, 1 значение - название чб,
    //2 значение - ожидаемое состояние иконки (uncheck/half-check/check).
    public boolean checkCondidtionOfCheckBoxesIcon(String[][] arrayOfExpectedIconConditions) {
        boolean isAllExpectedCondidtionsCorrect = true;
        for (int i = 0; i < arrayOfExpectedIconConditions.length; i++) {
            String checkboxName = arrayOfExpectedIconConditions[i][0];
            String checkboxCondition = arrayOfExpectedIconConditions[i][1];
            boolean isCurrentCheckBoxConditionCorrect;
            isCurrentCheckBoxConditionCorrect = !driver.findElements(By.xpath(String.format
                    ("//span[contains(text(), '%s')]/ancestor::span/label/span/*[@class='rct-icon rct-icon-%s']",
                            checkboxName, checkboxCondition))).isEmpty();
            isAllExpectedCondidtionsCorrect = isAllExpectedCondidtionsCorrect & isCurrentCheckBoxConditionCorrect;
        }
        return isAllExpectedCondidtionsCorrect;
    }

}
