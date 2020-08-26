package com.example.czujnik5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
private Button aktualne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       aktualne=(Button)findViewById(R.id.button2);
        aktualne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               Przelacz(v);

            }
        });
        }

    public void Przelacz(View view){
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        view.getContext().startActivity(intent);}
    }

