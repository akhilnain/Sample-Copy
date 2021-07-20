package sahab.singh.samplecopy;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.core.Context;

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

    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    /*@NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.movie_custom_list, parent, false);
        }
        // Get the {@link MoviesData} object located at this position in the list
        MoviesData moviesData = getItem(position);

        // Find the TextView in the movie_custom_list.xml layout with the ID tvname
        TextView nameTextView = listItemView.findViewById(R.id.tvname);
        // Get the name from the current MoviesData object and
        // set this text on the name TextView
        nameTextView.setText(moviesData.getName());

        // Find the TextView in the movie_custom_list.xml layout with the ID tvyear
        TextView yearTextView = (TextView) listItemView.findViewById(R.id.tvyear);
        // Get the year from the current MoviesData object and
        // set this text on the number TextView
       yearTextView.setText(moviesData.getYear());

        // Find the ImageView in the movie_custom_list.xml layout with the ID imageView
        ImageView imageView =  listItemView.findViewById(R.id.imageView);
        // Get the image Url from the current MoviesData object and
        // set the image to iconView
        Glide.with(imageView.getContext())
                .load(moviesData.getPhotoUrl())
                .into(imageView);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }*/
}
