package ru.hadzage;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * TestCalc operations REST tests
 */
@RunWith(Parameterized.class)
public class RestTest {

    private int valueA;
    private int valueB;

    public RestTest(int valueA, int valueB) {
        this.valueA = valueA;
        this.valueB = valueB;
    }

    @Parameterized.Parameters(name = "{index}: valueA={0}, valueB={1}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                //{1, 1},
                {2, 6},
                {18, 2},
                {13, 15},
                //{1, 0}
        });
    }

    @Test
    public void testAddition () {
        RestTemplate restTemplate = new RestTemplate();
        String pathAdd = ("http://localhost:8080/testCalc/restWS/add?val1=" + String.valueOf(valueA) +  "&val2=" + String.valueOf(valueB));
        Page res = restTemplate.getForObject(pathAdd, Page.class);

        assertTrue(res.getResult() == (valueA + valueB));
    }

    @Test
    public void testSubstraction () {
        RestTemplate restTemplate = new RestTemplate();
        String pathAdd = ("http://localhost:8080/testCalc/restWS/subtract?val1=" + String.valueOf(valueA) +  "&val2=" + String.valueOf(valueB));
        Page res = restTemplate.getForObject(pathAdd, Page.class);

        assertTrue(res.getResult() == (valueA - valueB));
    }

    @Test
    public void testMultiplication () {
        RestTemplate restTemplate = new RestTemplate();
        String pathAdd = ("http://localhost:8080/testCalc/restWS/multiply?val1=" + String.valueOf(valueA) +  "&val2=" + String.valueOf(valueB));
        Page res = restTemplate.getForObject(pathAdd, Page.class);

        assertTrue(res.getResult() == (valueA * valueB));
    }

    @Test
    public void testDivision () {
        RestTemplate restTemplate = new RestTemplate();
        String pathAdd = ("http://localhost:8080/testCalc/restWS/divide?val1=" + String.valueOf(valueA) +  "&val2=" + String.valueOf(valueB));
        Page res = restTemplate.getForObject(pathAdd, Page.class);

        assertTrue(res.getResult() == (valueA / valueB));
    }

}
