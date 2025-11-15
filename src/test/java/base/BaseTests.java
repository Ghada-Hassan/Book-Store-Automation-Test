package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://practice.automationtesting.in/");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void terminate(){
        driver.quit();
    }

}
