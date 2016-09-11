package com.echolima.mascotas;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
/**
 * Created by Fernando on 11/09/2016.
 */
public class GridAdaptador extends RecyclerView.Adapter<GridAdaptador.GridViewHolder> {

    ArrayList<MascotaGrid> mascotasGrid;


    //método constructor de la clase
    public GridAdaptador(ArrayList<MascotaGrid> mascotasGrid){
        this.mascotasGrid = mascotasGrid;

    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_grid, parent, false);

        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GridViewHolder gridViewHolder, int position) {

        MascotaGrid mascotaGrid = mascotasGrid.get(position);

        gridViewHolder.foto.setImageResource(mascotaGrid.getFoto());
        gridViewHolder.rate.setText(mascotaGrid.getRate());

    }

    @Override
    public int getItemCount() {
        return mascotasGrid.size();
    }


// -------------------- CLASE INNER GRIDVIEWHOLDER -----------------------------

    public static class GridViewHolder extends RecyclerView.ViewHolder{

        private ImageView foto;
        private TextView rate;
        private ImageView hueso;


        public GridViewHolder(View itemView) {
            super(itemView);

            foto    = (ImageView) itemView.findViewById(R.id.imgFotoMascotaGrid);
            rate    = (TextView) itemView.findViewById(R.id.tvNumeroRateGrid);
            hueso   = (ImageView) itemView.findViewById(R.id.imgHuesoAmarilloGrid);
        }
    }
}

