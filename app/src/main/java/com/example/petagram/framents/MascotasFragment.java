package com.example.petagram.framents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.pojo.Mascota;
import com.example.petagram.R;
import com.example.petagram.adapter.MascotaAdaptador;

import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;

public class MascotasFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Rambo",2,R.drawable.mascota1));
        mascotas.add(new Mascota("Firulais",4,R.drawable.mascota2));
        mascotas.add(new Mascota("Dobby",5,R.drawable.mascota3));
        mascotas.add(new Mascota("Rufus",2,R.drawable.mascota4));
        mascotas.add(new Mascota("Fatiga",1,R.drawable.mascota5));
        mascotas.add(new Mascota("Ronny",4,R.drawable.mascota6));
        mascotas.add(new Mascota("Rocco",4,R.drawable.mascota7));
        mascotas.add(new Mascota("Luchi",2,R.drawable.mascota8));
        mascotas.add(new Mascota("Dory",3,R.drawable.mascota9));
        mascotas.add(new Mascota("Patán",4,R.drawable.mascota10));

    }

}
