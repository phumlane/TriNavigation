package com.example.trinavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    public Button login;
    public EditText email, password;
    public TextView RegisterText;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button )findViewById(R.id.LoginBtn);
        RegisterText =(TextView)findViewById(R.id.RegisterText);
        email = (EditText)findViewById(R.id.EmailEditText);
        password = (EditText)findViewById(R.id.PasswordEditText);
        fAuth =  FirebaseAuth.getInstance();

        //Register Text View
        RegisterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });
        //creating onClick listener for button Login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = email.getText().toString();
                String mPassword = password.getText().toString();

                //check if the edit text if filled in with user information
                if (TextUtils.isEmpty(mEmail)){
                    email.setError("email required");
                    return;
                }else if (TextUtils.isEmpty(mPassword)){
                    password.setError("Password required");
                    return;
                }

            }
        });
    }
}
