package sahab.singh.samplecopy;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
public class Movies_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        //getting data from last activity to know which we have to show movies /webseries
        Intent intent = getIntent();
        String str = intent.getStringExtra("Type");
        ListView listView = findViewById(R.id.listview_movies);

        FirebaseDatabase mFirebaseDatabase;
        DatabaseReference mFirebaseDatabaseReference;
        ChildEventListener mChildEventListner;
        ArrayList<MoviesData> moviesData = new ArrayList<>();
        MovieAdaptor itemsAdapter = new MovieAdaptor(this, moviesData);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseDatabaseReference = mFirebaseDatabase.getReference().child(str);
        listView.setAdapter(itemsAdapter);
        //child event listner
        mChildEventListner = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
                MoviesData data = snapshot.getValue(MoviesData.class);
                itemsAdapter.add(data);
            }

            @Override
            public void onChildChanged(DataSnapshot snapshot, String previousChildName) {

            }

            @Override
            public void onChildRemoved(DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot snapshot, String previousChildName) {

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        };
        mFirebaseDatabaseReference.addChildEventListener(mChildEventListner);
    }
}
