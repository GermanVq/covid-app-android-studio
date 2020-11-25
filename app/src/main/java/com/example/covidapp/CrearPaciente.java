package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class CrearPaciente extends AppCompatActivity {
    private EditText nombre, motivo, direccion, numero, contacto, antecedentes;
    private Spinner sexo, eps;
    private CheckBox sintomas;
    private String[] opcionesSexo, opcionesEps;
    private int fotos[];
    private RadioGroup covid;
    private RadioButton rbSi, rbNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_paciente);
        nombre = findViewById(R.id.txtNombre);
        motivo = findViewById(R.id.txtMotivo);
        direccion = findViewById(R.id.txtDireccion);
        numero = findViewById(R.id.txtNumero);
        contacto = findViewById(R.id.txtContacto);
        rbSi = (RadioButton) findViewById(R.id.rbSi);
        rbNo = (RadioButton) findViewById(R.id.rbNo);

        fotos = new int[2];
        fotos[0] = R.drawable.hombre;
        fotos[1] = R.drawable.mujer;

        eps = (Spinner) findViewById(R.id.cmbEps);
        opcionesEps = getResources().getStringArray(R.array.epsSp);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, opcionesEps);
        eps.setAdapter(adapter);

        sexo = (Spinner) findViewById(R.id.cmbSexo);
        opcionesSexo = getResources().getStringArray(R.array.sexoSp);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, opcionesSexo);
        sexo.setAdapter(adapter2);



    }
}