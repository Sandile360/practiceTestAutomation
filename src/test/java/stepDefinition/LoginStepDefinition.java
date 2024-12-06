package stepDefinition;

import driverFactory.DriverFactory;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LoginStepDefinition {
    protected WebDriver driver;

    By menuBtnPractice = By.xpath("//a[normalize-space()='Practice']");
    By btnTestLoginPage = By.xpath("//a[normalize-space()='Test Login Page']");
    By btnLogOut = By.xpath("//a[normalize-space()='Log out']");

    By username = By.id("username");
    By password = By.id("password");
    By btnSubmit = By.id("submit");
    By msgError = By.id("error");

    @Before
    public void setUp(){
        driver = DriverFactory.getDriver("firefox");
        driver.navigate().to("https://practicetestautomation.com");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Given("user navigates to login page")
    public void userNavigatesToLoginPage() {

        driver.findElement(menuBtnPractice).click();
        driver.findElement(btnTestLoginPage).click();

    }

    @When("^user type valid (.+) (.+) and click submit$")
    public void userTypeValidUsernamePasswordAndClickSubmit(String name, String pass) {
        driver.findElement(username).sendKeys(name);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(btnSubmit).click();
    }

    @And("verify page URL, expected text and click logout")
    public void verifyPageURLExpectedTextAndClickLogout() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://practicetestautomation.com/logged-in-successfully/",url);
        String txt = driver.findElement(btnLogOut).getText();
        Assert.assertEquals("Log out",txt);
        driver.findElement(btnLogOut).click();
    }

    @When("^user type invalid (.+) (.+) and click submit$")
    public void userTypeInvalidIncorrectUserIncorrectPasswordAndClickSubmit(String name, String pass) {
        driver.findElement(username).sendKeys(name);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(btnSubmit).click();
    }

    @Then("verify error message")
    public void verifyErrorMessage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(msgError).isDisplayed();
        String txt = driver.findElement(msgError).getText();
        String expected = "Your username is invalid!";
        if(txt.equals(expected)) {
            Assert.assertEquals(expected, txt);
        } else {
            Assert.assertEquals("Your password is invalid!", txt);

        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

