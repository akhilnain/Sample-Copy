package sahab.singh.samplecopy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;


import com.google.android.gms.ads.AdRequest;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class MainActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //InterstitialAds
        MobileAds.initialize(this, initializationStatus -> {
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-9515920771619716/7147164297", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("TAG", loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });

        ImageView mMovies,mWebSeries;
        Button request;
        mMovies=findViewById(R.id.imageView_movies);
        mWebSeries=findViewById(R.id.imageView_web_series);
        request=findViewById(R.id.button_request);
        mMovies.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,Movies_Activity.class);
            intent.putExtra("Type","Movies");
            startActivity(intent);
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            }
        });
        mWebSeries.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,Movies_Activity.class);
            intent.putExtra("Type","Web Series");
            startActivity(intent);
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            }

        });
        request.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,Request.class);
            startActivity(intent);
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            }
        });
    }
}