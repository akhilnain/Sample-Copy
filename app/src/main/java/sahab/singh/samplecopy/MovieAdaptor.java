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

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdaptor extends ArrayAdapter<MoviesData> {

    public MovieAdaptor(Activity context, ArrayList<MoviesData> moviesData) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, moviesData);
    }

    @NonNull
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
    }
}
