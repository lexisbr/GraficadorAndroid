package com.example.graficadorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;

import com.example.graficadorapp.objetos.TablaDinamica;
import com.example.graficadorapp.reportes.AnimacionReport;
import com.example.graficadorapp.reportes.ColorReport;
import com.example.graficadorapp.reportes.ErrorToken;
import com.example.graficadorapp.reportes.FiguraReport;
import com.example.graficadorapp.reportes.OperadorReport;

import java.util.ArrayList;

public class ReportesActivity extends AppCompatActivity {

    private TableLayout tableLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        iniciarReporte1(bundle);
        iniciarReporte2(bundle);
        iniciarReporte3(bundle);
        iniciarReporte4(bundle);
    }

    public void iniciarReporte1(Bundle bundle){
        String[] header = {"Operador","Linea","Columna","Ocurrencia"};
        ArrayList<String[]> rows = new ArrayList<>();
        ArrayList<OperadorReport> operadores = (ArrayList<OperadorReport>) bundle.getSerializable("operadoresList");
        tableLayout = (TableLayout) findViewById(R.id.tableOperadores);
        TablaDinamica tablaDinamica = new TablaDinamica(tableLayout,getApplicationContext());
        tablaDinamica.addHeader(header);
        tablaDinamica.addData(getOperadores(operadores,rows));
        tablaDinamica.backgroundHeader(Color.rgb(0,204,204));
        tablaDinamica.backgroundData(Color.rgb(225,225,225),Color.LTGRAY);
    }

    private ArrayList<String[]> getOperadores(ArrayList<OperadorReport> operadores, ArrayList<String[]> rows){
        for(OperadorReport operador: operadores){
            rows.add(new String[]{operador.getOperador(),String.valueOf(operador.getLinea()),String.valueOf(operador.getColumn()),operador.getOcurrencia()});
        }
        return rows;
    }

    public void iniciarReporte2(Bundle bundle){
        String[] header = {"Color","Cantidad de Usos"};
        ArrayList<String[]> rows = new ArrayList<>();
        ArrayList<ColorReport> colores = (ArrayList<ColorReport>) bundle.getSerializable("coloresList");
        tableLayout = (TableLayout) findViewById(R.id.tableColores);
        TablaDinamica tablaDinamica = new TablaDinamica(tableLayout,getApplicationContext());
        tablaDinamica.addHeader(header);
        tablaDinamica.addData(getColores(colores,rows));
        tablaDinamica.backgroundHeader(Color.rgb(209,147,225));
        tablaDinamica.backgroundData(Color.rgb(225,225,225),Color.LTGRAY);
    }

    private ArrayList<String[]> getColores(ArrayList<ColorReport> colores, ArrayList<String[]> rows){
        for(ColorReport color: colores){
            if(color.getContador()!=0){
                rows.add(new String[]{color.getColor(),String.valueOf(color.getContador())});
            }
        }
        return rows;
    }

    public void iniciarReporte3(Bundle bundle){
        String[] header = {"Figura","Cantidad de Usos"};
        ArrayList<String[]> rows = new ArrayList<>();
        ArrayList<FiguraReport> figuras = (ArrayList<FiguraReport>) bundle.getSerializable("figurasList");
        tableLayout = (TableLayout) findViewById(R.id.tableFormas);
        TablaDinamica tablaDinamica = new TablaDinamica(tableLayout,getApplicationContext());
        tablaDinamica.addHeader(header);
        tablaDinamica.addData(getFiguras(figuras,rows));
        tablaDinamica.backgroundHeader(Color.rgb(132,222,150));
        tablaDinamica.backgroundData(Color.rgb(225,225,225),Color.LTGRAY);
    }

    private ArrayList<String[]> getFiguras(ArrayList<FiguraReport> figuras, ArrayList<String[]> rows){
        for(FiguraReport figura: figuras){
            if(figura.getContador()!=0){
                rows.add(new String[]{figura.getObjeto(),String.valueOf(figura.getContador())});
            }
        }
        return rows;
    }

    public void iniciarReporte4(Bundle bundle){
        String[] header = {"Animacion","Cantidad de Usos"};
        ArrayList<String[]> rows = new ArrayList<>();
        ArrayList<AnimacionReport> animaciones = (ArrayList<AnimacionReport>) bundle.getSerializable("animacionesList");
        tableLayout = (TableLayout) findViewById(R.id.tableAnimaciones);
        TablaDinamica tablaDinamica = new TablaDinamica(tableLayout,getApplicationContext());
        tablaDinamica.addHeader(header);
        tablaDinamica.addData(getAnimaciones(animaciones,rows));
        tablaDinamica.backgroundHeader(Color.rgb(255,162,90));
        tablaDinamica.backgroundData(Color.rgb(225,225,225),Color.LTGRAY);
    }

    private ArrayList<String[]> getAnimaciones(ArrayList<AnimacionReport> animaciones, ArrayList<String[]> rows){
        for(AnimacionReport animacion: animaciones){
            if(animacion.getContador()!=0){
                rows.add(new String[]{animacion.getAnimacion(),String.valueOf(animacion.getContador())});
            }
        }
        return rows;
    }

}