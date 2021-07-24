package sahab.singh.samplecopy;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DescActivity extends AppCompatActivity {
    private final messagedata Message=new messagedata();//To have a datatype of class messageData


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);

        String name,year,image,file_link,trailer;
        boolean hindi,english,punjabi,tamil,telugu;

        Intent intent = getIntent();

        name = intent.getStringExtra("name");//getting name of movie /web series from the last activity
        year = intent.getStringExtra("year");//getting year of release of movie /web series from the last activity
        image = intent.getStringExtra("image");//getting image link of movie /web series from the last activity
        file_link = intent.getStringExtra("file link");//getting file link of movie /web series from the last activity
        trailer = intent.getStringExtra("trailer");//getting trailer link of movie /web series from the last activity

        hindi = intent.getBooleanExtra("hindi",false);
        english = intent.getBooleanExtra("english",false);
        tamil = intent.getBooleanExtra("tamil",false);
        punjabi = intent.getBooleanExtra("punjabi",false);
        telugu = intent.getBooleanExtra("telugu",false);

        FirebaseDatabase fb;
        fb = FirebaseDatabase.getInstance();

        DatabaseReference ref;
        ref = fb.getReference().child("Request");

        ImageView descImage = findViewById(R.id.desc_image);
        TextView descName = findViewById(R.id.desc_name),
                descYear = findViewById(R.id.desc_year),
                descAudio = findViewById(R.id.desc_audio);
        Button descLink = findViewById(R.id.desc_link),
                descDamageRequest = findViewById(R.id.desc_damage_request);


        descName.setText(name);//setting name to textview

        Glide.with(descImage.getContext())//setting image to layout
                .load(image)
                .into(descImage);

        descImage.setOnClickListener(v -> { //setting on click listener to  image by getting link from firebase
            Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(trailer));
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent2.setPackage("com.google.android.youtube");
            startActivity(intent2);
        });

        descYear.setText(year);//setting Year to the textview

        StringBuffer stringBuffer = new StringBuffer();//to save data of all the language available
        if (hindi) {
            stringBuffer.append("Hindi  ");
        }
        if (english) {
            stringBuffer.append("English  ");
        }
        if (punjabi) {
            stringBuffer.append("Punjabi  ");
        }
        if (tamil) {
            stringBuffer.append("Tamil  ");
        }
        if (telugu) {
            stringBuffer.append("Telugu  ");
        }

        descAudio.setText(stringBuffer);//setting types of audio to text field

        descLink.setOnClickListener(v -> {
            final String appName = "org.telegram.messenger";
            final boolean isAppInstalled = isPackageInstalled(getPackageManager());
            if (isAppInstalled) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(file_link));

                myIntent.setPackage(appName);

                startActivity(myIntent);
            } else {
                Toast.makeText(DescActivity.this, "Telegram not Installed", Toast.LENGTH_SHORT).show();
            }
        });


        descDamageRequest.setOnClickListener(v -> {//to send data to know if the link od movie is working or not

            messagedata Message = new messagedata(name + " Link is Damage");
            //this it to pass a values to the message database of our app
            ref.push().setValue(Message);

        });

    }
    //Function to check weather a app is installed or not
        private boolean isPackageInstalled(PackageManager packageManager) {
        try {
            packageManager.getPackageInfo("org.telegram.messenger", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }


}