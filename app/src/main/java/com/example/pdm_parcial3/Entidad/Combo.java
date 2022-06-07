package com.example.pdm_parcial3.Entidad;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Combo {
    @PrimaryKey(autoGenerate = true)
    public int numCombo;
    public String entrada;
    public String platoFuerte;
    public String postre;
    public Double precio;
    public String img;

    @Ignore
    @Override
    public String toString() {
        return entrada;
    }
}
