package com.example.peticiontiempo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PeticionXML_M.ComunicacionPedirClima,PeticionXML_P.ComunicacionPedirClima,PeticionXML_Aemet.ComunicacionPedirClima {
    Spinner spn_provincias;
    Spinner spn_municipios;
    Button btn_tiempo;
    RecyclerView rc_vista;
    PeticionXML_P p;
    PeticionXML_M m;
    PeticionXML_Aemet n;
    String provincia_selec="";
    String codigo_p="";
    String codigo_m="";
    String codigo_final="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn_provincias =findViewById(R.id.spn_provincias);
        spn_municipios =findViewById(R.id.spn_municipios);
        btn_tiempo=findViewById(R.id.btn_tiempo);
        rc_vista=findViewById(R.id.rc_vista);
        p=new PeticionXML_P(this);
        m=new PeticionXML_M(this);
        n=new PeticionXML_Aemet(this);
        PeticionXML_P.pedirProvicias();

        spn_provincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Provinciero pro = (Provinciero) spn_provincias.getSelectedItem();
                provincia_selec=pro.getNombre();
                codigo_p=pro.getCodigo();
                PeticionXML_M.pedirMunicipios(provincia_selec);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spn_municipios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Municipiero mun =(Municipiero) spn_municipios.getSelectedItem();
                Codigo_Municipio muni_selec=mun.getCodigo_muni();
                codigo_m=muni_selec.getCm();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_tiempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while(codigo_p.length()<2){
                    codigo_p="0"+codigo_p;
                }
                while (codigo_m.length()<3){
                    codigo_m="0"+codigo_m;
                }
                codigo_final=codigo_p+codigo_m;
                PeticionXML_Aemet.pedirClima(codigo_final);

            }
        });

    }


    @Override
    public void mostrarDatos(Raiz_Aemet r) {
        rc_vista.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adaptador=new MyAdapter(r);
        rc_vista.setAdapter(adaptador);
    }



    @Override
    public void mostrarDatos(Raiz_Provinciero r) {
        List<Provinciero> lista_p=r.getProvinciero();
        ArrayAdapter adaptador_provincias = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, lista_p);
        spn_provincias.setAdapter(adaptador_provincias);


    }

    @Override
    public void mostrarDatos(Raiz_Municipiero r) {
        List<Municipiero> lista_mun=r.getMunicipiero();
        ArrayAdapter adaptador_municipios = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, lista_mun);
        spn_municipios.setAdapter(adaptador_municipios);
    }
}