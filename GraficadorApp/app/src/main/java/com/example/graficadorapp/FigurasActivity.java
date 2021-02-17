package com.example.graficadorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.graficadorapp.lexer.Lexer;
import com.example.graficadorapp.objetos.Figura;
import com.example.graficadorapp.parser.Parser;

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

            if (parser.getErrores()) {
                System.out.println("Tiene errores no ejecutara nada");
            } else {
                //parser.getGraficador().mostrarFiguras();
                ArrayList<Figura> listaFiguras  = parser.getGraficador().getListaFiguras();
            }

        } catch (Exception ex) {
            System.out.println("Error irrecuperable " + ex);
        }

        /*TextView textView = findViewById(R.id.textView);
        textView.setText(message);*/
    }


}