package ru.hadzage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Page {
    private String result;

    public String getResult() {
        return result;
    }

}
