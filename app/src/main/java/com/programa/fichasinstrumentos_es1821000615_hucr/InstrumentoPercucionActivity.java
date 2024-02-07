package com.programa.fichasinstrumentos_es1821000615_hucr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class InstrumentoPercucionActivity<dataHolder> extends AppCompatActivity {


    private Button regresar;
    private Button estudiados;
    private Button Noestudiados;
    private RecyclerView recyclerView;
    private InstrumentoPercucionAdapter instrumentoAdapter;
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
        instrumentos = getInstrumentosPercucion();



        // Crear y configurar el adaptador
        instrumentoAdapter = new InstrumentoPercucionAdapter(instrumentos);
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

    public List<Instrumento> getInstrumentosPercucion() {
        // Obtener los datos de formación de los instrumentos de viento
        // Puedes obtener estos datos de una base de datos, un archivo JSON, etc.

        List<Instrumento> instrumentos = new ArrayList<>();

        // Ejemplo de datos de instrumento
        instrumentos.add(new Instrumento("Timbal", ValuesStrings.TIMBAL_DESCRIPCION, ValuesStrings.TIMBAL_CARACTERISTICAS, ValuesStrings.TIMBAL_RESENA, R.drawable.timbal, false));
        instrumentos.add(new Instrumento("Tambor", ValuesStrings.TAMBOR_DESCRIPCION, ValuesStrings.TAMBOR_CARACTERISTICAS, ValuesStrings.TAMBOR_RESENA, R.drawable.tambor, false));
        instrumentos.add(new Instrumento("Platillos", ValuesStrings.PLATILLOS_DESCRIPCION, ValuesStrings.PLATILLOS_CARACTERISTICAS, ValuesStrings.PLATILLOS_RESENA, R.drawable.platillos, false));
        instrumentos.add(new Instrumento("Bombo", ValuesStrings.BOMBO_DESCRIPCION, ValuesStrings.BOMBO_CARACTERISTICAS, ValuesStrings.BOMBO_RESENA, R.drawable.bombo, false));

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

