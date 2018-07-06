package com.halo.loginui2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.halo.loginui2.R;

public class Login extends AppCompatActivity implements View.OnClickListener  {


   private EditText editTextEmail, editTextPassword;

  private  Button Login;
    private FirebaseAuth mAuth;

   private TextView TextView_Signup;
private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();


        if(mAuth.getCurrentUser()!=null){
            //check if user already logged in
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));


        }

         TextView_Signup=(TextView) findViewById(R.id.txt_signup);
        editTextEmail = (EditText) findViewById(R.id.et_email_login);
        editTextPassword = (EditText) findViewById(R.id.et_pass_login);

        Login=(Button)findViewById(R.id.login_login);
progressDialog=new ProgressDialog(this);
        Login.setOnClickListener(this);
        TextView_Signup.setOnClickListener(this);


    }
private void userLogin(){
        String str_email=editTextEmail.getText().toString().trim();
        String str_password=editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(str_email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG);
            return;
        }


    if(TextUtils.isEmpty(str_password)){
        Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG);
        return;
    }

    progressDialog.setTitle("Loading");

    progressDialog.setMessage("Please wait..");

        progressDialog.show();
        mAuth.signInWithEmailAndPassword(str_email,str_password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    //start activity for log in
finish();
startActivity(new Intent(getApplicationContext(),MainActivity.class));

                }
            }
        });

}



    @Override
    public void onClick(View view) {
        if(view==Login){
            userLogin();

        }

        if(view==TextView_Signup){
            finish();
            startActivity(new Intent(this,Signup.class));

        }


    }
}
