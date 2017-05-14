package com.example.akki.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    double h,w,r;
    String prevbmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final EditText age,we,hi;
        final TextView re;
        Button b,b1,b3,lb;

        Button b2=(Button)findViewById(R.id.button3);
        b3=(Button)findViewById(R.id.button2);
        lb=(Button)findViewById(R.id.button4);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("BMI");

        DatabaseReference myRef1 = database.getReference("BMI");

        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value= dataSnapshot.getValue(String.class);
                prevbmi=value;
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,DietChart.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,CU.class);
                startActivity(i);
            }
        });

        hi=(EditText)findViewById(R.id.hei);
        we=(EditText)findViewById(R.id.wei);
        b=(Button)findViewById(R.id.cal);
        b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,WhatYouShouldEat.class);
                startActivity(i);



            }
        });


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                h= Double.parseDouble(hi.getText().toString());
                w= Double.parseDouble(we.getText().toString());

                r=(w*10000)/(h*h);
                String bmi= String.format("%.2f",r);
                myRef.setValue(bmi);

                Intent i = new Intent(MainActivity.this,Evaluate.class);
                i.putExtra("prevBmi",prevbmi);
                i.putExtra("bmi",r);
                startActivity(i);



            }
        });





    }
}
