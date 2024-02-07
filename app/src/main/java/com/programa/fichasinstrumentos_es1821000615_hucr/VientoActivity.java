package com.programa.fichasinstrumentos_es1821000615_hucr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class VientoActivity extends AppCompatActivity {


    private Button regresar;

    private RecyclerView recyclerView;
    private InstrumentoAdapter instrumentoAdapter;
    private List<Instrumento> instrumentos;


    private DataHolderMain dataHolderMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viento);

        dataHolderMain = DataHolderMain.getInstance();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtener los datos de los instrumentos de viento
        instrumentos = getInstrumentosViento();

// Inicializar las listas de instrumentos  no estudiados

       // dataHolderMain.setInstrumentos_NoEstudiados(instrumentos);

        // Crear y configurar el adaptador
        instrumentoAdapter = new InstrumentoAdapter(instrumentos);
        recyclerView.setAdapter(instrumentoAdapter);

        // Asignar los botones desde el archivo de diseño
        regresar = findViewById(R.id.regresar);


        // Asignar eventos a los botones
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(VientoActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finalizar la actividad actual (VientoActivity)
            }
        });

    }

    public List<Instrumento> getInstrumentosViento() {
        // Obtener los datos de formación de los instrumentos de viento
        // Puedes obtener estos datos de una base de datos, un archivo JSON, etc.

        List<Instrumento> instrumentos = new ArrayList<>();

        //  datos de instrumento
        instrumentos.add(new Instrumento("Saxofón", ValuesStrings.SAXOFON_DESCRIPCION, ValuesStrings.SAXOFON_CARACTERISTICAS, ValuesStrings.SAXOFON_RESENA, R.drawable.saxofon, false));
        instrumentos.add(new Instrumento("Flauta", ValuesStrings.FLAUTA_DESCRIPCION, ValuesStrings.FLAUTA_CARACTERISTICAS, ValuesStrings.FLAUTA_RESENA, R.drawable.flauta, false));
        instrumentos.add(new Instrumento("Clarinete", ValuesStrings.CLARINETE_DESCRIPCION, ValuesStrings.CLARINETE_CARACTERISTICAS, ValuesStrings.CLARINETE_RESENA, R.drawable.clarinete, false));
        instrumentos.add(new Instrumento("Trompeta", ValuesStrings.TROMPETA_DESCRIPCION, ValuesStrings.TROMPETA_CARACTERISTICAS, ValuesStrings.TROMPETA_RESENA, R.drawable.trompeta, false));
        instrumentos.add(new Instrumento("Oboe", ValuesStrings.OBOE_DESCRIPCION, ValuesStrings.OBOE_CARACTERISTICAS, ValuesStrings.OBOE_RESENA, R.drawable.oboe, false));

        return instrumentos;
    }

    public void onCheckboxClicked(View view) {
        // Manejar el evento de clic en la casilla de verificación
        boolean checked = ((CheckBox) view).isChecked();

        // Obtener la posición del instrumento en la lista
        int position = recyclerView.getChildAdapterPosition((View) view.getParent());

        // Obtener el instrumento correspondiente a la posición
        Instrumento instrumento = instrumentos.get(position);

        // Actualizar el estado del instrumento en la lista correspondiente
        if (checked) {
            // Instrumento estudiado
            boolean b = dataHolderMain.agregarInstrumentoEstudiadoSiNoExiste(instrumento);
            boolean a = dataHolderMain.quitarInstrumentoEstudiado();

                Toast.makeText(this, "Instrumento marcado como estudiado", Toast.LENGTH_LONG).show();


        }

        // Actualizar la lista en el adaptador para reflejar los cambios visuales
        instrumentoAdapter.notifyDataSetChanged();


    }



}

