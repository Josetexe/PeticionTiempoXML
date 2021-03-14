package com.example.peticiontiempo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceProvincia {
    @GET("ConsultaProvincia")
    Call<Raiz_Provinciero> pedirProvincia();
}
