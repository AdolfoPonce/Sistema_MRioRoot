package com.example.adolfo.sistema_m;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by adolfo on 22/06/17.
 */

public class fragmentLista extends Fragment {
    private ArrayList<modelo_lista> mydataset;
    private RecyclerView recycler;
    LinearLayoutManager manager;
    private Drawable item;
    @Override
    public View onCreateView(LayoutInflater i, ViewGroup v, Bundle s){
        ViewGroup root=(ViewGroup)i.inflate(R.layout.lista,v,false);
        recycler=(RecyclerView)root.findViewById(R.id.list);
        recycler.setHasFixedSize(true);
        manager=new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(manager);
        mydataset=new ArrayList<modelo_lista>();


        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(item);
        recycler.addItemDecoration(new DividerItemDecoration(getResources().getDrawable(R.drawable.divider_background)));

        return  root;

    }

    public void llenar_lista(){
        int i=0;
        while(i<=20){
            modelo_lista model=new modelo_lista();
            model.setTitulo("titulo " + i);
            model.setDescripcion("Descripcion" + i);
            mydataset.add(model);
        }
        recycler.setAdapter(new adaptador_lista(getActivity(),mydataset));
    }

}
