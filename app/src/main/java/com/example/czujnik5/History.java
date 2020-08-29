package com.example.czujnik5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import java.sql.Connection;
import java.sql.DriverManager;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

    }






    //conect to database
    class connectToDataBase extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection= DriverManager.getConnection("mysql.cba.pl");

            }catch (Exception e){

            }
            return null;
        }
    }
}
