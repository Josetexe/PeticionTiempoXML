package com.example.peticiontiempo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceMunicipio {
    @GET("/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaMunicipio")
    Call<Raiz_Municipiero> pedirMunicipio(@Query("Provincia") String nombre_pro,
                                          @Query("Municipio") String municipio);
}
