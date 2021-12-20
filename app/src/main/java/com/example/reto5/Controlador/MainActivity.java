package com.example.reto5.Controlador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.reto5.R;
import com.example.reto5.Vista.fragment_compras;
import com.example.reto5.Vista.fragment_favoritos;
import com.example.reto5.Vista.fragment_inicio;
import com.example.reto5.Vista.fragment_productos;
import com.example.reto5.Vista.fragment_servicios;
import com.example.reto5.Vista.fragment_sucursales;

/**
 * Laura Garcia
 * MainActivity
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Atributos de la clase
     */
    Fragment subPantalla1;
    /**
     * Atributos de la clase
     */
    Fragment subPantalla2;
    /**
     * Atributos de la clase
     */
    Fragment subPantalla3;
    /**
     * Atributos de la clase
     */
    Fragment subPantalla4;
    /**
     * Atributos de la clase
     */
    Fragment subPantallaInicio;
    /**
     * Atributos de la clase
     */
    Fragment subPantalla5;
    /**
     * Atributos de la clase
     */
    FragmentTransaction intercambio;

    /**
     *Método sobre escrito de la clase AppCompatActivity
     */
    @Override
    protected void onCreate(Bundle savedInst) {
        super.onCreate(savedInst);
        setContentView(R.layout.activity_main);

        subPantalla1 = new fragment_productos();
        subPantalla2 = new fragment_servicios();
        subPantalla3 = new fragment_sucursales();
        subPantalla4 = new fragment_favoritos();
        subPantalla5 = new fragment_compras();
        subPantallaInicio = new fragment_inicio();

        //Permite poner una pantalla en el fragment
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragments, subPantallaInicio).commit();
        //Toast.makeText(this, ""+R.drawable.bono+"", Toast.LENGTH_LONG).show();
    }

    /**
     *Método sobre escrito de la clase AppCompatActivity que incializa el menú de opciones
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater infalter = getMenuInflater();
        infalter.inflate(R.menu.menu_opciones, menu);
        return true;
    }

    /**
     *Método sobre escrito de la clase AppCompatActivity que escucha las acciones del menú
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int identi = item.getItemId();
        if(identi==R.id.menuProductos){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla1).addToBackStack(null).commit();
        }
        if(identi==R.id.menuServicios){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla2).addToBackStack(null).commit();
        }
        if(identi==R.id.menuSucursales){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla3).addToBackStack(null).commit();
        }
        if(identi==R.id.menuFavoritos){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla4).addToBackStack(null).commit();
        }
        if(identi==R.id.menuCompras){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla5).addToBackStack(null).commit();
        }
        return super.onOptionsItemSelected(item);
    }


}