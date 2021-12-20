package com.example.reto5.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reto5.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.example.reto5.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Adaptar los datos manejados en entidad para ser mostrados en cada item de la lista
 */
public class Adaptador_compras extends BaseAdapter {

    ArrayList<Entidad> itemLista;
    Context context;
    ImageButton boton1;

    public Adaptador_compras(ArrayList<Entidad> itemLista, Context context) {
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

        v = LayoutInflater.from(context).inflate(R.layout.item_compras, null);
        //**************************************

        ImageView imagen = (ImageView) v.findViewById(R.id.imagen1_item_compras);
        TextView nombre = (TextView) v.findViewById(R.id.nombre_item_compras);
        TextView precio = (TextView) v.findViewById(R.id.precio_item_compras);
        TextView referencia = (TextView) v.findViewById(R.id.ref_item_compras);

        String imagen1 = datosItem.getImagen();
        Picasso.get().load(imagen1).fit().error(R.mipmap.ic_launcher_foreground).into(imagen);

        //imagen.setImageURI(datosItem.getImagen());
        nombre.setText(datosItem.getNombre());
        referencia.setText(datosItem.getReferencia());
        precio.setText(datosItem.getPrecio());


        MotorBaseDatosSQLite conectar = new MotorBaseDatosSQLite(context, "TiendaDecal15", null, 1);
        SQLiteDatabase db_escribir  =conectar.getWritableDatabase();



        boton1 = (ImageButton) v.findViewById(R.id.sacarProducto_compras);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db_escribir.execSQL("DELETE FROM comprar WHERE titulo='"+datosItem.getNombre()+"'");
                Toast.makeText(context,  "Eliminado del carrito de compras", Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }


}
