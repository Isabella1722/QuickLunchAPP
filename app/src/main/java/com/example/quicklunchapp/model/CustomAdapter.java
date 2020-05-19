package com.example.quicklunchapp.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quicklunchapp.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<Plato> platos;

    public CustomAdapter() {
        platos = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return platos.size();
    }

    @Override
    public Object getItem(int position) {
        return platos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.platorenglon, null);
        TextView nombrePlatoTv = row.findViewById(R.id.nombrePlatoTv);
        ImageView platoImage = row.findViewById(R.id.platoImage);
        nombrePlatoTv.setText(platos.get(position).getNombre());

        switch (platos.get(position).getUrl()) {
            case "1":
                platoImage.setImageResource(R.drawable.uno);
                break;
            case "2":
                platoImage.setImageResource(R.drawable.dos);
                break;
            case "3":
                platoImage.setImageResource(R.drawable.tres);
                break;
            case "4":
                platoImage.setImageResource(R.drawable.cuatro);
                break;
            case "5":
                platoImage.setImageResource(R.drawable.cinco);
                break;
            case "6":
                platoImage.setImageResource(R.drawable.seis);
                break;
        }
        return row;
    }

    public void agregarPlato(Plato plato) {
        platos.add(plato);
        this.notifyDataSetChanged();
    }
}
