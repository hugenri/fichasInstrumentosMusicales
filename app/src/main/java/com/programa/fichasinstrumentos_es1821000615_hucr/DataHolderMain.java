package com.programa.fichasinstrumentos_es1821000615_hucr;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DataHolderMain {
    private static DataHolderMain instance;

    private List<Instrumento> instrumentosEstudiados;
    private List<Instrumento> instrumentosNoEstudiados;

    protected DataHolderMain() {
        instrumentosEstudiados = new ArrayList<>();
        instrumentosNoEstudiados = new ArrayList<>();
    }

    public static DataHolderMain getInstance() {
        if (instance == null) {
            instance = new DataHolderMain();
        }
        return instance;
    }

    public List<Instrumento> getInstrumentos_Estudiados() {
        return instrumentosEstudiados;
    }

    public void setInstrumentos_Estudiados(List<Instrumento> instrumentosEstudiados) {
        this.instrumentosEstudiados = instrumentosEstudiados;
    }

    public List<Instrumento> getInstrumentos_NoEstudiados() {

        return instrumentosNoEstudiados;
    }

    public void setInstrumentos_NoEstudiados(List<Instrumento> instrumentosNoEstudiados) {
        for (Instrumento instrumento : instrumentosNoEstudiados) {
            boolean nombreExiste = false;

            // Validar si el nombre del instrumento ya existe en la lista de instrumentos estudiados
            for (Instrumento existingInstrumento : this.instrumentosEstudiados) {
                if (existingInstrumento.getNombre().equals(instrumento.getNombre())) {
                    nombreExiste = true;
                    break;
                }
            }

            // Validar si el nombre del instrumento ya existe en la lista de instrumentos no estudiados
            for (Instrumento existingInstrumento : this.instrumentosNoEstudiados) {
                if (existingInstrumento.getNombre().equals(instrumento.getNombre())) {
                    nombreExiste = true;
                    break;
                }
            }

            if (!nombreExiste) {
                this.instrumentosNoEstudiados.add(instrumento);
            }
        }
    }





public boolean agregarInstrumentoEstudiadoSiNoExiste(Instrumento instrumento) {
    boolean existe = false;
    Instrumento instrumentoExistente = null;
    boolean b = true;

    for (Instrumento iInstrumento : instrumentosEstudiados) {
        if (iInstrumento.getNombre().equals(instrumento.getNombre())) {
            existe = true;
            instrumentoExistente = iInstrumento;

            break;
        }
    }

    if (!existe) {
        instrumentosEstudiados.add(instrumento);
        b = instrumento.isEstudiado();


    }
    /*
    else {
        instrumentosEstudiados.remove(instrumentoExistente);
        instrumentosNoEstudiados.add(instrumento);
    }
    */
    return b;
}

public boolean quitarInstrumentoEstudiado() {
boolean n = false;
    if(!instrumentosNoEstudiados.isEmpty() && !instrumentosEstudiados.isEmpty()) {
        for (Instrumento instrumentoEstudiado : instrumentosEstudiados) {
            String nombreInstrumentoEstudiado = instrumentoEstudiado.getNombre();

            for (Instrumento instrumentoNoEstudiado : instrumentosNoEstudiados) {
                String nombreInstrumentoNoEstudiado = instrumentoNoEstudiado.getNombre();

                if (nombreInstrumentoEstudiado.equals(nombreInstrumentoNoEstudiado)) {
                    boolean estudiadoInstrumentoEstudiado = instrumentoEstudiado.isEstudiado();
                    boolean estudiadoInstrumentoNoEstudiado = instrumentoNoEstudiado.isEstudiado();

                    if (estudiadoInstrumentoEstudiado != estudiadoInstrumentoNoEstudiado) {
                        instrumentosNoEstudiados.remove(instrumentoNoEstudiado);
                        n = true;
                        break; // Salir del bucle interno una vez que se elimina el instrumento
                    }
                }
            }
        }
    }
    return n;
}



}
