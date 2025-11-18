package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class Formular {
    private WebDriver driver;
    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterEach
    public void tearDown(){
        // Pre zatvorenie okna prehliadaca
        driver.close();
        // Pre zatvorenie zrusenia objektu
        driver.quit();
    }
    @Test
    public void formTest() {
        // Prikaz na otvorenie stranky
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.findElement(By.id("name")).sendKeys("Milos Valcak");
        driver.findElement(By.id("email")).sendKeys("email@email.com");
        driver.findElement(By.id("gender")).click();

        driver.findElement(By.xpath("//*[@id=\"practiceForm\"]/div[3]/div/div/div[2]")).click();
        // Validacia, ci su radio buttons zaskrtnute
        assertTrue(driver.findElement(By.xpath("//*[@id=\"practiceForm\"]/div[3]/div/div/div[2]/input")).isSelected());
        assertFalse(driver.findElement(By.id("gender")).isSelected(),"Radio button je zaskrtnuty :(");
    }
}