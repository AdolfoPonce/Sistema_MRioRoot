package com.example.adolfo.sistema_m;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by adolfo on 18/06/17.
 */

public class fragment2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater i, ViewGroup v, Bundle s){
        ViewGroup root=(ViewGroup)i.inflate(R.layout.fragment2,v,false);

        return  root;

    }
}
