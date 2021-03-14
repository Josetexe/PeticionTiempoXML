package com.example.peticiontiempo;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="consulta_provinciero", strict =false)
public class Raiz_Provinciero {
    @ElementList
    private List<Provinciero> provinciero;

    public List<Provinciero> getProvinciero() {
        return provinciero;
    }

    public void setProvinciero(List<Provinciero> provincias) {
        this.provinciero = provincias;
    }

    @Override
    public String toString() {
        return "ClaseRaiz{" + "Provincia=" + provinciero + '}';
    }

}

