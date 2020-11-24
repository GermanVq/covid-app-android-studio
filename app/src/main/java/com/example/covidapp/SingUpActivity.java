package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class SingUpActivity extends AppCompatActivity {
    TextView nuevoUsuario, bienvenido, continuar;
    ImageView signUPImageView;
    TextInputLayout emailSignUp, contrasenaSignUp;
    Button inicioSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);



    }
}