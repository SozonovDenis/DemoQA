package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ButtonsTest extends BaseTest {
    @Test
    public void leftClickOnClickMeButton() {
        String buttonName = "Click Me";
        buttonsPage.openButtonsPage();
        buttonsPage.clickButton(buttonName, "Left click");
        Assert.assertTrue(buttonsPage.checkOutput(buttonName));
    }

    @Test
    public void rightClickOnRightClickMeButton() {
        String buttonName = "Right Click Me";
        buttonsPage.openButtonsPage();
        buttonsPage.clickButton(buttonName, "Right click");
        Assert.assertTrue(buttonsPage.checkOutput(buttonName));
    }

    @Test
    public void doubleClickOnDoubleClickMeButton() {
        String buttonName = "Double Click Me";
        buttonsPage.openButtonsPage();
        buttonsPage.clickButton(buttonName, "Double click");
        Assert.assertTrue(buttonsPage.checkOutput(buttonName));
    }

    @Test
    public void allButtonsClick() {
        SoftAssert softAssert = new SoftAssert();
        buttonsPage.openButtonsPage();
        String buttonName = "Click Me";
        buttonsPage.clickButton(buttonName, "Left click");
        softAssert.assertTrue(buttonsPage.checkOutput(buttonName));
        buttonName = "Right Click Me";
        buttonsPage.clickButton(buttonName, "Right click");
        softAssert.assertTrue(buttonsPage.checkOutput(buttonName));
        buttonName = "Double Click Me";
        buttonsPage.clickButton(buttonName, "Double click");
        softAssert.assertTrue(buttonsPage.checkOutput(buttonName));
        softAssert.assertAll();
    }

}
