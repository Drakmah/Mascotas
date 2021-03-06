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

import com.echolima.mascotas.db.ConstructorMascotasFav;
import com.echolima.mascotas.db.CostructorMascotas;
import com.squareup.picasso.Picasso;

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
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        //holder.imgfoto.setImageResource(mascota.getUrlFoto());
        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.dog01)// si falla la carga de la imagen, mostrará esta otra
                .into(holder.imgfoto);
        holder.tvratemascota.setText(String.valueOf(mascota.getRate()));  // DARA ERROR EN TIEMPO DE EJECUCION PORQUE  setText solo maneja String y ahora mismo es un int. Hay que hacer un String.valueOf para convertirlo a String
        //holder.tvnombremascota.setText(mascota.getNombreCompleto());
       /* holder.btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Código a ejecutar cuando se apriete el boton
                //Toast.makeText(activity, "Has dado rate a " + mascota.getNombreCompleto(), Toast.LENGTH_SHORT).show();
                CostructorMascotas costructorMascotas = new CostructorMascotas(activity); // creamos un objeto CostructorMascotas. la variable activity representa el contexto en el que estamos trabajando
                costructorMascotas.darLikeMascota(mascota);// le pasamos el objeto mascota definido al principio del método OnBindViewHolder
                holder.tvratemascota.setText(String.valueOf(costructorMascotas.obtenerLikesMascota(mascota)) + " Likes");// setea el textView tvratemascota con el metodo obtenerLikesMascota del constructor, con lo que nos devolverá el número total de likes
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }



    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgfoto;
        private TextView tvratemascota;
        private ImageView imgcantidadrate;
        //private ImageButton btnRate;
        //private TextView tvnombremascota;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgfoto         = (ImageView) itemView.findViewById(R.id.ivfotoMascota);
            tvratemascota   = (TextView) itemView.findViewById(R.id.tvNumeroRate); // Este es el textview que muestra el numero de likes
            imgcantidadrate = (ImageView) itemView.findViewById(R.id.imgCantidadRate); // Este es la imagen del hueso amarillo
            //btnRate         = (ImageButton) itemView.findViewById(R.id.btnRate);
            //tvnombremascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
        }
    }
    /*public int suma (int cantidad, Mascota mascota){ // FUNCION PARA SUMAR LA CANTIDAD DE RATES DE CADA MASCOTA, SE LLAMA EN EL ONCLIK DENTRO DE ONBINDVIEWHOLDER
        cantidad = cantidad +1;
        mascota.setRate(cantidad);
        return mascota.getRate();

    }*/
    
}

