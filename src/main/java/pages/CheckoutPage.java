package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    By billingDetailsForm = By.cssSelector("div.woocommerce-billing-fields");

    public boolean isBillingDetailsFormDisplayed(){
        return driver.findElement(billingDetailsForm).isDisplayed();
    }

}
