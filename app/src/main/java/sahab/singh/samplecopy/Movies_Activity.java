package sahab.singh.samplecopy;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SearchView;

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
    EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        //getting data from last activity to know which we have to show movies /webseries

        search = findViewById(R.id.et_search);
        recyclerView = findViewById(R.id.rclview);
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

        search.addTextChangedListener(new TextWatcher() {//TO search in search bar
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String text) {

        ArrayList<MoviesData> filterList = new ArrayList<>();// a array list to save all filtered objects

        for (MoviesData obj : moviesData) {//loop to check every object
            if (obj.getName().toLowerCase().contains(text.toLowerCase())) {
                filterList.add(obj);
            }
        }
        itemsAdapter.filteredList(filterList);//calling function of adaptor class
    }

}
