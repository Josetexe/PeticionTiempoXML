package com.example.peticiontiempo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface InterfaceAemet {
    @GET("xml/municipios/localidad_{codigo}.xml")
    Call<Raiz_Aemet> pedirClima(@Path("codigo") String codigo_final);
}
