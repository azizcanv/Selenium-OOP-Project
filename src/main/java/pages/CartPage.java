package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void setProductQuantity(int quantity) {
        WebElement quantityDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='m-select -small']>select")));

        Select select = new Select(quantityDropdown);

        try {
            select.selectByValue(String.valueOf(quantity));
            System.out.println("Product quantity is set to " + quantity + ".");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Selected quantity is not available: " + quantity, e);
        }

    }

    public void verifyCartQuantity(int expectedQuantity) {
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='m-select -small']>select")));
        String actualQuantity = quantityInput.getAttribute("value");
        Assertions.assertEquals(String.valueOf(expectedQuantity), actualQuantity, "Quantity did not update correctly.");
    }

    public void clearCart() {
        WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='m-basket__remove']")));
        removeButton.click();
    }

    public void verifyCartIsEmpty() {
        WebElement emptyCartMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='m-empty__messageBtn']")));
        Assertions.assertTrue(emptyCartMessage.isDisplayed(), "Cart is not empty.");
    }
}
