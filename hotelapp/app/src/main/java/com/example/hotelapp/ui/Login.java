package com.example.hotelapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.hotelapp.R;
import com.example.hotelapp.ui.main.RegistrationForm;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    TextInputEditText userEt,passEt;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        userEt = findViewById(R.id.user_name);
        passEt = findViewById(R.id.password);
        loginBtn = findViewById(R.id.login);

        checktoSignIn();

    }

    private boolean isUserNameValid(){
        String val = userEt.getEditableText().toString();
        if(val.isEmpty()){
            userEt.setError("Field can not be empty");
            return false;
        }else {
            userEt.setError(null);
            userEt.setEnabled(false);
            return true;
        }

    }
    private boolean isPasswordValid(){
        String val = passEt.getEditableText().toString();
        if(val.isEmpty()){
            passEt.setError("Field can not be empty");
            return false;
        }else {
            passEt.setError(null);
            passEt.setEnabled(false);
            return true;
        }

    }


    private void checktoSignIn() {
        if (!isUserNameValid() || !isPasswordValid()){
            Toast.makeText(this, "Erorrr", Toast.LENGTH_SHORT).show();

        }else if (userEt.getEditableText().toString()=="admin" && passEt.getEditableText().toString()=="admin"){
            Intent i = new Intent(Login.this, RegistrationForm.class);
            startActivity(i);
            finish();
        }else if (userEt.getEditableText().toString()=="user" && passEt.getEditableText().toString()=="user"){
            Intent i = new Intent(Login.this, EmployerForm.class);
            startActivity(i);
            finish();
        }
    }
}