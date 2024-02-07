package com.programa.fichasinstrumentos_es1821000615_hucr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InstrumentosEstudiadosActivity extends AppCompatActivity {

    private Button regresar;

    private RecyclerView recyclerView;
    private InstrumentosEstudiadosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrumentos_estudiados);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DataHolderMain dataHolder = DataHolderMain.getInstance();
        //SharedPreferencesManager.loadData(dataHolder, this);
        List<Instrumento> instrumentosEstudiados = dataHolder.getInstrumentos_Estudiados();

        // Crea el adaptador y establece los instrumentos estudiados en el RecyclerView
        adapter = new InstrumentosEstudiadosAdapter(instrumentosEstudiados);
        recyclerView.setAdapter(adapter);
        // Asignar los botones desde el archivo de diseño
        regresar = findViewById(R.id.regresar);


// Asignar eventos a los botones
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InstrumentosEstudiadosActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finalizar la actividad actual (VientoActivity)
            }
        });

    }
}
