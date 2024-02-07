package com.programa.fichasinstrumentos_es1821000615_hucr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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



public class CuerdaActivity extends AppCompatActivity {


    private Button regresar;

    private RecyclerView recyclerView;
    private InstrumentoCuerdaAdapter instrumentoAdapter;
    private List<Instrumento> instrumentos;

    private DataHolderMain dataHolderMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuerda);

        dataHolderMain = DataHolderMain.getInstance();

        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtener los datos de los instrumentos de viento
        instrumentos = getInstrumentosCuerda();



        // Crear y configurar el adaptador
        instrumentoAdapter = new InstrumentoCuerdaAdapter(instrumentos);
        recyclerView.setAdapter(instrumentoAdapter);

        // Asignar los botones desde el archivo de diseño
        regresar = findViewById(R.id.regresar);



        // Asignar eventos a los botones
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });


    }

    public List<Instrumento> getInstrumentosCuerda() {
        // Obtener los datos de formación de los instrumentos de viento
        // Puedes obtener estos datos de una base de datos, un archivo JSON, etc.

        List<Instrumento> instrumentos = new ArrayList<>();

        // Ejemplo de datos de instrumento
        instrumentos.add(new Instrumento("Guitarra", ValuesStrings.GUITARRA_DESCRIPCION, ValuesStrings.GUITARRA_CARACTERISTICAS, ValuesStrings.GUITARRA_RESENA, R.drawable.guitarra, false));
        instrumentos.add(new Instrumento("Arpa", ValuesStrings.ARPA_DESCRIPCION, ValuesStrings.ARPA_CARACTERISTICAS, ValuesStrings.ARPA_RESENA, R.drawable.arpa, false));
        instrumentos.add(new Instrumento("Violín", ValuesStrings.VIOLIN_DESCRIPCION, ValuesStrings.VIOLIN_CARACTERISTICAS, ValuesStrings.VIOLIN_RESENA, R.drawable.violin, false));
        instrumentos.add(new Instrumento("Piano", ValuesStrings.PIANO_DESCRIPCION, ValuesStrings.PIANO_CARACTERISTICAS, ValuesStrings.PIANO_RESENA, R.drawable.piano, false));

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



            dataHolderMain.agregarInstrumentoEstudiadoSiNoExiste(instrumento);
            dataHolderMain.quitarInstrumentoEstudiado();
            Toast.makeText(this, "Instrumento marcado como estudiado", Toast.LENGTH_LONG).show();

        }
        // Actualizar la lista en el adaptador para reflejar los cambios visuales
        instrumentoAdapter.notifyDataSetChanged();

    }

}

