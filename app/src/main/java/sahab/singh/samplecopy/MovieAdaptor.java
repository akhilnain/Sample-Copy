package sahab.singh.samplecopy;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;

public class MovieAdaptor extends RecyclerView.Adapter<myViewHolder> {
    ArrayList<MoviesData> data;
    Movies_Activity context;

    public MovieAdaptor(Movies_Activity context, ArrayList<MoviesData> data) {
        this.data = data;
        this.context=context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.movie_custom_list,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  myViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.year.setText(data.get(position).getYear());
        Glide.with(holder.image.getContext())
                .load(data.get(position).getPhotoUrl())
                .into(holder.image);


        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, DescActivity.class);
            i.putExtra("title",data.get(position).getName());
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
