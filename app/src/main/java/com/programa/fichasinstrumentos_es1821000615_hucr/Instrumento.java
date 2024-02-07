package com.programa.fichasinstrumentos_es1821000615_hucr;

public class Instrumento {
    private String nombre;
    private String descripcion;
    private String caracteristicas;
    private String resenaHistorica;
    private int imagen;
    private boolean estudiado;

    public Instrumento(String nombre, String descripcion, String caracteristicas, String resenaHistorica, int imagen, boolean estudiado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.resenaHistorica = resenaHistorica;
        this.imagen = imagen;
        this.estudiado = estudiado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getResenaHistorica() {
        return resenaHistorica;
    }

    public void setResenaHistorica(String resenaHistorica) {
        this.resenaHistorica = resenaHistorica;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public boolean isEstudiado() {
        return estudiado;
    }

    public void setEstudiado(boolean estudiado) {
        this.estudiado = estudiado;
    }
}


