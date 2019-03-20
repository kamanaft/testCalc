package ru.hadzage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * TestCalc Project!
 *
 */
public class App {

    private static String path = "http://localhost:8080/testCalc/webUI";

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get(path);

        //Find the text input element by its name
        WebElement value1 = driver.findElement(By.name("val1"));
        // Enter something as value 1
        value1.sendKeys("5");
        // Find the text input element by its name
        WebElement value2 = driver.findElement(By.name("val2"));
        // Enter something as value 1
        value2.sendKeys("5");
        // Find the text input element by its css
        WebElement operadd = driver.findElement(By.cssSelector("input[value=\"add\"]"));
        operadd.click();
        // Find the text input element by its css
        WebElement calculate = driver.findElement(By.cssSelector("input[value=\"Calculate\"]"));
        calculate.click();
        Thread.sleep(1000);
        //Find the text input element by its css
        WebElement result = driver.findElement(By.cssSelector("input[name=\"result\"]"));

        //System.out.println("3 multiply to to 4: " + result.getAttribute("value"));



        driver.quit();

    }
}
