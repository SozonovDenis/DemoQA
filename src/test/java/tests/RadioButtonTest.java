package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    @Test
    public void checkOutputBlockNotShownByDefault() {
        radioButtonPage.openRadioButtonPage();
        Assert.assertFalse(radioButtonPage.isOutputDisplayed());
    }

    @Test
    public void checkOutputOfYesRadioButton() {
        String radioButtonName = "Yes";
        radioButtonPage.openRadioButtonPage();
        radioButtonPage.clickRadioButton(radioButtonName);
        Assert.assertEquals(radioButtonPage.getOutputText(), "You have selected " + radioButtonName);
    }

    @Test
    public void checkOutputOfImpressiveRadioButton() {
        String radioButtonName = "Impressive";
        radioButtonPage.openRadioButtonPage();
        radioButtonPage.clickRadioButton(radioButtonName);
        Assert.assertEquals(radioButtonPage.getOutputText(), "You have selected " + radioButtonName);
    }

    @Test
    public void checkOutputOfNoRadioButton() {
        String radioButtonName = "No";
        radioButtonPage.openRadioButtonPage();
        radioButtonPage.clickRadioButton(radioButtonName);
        Assert.assertFalse(radioButtonPage.isOutputDisplayed());
    }

}
