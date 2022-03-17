package com.example.itemlist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class teetan extends AppCompatActivity {
    Button buy,back;
    RadioButton m,l,xl;
    EditText edtslg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teetan_page);
        anhxa();

        m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                buy.setEnabled(true);
            }
            });
        l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                buy.setEnabled(true);
            }
        });
        xl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                buy.setEnabled(true);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(teetan.this,listitem.class);
                startActivity(intent);
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtslg.getText().toString().isEmpty()||edtslg.getText().toString().equals("0")){
                    Toast.makeText(teetan.this, "Vui lòng nhập số lượng", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent2 = new Intent(teetan.this, DkyPage.class);
                    startActivity(intent2);

            }}
        });
}

    private void anhxa() {
            buy = findViewById(R.id.button);
            back = findViewById(R.id.button2);
            m = findViewById(R.id.radioButton3);
            l = findViewById(R.id.radioButton2);
            xl = findViewById(R.id.radioButton);
            edtslg = findViewById(R.id.editTextNumber);
        }
    }