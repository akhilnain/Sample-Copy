package sahab.singh.samplecopy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() -> {//to hide progress bar after 2 sec
            Intent intent=new Intent(SplashScreen.this,MainActivity.class);
            startActivity(intent);

        }, 2000);
        finish();
    }
}