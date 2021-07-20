package sahab.singh.samplecopy;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView name,year;
    public myViewHolder(@NonNull  View itemView) {
        super(itemView);
        image=itemView.findViewById(R.id.imageView);
        name=itemView.findViewById(R.id.tvname);
        year=itemView.findViewById(R.id.tvyear);

    }
}
