package com.example.pdm_parcial3.Repositorio;

import com.example.pdm_parcial3.DAO.comboDAO;
import com.example.pdm_parcial3.Entidad.Combo;

import java.util.List;

public class repositorioCombo implements IrepositorioCombo{
    public comboDAO DAO;

    public repositorioCombo(comboDAO DAO) {
        this.DAO = DAO;
    }
    @Override
    public void insertCombo(Combo combo) {
        this.DAO.insertCombo(combo);
    }

    @Override
    public void deleteCombo(Combo combo) {
        this.DAO.deleteCombo(combo);
    }

    @Override
    public void updateCombo(Combo combo) {
        this.DAO.updateCombo(combo);
    }

    @Override
    public List<Combo> getCombo() {
        return this.DAO.getCombo();
    }
}
