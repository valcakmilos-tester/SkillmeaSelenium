package org.example;


import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class Login {
  private WebDriver driver;


  @Before
  public void setUp() {
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
