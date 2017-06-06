package com.example.ash.firebasewithrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button saveButton , showButton;
    String names[] = {"Albert Robbani","Eion Ashraf","Sucker Jahid","John Selim","Mark Jahid"};
    String numbers [] = {"01834456","0167345343","0184354234","01437536","0181643536"};
    Random random = new Random();
    FirebaseDatabase firebaseDatabase;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseDatabase = FirebaseDatabase.getInstance();
        ref = firebaseDatabase.getReference();

        saveButton = (Button) findViewById(R.id.button1);
        showButton  = (Button) findViewById(R.id.button2);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ran = random.nextInt(+names.length);
                ContractsDataModel model = new ContractsDataModel(names[ran] , numbers[ran]);
                ref.push().setValue(model);
                Toast.makeText(getApplicationContext() ,"Added!!" , Toast.LENGTH_SHORT).show();


            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , RecyclerViewActivity.class);
                startActivity(intent);
            }
        });


    }
}
