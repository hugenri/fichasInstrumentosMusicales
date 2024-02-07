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



public class ElectricoActivity<dataHolder> extends AppCompatActivity {


    private Button regresar;
    private Button estudiados;
    private Button Noestudiados;
    private RecyclerView recyclerView;
    private ElectricoAdapter instrumentoAdapter;
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
        instrumentos = getInstrumentosElectrico();


        // Crear y configurar el adaptador
        instrumentoAdapter = new ElectricoAdapter(instrumentos);
        recyclerView.setAdapter(instrumentoAdapter);

        // Asignar los botones desde el archivo de diseño
        regresar = findViewById(R.id.regresar);
        estudiados = findViewById(R.id.estudiados);
        Noestudiados = findViewById(R.id.Noestudiados);


        // Asignar eventos a los botones
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });



    }

    public List<Instrumento> getInstrumentosElectrico() {
        // Obtener los datos de formación de los instrumentos de viento
        // Puedes obtener estos datos de una base de datos, un archivo JSON, etc.

        List<Instrumento> instrumentos = new ArrayList<>();

        // Ejemplo de datos de instrumento
        instrumentos.add(new Instrumento("Guitarra eléctrica", ValuesStrings.GUITARRA_ELECTRICA_DESCRIPCION, ValuesStrings.GUITARRA_ELECTRICA_CARACTERISTICAS, ValuesStrings.GUITARRA_ELECTRICA_RESENA, R.drawable.guitarra_electrica, false));
        instrumentos.add(new Instrumento("Bajo eléctrico", ValuesStrings.BAJO_ELECTRICO_DESCRIPCION, ValuesStrings.BAJO_ELECTRICO_CARACTERISTICAS, ValuesStrings.BAJO_ELECTRICO_RESENA, R.drawable.bajo, false));
        instrumentos.add(new Instrumento("Theremin", ValuesStrings.THEMERIN_DESCRIPCION, ValuesStrings.THEMERIN_CARACTERISTICAS, ValuesStrings.THEMERIN_RESENA, R.drawable.theremin, false));
        instrumentos.add(new Instrumento("Sintetizador", ValuesStrings.SINTETIZADOR_DESCRIPCION, ValuesStrings.SINTETIZADOR_CARACTERISTICAS, ValuesStrings.SINTETIZADOR_RESENA, R.drawable.sintetizador, false));

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

