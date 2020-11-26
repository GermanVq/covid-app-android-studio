package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class CrearPaciente extends AppCompatActivity {
    private EditText nombre, motivo, direccion, numero, contacto, antecedentes;
    private Spinner sexo, eps;
    private CheckBox sintomas, c1, c2, c3, c4;
    private String[] opcionesSexo, opcionesEps;
    private int fotos[];
    private RadioGroup covid;
    private RadioButton rbSi, rbNo;
    private String resCov;
    private String resSin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_paciente);
        nombre = findViewById(R.id.txtNombre);
        motivo = findViewById(R.id.txtMotivo);
        direccion = findViewById(R.id.txtDireccion);
        numero = findViewById(R.id.txtNumero);
        contacto = findViewById(R.id.txtContacto);
        antecedentes = findViewById(R.id.txtAntecedentes);
        rbSi = (RadioButton) findViewById(R.id.rbSi);
        rbNo = (RadioButton) findViewById(R.id.rbNo);
        c1 = (CheckBox) findViewById(R.id.cbTos);
        c2 = (CheckBox) findViewById(R.id.cbGripa);
        c3 = (CheckBox) findViewById(R.id.cbDolor);
        c4 = (CheckBox) findViewById(R.id.cbFatiga);

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

/*
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c1.isChecked()){
                    resSin.add("Tos");
                }else{
                    resSin.remove("Tos");
                }
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c2.isChecked()){
                    resSin.add("Gripe");
                }else{
                    resSin.remove("Gripe");
                }
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c3.isChecked()){
                    resSin.add("Dolor");
                }else {
                    resSin.remove("Dolor");
                }
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c4.isChecked()){
                    resSin.add("Fatiga");
                }else{
                    resSin.remove("Fatiga");
                }
            }
        });
*/

    }

    public void guardar(View v){
        if(rbSi.isChecked() == true){
            resCov = "Positivo";
        }if(rbNo.isChecked() == true){
            resCov = "Negativo";
        }else{
            resCov = "Inseguro";
        }
        if(c1.isChecked()){
            String resSin = "tos";
        }
        if(validar()){
            String nomb, ep, sex, dirc, num, motiv, contac, antec, cov, sinto;
            Paciente p;
            String sint = "tos";
            nomb = nombre.getText().toString();
            ep = eps.getSelectedItem().toString();
            sex = sexo.getSelectedItem().toString();
            dirc = direccion.getText().toString();
            num = numero.getText().toString();
            motiv = motivo.getText().toString();
            contac = contacto.getText().toString();
            antec = antecedentes.getText().toString();
            cov = resCov;
            sinto = resSin;

            p = new Paciente(fotoAleatoria(fotos), nomb, ep, motiv, dirc, num, contac, sex, antec, sinto, cov );
            p.guardar();

            Toast.makeText(this, getString(R.string.mensaje_guardado), Toast.LENGTH_LONG).show();
        }
    }

    public Boolean validar(){
        nombre = findViewById(R.id.txtNombre);
        if (nombre.getText().toString().isEmpty()){
            return false;
        }
        return true;
    }
    public int fotoAleatoria(int fotos[]){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.length);
        return fotos[fotoSeleccionada];
    }
    public void onBackPressed(){
        finish();
        Intent i = new Intent(CrearPaciente.this, MenuActivity.class);
        startActivity(i);
    }
    public void borrar(View v){
        nombre.setText("");
        eps.equals("");
        motivo.setText("");
        direccion.setText("");
        numero.setText("");
        contacto.setText("");
        sexo.equals(0);
        antecedentes.setText("");
        nombre.requestFocus();
    }
}