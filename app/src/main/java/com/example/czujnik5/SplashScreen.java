package com.example.czujnik5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Timer;

public class SplashScreen extends AppCompatActivity {

    private TextView title;
    private ImageView logo;
    private ProgressBar load;
    private android.content.Intent Intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        title=findViewById(R.id.textView9);
        logo=findViewById(R.id.imageView);
        load=findViewById(R.id.progressBar);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animation1);
        title.startAnimation(animation);
        logo.startAnimation(animation);
        load.startAnimation(animation);
        final Intent newScreen=new Intent(this,Main2Activity.class);
        Thread thread = new Thread(){
            public void run()   {
                try {
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(newScreen);
                    finish();
                }
            }
        };
        thread.start();
    }

}
