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
 * TestCalc operations tests by Selenium
 */

@RunWith(Parameterized.class)
public class AppTestBySelenium {
    private final String path = "http://localhost:8080/testCalc/webUI";
    private WebDriver driver;

    private int valueA;
    private int valueB;



    public AppTestBySelenium(int valueA, int valueB) {
        this.valueA = valueA;
        this.valueB = valueB;
    }

    @Parameterized.Parameters(name = "{index}: valueA={0}, valueB={1}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                /*{1, 1},
                {2, 6},*/
                {18, 2},
                {13, 15},
                //{1, 0}
        });
    }


    @Before
    public void chromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get(path);
        //Find the text input element by its name
        WebElement value1 = driver.findElement(By.name("val1"));
        // Enter something as value 1
        value1.sendKeys(String.valueOf(valueA));
        // Find the text input element by its name
        WebElement value2 = driver.findElement(By.name("val2"));
        // Enter something as value 1
        value2.sendKeys(String.valueOf(valueB));

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

        assertTrue( x == (valueA + valueB));
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
        assertTrue( x == (valueA - valueB));
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

        assertTrue( x == (valueA * valueB));
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
        double x = Double.valueOf(result.getAttribute("value"));
        driver.quit();
        System.out.println("result : " + x);

        assertTrue( x == (valueA / valueB));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() throws InterruptedException {
        valueA = 1;
        valueB = 0;
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
        double x = Double.valueOf(result.getAttribute("value"));
        driver.quit();
        System.out.println("result : " + x);

        assertTrue( x == (valueA / valueB));
    }

}
