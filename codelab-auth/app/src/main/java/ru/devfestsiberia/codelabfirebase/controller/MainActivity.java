package ru.devfestsiberia.codelabfirebase.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.devfestsiberia.codelabfirebase.R;
import ru.devfestsiberia.codelabfirebase.model.Animal;

public class MainActivity extends AppCompatActivity {

    private List<Animal> animalList;

    private AnimalAdapter adapter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();

        setupList();
        setupRecyclerView();
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupList(){
        animalList = new ArrayList<>();
        for(int i=0; i < 3; i++){
            Animal animal = new Animal();
            animal.setName("Cachorra");
            animal.setDescription("The tusks are so large that the upper jaw has two holes to accommodate them when the mouth is closed. Large pectoral fins. Uniform silver staining with an elongated black stain behind the operculum.");
            animal.setPhoto("https://i.imgur.com/mNG2t1b.jpg");
            animalList.add(animal);
        }
    }

    private void setupRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AnimalAdapter(animalList,this);
        recyclerView.setAdapter(adapter);
    }
}
