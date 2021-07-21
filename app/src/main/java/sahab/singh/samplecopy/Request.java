package sahab.singh.samplecopy;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Request extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        FirebaseDatabase db;
        db = FirebaseDatabase.getInstance();

        DatabaseReference ref;
        ref = db.getReference().child("Request");

        ListView listView = findViewById(R.id.listview);

        EditText name = findViewById(R.id.messageEditText);
        name.requestFocus();

        Button request = findViewById(R.id.sendButton);

        List<messagedata> Messages = new ArrayList<>();

        messageAdaptor adapter = new messageAdaptor(this, R.layout.item_message,Messages);

        listView.setAdapter(adapter);
        ref.addChildEventListener(new ChildEventListener() {
          @Override
          public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
              messagedata data= snapshot.getValue(messagedata.class);
              adapter.add(data);

          }

          @Override
          public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable  String previousChildName) {

          }

          @Override
          public void onChildRemoved(@NonNull DataSnapshot snapshot) {

          }

          @Override
          public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable  String previousChildName) {

          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {

          }
      });
        request.setOnClickListener(v -> {
            //Creating a instace of FriendlyMessage Class to store Message Data in Friendly Message Variable
            //passing text as message , mUsername as username , photoUrl as null for now
            messagedata Message = new messagedata(name.getText().toString());
            //this it to pass a values to the messgae database of our app
            ref.push().setValue(Message);
            // Clear input box
            name.setText("");

        });
    }
}