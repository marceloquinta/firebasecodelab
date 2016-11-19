package ru.devfestsiberia.codelabfirebase.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        animalList = new ArrayList<>();
        setupRecyclerView();

        setupList();
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupList(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("animals");
        myRef.keepSynced(true);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                GenericTypeIndicator<List<Animal>> genericTypeIndicator = new GenericTypeIndicator<List<Animal>>() {};

                animalList = dataSnapshot.getValue(genericTypeIndicator);
                adapter.setAnimals(animalList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("ERROR", "Failed to read value.", error.toException());
            }
        });
    }

    private void setupRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AnimalAdapter(animalList,this);
        recyclerView.setAdapter(adapter);
    }

}
