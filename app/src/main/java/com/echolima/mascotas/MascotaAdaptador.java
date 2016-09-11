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
 * Created by Fernando on 04/09/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    Mascota mascota;

    public MascotaAdaptador (ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }



    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.imgfoto.setImageResource(mascota.getFoto());
        holder.tvnombremascota.setText(mascota.getNombre());
        holder.tvratemascota.setText(mascota.getRate());

        holder.btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Código a ejecutar cuando se apriete el boton
                Toast.makeText(activity, "Has dado rate a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }



    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgfoto;
        private ImageButton btnRate;
        private TextView tvnombremascota;
        private TextView tvratemascota;
        private ImageView imgcantidadrate;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgfoto         = (ImageView) itemView.findViewById(R.id.ivfotoMascota);
            btnRate         = (ImageButton) itemView.findViewById(R.id.btnRate);
            tvnombremascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvratemascota   = (TextView) itemView.findViewById(R.id.tvNumeroRate);
            imgcantidadrate = (ImageView) itemView.findViewById(R.id.imgCantidadRate);
        }
    }
}

