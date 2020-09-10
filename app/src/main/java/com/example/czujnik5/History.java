package com.example.czujnik5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.sql.Connection;
import java.sql.DriverManager;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabItem tabTemp = findViewById(R.id.tab_temperatura);
        TabItem tabCis = findViewById(R.id.tab_cisnienie);
        TabItem tabWilg = findViewById(R.id.tab_wilgotnosc);
       ViewPager viewPager = findViewById(R.id.viewPager);

    }


    //conect to database
    class connectToDataBase extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("mysql.cba.pl");

            } catch (Exception e) {

            }
            return null;
        }
    }
}
