public class LoginSteps package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.tagName("button"));

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginButton.click();
    }

    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        WebElement profile = driver.findElement(By.id("welcome"));
        assertTrue(profile.isDisplayed());
        driver.quit();
    }

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.tagName("button"));

        username.sendKeys("WrongUser");
        password.sendKeys("wrongpassword");
        loginButton.click();
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        WebElement errorMessage = driver.findElement(By.id("spanMessage"));
        assertTrue(errorMessage.isDisplayed());
        driver.quit();
    }
}
{
}
