package com.example.peticiontiempo;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView tv_fecha;
    TextView tv_maxima;
    TextView tv_minima;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_fecha=itemView.findViewById(R.id.tv_fecha);
        tv_maxima=itemView.findViewById(R.id.tv_maxima);
        tv_minima=itemView.findViewById(R.id.tv_minima);
    }

    @Override
    public void onClick(View v) {
        Log.v("DESDE MiViewHolder:",String.valueOf(getAdapterPosition()));
    }
}
