package ru.hadzage;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

/**
 * TestCalc operations Tests :-)
 */

@RunWith(Parameterized.class)
public class AppTest {
    private static String path = "http://localhost:8080/testCalc/webUI";
    private WebDriver driver;
    private static int a;
    private static int b;

    private int valueA;
    private int valueB;
    private int expected;



    public AppTest(int valueA, int valueB, int expected) {
        this.valueA = valueA;
        this.valueB = valueB;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:sumOf({0}+{1})={2}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {1, 1, 2},
                {2, 6, 8},
                {18, 2, 20},
                {13, 15, 28},
                {1, 5, 6}
        });
    }

    @Parameterized.Parameters(name = "{index}:difOf({2}+{1})={1}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {2, 1, 1},
                {15, 7, 8},
                {18, 20, -2},
                {135, 67, 68},
                {100500, 500, 100000}
        });
    }



    @Before
    public void ChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get(path);
        //Find the text input element by its name
        WebElement value1 = driver.findElement(By.name("val1"));
        // Enter something as value 1
        a = 5;
        value1.sendKeys(String.valueOf(a));
        // Find the text input element by its name
        WebElement value2 = driver.findElement(By.name("val2"));
        // Enter something as value 1
        b = 5;
        value2.sendKeys(String.valueOf(b));

    }

    @Test
    public void testAddition() throws InterruptedException {
        // Find the operation element by its css
        WebElement operadd = driver.findElement(By.cssSelector("input[value=\"add\"]"));
        operadd.click();
        // Find the calculate button element by its css
        WebElement calculate = driver.findElement(By.cssSelector("input[value=\"Calculate\"]"));
        calculate.click();
        Thread.sleep(1000);
        //Find the result field element by its css
        WebElement result = driver.findElement(By.cssSelector("input[name=\"result\"]"));
        int x = Integer.parseInt(result.getAttribute("value"));
        driver.quit();

        assertTrue( x == (a + b));
    }

    @Test
    public void testSubtract() throws InterruptedException {
        // Find the operation element by its css
        WebElement opersub = driver.findElement(By.cssSelector("input[value=\"sub\"]"));
        opersub.click();
        // Find the calculate button element by its css
        WebElement calculate = driver.findElement(By.cssSelector("input[value=\"Calculate\"]"));
        calculate.click();
        Thread.sleep(1000);
        //Find the result field element by its css
        WebElement result = driver.findElement(By.cssSelector("input[name=\"result\"]"));
        int x = Integer.parseInt(result.getAttribute("value"));
        driver.quit();
        assertTrue( x == (a - b));
    }

    @Test
    public void testMultiplication() throws InterruptedException {
        // Find the operation element by its css
        WebElement opermul = driver.findElement(By.cssSelector("input[value=\"mul\"]"));
        opermul.click();
        // Find the calculate button element by its css
        WebElement calculate = driver.findElement(By.cssSelector("input[value=\"Calculate\"]"));
        calculate.click();
        Thread.sleep(1000);
        //Find the result field element by its css
        WebElement result = driver.findElement(By.cssSelector("input[name=\"result\"]"));
        int x = Integer.parseInt(result.getAttribute("value"));
        driver.quit();

        assertTrue( x == (a * b));
    }

    @Test
    public void testDivision() throws InterruptedException {
        // Find the operation element by its css
        WebElement operdiv = driver.findElement(By.cssSelector("input[value=\"div\"]"));
        // Now submit the form. WebDriver will find the form for us from the element
        operdiv.click();
        // Find the calculate button element by its css
        WebElement calculate = driver.findElement(By.cssSelector("input[value=\"Calculate\"]"));
        // Now submit the form. WebDriver will find the form for us from the element
        calculate.click();
        Thread.sleep(1000);
        //Find the result field element by its css
        WebElement result = driver.findElement(By.cssSelector("input[name=\"result\"]"));
        int x = Integer.parseInt(result.getAttribute("value"));
        driver.quit();

        assertTrue( x == (a / b));
    }

}
