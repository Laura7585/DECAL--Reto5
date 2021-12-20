package com.example.reto5.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
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
public class Adaptador_catalogo extends BaseAdapter {

    ArrayList<Entidad> itemLista;
    Context context;
    Button button1;
    ImageButton button2;

    public Adaptador_catalogo(ArrayList<Entidad> itemLista, Context context) {
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

        v = LayoutInflater.from(context).inflate(R.layout.item_catalogo, null);
        //**************************************

        ImageView imagen = (ImageView) v.findViewById(R.id.imagen1_item_catalogo);
        TextView nombre = (TextView) v.findViewById(R.id.nombre_item_catalogo);
        TextView precio = (TextView) v.findViewById(R.id.precio_item_item_catalogo);
        TextView referencia = (TextView) v.findViewById(R.id.ref_item_catalogo);


        String imagen1 = datosItem.getImagen();
        Picasso.get().load(imagen1).fit().error(R.mipmap.ic_launcher_foreground).into(imagen);

        nombre.setText(datosItem.getNombre());
        referencia.setText(datosItem.getReferencia());
        precio.setText(datosItem.getPrecio());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "item: " + nombre.getText(), Toast.LENGTH_LONG).show();
            }
        });

        MotorBaseDatosSQLite conectar = new MotorBaseDatosSQLite(context, "TiendaDecal12", null, 1);
        SQLiteDatabase db_escribir  =conectar.getWritableDatabase();

        button1 = (Button) v.findViewById(R.id.botonComprar_item_catalogo);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Agregado a las compras", Toast.LENGTH_LONG).show();
                conectar.agregarProducto(db_escribir , datosItem.getImagen(), datosItem.getNombre(), datosItem.getReferencia(), datosItem.getPrecio());
            }
        });

        button2 = (ImageButton) v.findViewById(R.id.addFav_item_catalogo);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Agregado a los favoritos", Toast.LENGTH_LONG).show();
                db_escribir.execSQL("INSERT INTO favoritos VALUES('"+datosItem.getImagen()+"', '"+datosItem.getNombre()+"', '"+datosItem.getReferencia()+"','"+datosItem.getPrecio()+"')");
            }
        });

        conectar.onUpgrade(db_escribir,1,2);
    //***************************************
        return v;
    }

}
