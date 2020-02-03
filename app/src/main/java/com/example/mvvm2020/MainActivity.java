package com.example.mvvm2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mvvm2020.listRecycler_mvvm.ListRecyclerActivity;
import com.example.mvvm2020.save_mvvm.SaveDataActivity;
import com.example.mvvm2020.save_mvvm2.Save2Activity;

public class MainActivity extends AppCompatActivity {

    Button grabarActivity, graba2Activity, listaActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grabarActivity = findViewById(R.id.btn_activity_guardar);
        graba2Activity = findViewById(R.id.btn_activity_guardar2);
        listaActivity = findViewById(R.id.btn_activity_lista);


        grabarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SaveDataActivity.class);
                startActivity(i);
            }
        });

        graba2Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Save2Activity.class);
                startActivity(i);
            }
        });

        listaActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListRecyclerActivity.class);
                startActivity(i);
            }
        });
    }

}
