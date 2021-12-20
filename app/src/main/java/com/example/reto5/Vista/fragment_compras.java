package com.example.reto5.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.reto5.Modelo.Adaptador_compras;
import com.example.reto5.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.example.reto5.Modelo.Entidad;
import com.example.reto5.R;

import java.util.ArrayList;

public class fragment_compras extends Fragment {

    GridView listaCompras;
    View v;
    Cursor cursor;
    ArrayList<Entidad> listaItems = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =inflater.inflate(R.layout.fragment_comprar, container, false);

        //***************************************************

        listaCompras = (GridView) v.findViewById(R.id.lista_comprar);
        Adaptador_compras adapter = new Adaptador_compras(getLista_conSQL(), getContext());
        listaCompras.setAdapter(adapter);

        //***************************************************
        return v;
    }

    private ArrayList<Entidad> getLista_conSQL() {
        MotorBaseDatosSQLite conectar = new MotorBaseDatosSQLite(getContext(), "TiendaDecal12", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();

        cursor = db_leer.rawQuery("SELECT * FROM comprar", null);

        while(cursor.moveToNext()){
            listaItems.add(new Entidad(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
        }
        conectar.onUpgrade(db_leer, 1, 2);
        return listaItems;
    }

}