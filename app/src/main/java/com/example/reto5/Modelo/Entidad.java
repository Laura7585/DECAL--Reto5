package com.example.reto5.Modelo;

import android.net.Uri;

/**
 * Administrar los datos de las listas
 */
public class Entidad {

    String imagen;
    String nombre;
    String referencia;
    String precio;

    public Entidad(String imagen, String nombre, String referencia, String precio) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.referencia = referencia;
        this.precio = precio;
    }

    public Entidad(String imagen, String nombre, String referencia) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.referencia = referencia;
    }


    public String getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getPrecio() {
        return precio;
    }

}
