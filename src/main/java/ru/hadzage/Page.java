package ru.hadzage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Page {
    private Double result;

    public Double getResult() {
        return result;
    }

}
