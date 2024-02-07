package com.programa.fichasinstrumentos_es1821000615_hucr;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView datosTextView;
    private Button btnSalir;
    private DataHolderMain dataHolderMain;

    private  Button btnNoEstudiados;
    private Button btnEstudiados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataHolderMain = DataHolderMain.getInstance();
        // Inicializar las listas de instrumentos no estudiados


// Obtener instrumentos de la actividad VientoActivity y agregarlos a la lista
        List<Instrumento> instrumentosViento = new VientoActivity().getInstrumentosViento();
        instrumentosViento.addAll(instrumentosViento);

// Obtener instrumentos de la actividad CuerdaActivity y agregarlos a la lista
        List<Instrumento> instrumentosCuerda = new CuerdaActivity().getInstrumentosCuerda();
        instrumentosViento.addAll(instrumentosCuerda);

// Obtener instrumentos de la actividad Electricosctivity y agregarlos a la lista
        List<Instrumento> instrumentosElectrico = new ElectricoActivity().getInstrumentosElectrico();
        instrumentosViento.addAll(instrumentosElectrico);

// Obtener instrumentos de la actividad CuerdaActivity y agregarlos a la lista
        List<Instrumento> instrumentosPercucion = new InstrumentoPercucionActivity().getInstrumentosPercucion();
        instrumentosViento.addAll(instrumentosPercucion);

// Establecer la lista de instrumentos no estudiados en dataHolderMain
        dataHolderMain.setInstrumentos_NoEstudiados(instrumentosViento);


        dataHolderMain.setInstrumentos_NoEstudiados(instrumentosViento);


        datosTextView = findViewById(R.id.datosTextView);

        // Configurar los datos del estudiante, docente y grupo
        String autor = "Hugo E. Chaparro Ronquillo";
        String docente = "Victoria Espinoza Romo";
        String grupo = "DS-DPMO-2301-B2-002";

        String datos = "Autor: " + autor + " Docente: " + docente + " Grupo: " + grupo;
        datosTextView.setText(datos);
        btnEstudiados = findViewById(R.id.btnEstudiados);
        btnNoEstudiados = findViewById(R.id.btnNoestudiados);
        btnSalir = findViewById(R.id.btnSalir);

        btnEstudiados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, InstrumentosEstudiadosActivity.class);

                // Inicia la actividad
                startActivity(intent);
            }
        });
        btnNoEstudiados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InstrumentosNoEstudiadosActivity.class);

                // Inicia la actividad
                startActivity(intent);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finishAffinity();            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (id) {
            case R.id.menu_viento:
                intent = new Intent(this, VientoActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_cuerda:
                intent = new Intent(this, CuerdaActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_percusion:
                intent = new Intent(this, InstrumentoPercucionActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_electricos:
                intent = new Intent(this, ElectricoActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
