package com.example.peticiontiempo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class PeticionXML_Aemet {
    private static ComunicacionPedirClima clase_llamante;

    public PeticionXML_Aemet(ComunicacionPedirClima clase_llamante) {
        this.clase_llamante = clase_llamante;
    }

    public static void pedirClima(String codigo_final)
    {
        String base="http://www.aemet.es//";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base).addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        InterfaceAemet servicio=retrofit.create(InterfaceAemet.class);
        Call<Raiz_Aemet> llamada=servicio.pedirClima(codigo_final);
        llamada.enqueue(new Callback<Raiz_Aemet>() {
            @Override
            public void onResponse(Call<Raiz_Aemet> call, Response<Raiz_Aemet> rspns) {
                Raiz_Aemet a =rspns.body();
                clase_llamante.mostrarDatos(a);
            }

            @Override
            public void onFailure(Call<Raiz_Aemet> call, Throwable thrwbl) {
                System.out.println("ERROR: "+thrwbl.getMessage());
            }
        });
    }
    public interface ComunicacionPedirClima{
        public void mostrarDatos(Raiz_Aemet r);
    }
}
