package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.example.Login.driver;

import static org.junit.jupiter.api.Assertions.*;

public class Formular {
    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void formTest() {
        // Prikaz na otvorenie stranky
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.findElement(By.id("name")).sendKeys("Milos Valcak");
        driver.findElement(By.id("email")).sendKeys("email@email.com");
        driver.findElement(By.id("gender")).click();

        driver.findElement(By.xpath("//*[@id=\"practiceForm\"]/div[3]/div/div/div[2]")).click();

        assertTrue(driver.findElement(By.xpath("//*[@id=\"practiceForm\"]/div[3]/div/div/div[2]/input")).isSelected());
        assertFalse(driverdriver.findElement(By.id("gender")).isSelected(),"Radio button je zaskrtnuty :(");
    }
}