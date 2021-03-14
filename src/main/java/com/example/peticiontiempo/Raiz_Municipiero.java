package com.example.peticiontiempo;


import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="consulta_municipiero", strict =false)
public class Raiz_Municipiero {
    @ElementList
    private List<Municipiero> municipiero;

    public List<Municipiero> getMunicipiero() {

        return municipiero;
    }

    public void setMunicipiero(List<Municipiero> municipiero) {
        this.municipiero = municipiero;
    }

    @Override
    public String toString() {
        return "ClaseRaiz{" + "municipiero=" + municipiero + '}';
    }

}
