package com.example.czujnik5.TopBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.czujnik5.History;
import com.example.czujnik5.Main2Activity;
import com.example.czujnik5.MainActivity;
import com.example.czujnik5.R;
import com.example.czujnik5.Wykresy;

import static com.example.czujnik5.R.*;

public abstract class BaseActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    protected abstract int getLayoutResource();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void setToolbar(String name) {
        toolbar = findViewById(id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
            getSupportActionBar().setTitle(name);
        }
    }

    public void showToolbar() {
        toolbar.setVisibility(View.VISIBLE);
    }

    public void hideToolbar() {
        toolbar.setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case android.R.id.home:
                i = new Intent(this, Main2Activity.class);
                startActivity(i);
                finish();
                break;
            case id.refresh:
                finish();
                startActivity(getIntent());
                break;
            case id.chart:
                finish();
                i = new Intent(this, Wykresy.class);
                startActivity(i);
                break;
            case id.history:
                finish();
                i = new Intent(this, History.class);
                startActivity(i);
                break;
            case id.actual:
                finish();
                i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
