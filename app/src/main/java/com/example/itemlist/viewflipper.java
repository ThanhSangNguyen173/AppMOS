package com.example.itemlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class viewflipper extends AppCompatActivity {
    ViewFlipper viewFlipper;
    Button bt1,bt2,bt3,btnfeedback;
    Animation in,out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewflipper_page);

        viewFlipper = (ViewFlipper)findViewById(R.id.ViewFlipper);
        in = AnimationUtils.loadAnimation(this,R.anim.fadein);
        out = AnimationUtils.loadAnimation(this,R.anim.fadeout);
        bt1 = findViewById(R.id.btnpre);
        bt2 = findViewById(R.id.btnjoin);
        bt3 = findViewById(R.id.btnnext);
        btnfeedback = findViewById(R.id.btnfeedback);

        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(5000);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewFlipper.isAutoStart()){
                    viewFlipper.stopFlipping();
                    viewFlipper.showPrevious();
                    viewFlipper.startFlipping();
                    viewFlipper.setAutoStart(true);
                }
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewFlipper.isAutoStart()){
                    viewFlipper.stopFlipping();
                    viewFlipper.showNext();
                    viewFlipper.startFlipping();
                    viewFlipper.setAutoStart(true);
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(viewflipper.this, listitem.class);
                startActivity(intent3);
            }
        });
        btnfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentfb = new Intent(viewflipper.this, MainActivity.class );
                startActivity(intentfb);
            }
        });
    }
}