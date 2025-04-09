package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://www.beymen.com");
    }

    public void verifyHomePage() {
        Assertions.assertTrue(driver.getTitle().contains("Beymen"), "Homepage did not load correctly.");
    }

    public void acceptCookies() {
        WebElement acceptButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='onetrust-accept-btn-handler']")));
        acceptButton.click();
    }

    public void selectGender() {
        WebElement genderButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='genderManButton']")));
        genderButton.click();
    }
}
