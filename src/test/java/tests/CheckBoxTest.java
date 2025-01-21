package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckBoxTest extends BaseTest {

    @Test
    public void expandAndCollapseAll() {
        SoftAssert softAssert = new SoftAssert();
        checkBoxPage.openCheckBoxPage();
        checkBoxPage.clickExpandAllButton();
        String[] checkBoxesToCheckDisplay = {"Home", "Desktop", "Notes", "Commands", "Documents", "WorkSpace", "React", "Angular", "Veu", "Office", "Public", "Private", "Classified", "General", "Downloads", "Word File.doc", "Excel File.doc"};
        softAssert.assertTrue(checkBoxPage.isCheckBoxesDisplayed(checkBoxesToCheckDisplay));
        checkBoxPage.clickCollapseAllButton();
        checkBoxesToCheckDisplay = new String[]{"Home"};
        softAssert.assertTrue(checkBoxPage.isCheckBoxesDisplayed(checkBoxesToCheckDisplay));
        softAssert.assertAll();
    }


    @Test
    public void clickHomeCheckBox() {
        String[] checkBoxesToClick = {"Home"};
        String[] arrayOfExpectedCheckBoxesOutput = {"home", "desktop", "notes", "commands", "documents", "workspace", "react", "angular", "veu", "office", "public", "private", "classified", "general", "downloads", "wordFile", "excelFile"};
        checkBoxPage.openCheckBoxPage();
        checkBoxPage.clickOnCheckBoxes(checkBoxesToClick);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkBoxPage.checkOutputArrayOfCheckedCheckBoxes(arrayOfExpectedCheckBoxesOutput)); //Проверка что выведены все ожидаемые элементы
        softAssert.assertEquals(checkBoxPage.countOfOtputedCheckBoxes(), arrayOfExpectedCheckBoxesOutput.length); //Проверка что кол-во выведенных элементов совпадает с ожидаемым
        softAssert.assertAll();
    }

    @Test
    public void clickSomeCheckBoxes() {
        String[] checkBoxesToClick = {"React", "Angular", "Veu", "Office"};
        String[] arrayOfExpectedCheckBoxesOutput = {"documents", "workspace", "react", "angular", "veu", "office", "public", "private", "classified", "general"};
        checkBoxPage.openCheckBoxPage();
        checkBoxPage.clickExpandAllButton();
        checkBoxPage.clickOnCheckBoxes(checkBoxesToClick);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkBoxPage.checkOutputArrayOfCheckedCheckBoxes(arrayOfExpectedCheckBoxesOutput)); //Проверка что выведены все ожидаемые элементы
        softAssert.assertEquals(checkBoxPage.countOfOtputedCheckBoxes(), arrayOfExpectedCheckBoxesOutput.length); //Проверка что кол-во выведенных элементов совпадает с ожидаемым
        softAssert.assertAll();
    }

    @Test
    public void iconConditionCheck() {
        String[] checkBoxesToClick = {"Commands"};
        String[][] arrayOfExpectedIconConditions = {{"Commands", "check"}, {"Notes", "uncheck"}, {"Desktop", "half-check"}};
        checkBoxPage.openCheckBoxPage();
        checkBoxPage.clickExpandAllButton();
        checkBoxPage.clickOnCheckBoxes(checkBoxesToClick);
        Assert.assertTrue(checkBoxPage.checkCondidtionOfCheckBoxesIcon(arrayOfExpectedIconConditions));
    }

}
