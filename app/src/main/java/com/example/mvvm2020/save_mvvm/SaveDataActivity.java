package com.example.mvvm2020.save_mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvvm2020.R;
import com.example.mvvm2020.save_mvvm.viewmodel.sUsuarioViewModel;

public class SaveDataActivity extends AppCompatActivity {

    private EditText username,pass;
    private Button grabar;
    private sUsuarioViewModel usuarioViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);
        configView();

    }

    private void configView(){

        username = findViewById(R.id.txt_username);
        pass = findViewById(R.id.txt_pwd);
        grabar = findViewById(R.id.btn_grabar);
        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = username.getText().toString();
                String pwd = pass.getText().toString();

                usuarioViewModel = ViewModelProviders.of(SaveDataActivity.this).get(sUsuarioViewModel.class);
                usuarioViewModel.getRespuestaLivedata(id,pwd)
                        .observe(SaveDataActivity.this, new Observer<String>() {
                            @Override
                            public void onChanged(String s) {
                                Toast.makeText(SaveDataActivity.this,s,Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
