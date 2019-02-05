package test.pageobjects;

import base.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BrowserDriver {

    @Test
    public void SearchPageTest() {

        driver.findElement(By.id("search_text")).sendKeys("Laptop Sleeve", Keys.ENTER);
        String actualText = driver.findElement(By.partialLinkText("Kensington SP17 17\" Classic Laptop Sleeve")).getText();
        System.out.println("HomePage : Test Passed");

        Assert.assertEquals(actualText, "Kensington SP17 17\" Classic Laptop Sleeve");

    }

    @Test
    public void LoginlinkTest() {

        driver.findElement(By.cssSelector("#nav_login > a")).click();
        String actualText = driver.findElement(By.cssSelector("#login_main > legend")).getText();
        Assert.assertEquals(actualText, "Returning Customers");
        System.out.println("Log In link - Test Passed");
    }

    @Test
    public void HelplinkTest() {

        driver.findElement(By.cssSelector("#tbl_rtHalf > tbody > tr > td:nth-child(4) > a")).click();
        String actualText = driver.findElement(By.cssSelector("#hcHeader > h1")).getText();
        Assert.assertEquals(actualText, "Help Center");
        System.out.println("Help link - Test Passed");
    }
}

