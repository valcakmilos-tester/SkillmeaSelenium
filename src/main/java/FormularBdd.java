import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
// junit.jupiter nemoze pouziavat spolocne s cucumber kniznicou
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Ak pouzivam rozne kniznice, treba ich zjednosti, cize pre beforeEach a AfterEach nepouzijem z junit.jupite ale z cucumber
public class FormularBdd {
    private WebDriver driver;
    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
        // Pre zatvorenie okna prehliadaca
        driver.close();
        // Pre zatvorenie zrusenia objektu
        driver.quit();
    }



    @Given("Uzivatel je na stranke s formularom")
    public void uzivatelJeNaStrankeSFormularom() {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
    }

    @When("Uzivatel napise do input meno {string}")
    public void uzivatelNapiseDoInputMeno(String meno) {
        driver.findElement(By.id("name")).sendKeys(meno);
    }

    @And("Uzivatel napise do input email {string}")
    public void uzivatelNapiseDoInputEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @And("Uzivatel klikne na radiobutton male")
    public void uzivatelKlikneNaRadiobuttonMale() {
        driver.findElement(By.id("gender")).click();
    }

    @And("Uzivatel klikne na radiobutton female")
    public void uzivatelKlikneNaRadiobuttonFemale() {
        driver.findElement(By.xpath("//*[@id=\"practiceForm\"]/div[3]/div/div/div[2]")).click();
    }

    @Then("Uzivatel vidi zaskrtnuty radiobutton female")
    public void uzivatelVidiZaskrtnutyRadiobuttonFemale() {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"practiceForm\"]/div[3]/div/div/div[2]/input")).isSelected());
    }

    @And("Uzivatel vidi odskrtnuty radiobutton male")
    public void uzivatelVidiOdskrtnutyRadiobuttonFemale() {
        assertFalse(driver.findElement(By.id("gender")).isSelected(),"Radio button je zaskrtnuty :(");
    }
}
