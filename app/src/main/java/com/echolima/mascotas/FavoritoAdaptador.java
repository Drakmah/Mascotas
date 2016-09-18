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
public class FavoritoAdaptador extends RecyclerView.Adapter<FavoritoAdaptador.FavoritoViewHolder>{

    ArrayList<Mascota> favoritos;
    Activity activity;

    public FavoritoAdaptador(ArrayList<Mascota> favoritos, Activity activity){
        this.favoritos = favoritos;
        this.activity = activity;
    }

    @Override
    public FavoritoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_mascota, parent, false);
        return new FavoritoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FavoritoViewHolder holder, int position) {
        final Mascota favorito = favoritos.get(position);

        holder.imgfotofav.setImageResource(favorito.getFoto());
        holder.tvnombremascotafav.setText(favorito.getNombre());
        holder.tvratemascotafav.setText(String.valueOf(favorito.getRate()) + " Likes"); // Dará error en tiempo de ejecución porque setText solo maneja String y es un dato int. Hay que hacer un String.valueOf para convertirlo a String

        holder.btnRatefav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Código a ejecutar cuando se apriete el boton
                //Toast.makeText(activity, "Has dado rate a " + favorito.getNombre(), Toast.LENGTH_SHORT).show();
                Toast.makeText(activity, "Debes dar rate en la lista principal", Toast.LENGTH_SHORT).show();

            }
        });



    }

    @Override
    public int getItemCount() {
        return favoritos.size();
    }

    public static class FavoritoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgfotofav;
        private ImageButton btnRatefav;
        private TextView tvnombremascotafav;
        private TextView tvratemascotafav;
        private ImageView imgcantidadratefav;

        public FavoritoViewHolder(View itemView) {
            super(itemView);

            imgfotofav         = (ImageView) itemView.findViewById(R.id.ivfotoMascota);
            btnRatefav         = (ImageButton) itemView.findViewById(R.id.btnRate);
            tvnombremascotafav = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvratemascotafav   = (TextView) itemView.findViewById(R.id.tvNumeroRate);   // Este es el TextView que muestra el numero de likes
            imgcantidadratefav = (ImageView) itemView.findViewById(R.id.imgCantidadRate); // Este el el hueso amarillo

        }
    }
}
