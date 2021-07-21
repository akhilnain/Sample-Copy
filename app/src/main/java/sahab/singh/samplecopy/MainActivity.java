package sahab.singh.samplecopy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView mMovies,mWebSeries;
        Button request;
        mMovies=findViewById(R.id.imageView_movies);
        mWebSeries=findViewById(R.id.imageView_web_series);
        request=findViewById(R.id.button_request);
        mMovies.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,Movies_Activity.class);
            intent.putExtra("Type","Movies");
            startActivity(intent);
        });
        mWebSeries.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,Movies_Activity.class);
            intent.putExtra("Type","Web Series");
            startActivity(intent);
        });
        request.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,Request.class);
            startActivity(intent);
        });
    }
}