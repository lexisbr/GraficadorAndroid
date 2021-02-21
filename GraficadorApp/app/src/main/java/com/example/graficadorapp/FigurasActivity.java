package com.example.graficadorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

import com.example.graficadorapp.herramientas.Dibujador;
import com.example.graficadorapp.lexer.Lexer;
import com.example.graficadorapp.objetos.Figura;
import com.example.graficadorapp.parser.Parser;
import com.example.graficadorapp.reportes.ErrorToken;

import java.io.StringReader;
import java.util.ArrayList;

public class FigurasActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figuras);

        Intent intent = getIntent();
        String codigoFuente = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        StringReader reader = new StringReader(codigoFuente);
    
        Lexer lex = new Lexer(reader);
        Parser parser = new Parser(lex);

        try {
            parser.parse();

            System.out.println("ERROR: ");
            if (parser.getErrorsList().size()>0) {
                /*for(ErrorToken error: parser.getErrorsList()){
                    System.out.println("Lexema: "+error.getLexeme()+" Linea: "+error.getLine()+" Columna: "+error.getColumn()+" Tipo "+error.getTipo()+" Descripcion: "+error.getDescripcion());
                }*/
                Intent reportErrors = new Intent(this,ReporteErrores.class);
                Bundle bundle = new  Bundle();
                bundle.putSerializable("listaErrores",parser.getErrorsList());
                reportErrors.putExtra("Bundle",bundle);
                startActivity(reportErrors);


            } else {
                //parser.getGraficador().mostrarFiguras();
                ArrayList<Figura> listaFiguras  = parser.getGraficador().getListaFiguras();
                ConstraintLayout layout =  (ConstraintLayout) findViewById(R.id.layoutFiguras);

                Dibujador dibujador = new Dibujador(this,listaFiguras);
                dibujador.mostrarFiguras();
                layout.addView(dibujador);

            }

        } catch (Exception ex) {
            System.out.println("Error irrecuperable " + ex);
            for(ErrorToken error: parser.getErrorsList()){
                System.out.println(">>>>> Lexema: "+error.getLexeme()+" Linea: "+error.getLine()+" Columna: "+error.getColumn()+" Tipo "+error.getTipo()+" Descripcion: "+error.getDescripcion());
            }
            Intent reportErrors = new Intent(this,ReporteErrores.class);
            Bundle bundle = new  Bundle();
            bundle.putSerializable("listaErrores",parser.getErrorsList());
            reportErrors.putExtra("Bundle",bundle);
            startActivity(reportErrors);
        }



    }


}