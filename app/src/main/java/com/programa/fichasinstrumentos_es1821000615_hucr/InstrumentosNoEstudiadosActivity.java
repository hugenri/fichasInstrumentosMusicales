package com.programa.fichasinstrumentos_es1821000615_hucr;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class InstrumentosNoEstudiadosActivity extends AppCompatActivity {

    private Button regresar;
    private Button home;
    private RecyclerView recyclerView;
    private InstrumentosNoEstudiadosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrumentos_no_estudiados);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DataHolderMain dataHolder = DataHolderMain.getInstance();


        List<Instrumento> instrumentosNoEstudiados = dataHolder.getInstrumentos_NoEstudiados();

        // Crea el adaptador y establece los instrumentos estudiados en el RecyclerView
        adapter = new InstrumentosNoEstudiadosAdapter(instrumentosNoEstudiados);
        recyclerView.setAdapter(adapter);

        // Asignar los botones desde el archivo de diseño
        regresar = findViewById(R.id.regresar);
        home = findViewById(R.id.home);

// Asignar eventos a los botones
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InstrumentosNoEstudiadosActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finalizar la actividad actual (VientoActivity)
            }
        });


    }
}

