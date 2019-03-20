package ru.hadzage;

import org.springframework.web.client.RestTemplate;

public class HelloCalc {

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        Page page = restTemplate.getForObject("http://localhost:8080/testCalc/restWS/multiply?val1=3&val2=4", Page.class);
        System.out.println("Result:    " + page.getResult());
    }
}
