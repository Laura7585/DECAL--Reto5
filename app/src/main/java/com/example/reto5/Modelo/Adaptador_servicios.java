package com.example.reto5.Modelo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reto5.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Adaptar los datos manejados en entidad para ser mostrados en cada item de la lista
 */
public class Adaptador_servicios extends BaseAdapter {

    ArrayList<Entidad> itemLista;
    Context context;

    public Adaptador_servicios(ArrayList<Entidad> itemLista, Context context) {
        this.itemLista = itemLista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemLista.size(); //Devuelve el nùmero de itmes de la lista
    }

    @Override
    public Object getItem(int position) {
        return itemLista.get(position); //Devuelve el item que se està trabajando
    }

    @Override
    public long getItemId(int position) {
        return 0; //No lo vamos a trabajr por ahora
    }

    /**
     * En este mètodo se van a poner los valore que corresponden a cada item, y lo configuramos
     * de manera similar a los frgaments
     * @param position
     * @param v
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View v, ViewGroup parent) {
        Entidad datosItem = (Entidad) getItem(position);

        v = LayoutInflater.from(context).inflate(R.layout.item_servicios, null);
        //**************************************

        ImageView imagen= (ImageView) v.findViewById(R.id.imagen_serv);
        TextView titulo = (TextView) v.findViewById(R.id.titulo_item_serv);
        TextView descripcion = (TextView) v.findViewById(R.id.descripcion_item_serv);

        String imagen1 = datosItem.getImagen();
        Picasso.get().load(imagen1).resize(120,120).error(R.mipmap.ic_launcher_foreground).into(imagen);

        titulo.setText(datosItem.getNombre());
        descripcion.setText(datosItem.getReferencia());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Servicio: " + titulo.getText(), Toast.LENGTH_LONG).show();
            }
        });
        //***************************************
        return v;
    }
}
