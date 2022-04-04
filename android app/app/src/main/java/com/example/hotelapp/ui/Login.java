package com.example.hotelapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hotelapp.R;
import com.example.hotelapp.ui.main.RegistrationForm;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    private static final String TAG = "Login";
    TextInputEditText userEt,passEt;
    Button loginBtn,regBtn,empBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        userEt = findViewById(R.id.user_name);
        passEt = findViewById(R.id.password);
        loginBtn = findViewById(R.id.login);
        regBtn = findViewById(R.id.reg_btn);
        empBtn = findViewById(R.id.employer_btn);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, RegistrationForm.class);
                startActivity(i);
                finish();
            }
        });
        empBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, EmployerForm.class);
                startActivity(i);
                finish();
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: btn clicked" );
                checktoSignIn();

            }
        });

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
        if (!isUserNameValid() && !isPasswordValid()){
            Toast.makeText(this, "Erorrr", Toast.LENGTH_SHORT).show();

        }else if (userEt.getEditableText().toString().equals("admin") && passEt.getEditableText().toString().equals("admin")){
            Log.e(TAG, "checktoSignIn: : "+userEt.getEditableText().toString() );

            Intent i = new Intent(Login.this, EmployerForm.class);
            startActivity(i);
            finish();
        }else if (userEt.getEditableText().toString().equals("user") && passEt.getEditableText().toString().equals("user")){
            Log.e(TAG, "checktoSignIn: : "+userEt.getEditableText().toString() );
            Intent i = new Intent(Login.this, RegistrationForm.class);
            startActivity(i);
            finish();
        }
    }
}