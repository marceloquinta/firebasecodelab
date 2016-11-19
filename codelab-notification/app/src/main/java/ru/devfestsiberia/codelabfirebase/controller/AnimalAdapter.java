package ru.devfestsiberia.codelabfirebase.controller;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import ru.devfestsiberia.codelabfirebase.R;
import ru.devfestsiberia.codelabfirebase.model.Animal;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>{

    private List<Animal> animals;
    private Context context;

    public AnimalAdapter(List<Animal> animals, Context context){
        this.animals = animals;
        this.context = context;
    }


    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_animal, viewGroup, false);
        AnimalViewHolder viewHolder = new AnimalViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        final Animal animal = animals.get(position);
        holder.name.setText(animal.getName());
        holder.description.setText(animal.getDescription());
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.listener(new Picasso.Listener()
        {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception)
            {
                exception.printStackTrace();
            }
        });
        builder.build().load(animal.getPhoto()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView image;
        TextView description;

        public AnimalViewHolder(View itemView) {
            super(itemView);
            name =  (TextView)itemView.findViewById(R.id.name);
            description = (TextView)itemView.findViewById(R.id.description);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
