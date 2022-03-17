package com.example.itemlist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DkyPage extends AppCompatActivity {
    Button dky2;
    EditText ho,ten,dob,pass,copass,id;
    CheckBox checkBox;
    RadioButton nam,nu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dky_page);

        id = findViewById(R.id.editTextID);
        dky2 = findViewById(R.id.dky2);
        ho = findViewById(R.id.editTextHo);
        ten = findViewById(R.id.editTextTen);
        dob = findViewById(R.id.editTextDOB);
        pass = findViewById(R.id.editTextPass);
        copass = findViewById(R.id.editTextCoPass);
        checkBox = findViewById(R.id.checkBox);
        nam = findViewById(R.id.nam);
        nu = findViewById(R.id.nu);

        nam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                dky2.setEnabled(true);
                if(b){
                    Toast.makeText(DkyPage.this, "Giới tính: Nam ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        nu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                dky2.setEnabled(true);
                if(b){
                    Toast.makeText(DkyPage.this, "Giới tính: Nữ ", Toast.LENGTH_SHORT).show();
                }
            }
        });



        dky2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dk1 = ho.getText().toString().trim();
                String dk2 = ten.getText().toString().trim();
                String dk3 = dob.getText().toString().trim();
                String dk4 = pass.getText().toString().trim();
                String dk5 = copass.getText().toString().trim();
                String dk6 = id.getText().toString().trim();
                Boolean b = !checkBox.isChecked();

                if (dk1.isEmpty() || dk2.isEmpty() || dk3.isEmpty() || dk4.isEmpty() || dk5.isEmpty() ||dk6.isEmpty() || b ) {
                    Toast.makeText(DkyPage.this, "Vui lòng nhập đầy đủ thông tin và đồng ý điều khoản sử dụng", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(DkyPage.this, "Mua hàng thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}