package com.example.adolfo.sistema_m;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by adolfo on 15/06/17.
 */

public class grafica extends AppCompatActivity{
    private LineChart line_chart;

    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.line_chart);
        line_chart=(LineChart)findViewById(R.id.line_chart);

        data_base db=new data_base(grafica.this,"tienda",null,1);
        SQLiteDatabase sld=db.getReadableDatabase();
        ArrayList<Entry> entries=new ArrayList<>();
        ArrayList<String> labels=new ArrayList<>();
        Cursor c=sld.rawQuery("select * from tienda",null);
        int cantidad=c.getCount();
        String[] labeles=new String[cantidad];
        float[] ganancia=new float[cantidad];
        int contador=0;
        if(db!=null){

            if(c.moveToFirst()){
                do{
                    entries.add(new Entry(c.getFloat(1),contador));
                    labels.add(c.getString(2).toString());
   contador ++;
                }while(c.moveToNext());
            }
        }db.close();
        LineDataSet ds=new LineDataSet(entries,"Tabla");
        ds.setDrawCubic(true);
        ds.setDrawFilled(true);
        ds.setValueTextColor(Color.WHITE);
        ds.setCircleColors(ColorTemplate.COLORFUL_COLORS);
        LineData ld=new LineData(labels,ds);
        line_chart.setData(ld);


       /* ArrayList<Entry> entries=new ArrayList<>();
        entries.add(new Entry(8f,0));
        entries.add(new Entry(81f,1));
        entries.add(new Entry(23f,2));
        entries.add(new Entry(8f,3));
        entries.add(new Entry(8f,4));
        entries.add(new Entry(19f,5));
        entries.add(new Entry(4f,6));
        entries.add(new Entry(8f,7));
        LineDataSet dataset=new LineDataSet(entries,"Line Chart");
        ArrayList<String> labels=new ArrayList<>();
        labels.add("Enero");
        labels.add("Enero");
        labels.add("Enero");
        labels.add("Enero");
        labels.add("Enero");
        labels.add("Enero");
        labels.add("Enero");
        labels.add("Enero");
        LineData data=new LineData(labels,dataset);
        line_chart.setData(data);
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);
        line_chart.animateX(2000);
        */
    }
}
