package com.example.graficadorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;

import com.example.graficadorapp.objetos.TablaDinamica;
import com.example.graficadorapp.reportes.ErrorToken;

import java.util.ArrayList;

public class ReporteErrores extends AppCompatActivity {

    private TableLayout tableLayout;
    private String[] header = {"Lexema","Linea","Columna","Tipo","Descripcion"};
    private ArrayList<String[]> rows = new ArrayList<>();
    private ArrayList<ErrorToken> errores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_errores);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Bundle");
        errores = (ArrayList<ErrorToken>) bundle.getSerializable("listaErrores");
        tableLayout = (TableLayout) findViewById(R.id.table);
        TablaDinamica tablaDinamica = new TablaDinamica(tableLayout,getApplicationContext());
        tablaDinamica.addHeader(header);
        tablaDinamica.addData(getErrors());
        tablaDinamica.backgroundHeader(Color.BLUE);
        tablaDinamica.backgroundData(Color.WHITE,Color.GRAY);

    }

    private ArrayList<String[]> getErrors(){
        for(ErrorToken error: errores){
            rows.add(new String[]{error.getLexeme(),String.valueOf(error.getLine()),String.valueOf(error.getColumn()),error.getTipo(),error.getDescripcion()});
        }
        return rows;
    }

   public void mostrarLista(ArrayList<ErrorToken> errores){
        for(ErrorToken error: errores){
            System.out.println("Lexema: "+error.getLexeme()+" Linea: "+error.getLine()+" Columna: "+error.getColumn()+" Tipo "+error.getTipo()+" Descripcion: "+error.getDescripcion());
        }
    }

}