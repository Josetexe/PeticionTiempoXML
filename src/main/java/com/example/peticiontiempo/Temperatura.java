package com.example.peticiontiempo;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "root",strict = false)
public class Temperatura {
    @Element(name = "maxima")
    private String maxima;
    @Element(name = "minima")
    private String minima;

    public String getMaxima() {
        return maxima;
    }

    public void setMaxima(String maxima) {
        this.maxima = maxima;
    }

    public String getMinima() {
        return minima;
    }

    public void setMinima(String minima) {
        this.minima = minima;
    }

    @Override
    public String toString() {
        return "Temperatura{" + "maxima=" + maxima + ", minima=" + minima + '}';
    }

}

