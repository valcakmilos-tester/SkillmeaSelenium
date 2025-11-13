package org.example;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class Login {
  private WebDriver driver;


  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "");
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
