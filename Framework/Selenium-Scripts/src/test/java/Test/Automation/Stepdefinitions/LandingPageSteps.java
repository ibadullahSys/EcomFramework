package Test.Automation.Stepdefinitions;

import Test.Automation.Pages.LandingPage;
import Test.Automation.Utils.DriverFactory;
import Test.Automation.Utils.ExcelFileManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;

import static Test.Automation.Utils.DataPool.readExcelData;

public class LandingPageSteps extends DriverFactory {

    private LandingPage landingPage;

    public LandingPageSteps() throws Exception {
        landingPage = new LandingPage(driver);
    }

    @When("^user search on landing page$")
    public void user_search_on_landing_page() throws Throwable{

        //Reading xpath file information from setup sheet
        String xpathFileName = ExcelFileManager.readFromCell("Testdata","SetUp",1,"fileName");
        String xpathSheetName = ExcelFileManager.readFromCell("Testdata","SetUp",1,"sheetName");
        int xpathRowNumber = Integer.parseInt(ExcelFileManager.readFromCell("Testdata","SetUp",1,"rowToMatch"));

        //Getting xpath from xpath file
        String searchXpath = ExcelFileManager.readFromCell(xpathFileName,xpathSheetName,xpathRowNumber,"searchFieldPath");
        //String productXpath = ExcelFileManager.readFromCell(xpathFileName,xpathSheetName,xpathRowNumber,"productField");

        //Reading product file information from setup sheet
        String productFileName = ExcelFileManager.readFromCell("Testdata","SetUp",1,"productFileName");
        String productSheetName = ExcelFileManager.readFromCell("Testdata","SetUp",1,"productFileSheet");
        int productRowToMatch = Integer.parseInt(ExcelFileManager.readFromCell("Testdata","SetUp",1,"productRowToMatch"));

        //Getting product name from product file
        String productName = ExcelFileManager.readFromCell(productFileName,productSheetName,productRowToMatch,"productName");

        landingPage.searchForProduct(searchXpath,productName);
    }
}
