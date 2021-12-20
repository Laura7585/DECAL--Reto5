package com.example.reto5.Vista;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.reto5.Modelo.Adaptador_catalogo;
import com.example.reto5.Modelo.Entidad;
import com.example.reto5.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class fragment_productos extends Fragment {

    GridView listaProductos;
    View v;
    TextView tituloPro;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =inflater.inflate(R.layout.fragment_productos, container, false);
        //***************************************************

        listaProductos = (GridView) v.findViewById(R.id.lista_catalogo);
        Adaptador_catalogo adapter = new Adaptador_catalogo(getListaItems_conSQL(), getContext());

        listaProductos.setAdapter(adapter);

        tituloPro = (TextView) v.findViewById(R.id.titPro);
        //***************************************************

        return v;
    }

    private ArrayList<Entidad> getListaItems_conSQL() {
        ArrayList<Entidad> listaItems = new ArrayList<>();
        String url = "https://g935d257da991b6-reto5decal.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/productos/productos";

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String imagen = jsonObject.getString("imagen");
                        String titulo = jsonObject.getString("titulo");
                        String descripcion = jsonObject.getString("descripcion");
                        String precio = jsonObject.getString("precio");

                        listaItems.add(new Entidad(imagen,titulo,descripcion,precio));
                        tituloPro.setText("Catálogo de productos"+" \n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
        /* ================================================================================================== */

        return listaItems;
    }


}