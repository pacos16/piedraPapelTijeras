package com.pacosignes.piedrapapeltijeras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public enum Opciones{
        PIEDRA(R.string.rock,R.string.sissors,R.drawable.rock1),
        PAPEL(R.string.paper,R.string.rock,R.drawable.paper),
        TIJERAS(R.string.sissors,R.string.paper,R.drawable.sissors);

        private int ganaA;
        private int nombre;
        private int imagen;
        Opciones(int nombre,int ganaA,int imagen){
            this.nombre=nombre;
            this.ganaA=ganaA;
            this.imagen=imagen;
        }
    }

    private Button bPiedra;
    private Button bPapel;
    private Button bTijeras;
    private ImageView iv;
    private TextView tvResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bPiedra=findViewById(R.id.bPiedra);
        bPapel=findViewById(R.id.bPapel);
        bTijeras=findViewById(R.id.bTijeras);
        iv=findViewById(R.id.iv);
        tvResultado=findViewById(R.id.tvResultado);

        bPiedra.setOnClickListener(this);
        bPapel.setOnClickListener(this);
        bTijeras.setOnClickListener(this);
    }



    public void onClick(View v){
        Opciones miOpcion=Opciones.PAPEL;
        switch (v.getId()){
            case R.id.bPiedra:
                miOpcion=Opciones.PIEDRA;
                break;
            case R.id.bPapel:
                miOpcion=Opciones.PAPEL;
                break;
            case R.id.bTijeras:
                miOpcion=Opciones.TIJERAS;
                break;

        }
        jugar(miOpcion);
    }

    public void jugar(Opciones miOpcion){
        Random random=new Random();
        Opciones sorteo;
        int num=random.nextInt(3);
        switch (num){
            case 0:
                sorteo=Opciones.PIEDRA;
                break;
            case 1:
                sorteo=Opciones.PAPEL;
                break;
            case 2:
                sorteo=Opciones.TIJERAS;

                break;
            default:
                sorteo=Opciones.PAPEL;
        }
        iv.setImageResource(sorteo.imagen);


        if(miOpcion.equals(sorteo)){
            tvResultado.setText(R.string.deuce);
        }else if(miOpcion.ganaA==sorteo.nombre){
            tvResultado.setText(R.string.win);
        }else{
            tvResultado.setText(R.string.lose);
        }
    }
}
