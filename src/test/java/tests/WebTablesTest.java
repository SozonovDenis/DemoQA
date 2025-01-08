package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest {

    @Test
    public void deleteSomeRowsAndCheckCountOfFilledRows() {
        webTablesPage.openWebTablesPage();
        for (int i = 1; i <= 2; i++) { //удаление строк с 1 по 2
            webTablesPage.deleteRow(i);
        }
        Assert.assertEquals(webTablesPage.countOfFilledRows(), 1);
    }

    @Test
    public void changeQuantityOfRowsAndCheckCountOfRows() {
        int quantityOfRows = 25; //Допустимые значения - 5, 10, 20, 25, 50, 100
        webTablesPage.openWebTablesPage();
        webTablesPage.changeQuantityOfRows(quantityOfRows);
        Assert.assertEquals(webTablesPage.countOfFilledRows() + webTablesPage.countOfEmptyRows(), quantityOfRows);
    }

    @Test
    public void addNewRow() {
        int quantityOfRowsToAdd = 4;
        webTablesPage.openWebTablesPage();
        for (int i = 0; i < quantityOfRowsToAdd; i++) {
            webTablesPage.addNewRow();
        }
        Assert.assertEquals(webTablesPage.countOfFilledRows(), 3 + quantityOfRowsToAdd);
    }

}
