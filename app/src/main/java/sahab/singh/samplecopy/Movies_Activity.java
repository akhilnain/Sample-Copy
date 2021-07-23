package sahab.singh.samplecopy;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
public class Movies_Activity extends AppCompatActivity {
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mFirebaseDatabaseReference;
    ChildEventListener mChildEventListner;
    RecyclerView recyclerView;
    MovieAdaptor itemsAdapter;
    ArrayList<MoviesData> moviesData = new ArrayList<>();
    String string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        //getting data from last activity to know which we have to show movies /webseries

        //ListView listView = findViewById(R.id.listview_movies);
        recyclerView=findViewById(R.id.rclview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        string = intent.getStringExtra("Type");

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseDatabaseReference = mFirebaseDatabase.getReference().child(string);
        itemsAdapter = new MovieAdaptor(this, moviesData);
        recyclerView.setAdapter(itemsAdapter);
        //child event listner
        mChildEventListner = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, String previousChildName) {
                MoviesData data = snapshot.getValue(MoviesData.class);
                moviesData.add(data);
               itemsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mFirebaseDatabaseReference.addChildEventListener(mChildEventListner);
    }
}
