package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void productValue() {
        boolean sizeSelected = false;
        int maxAttempts = 5;

        for (int i = 1; i <= maxAttempts; i++) {
            try {
                WebElement sizeOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='m-variation']/span)[" + i + "]")));

                if (sizeOption.isDisplayed() && sizeOption.isEnabled()) {
                    sizeOption.click();
                    sizeSelected = true;
                    System.out.println("Selected size: " + sizeOption.getText());
                    break;
                }
            }catch (Exception e) {
                System.out.println("Size option is not clickable\n: " + i);
            }

            if (!sizeSelected) {
                throw new RuntimeException("No suitable size option found.");
            }
        }
    }

    public void addToCart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='addBasket']")));
        addToCartButton.click();
    }

    public void goToCart() {
        WebElement goToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Sepetim']")));
        goToCartButton.click();
    }

    public void verifyCartPrice(String expectedPrice) {
        String actualPrice = driver.findElement(By.cssSelector("li[class='m-orderSummary__item -grandTotal']>span[class='m-orderSummary__value']")).getText();

        if (actualPrice.contains(",")) {
            actualPrice = actualPrice.split(",")[0] + " TL";
        }

        Assertions.assertEquals(expectedPrice, actualPrice, "Prices do not match.");
    }
}