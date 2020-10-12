package Test.Automation.Pages;

import Test.Automation.Utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import javax.rmi.CORBA.Util;


public class LandingPage extends DriverFactory {


    public LandingPage(WebDriver driver) throws Exception {
        PageFactory.initElements(driver,this);

    }

//    public static void Initializer() throws Exception{
//        String searchFieldPath = ExcelFileManager.readFromCell("Testdata", "XPaths", 1, "searchFieldPath");
//        searchProduct = driver.findElement(By.xpath(searchFieldPath));
//    }


    public void searchForProduct(String searchXpath, String productName) throws Exception{
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.elementClick(searchXpath);
        UtilityMethods.elementSendKeys(searchXpath,productName);
        //searchProduct.click();
        //searchProduct.sendKeys(productName);
        UtilityMethods.wait1Seconds();
        UtilityMethods.elementSendKeys(searchXpath,Keys.ENTER);
        //searchProduct.sendKeys(Keys.ENTER);
        UtilityMethods.waitForPageLoadAndPageReady();
    }

}
