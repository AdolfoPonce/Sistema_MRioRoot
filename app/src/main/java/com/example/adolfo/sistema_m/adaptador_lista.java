package com.example.adolfo.sistema_m;

import android.content.Context;;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by adolfo on 21/06/17.
 */

public class adaptador_lista extends RecyclerView.Adapter<adaptador_lista.ViewHolder> {
    Context c;
    ArrayList<modelo_lista> dataset;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt,txt_c;
        ViewHolder(View v){
            super(v);
            txt=(TextView)v.findViewById(R.id.name);
            txt_c=(TextView)v.findViewById(R.id.content);
        }
    }
    public adaptador_lista(Context c,ArrayList<modelo_lista> dataset){
        this.c=c;
        this.dataset=dataset;
    }

    @Override
    public adaptador_lista.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.modelo_lista,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txt.setText(dataset.get(position).getTitulo());
        holder.txt_c.setText(dataset.get(position).getDescripcion());
    }


    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
