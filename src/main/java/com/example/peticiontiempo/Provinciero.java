package com.example.peticiontiempo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="consulta_provinciero", strict =false)
public class Provinciero {
    @Element(name = "cpine")
    private String codigo;
    @Element(name = "np")
    private String nombre;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  nombre;
    }

}
