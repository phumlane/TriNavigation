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

public class RegisterActivity extends AppCompatActivity {
    public Button register ;
    public EditText name,email,password;
    public TextView LoginText;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText)findViewById(R.id.UserName);
        email = (EditText)findViewById(R.id.UserNameEditText);
        password = (EditText)findViewById(R.id.PasswordEditText);
        register = (Button)findViewById(R.id.RegisterBtn1);
        LoginText = (TextView)findViewById(R.id.LoginText);
        fAuth = FirebaseAuth.getInstance();


        LoginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mNama = name.getText().toString().trim();
                String mEmail = email.getText().toString();
                String mPassword = password.getText().toString();

                if(TextUtils.isEmpty(mNama)){
                    name.setError("Name Required");
                    return;
                }else if(TextUtils.isEmpty(mEmail)){
                    email.setError("Email Required");
                    return;
                }else  if(TextUtils.isEmpty(mPassword)){
                    password.setError("Password required");
                    return;
                }else if(mPassword.length()<6){
                    password.setError("password must be greate than 6");
                    return;

                }else if(mPassword.length()>10){
                    password.setError("password must be less than 10");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(mEmail,mPassword).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Successfully Registered",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(),UserInter.class);
                            startActivity(intent);

                        }
                        else {

                            Toast.makeText(RegisterActivity.this,"Authentication Failed" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });


            }
        });
    }
}
