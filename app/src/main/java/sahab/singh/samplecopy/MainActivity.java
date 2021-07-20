package sahab.singh.samplecopy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView mMovies,mWebSeries;
        mMovies=findViewById(R.id.imageView_movies);
        mWebSeries=findViewById(R.id.imageView_web_series);
        mMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Movies_Activity.class);
                intent.putExtra("Type","Movies");
                startActivity(intent);
            }
        });
        mWebSeries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Movies_Activity.class);
                intent.putExtra("Type","Web Series");
                startActivity(intent);
            }
        });
    }
}