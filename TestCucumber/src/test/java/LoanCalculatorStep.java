import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Manfis on 12.01.2016.
 */
public class LoanCalculatorStep {
    protected WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("users open loan calculator")
    public void user_open_loan_calculator() {
        driver.get("http://www.thecalculatorsite.com/finance/calculators/loancalculator.php/");
    }

    @When("users enter (\\d+) into amount field")
    public void users_enter_amount_field(String amount){
        WebElement loanAmount = driver.findElement(By.id("amount"));
        loanAmount.sendKeys(amount);
    }

    @And("users enter (\\d+) into rate field")
    public void users_enter_rate_field(String rate){
        WebElement loanRate = driver.findElement(By.id("percent"));
        loanRate.sendKeys(rate);
    }

    @And("users enter (\\d+) into months field")
    public void users_enter_months_field(String months){
        WebElement loanRate = driver.findElement(By.id("term"));
        loanRate.sendKeys(months);
    }

    @And("users click on calculate button")
    public void users_click_button(){
        WebElement loanButton = driver.findElement(By.className("calculatorButton"));
        loanButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Then("users should get result as (\\d+)")
    public void users_should_get_result(String result){
        WebElement loanResult = driver.findElement(By.xpath("//tr[2]/td[5]"));
        String value = loanResult.getText().substring(1);

        Assert.assertEquals("values are not equal!!!!", value, result);

    }
}
