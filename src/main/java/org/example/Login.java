package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;


public class Login {
private static WebDriver driver;

  @BeforeAll
  public static void setUp() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\ProgramovanieKody\\SkillmeaOOP2\\SkilmeaBDD\\SkillmeaSelenium\\SkillmeaSelenium\\src\\main\\resources\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Test
  public void testLogin() {
    driver.get("https://www.tutorialspoint.com/selenium/practice/login.php");
    driver.findElement(By.id("password")).sendKeys("heslo");
    driver.findElement(By.id("email")).sendKeys("novyemail@email.com");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    assertEquals("Welcome, Login In", driver.findElement(By.xpath("//*[@id=\"signInForm\"]/h1")).getText());
  }
}
