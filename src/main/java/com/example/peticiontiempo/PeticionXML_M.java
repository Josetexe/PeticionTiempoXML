package com.example.peticiontiempo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


public class PeticionXML_M {
    private static ComunicacionPedirClima clase_llamante;

    public PeticionXML_M(ComunicacionPedirClima clase_llamante) {
        this.clase_llamante = clase_llamante;
    }

    public static void pedirMunicipios(String nombre_pro)
    {
        String base="http://ovc.catastro.meh.es";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base).addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        InterfaceMunicipio servicio=retrofit.create(InterfaceMunicipio.class);

        Call<Raiz_Municipiero> llamada=servicio.pedirMunicipio(nombre_pro , "" );
        llamada.enqueue(new Callback<Raiz_Municipiero>() {
            @Override
            public void onResponse(Call<Raiz_Municipiero> call, Response<Raiz_Municipiero> rspns) {
                Raiz_Municipiero r =rspns.body();
                clase_llamante.mostrarDatos(r);

            }

            @Override
            public void onFailure(Call<Raiz_Municipiero> call, Throwable thrwbl) {
                System.out.println("ERROR: "+thrwbl.getMessage());
            }
        });
    }
    public interface ComunicacionPedirClima{
        public void mostrarDatos(Raiz_Municipiero r);
    }
}
