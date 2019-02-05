package test.pageobjects;

import application.page.base.ApplicationPageBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.objects.HomePage;
import page.objects.LogIn;
import util.xlsx.reader.XlsxDataReader;

import java.io.File;


public class LogInTest extends ApplicationPageBase {
    LogIn objLogIn = null;
    HomePage objHomePage = null;

    @BeforeMethod
    public void initializationOfElements() {
        objLogIn = PageFactory.initElements(driver, LogIn.class);
        objHomePage = PageFactory.initElements(driver, HomePage.class);

    }


    @DataProvider(name="DP")
    public Object[][] getTestData() throws Exception{
        File filepath = new File(System.getProperty("user.dir") +  "/DataTable/TestData.xlsx");
        XlsxDataReader dr = new XlsxDataReader();
        //Show me where is data file
        dr.setExcelFile(filepath.getAbsolutePath());
        String[][] data = dr.getExcelSheetData("Sheet1");
        return data;
    }

    @Test(dataProvider = "DP")
    public  void invalidLogIn(String email, String password, String expectedErroMessage){

        objHomePage.getLogIn();
        objLogIn.login(email, password);
        String expectedText = expectedErroMessage;
        String actualText = objLogIn.getErroMessage();
        Assert.assertEquals(actualText, expectedText);
    }
}


