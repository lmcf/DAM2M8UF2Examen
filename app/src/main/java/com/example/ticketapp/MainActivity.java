package com.example.ticketapp;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cargo el fichero a reproducir
        mediaPlayer = MediaPlayer.create(this,R.raw.dubbstyle);
        mediaPlayer.start();



        List<infoCaja> informacion = new ArrayList<>();
        viewAdapter viewadapter;

        infoCaja caja1 = new infoCaja("Tele Rota","Aula20",R.drawable.incidencia);
        infoCaja caja2 = new infoCaja("Proyector Roto","Aula22",R.drawable.incidencia);
        infoCaja caja3 = new infoCaja("Enchufe Roto","Aula21",R.drawable.incidencia);
        infoCaja caja4 = new infoCaja("Pizarra no funciona","Aula25",R.drawable.incidencia);

        informacion.add(caja1);
        informacion.add(caja2);
        informacion.add(caja3);
        informacion.add(caja4);

        RecyclerView recyclerview;
        recyclerview = findViewById(R.id.recycler);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        viewadapter = new viewAdapter(informacion);
        recyclerview.setAdapter(viewadapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.pause:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();

                }else{
                    mediaPlayer.start();
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    public class viewAdapter extends RecyclerView.Adapter<viewAdapter.viewHolder>{
        List<infoCaja> inf;

        public viewAdapter(List<infoCaja> inf) {
            this.inf = inf;
        }

        @Override
        public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = getLayoutInflater();

            return new viewHolder(layoutInflater, viewGroup);
        }

        @Override
        // Pones los datos en cada viewholder
        public void onBindViewHolder(@NonNull viewHolder  vh, int i) {
            infoCaja ic = inf.get(i);
            vh.desIncidencia.setText(ic.getDesIncidencia());
            vh.aulaincidencia.setText(ic.getAulaincidencia());
            vh.imgIncidencia.setImageResource(ic.getImgIncidencia());
            vh.resolta.setChecked(ic.getResolta());

        }

        @Override
        public int getItemCount() {
            return inf.size();
        }

        /* MusicaHolder es el bloque donde pinto la info de cada objeto de cojo de la array */
        public class viewHolder extends RecyclerView.ViewHolder{

            TextView desIncidencia, aulaincidencia;
            ImageView imgIncidencia, cruz;
            CheckBox resolta;

            public viewHolder(LayoutInflater layoutInflater, ViewGroup parent) { // Busca el itemview
                super(layoutInflater.inflate(R.layout.viewholder, parent,false));

                desIncidencia = itemView.findViewById(R.id.nombreIncidencia);
                aulaincidencia = itemView.findViewById(R.id.nombreAula);
                imgIncidencia = itemView.findViewById(R.id.imgIncidencia);
                resolta = itemView.findViewById(R.id.resolta);
                cruz = itemView.findViewById(R.id.cruz);

                cruz.animate().alpha(0);

                    resolta.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(resolta.isChecked()){
                                cruz.setTranslationX(900);
                                cruz.animate()
                                        .alpha(1)
                                        .translationX(0)
                                        .setDuration(2000)
                                        .start();
                               cruz.animate().alpha(1);
                            }else{
                                cruz.setTranslationX(0);
                                cruz.animate()
                                        .alpha(1)
                                        .translationX(900)
                                        .setDuration(2000)
                                        .start();
                                cruz.animate().alpha(0);
                            }


                        }
                    });

            }
        }

    }
}
