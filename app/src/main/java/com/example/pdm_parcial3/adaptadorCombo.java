package com.example.pdm_parcial3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pdm_parcial3.Entidad.Combo;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class adaptadorCombo extends BaseAdapter {

    public ArrayList<Combo> data;
    private Context context;

    public FirebaseStorage storage;
    public StorageReference reference;

    public adaptadorCombo(ArrayList<Combo> c, Context con){
        this.data = c;
        this.context = con;
        storage = FirebaseStorage.getInstance();
        reference = storage.getReference();
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Combo c = (Combo) getItem(i);
        view = LayoutInflater.from(context).inflate(R.layout.items_combo,null);

        TextView numero = (TextView) view.findViewById(R.id.textView);
        TextView entrada = (TextView) view.findViewById(R.id.textView2);
        TextView plato = (TextView) view.findViewById(R.id.textView3);
        TextView postre = (TextView) view.findViewById(R.id.textView4);
        TextView precio = (TextView) view.findViewById(R.id.textView5);
        ImageView img = (ImageView) view.findViewById(R.id.imageView2);

        numero.setText("Numero: "+c.numCombo);
        entrada.setText("Entrada: "+c.entrada);
        plato.setText("Plato: "+c.platoFuerte);
        postre.setText("Postre: "+c.postre);
        precio.setText("Precio: "+c.precio);

        Glide.with(context).load(c.img).into(img);


        return view;
    }
}
