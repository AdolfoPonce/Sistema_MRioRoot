package com.example.adolfo.sistema_m;

import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
private BubbleChart buble;
    private PieChart pie_chart;
    LineChart line_chart;
    BottomNavigationView btn_n_v;
    private VideoView vv;
ImageView image;
    EditText label,ganancia;
    Button insertar,ver_tabla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        label=(EditText)findViewById(R.id.label);
        ganancia=(EditText)findViewById(R.id.ganancias);
        insertar=(Button)findViewById(R.id.insertar);
        ver_tabla=(Button)findViewById(R.id.ver_tabala);
        image=(ImageView)findViewById(R.id.imagen);
        insertar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dispatchTakePictureIntent();
            }
        });
        ver_tabla.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            ver_tabla();
            }
        });
        startService(new Intent(MainActivity.this,servicio.class));

        /*
        line_chart=(LineChart)findViewById(R.id.line_chart);
        ArrayList<Entry> entries=new ArrayList<>();
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
        /*
        buble=(BubbleChart)findViewById(R.id.buble_chart);
        pie_chart=(PieChart)findViewById(R.id.pie_c);
        ArrayList<Entry> entries=new ArrayList<>();
        entries.add(new Entry(14f,0));
        entries.add(new Entry(64f,0));
        entries.add(new Entry(14f,0));
        entries.add(new Entry(23f,0));
        entries.add(new Entry(1f,0));
        entries.add(new Entry(14f,0));
        PieDataSet dataset=new PieDataSet(entries,"PieChart");
        ArrayList<String> labels=new ArrayList<>();
        labels.add("Enero");
        labels.add("Febrero");
        labels.add("Marzo");
        labels.add("Abril");
        labels.add("Enero");
        labels.add("Enero");
        labels.add("Enero");
        PieData pie_data=new PieData(labels,dataset);
        pie_chart.setData(pie_data);
        pie_chart.setDescription("Pie CHar Meses");
        dataset.setValueTextSize(15f);
        dataset.setValueTextColor(Color.WHITE);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        btn_n_v=(BottomNavigationView)findViewById(R.id.btn_navigation);
        */
        /*
        btn_n_v.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                }
                return false;
            }
        });

        */
        /*
        ArrayList<BubbleEntry> entries=new ArrayList<>();
        entries.add(new BubbleEntry(1,50f,40f));
        entries.add(new BubbleEntry(2,40f,56f));
        entries.add(new BubbleEntry(3,80f,40f));
        entries.add(new BubbleEntry(4,12f,56f));
        entries.add(new BubbleEntry(5,34f,40f));
        entries.add(new BubbleEntry(6,50f,90f));
        entries.add(new BubbleEntry(7,50f,40f));
        BubbleDataSet ds=new BubbleDataSet(entries,"Ingresos Semanales");
        ArrayList<String> semana=new ArrayList<>();
        semana.add("Lun");
        semana.add("Mart");
        semana.add("Mierc");
        semana.add("Jue");
        semana.add("Vier");
        semana.add("Sab");
        semana.add("Dom");
        BubbleData datos=new BubbleData(semana,ds);
        buble.setData(datos);
        buble.setDescription("Ganancias");
        buble.animateX(2000);
        buble.setDragEnabled(true);
        buble.setTouchEnabled(true);
        ds.setColors(ColorTemplate.COLORFUL_COLORS);
        */



    }
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
           image.setImageBitmap(imageBitmap);
        }
    }

    /* static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    } */
    static final int REQUEST_TAKE_PHOTO = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }
    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    static final int REQUEST_VIDEO_CAPTURE = 1;

    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }

    public void ver_tabla(){
        Intent i=new Intent(MainActivity.this,viewpageractivity.class);
        startActivity(i);
    }
    public void extraer(){
        data_base db=new data_base(MainActivity.this,"tienda",null,1);
        SQLiteDatabase sld=db.getReadableDatabase();
        if(db!=null){
            Cursor c=sld.rawQuery("select * from tienda",null);
            int cantidad=c.getCount();
            if(c.moveToFirst()){
                do{
                    System.out.print(c.getInt(0) +",");
                    System.out.print(c.getString(1) +  "\n");
                }while(c.moveToNext());
            }
        }db.close();
    }

    public void insertar(){
        data_base db=new data_base(MainActivity.this,"tienda",null,1);
        String lb= label.getText().toString();
        float gan=(Float.parseFloat(ganancia.getText().toString()));
        SQLiteDatabase sld=db.getWritableDatabase();
        if(db!=null){
            System.out.println("Se inserto correctamente");
            ContentValues valores=new ContentValues();
            valores.put("ganancia",gan);
            valores.put("dia",lb);
            sld.insert("tienda",null,valores);
        }db.close();
    }
}
