package com.android.turtleschool;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.android.turtleschool.storage.FirebaseDataBaseAccessor;
import com.android.turtleschool.storage.School;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.etUserName)
    TextInputEditText etUserName;
    @BindView(R.id.etPassword)
    TextInputEditText etPassword;
    private FirebaseAuth firebaseAuth;

    private DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //Get Firebase auth instance
        firebaseAuth = FirebaseAuth.getInstance();

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("school");

        //FirebaseDataBaseAccessor.getInstance().fillSchoolDataFromFirebase();
        FirebaseDataBaseAccessor.getInstance().addDataStudent("assaf","60", "89", "0");
        FirebaseDataBaseAccessor.getInstance().addDataStudent("refael","60", "89", "0");
        // remember your login
        if (firebaseAuth.getCurrentUser() != null) {
            /*startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();*/

        }
    }

    @OnClick(R.id.btnSignIn)
    public void singIn() {
        String email = etUserName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(this, "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }
        //authenticate user
        //Login button click listener
        validate(email, password);
    }


    private void validate(String userName, String Password) {
        firebaseAuth.signInWithEmailAndPassword(userName, Password).addOnCompleteListener(this, task -> {
            if (task.isSuccessful()) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "One of the entered details is incorrect", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

