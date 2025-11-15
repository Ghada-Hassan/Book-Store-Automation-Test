package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
   private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By seleniumBookPrice = By.cssSelector("a[href*=selenium-ruby] .price .amount");
    By shoppingCartLink = By.xpath("//a[@title='View your shopping cart']");


    public void clickOnAddBookToBasket(String bookName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the "Add to basket" button relative to the book name
        By addToCartButton = By.xpath("//h3[text()='" + bookName + "']/ancestor::li//a[contains(@class, 'add_to_cart_button')]");

        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();
    }

    public String getSeleniumBookPrice(){
        return driver.findElement(seleniumBookPrice).getText();
    }

    public boolean isBookDisplayed(String bookName){
       return driver.findElement(By.xpath("//h3[text()='"+ bookName +"']")).isDisplayed();
    }

    public ShoppingCartPage clickOnShoppingCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink));
        driver.findElement(shoppingCartLink).click();
        return new ShoppingCartPage(driver);
    }

}
