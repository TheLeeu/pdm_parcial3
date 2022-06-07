package com.example.pdm_parcial3;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pdm_parcial3.DAO.comboDAO;
import com.example.pdm_parcial3.Entidad.Combo;

@Database(entities = {Combo.class}, version = 1)

public abstract class dataBase extends RoomDatabase {
    public static dataBase INSTANCE;

    public abstract comboDAO ComboDAO();



    public static dataBase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context,dataBase.class,"dbCombo")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
