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
        TabLayout tabLayout = findViewById(R.id.tablayout_id);
       ViewPager viewPager = findViewById(R.id.viewpager_id);
    ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
    adapter.AddFragment(new FragmentTemp(),"Temperatura");
    adapter.AddFragment(new FragmentCis(),"Ciśnienie");
    adapter.AddFragment(new FragmentWilg(),"Wilgotność");
viewPager.setAdapter(adapter);
tabLayout.setupWithViewPager(viewPager);
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
