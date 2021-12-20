package com.example.reto5.Modelo.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class MotorBaseDatosSQLite extends SQLiteOpenHelper {

    public MotorBaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE comprar (image TEXT, titulo TEXT, descripcion TEXT, precio TEXT)");
        db.execSQL("CREATE TABLE favoritos (image TEXT, titulo TEXT, descripcion TEXT, precio TEXT)");
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE favoritos");
        db.execSQL("DROP TABLE comprar");
        onCreate(db);
    }

    public void agregarProducto(SQLiteDatabase db, String image, String nombre, String ref, String precio){
        db.execSQL("INSERT INTO comprar VALUES('"+image+"','"+nombre+"', '"+ref+"','"+precio+"')");
    }
    public void eliminarFav(SQLiteDatabase db, String tit){
        db.execSQL("DELETE FROM favoritos WHERE titulo='"+tit+"'");
    }
}
