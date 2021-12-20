package com.example.reto5.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.reto5.Modelo.Adaptador_servicios;
import com.example.reto5.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.example.reto5.Modelo.Entidad;
import com.example.reto5.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class fragment_servicios extends Fragment {

    ListView listaServicios;
    View v;
    TextView titServ, campo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =inflater.inflate(R.layout.fragment_servicios, container, false);
        //***************************************************

        listaServicios = (ListView) v.findViewById(R.id.lista_servicios);
        Adaptador_servicios adapter = new Adaptador_servicios(getListaItems_conSQL(), getContext());

        listaServicios.setAdapter(adapter);
        titServ = (TextView) v.findViewById(R.id.titServ);
        campo = (TextView) v.findViewById(R.id.campo);

        //***************************************************
        return v;
    }

        private ArrayList<Entidad> getListaItems_conSQL() {
            ArrayList<Entidad> listaItems = new ArrayList<>();
            String url = "https://g935d257da991b6-reto5decal.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/productos/servicios";

            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray jsonArray = response.getJSONArray("items");
                        for(int i = 0; i < jsonArray.length(); i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            String imagen1 = jsonObject.getString("imagen");
                            String titulo = jsonObject.getString("titulo");
                            String descripcion = jsonObject.getString("descripcion");

                            listaItems.add(new Entidad(imagen1,titulo,descripcion));
                            titServ.setText("Servicios"+"\n");

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

