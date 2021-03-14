package com.example.peticiontiempo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Raiz_Aemet r;
    private List<Dias> lista_dias;


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_tiempo, parent, false);
        MyViewHolder vh = new MyViewHolder(v);//Le paso la vista
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Temperatura temperatura=lista_dias.get(position).getTemperatura();
        holder.tv_fecha.setText(lista_dias.get(position).getFecha());
        holder.tv_maxima.setText("Temp max: "+temperatura.getMaxima()+"ºC");
        holder.tv_minima.setText("Temp min: "+temperatura.getMinima()+"ºC");

    }

    public MyAdapter (Raiz_Aemet r) {
        this.r=r;
        lista_dias=r.getPrediccion();
    }



    @Override
    public int getItemCount() {
        return lista_dias.size();
    }


}
