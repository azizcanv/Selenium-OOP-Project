package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.Driver;
import utils.ExcelUtil;
import utils.FileUtil;
import pages.*;

public class BeymenAutomationTest {

    private static final Logger logger = LogManager.getLogger(BeymenAutomationTest.class);
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        Driver.initDriver();
        driver = Driver.getDriver();
        wait = Driver.getWait();

        driver.manage().window().maximize();
        logger.info("Test setup completed.");
    }

    @AfterAll
    public static void teardown() {
        Driver.quitDriver();
        logger.info("Test teardown completed.");
    }

    @Test
    public void testBeymenSearchAndCart() throws Exception {
        HomePage homePage = new HomePage(driver, wait);
        SearchPage searchPage = new SearchPage(driver, wait);
        ProductPage productPage = new ProductPage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);
        ExcelUtil excelUtil = new ExcelUtil("searchTerms.xlsx");

        homePage.open();
        homePage.verifyHomePage();
        homePage.acceptCookies();
        homePage.selectGender();

        String shortTerm = excelUtil.readCell(0, 0);
        String shirtTerm = excelUtil.readCell(0, 1);

        searchPage.searchClick();
        searchPage.searchForItem(shortTerm);
        searchPage.searchClick();
        searchPage.clearSearchBox();
        searchPage.searchForItem(shirtTerm);
        String[] productDetailsData = searchPage.selectProductGetData(2);

        String productDetails = "Product Details: " + productDetailsData[0] + " - " + productDetailsData[1];
        FileUtil.writeToFile("productDetails.txt", productDetails);

        productPage.productValue();
        productPage.addToCart();
        productPage.goToCart();
        productPage.verifyCartPrice(productDetailsData[1]);

        cartPage.setProductQuantity(2);
        cartPage.verifyCartQuantity(2);

        cartPage.clearCart();
        cartPage.verifyCartIsEmpty();
    }
}