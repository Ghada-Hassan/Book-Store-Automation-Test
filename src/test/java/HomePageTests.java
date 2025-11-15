import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ShoppingCartPage;


public class HomePageTests extends BaseTests {

    @Test
    public void validateThatBooksExistInHomePage(){
        Assert.assertTrue(homePage.isBookDisplayed("Selenium Ruby"),"Selenium book isn't displayed");
        Assert.assertTrue(homePage.isBookDisplayed("Thinking in HTML"),"HTML book isn't displayed");
        Assert.assertTrue(homePage.isBookDisplayed("Mastering JavaScript"),"HTML book isn't displayed");
    }

    @Test
    public void validateThatSeleniumBookCanBeAddedToBasketWithTheCorrectPrice(){
        homePage.clickOnAddBookToBasket("Selenium Ruby");
        ShoppingCartPage shoppingCartPage = homePage.clickOnShoppingCart();

       //selenium book
        Assert.assertTrue(shoppingCartPage.isBookAddedToCart("Selenium Ruby"),"Selenium Ruby book isn't added to basket");
        Assert.assertEquals(shoppingCartPage.isBookAddedToCartWithTheCorrectPrice(),"₹500.00","Selenium Ruby book price isn't correct");
    }

    @Test
    public void validateThatJavaScriptBookCanBeAddedToBasketWithTheCorrectPrice(){

        homePage.clickOnAddBookToBasket("Mastering JavaScript");
        ShoppingCartPage shoppingCartPage = homePage.clickOnShoppingCart();

        //Mastering JavaScript book
        Assert.assertTrue(shoppingCartPage.isBookAddedToCart("Mastering JavaScript"),"Mastering JavaScript book isn't added to basket");
        Assert.assertEquals(shoppingCartPage.isBookAddedToCartWithTheCorrectPrice(),"₹350.00","Mastering JavaScript book price isn't correct");
    }

    @Test
    public void validateThatBillingFormIsDisplayed(){
        homePage.clickOnAddBookToBasket("Thinking in HTML");
        ShoppingCartPage shoppingCartPage = homePage.clickOnShoppingCart();
        CheckoutPage checkoutPage = shoppingCartPage.clickOnProceedToCheckout();
        Assert.assertTrue(checkoutPage.isBillingDetailsFormDisplayed(),"billing details form isn't displayed");
    }

}
