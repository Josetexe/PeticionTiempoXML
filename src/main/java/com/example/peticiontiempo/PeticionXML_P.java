package com.example.peticiontiempo;


import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


public class PeticionXML_P {

        private static ComunicacionPedirClima clase_llamante;

        public PeticionXML_P(ComunicacionPedirClima clase_llamante) {
            this.clase_llamante = clase_llamante;
        }


        public static void pedirProvicias()
        {
            String base="http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(base).addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();
            InterfaceProvincia servicio=retrofit.create(InterfaceProvincia.class);
            Call<Raiz_Provinciero> llamada=servicio.pedirProvincia();
            llamada.enqueue(new Callback<Raiz_Provinciero>() {
                @Override
                public void onResponse(Call<Raiz_Provinciero> call, Response<Raiz_Provinciero> rspns) {
                    Raiz_Provinciero p =rspns.body();
                    clase_llamante.mostrarDatos(p);

                }

                @Override
                public void onFailure(Call<Raiz_Provinciero> call, Throwable thrwbl) {
                    System.out.println("ERROR: "+thrwbl.getMessage());
                }
            });
        }
        public interface ComunicacionPedirClima{
            public void mostrarDatos(Raiz_Provinciero r);
        }
}

