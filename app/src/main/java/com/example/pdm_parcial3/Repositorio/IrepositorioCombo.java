package com.example.pdm_parcial3.Repositorio;

import com.example.pdm_parcial3.Entidad.Combo;

import java.util.List;

public interface IrepositorioCombo {
    void insertCombo(Combo combo);
    void deleteCombo(Combo combo);
    void updateCombo(Combo combo);
    List<Combo> getCombo();
}
