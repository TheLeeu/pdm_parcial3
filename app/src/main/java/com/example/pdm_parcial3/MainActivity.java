package com.example.pdm_parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.pdm_parcial3.DAO.comboDAO;
import com.example.pdm_parcial3.Entidad.Combo;
import com.example.pdm_parcial3.Repositorio.repositorioCombo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public dataBase db;
    public ListView listCombos;
    public ArrayList<Combo> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = dataBase.getInstance(getApplicationContext());
        listCombos = (ListView) findViewById(R.id.listaCombo);
        listData = new ArrayList<Combo>();

        rellenar();

        listCombos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), CRUDCombo.class);
                intent.putExtra("numero",String.valueOf(listData.get(i).numCombo));
                intent.putExtra("entrada",listData.get(i).entrada);
                intent.putExtra("plato",listData.get(i).platoFuerte);
                intent.putExtra("postre",listData.get(i).postre);
                intent.putExtra("precio",String.valueOf(listData.get(i).precio));
                intent.putExtra("url",listData.get(i).img);
                startActivity(intent);
            }
        });
    }

    public void rellenar(){
        comboDAO cDAO = db.ComboDAO();
        repositorioCombo rc = new repositorioCombo(cDAO);
        List<Combo> listCombo = rc.getCombo();
        for (Combo itemsC: listCombo) {
            listData.add(itemsC);
        }

        adaptadorCombo adap = new adaptadorCombo(listData, getApplicationContext());
        listCombos.setAdapter(adap);
    }

    public void btnAgregar(View view) {
        Intent i = new Intent(this, CRUDCombo.class);
        i.putExtra("numero","");
        i.putExtra("entrada","");
        i.putExtra("plato","");
        i.putExtra("postre","");
        i.putExtra("precio","");

        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listData.clear();
        rellenar();
    }
}