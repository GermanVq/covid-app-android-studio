package com.example.covidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class SingUpActivity extends AppCompatActivity {
    TextView nuevoUsuario, bienvenido, continuarLogin;
    ImageView signUpImageView;
    TextInputLayout emailSignUp, contrasenaSignUp;
    Button inicioSesion;
    TextInputEditText emailtxt, passwordtxt, confirmpasswordtxt;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        emailtxt = findViewById(R.id.emailtxt);
        passwordtxt = findViewById(R.id.passwordtxt);
        confirmpasswordtxt = findViewById(R.id.password2txt);
        nuevoUsuario = findViewById(R.id.registroSesion);


        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }

        });
        mAuth = FirebaseAuth.getInstance();

        continuarLogin = findViewById(R.id.yatieneUsuario);
        continuarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void validate() {
        String email = emailtxt.getText().toString().trim();
        String password = passwordtxt.getText().toString().trim();
        String confirmPassword = confirmpasswordtxt.getText().toString().trim();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailtxt.setError("Correo invalido");
            return;
        }else {
            emailtxt.setError(null);
        }
        if (password.isEmpty() || password.length() < 8) {
            passwordtxt.setError("Contraseña invalida se necesitan mas de 8 caracteres");
        } else if(!Pattern.compile("[0-9]").matcher(password).find()){
            passwordtxt.setError("Ingrese al menos un número");
        } else {
            passwordtxt.setError(null);
        }
        if(!confirmPassword.equals(password)){
            confirmpasswordtxt.setError("Deben coincidir las contraseñas");
        } else {
            registrar(email, password);
        }
    }

    public void registrar(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SingUpActivity.this, "Registro Exitoso!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SingUpActivity.this, MenuActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(SingUpActivity.this, "Fallo el registro", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}