package com.practiceapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.resources.SaveSharedPreference;

import org.apache.log4j.Logger;

import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity{

    private Button logInButton;
    private EditText emailText;
    private EditText passwordText;
    private TextView signUpText;
    private RadioGroup radioUserGroup;
    private RadioButton radioUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("Login", "iside he login activity");
        emailText = (EditText) findViewById(R.id.input_email);
        passwordText = (EditText) findViewById(R.id.input_password);
        radioUserGroup = (RadioGroup) findViewById(R.id.userType);
        if(SaveSharedPreference.getUserType(MainActivity.this).length() == 0)
        {
            logInButton = (Button) findViewById(R.id.btn_login);
            logInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    login();
                }
            });

            signUpText = (TextView) findViewById(R.id.link_signup);
            signUpText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                    startActivity(intent);
                }
            });
        }else{
            if(SaveSharedPreference.getUserType(MainActivity.this).toLowerCase().equals("shopkeeper")){
                Intent intent = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(intent);
                finish();
            }else if(SaveSharedPreference.getUserType(MainActivity.this).toLowerCase().equals("consumer")){
                Intent intent = new Intent(getApplicationContext(), ConsumerActivity.class);
                startActivity(intent);
                finish();
            }

        }
    }

    public void login(){
        Log.e("Login", "iside he login activity indside thr login");
        
        if(!validate()){
            return;
        }

        logInButton.setEnabled(false);
        if(authLogin()){
            int selectedId = radioUserGroup.getCheckedRadioButtonId();
            radioUserButton = (RadioButton) findViewById(selectedId);
            String userType = radioUserButton.getText().toString();
            Log.e("Login", "va;lue of userType "+userType);
            if(userType.toLowerCase().equals("shopkeeper")){
                SaveSharedPreference.setShopkeeperObjectValue(getApplicationContext(),userType,null);
                Intent intent = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(intent);
                finish();
            }else if(userType.toLowerCase().equals("consumer")){
                SaveSharedPreference.setConsumerObjectValue(getApplicationContext(),userType,null);
                Intent intent = new Intent(getApplicationContext(), ConsumerActivity.class);
                startActivity(intent);
                finish();
            }
        }else{
            authFailed();
            return;
        }
    }

    private boolean authLogin(){
        boolean auth = false;
        try{
            String userName = emailText.getText().toString().trim();
            String password = passwordText.getText().toString().trim();
            if(userName.equals("admin@gmail.com") && password.equals("admin")){
                auth = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return auth;
    }

    public boolean validate() {
        boolean valid = true;
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        int selectedId = radioUserGroup.getCheckedRadioButtonId();
        Log.e("Login", "value of email  "+email);
        Log.e("Login", "value of password  "+password);

        if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("enter a valid email address");
            valid = false;
            return valid;
        } else {
            emailText.setError(null);
        }

        if (TextUtils.isEmpty(password) ) {
            passwordText.setError("please enter your password");
            valid = false;
            return valid;
        } else {
            passwordText.setError(null);
        }

      if( selectedId == -1){
          noRadioSelected();
          valid = false;
        }
        return valid;
    }
    public void noRadioSelected() {
        Toast.makeText(getBaseContext(), "Please Select Type", Toast.LENGTH_LONG).show();
    }

    public void authFailed(){
        Toast.makeText(getBaseContext(), "Please Enter Valid UserName or Password", Toast.LENGTH_LONG).show();
        logInButton.setEnabled(true);
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

}
