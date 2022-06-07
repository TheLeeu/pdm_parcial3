package com.example.pdm_parcial3.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pdm_parcial3.Entidad.Combo;

import java.util.List;

@Dao
public interface comboDAO {
    @Insert
    void insertCombo(Combo combo);
    @Delete
    void deleteCombo(Combo combo);
    @Update
    void updateCombo(Combo combo);
    @Query("SELECT * FROM Combo")
    List<Combo> getCombo();
}
