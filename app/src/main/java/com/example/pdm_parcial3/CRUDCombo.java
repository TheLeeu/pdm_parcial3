package com.example.pdm_parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pdm_parcial3.DAO.comboDAO;
import com.example.pdm_parcial3.Entidad.Combo;
import com.example.pdm_parcial3.Repositorio.repositorioCombo;

public class CRUDCombo extends AppCompatActivity {

    public dataBase db;
    private EditText et_entrada, et_plato, et_postre,et_precio;
    private TextView tv_numero;
    private Button btn_insertar, btn_modificar, btn_eliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudcombo);

        db = dataBase.getInstance(getApplicationContext());
        et_entrada = (EditText) findViewById(R.id.etEntrada);
        et_plato = (EditText) findViewById(R.id.etPlato);
        et_postre = (EditText) findViewById(R.id.etPostre);
        et_precio = (EditText) findViewById(R.id.etPrecio);
        tv_numero = (TextView) findViewById(R.id.tvNumero);
        btn_insertar = (Button) findViewById(R.id.btnInsertar);
        btn_modificar = (Button) findViewById(R.id.btnModificar);
        btn_eliminar = (Button) findViewById(R.id.btnEliminar);

        tv_numero.setText(getIntent().getStringExtra("numero"));
        et_entrada.setText(getIntent().getStringExtra("entrada"));
        et_plato.setText(getIntent().getStringExtra("plato"));
        et_postre.setText(getIntent().getStringExtra("postre"));
        et_precio.setText(getIntent().getStringExtra("precio"));

        if(tv_numero.getText().toString().isEmpty()){
            btn_modificar.setVisibility(View.INVISIBLE);
            btn_eliminar.setVisibility(View.INVISIBLE);
            btn_modificar.setEnabled(false);
            btn_eliminar.setEnabled(false);
        }else{
            btn_insertar.setVisibility(View.INVISIBLE);
            btn_insertar.setEnabled(false);
        }

    }

    public void insertar(View view) {
        if(!et_entrada.getText().toString().isEmpty() && !et_plato.getText().toString().isEmpty()
        && !et_postre.getText().toString().isEmpty() && !et_precio.getText().toString().isEmpty()) {
            Combo combo = new Combo();
            combo.entrada = et_entrada.getText().toString();
            combo.platoFuerte = et_plato.getText().toString();
            combo.postre = et_postre.getText().toString();
            combo.precio = Double.parseDouble(et_precio.getText().toString());

            comboDAO cDao = db.ComboDAO();

            repositorioCombo rc = new repositorioCombo(cDao);
            rc.insertCombo(combo);
            this.finish();
        }else{
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
        }
    }

    public void modificar(View view) {
        if(!et_entrada.getText().toString().isEmpty() && !et_plato.getText().toString().isEmpty()
                && !et_postre.getText().toString().isEmpty() && !et_precio.getText().toString().isEmpty()
        && !tv_numero.getText().toString().isEmpty()) {
            Combo combo = new Combo();
            combo.numCombo = Integer.parseInt(tv_numero.getText().toString());
            combo.entrada = et_entrada.getText().toString();
            combo.platoFuerte = et_plato.getText().toString();
            combo.postre = et_postre.getText().toString();
            combo.precio = Double.parseDouble(et_precio.getText().toString());

            comboDAO cDao = db.ComboDAO();

            repositorioCombo rc = new repositorioCombo(cDao);
            rc.updateCombo(combo);
            this.finish();
        }else{
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
        }

    }

    public void Eliminar(View view) {
        if(!et_entrada.getText().toString().isEmpty() && !et_plato.getText().toString().isEmpty()
                && !et_postre.getText().toString().isEmpty() && !et_precio.getText().toString().isEmpty()
                && !tv_numero.getText().toString().isEmpty()) {
            Combo combo = new Combo();
            combo.numCombo = Integer.parseInt(tv_numero.getText().toString());
            combo.entrada = et_entrada.getText().toString();
            combo.platoFuerte = et_plato.getText().toString();
            combo.postre = et_postre.getText().toString();
            combo.precio = Double.parseDouble(et_precio.getText().toString());

            comboDAO cDao = db.ComboDAO();

            repositorioCombo rc = new repositorioCombo(cDao);
            rc.deleteCombo(combo);
            this.finish();
        }else{
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
        }
    }
}