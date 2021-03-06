package com.imran.tubesakb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    private EditText userName, userPassword, userEmail;
    private Button regButton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;
    String name, password, email;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    //database

                    final String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();
                    final String user_name = userName.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){
                                // ngambil user id
                                String uid = firebaseAuth.getCurrentUser().getUid();

                                // ngambil collection ref di firebase firestore
                                CollectionReference userRef = db.collection("users");

                                // ngisi data yang akan dimasukan database firestore
                                Map<String,Object> dataUser = new HashMap<>();
                                dataUser.put("uid",uid);
                                dataUser.put("nama",user_name);
                                dataUser.put("userEmail",user_email);

                                // memasukan data user ke firestore
                                userRef.document(uid).set(dataUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(RegistrationActivity.this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(RegistrationActivity.this, MainActivity2.class));
                                            finish();
                                        }
                                    }
                                });

                            }else{
                                Toast.makeText(RegistrationActivity.this, "Registrasi Gagal", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, MainActivity2.class));
            }
        });
    }

    private void setupUIViews(){
        userName = (EditText)findViewById(R.id.etUserName);
        userEmail = (EditText)findViewById(R.id.etUserEmail);
        userPassword = (EditText)findViewById(R.id.etUserPassword);
        regButton = (Button)findViewById(R.id.button3);
        userLogin = (TextView)findViewById(R.id.tvUserLogin);


    }

    private Boolean validate(){
        Boolean result = false;

         name = userName.getText().toString();
         password = userPassword.getText().toString();
         email = userEmail.getText().toString();

        if (name.isEmpty() || password.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Mohon diisi semuanya ya kawan!", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }

        return result;
    }
}