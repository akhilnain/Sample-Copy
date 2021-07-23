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
        this.context = context;
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

            i.putExtra("name",data.get(position).getName());
            i.putExtra("year",data.get(position).getYear());
            i.putExtra("image",data.get(position).getPhotoUrl());
            i.putExtra("file link",data.get(position).getFileurl());
            i.putExtra("trailer",data.get(position).getzTrailer());
            i.putExtra("hindi",data.get(position).ismHindiChecked());
            i.putExtra("english",data.get(position).ismEnglishChecked());
            i.putExtra("punjabi",data.get(position).ismPunjabiChecked());
            i.putExtra("tamil",data.get(position).ismTamilChecked());
            i.putExtra("telugu", data.get(position).ismTeluguChecked());

            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void filteredList(ArrayList<MoviesData> filterList) {
        data = filterList;
        notifyDataSetChanged();
    }
}
