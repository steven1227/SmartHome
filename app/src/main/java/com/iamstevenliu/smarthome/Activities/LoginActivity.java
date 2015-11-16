package com.iamstevenliu.smarthome.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.iamstevenliu.smarthome.R;

/**
 * Created by steven on 11/16/15.
 */
public class LoginActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        final Button button=(Button)findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameWrapper.getEditText().getText().toString();
                String password = passwordWrapper.getEditText().getText().toString();
                passwordWrapper.setErrorEnabled(false);
                usernameWrapper.setErrorEnabled(false);

                if (username.isEmpty()) {
                    usernameWrapper.setError("Do not enter empty username!");
                } else if (password.isEmpty()) {
                    passwordWrapper.setError("Do not enter empty password!");
                } else if(username.equals("ecogenie")&&password.equals("ecogenie")){
                    Intent i=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this, R.style.MyAlertDialogStyle);
                    builder.setTitle("Login Error");
                    builder.setMessage("Wrong UserName or Password");
                    builder.setPositiveButton("OK", null);
                    builder.show();
                }

            }
        });

        usernameWrapper.setHint("Username");
        passwordWrapper.setHint("Password");
    }

}
