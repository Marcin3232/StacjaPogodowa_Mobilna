package com.example.czujnik5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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


    @Override
    public void onBackPressed() {
       AlertDialog.Builder alert=new AlertDialog.Builder(Main2Activity.this);
        alert.setMessage("Czy napewno chcesz wyjść z Aplikacji");
        alert.setCancelable(false);



        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog=alert.create();
       alertDialog.show();
    }
}



