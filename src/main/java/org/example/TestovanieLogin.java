package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;


public class TestovanieLogin {
private WebDriver driver;

  @BeforeEach
  public void setUp() {
        // Toto plati len pre klasicke pridanie chrome driver
      /* System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\ProgramovanieKody\\SkillmeaOOP2\\SkilmeaBDD\\SkillmeaSelenium\\SkillmeaSelenium\\src\\main\\resources\\chromedriver.exe");
    driver = new ChromeDriver();
   */
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
  }

  @Test
  public void testLogin() {
    System.out.println("Otvorenie stránky");
    driver.get("https://www.tutorialspoint.com/selenium/practice/login.php");
    System.out.println("Vyplnenie hesla");
    driver.findElement(By.id("password")).sendKeys("heslo");
    System.out.println("Vyplnenie emailu");
    driver.findElement(By.id("email")).sendKeys("novyemail@email.com");
    System.out.println("Kliknutie na Login");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    System.out.println("Overenie výsledku");
    assertEquals("Welcome, Login In", driver.findElement(By.xpath("//*[@id=\"signInForm\"]/h1")).getText());
  }
    /*  @AfterAll
      public static void tearDown() {

              if (driver != null) {
                  driver.quit();
                  System.out.println("Prehliadač zatvorený");
              }
          }
*/
      }
