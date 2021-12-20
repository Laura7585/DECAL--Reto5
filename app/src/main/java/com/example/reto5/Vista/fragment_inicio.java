package com.example.reto5.Vista;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.reto5.R;


public class fragment_inicio extends Fragment {

    Drawable drawable1;
    ImageView imagen1;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =inflater.inflate(R.layout.fragment_inicio, container, false);

        //*********************************

        Resources res = getResources();
        drawable1 = res.getDrawable(R.drawable.logo1, v.getContext().getTheme());
        imagen1 =(ImageView) v.findViewById(R.id.logo1);
        imagen1.setImageDrawable(drawable1);

        //*********************************
        return v;
    }
}