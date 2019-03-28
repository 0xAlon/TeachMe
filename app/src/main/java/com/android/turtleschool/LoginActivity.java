package com.android.turtleschool;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.etUserName)
    EditText etUserName;
    @BindView(R.id.etPassword)
    EditText etPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //Get Firebase auth instance
        firebaseAuth = FirebaseAuth.getInstance();

        // remember your login
        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        //validate email and password
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
            }
        });
    }
}

