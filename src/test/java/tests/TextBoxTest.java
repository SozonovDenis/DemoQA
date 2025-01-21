package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TextBoxTest extends BaseTest {

    @Test
    public void CorrectInputAllFields() {
        String fullName = "Sozonov Denis";
        String email = "qwerty@gmail.com";
        String currentAddress = "Some current address";
        String permanentAddress = "Some permanent address";
        textBoxPage.openTextBoxPage();
        textBoxPage.fillFields(fullName, email, currentAddress, permanentAddress);
        textBoxPage.submitButton();
        String[] outputDataArray = textBoxPage.outputData(fullName, email, currentAddress, permanentAddress);
        String[] expectedOutputDataArray = textBoxPage.expectedOutputData(fullName, email, currentAddress, permanentAddress);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outputDataArray[0], expectedOutputDataArray[0]);
        softAssert.assertEquals(outputDataArray[1], expectedOutputDataArray[1]);
        softAssert.assertEquals(outputDataArray[2], expectedOutputDataArray[2]);
        softAssert.assertEquals(outputDataArray[3], expectedOutputDataArray[3]);
        softAssert.assertAll();
    }

    @Test
    public void CorrectInputPartOfFields() {
        String fullName = "Sozonov Denis";
        String email = "";
        String currentAddress = "Some current address";
        String permanentAddress = "";
        textBoxPage.openTextBoxPage();
        textBoxPage.fillFields(fullName, email, currentAddress, permanentAddress);
        textBoxPage.submitButton();
        String[] outputDataArray = textBoxPage.outputData(fullName, email, currentAddress, permanentAddress);
        String[] expectedOutputDataArray = textBoxPage.expectedOutputData(fullName, email, currentAddress, permanentAddress);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outputDataArray[0], expectedOutputDataArray[0]);
        softAssert.assertEquals(outputDataArray[1], expectedOutputDataArray[1]);
        softAssert.assertEquals(outputDataArray[2], expectedOutputDataArray[2]);
        softAssert.assertEquals(outputDataArray[3], expectedOutputDataArray[3]);
        softAssert.assertAll();
    }

    @Test
    public void EmailFieldErrorCheck() {
        String fullName = "";
        String email = "111@222"; //Невалидный емейл
        String currentAddress = "";
        String permanentAddress = "";
        textBoxPage.openTextBoxPage();
        textBoxPage.fillFields(fullName, email, currentAddress, permanentAddress);
        textBoxPage.submitButton();
        Assert.assertTrue(textBoxPage.isEmailFieldErrorPresent());
    }

}
