package com.example.covidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    TextView nuevoUsuario;
    Button iniciarSesion;
    TextInputLayout emailtxt, passwordtxt;
    TextInputEditText lemailtxt, lpasswordtxt;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iniciarSesion = findViewById(R.id.inicioSesion);
        nuevoUsuario = findViewById(R.id.nuevoUsuario);
        lemailtxt = findViewById(R.id.lemailtxt);
        lpasswordtxt = findViewById(R.id.lpasswordtxt);

        mAuth = FirebaseAuth.getInstance();

        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SingUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }
    public void validate() {
        String email = lemailtxt.getText().toString().trim();
        String password = lpasswordtxt.getText().toString().trim();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            lemailtxt.setError("Correo invalido");
            return;
        }else {
            lemailtxt.setError(null);
        }
        if (password.isEmpty() || password.length() < 8) {
            lpasswordtxt.setError("Contraseña invalida se necesitan mas de 8 caracteres");
        } else if(!Pattern.compile("[0-9]").matcher(password).find()){
            lpasswordtxt.setError("Ingrese al menos un número");
        } else {
            lpasswordtxt.setError(null);
        }
        iniciarSesion(email, password);

    }

    public void iniciarSesion(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                         if (task.isSuccessful()) {
                             Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                             startActivity(intent);
                             finish();
                         } else {
                             Toast.makeText(LoginActivity.this, "Credenciales incorrectas, vuelva a intentar", Toast.LENGTH_LONG).show();
                         }
                    }
                });
    }


}