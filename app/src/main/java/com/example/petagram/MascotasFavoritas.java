package com.example.petagram;

import android.content.Intent;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.adapter.MascotaAdaptador;
import com.example.petagram.menuopc.AcercaDe;
import com.example.petagram.menuopc.Contacto;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoritas_mascotas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarFavoritos);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }


    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Rambo",6,R.drawable.mascota1));
        mascotas.add(new Mascota("Firulais",5,R.drawable.mascota2));
        mascotas.add(new Mascota("Dobby",4,R.drawable.mascota3));
        mascotas.add(new Mascota("Rufus",8,R.drawable.mascota4));
        mascotas.add(new Mascota("Fatiga",7,R.drawable.mascota5));
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.mContancto:
                intent = new Intent(this, Contacto.class);
                startActivity(intent);
                break;

            case R.id.mAcercaDe:
                intent = new Intent(this, AcercaDe.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
