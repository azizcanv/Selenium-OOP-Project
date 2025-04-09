package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void searchClick() {
        WebElement searchBox = driver.findElement(By.cssSelector("input[placeholder='Ürün, Marka Arayın']"));
        searchBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='o-header__form--close']")));
    }

    public void searchForItem(String searchTerm) {
        WebElement searchBox = driver.findElement(By.cssSelector("input[id='o-searchSuggestion__input']"));
        searchBox.sendKeys(searchTerm + Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='o-productList__item'])[1]")));
    }

    public void clearSearchBox() {
        WebElement searchBox = driver.findElement(By.cssSelector("input[id='o-searchSuggestion__input']"));
        searchBox.clear();
    }

    public String[] selectProductGetData(int productIndex) {
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='o-productList__item'])[" + productIndex + "]")));
        product.click();

        WebElement productInfoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='o-productDetail__description']")));
        WebElement productPriceElement = driver.findElement(By.cssSelector("ins[id='priceNew']"));

        String productInfo = productInfoElement.getText();
        String productPrice = productPriceElement.getText();

        return new String[]{productInfo, productPrice};
    }

}