package com.imran.tubesakb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.imran.tubesakb.menuactivity.MenuActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login, userRegistration;
    private FirebaseAuth mAuth;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Login = (Button)findViewById(R.id.button);
        userRegistration = (Button)findViewById(R.id.button2);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, RegistrationActivity.class));
            }
        });

        mAuth = FirebaseAuth.getInstance();

        /** [ Start ] Ngecek kalo user masih login langsung ke Menu Activity **/
        if(mAuth.getCurrentUser() != null){
            Intent intent = new Intent (MainActivity2.this, MenuActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void validate(String userName, String userPassword){
        mAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent (MainActivity2.this, MenuActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Login gagal",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }
}