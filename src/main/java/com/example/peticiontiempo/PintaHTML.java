package com.example.peticiontiempo;

import java.util.List;

public class PintaHTML {

    static String hacerTabla(Raiz_Aemet tiempo) {
        String html="<html><head></head><body><h1>Clima de: "+tiempo.getNombre()+"</h1><table border=1 >";
        List<Dias> lista_dias=tiempo.getPrediccion();
        html=html+"<tr><th>Dia</th>"
                + "<th>Temperatura Max</th>"
                + "<th>Temperatura Min</th></tr>";
        for(Dias x: lista_dias){
            String fecha=x.getFecha();
            Temperatura c=x.getTemperatura();
            String maxima=c.getMaxima();
            String minima=c.getMinima();
            html=html+"<tr><td>"+fecha+"</td>"
                    + "<td>"+maxima+"</td>"
                    + "<td>"+minima+"</td>"
                    + "</tr>";
        }
        html=html+"</table></body></html>";
        return html;
    }

}

