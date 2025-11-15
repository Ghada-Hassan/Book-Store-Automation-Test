package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {
    private WebDriver driver;
    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }

   By cartItemsPrices = By.cssSelector("td.product-price .amount");
   By proceedToCheckoutBtn = By.cssSelector("a.checkout-button");
   By couponCode = By.id("coupon_code");
   By applyCouponBtn = By.name("apply_coupon");


    public boolean isBookAddedToCart(String bookName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bookInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + bookName + "']")));
        return bookInCart.isDisplayed();
    }

    public String isBookAddedToCartWithTheCorrectPrice(){
        return driver.findElement(cartItemsPrices).getText();
    }
    public CheckoutPage clickOnProceedToCheckout(){
        driver.findElement(proceedToCheckoutBtn).click();
        return new CheckoutPage(driver);
    }

    public void addCoupon(String coupon){
        driver.findElement(couponCode).clear();
        driver.findElement(couponCode).sendKeys(coupon);
        driver.findElement(applyCouponBtn).click();
    }

}
