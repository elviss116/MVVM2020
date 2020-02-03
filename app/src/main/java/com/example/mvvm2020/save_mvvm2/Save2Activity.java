package com.example.mvvm2020.save_mvvm2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvvm2020.R;
import com.example.mvvm2020.save_mvvm2.model.UserResponse;
import com.example.mvvm2020.save_mvvm2.viewmodel.s2UsuarioViewModel;

public class Save2Activity extends AppCompatActivity {

    private EditText id, pwd;
    private Button grabar;
    private s2UsuarioViewModel usuarioViewModel;

    String userS = "";
    String pwdS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save2);

        usuarioViewModel = ViewModelProviders.of(Save2Activity.this).get(s2UsuarioViewModel.class);
        configView();

    }

    private void configView(){

        id = findViewById(R.id.txt_id2);
        pwd = findViewById(R.id.txt_pwd2);
        grabar = findViewById(R.id.btn_save2);

        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateString()){
                    saveData();
                }else {
                    showMessage("Llenar Datos");
                }
                /*
                String usu = id.getText().toString();
                String pwd2 = pwd.getText().toString();
                usuarioViewModel = ViewModelProviders.of(Save2Activity.this).get(s2UsuarioViewModel.class);  //EN NEW VER. ESTO YA ESTA EN EL ONCREATE
                usuarioViewModel.getRespuestaLivedata(usu,pwd2)
                        .observe(Save2Activity.this, new Observer<String>() {
                            @Override
                            public void onChanged(String s) {
                                Toast.makeText(Save2Activity.this,s,Toast.LENGTH_SHORT).show();
                            }
                        });*/
            }
        });
    }

    private void saveData(){

        usuarioViewModel.saveData(userS,pwdS).observe(Save2Activity.this, new Observer<UserResponse>() {
            @Override
            public void onChanged(UserResponse userResponse) {
                if (userResponse!=null){
                    if (userResponse.getData()!=null){
                        showMessage(userResponse.getData());
                    }else {
                        showMessage(userResponse.getError().toString());
                    }
                }
            }
        });

    }
    private Boolean validateString(){
        userS = id.getText().toString().trim();
        pwdS = pwd.getText().toString().trim();

        if (userS.isEmpty()){
            return false;
        }
        if (pwdS.isEmpty()){
            return false;
        }
        return true;
    }

    private void showMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
