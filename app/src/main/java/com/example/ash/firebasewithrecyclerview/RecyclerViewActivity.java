package com.example.ash.firebasewithrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<ContractsDataModel> list;
    MyAdapter myAdapter;
    FirebaseDatabase database;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recylerView);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        //init firebase instance variables

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

        //

        list = new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dss : dataSnapshot.getChildren()){
                    ContractsDataModel model = dss.getValue(ContractsDataModel.class);
                    ContractsDataModel dataModel = new ContractsDataModel(model.getName() ,model.getNumber());
                    list.add(dataModel);
                }

                myAdapter = new MyAdapter(list , getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });









    }
}
