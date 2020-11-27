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
    private ArrayList<String> resSintomas;


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
                    resSintomas.add("Tos");
                }else{
                    resSintomas.remove("Tos");
                }
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c2.isChecked()){
                    resSintomas.add("Gripe");
                }else{
                    resSintomas.remove("Gripe");
                }
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c3.isChecked()){
                    resSintomas.add("Dolor");
                }else {
                    resSintomas.remove("Dolor");
                }
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c4.isChecked()){
                    resSintomas.add("Fatiga");
                }else{
                    resSintomas.remove("Fatiga");
                }
            }
        });


 */

    }
    public String SintomasEnf(){
        String sin = resSin;
        if(c1.isChecked()){
            sin = c1.getText().toString()+", ";
        }
        if(c2.isChecked()){
            sin = c2.getText().toString()+", ";
        }
        if(c3.isChecked()){
            sin = c3.getText().toString()+", ";
        }
        if(c4.isChecked()){
            sin = c4.getText().toString()+", ";
        }
        if(c1.isChecked() == false && c2.isChecked() == false && c3.isChecked() == false && c4.isChecked() == false){
            sin = getString(R.string.sin_sintomas);
        }
        return sin;
    }

    public void guardar(View v){
        if(rbSi.isChecked() == true){
            resCov = getString(R.string.positivo);
        }if(rbNo.isChecked() == true){
            resCov = getString(R.string.negativo);
        }else{
            resCov = getString(R.string.incierto);
        }

        if(validar()){
            String nomb, ep, sex, dirc, num, motiv, contac, antec, cov, sinto;
            Paciente p;
            nomb = nombre.getText().toString();
            ep = eps.getSelectedItem().toString();
            sex = sexo.getSelectedItem().toString();
            dirc = direccion.getText().toString();
            num = numero.getText().toString();
            motiv = motivo.getText().toString();
            contac = contacto.getText().toString();
            antec = antecedentes.getText().toString();
            cov = resCov;
            sinto =  SintomasEnf();

            p = new Paciente(fotoAleatoria(fotos), nomb, ep, motiv, dirc, num, contac, sex, antec, sinto, cov );
            p.guardar();
            borrar(v);

            Toast.makeText(this, getString(R.string.mensaje_guardado), Toast.LENGTH_LONG).show();
        }
    }

    public Boolean validar(){
        nombre = findViewById(R.id.txtNombre);
        if (nombre.getText().toString().isEmpty()){
            nombre.setError(getString(R.string.mensaje_error));
            nombre.requestFocus();
            return false;
        }
        if (direccion.getText().toString().isEmpty()){
            direccion.setError(getString(R.string.mensaje_error));
            direccion.requestFocus();
            return false;
        }
        if (numero.getText().toString().isEmpty()){
            numero.setError(getString(R.string.mensaje_error));
            numero.requestFocus();
            return false;
        }
        if (motivo.getText().toString().isEmpty()){
            motivo.setError(getString(R.string.mensaje_error));
            motivo.requestFocus();
            return false;
        }
        if (contacto.getText().toString().isEmpty()){
            contacto.setError(getString(R.string.mensaje_error));
            contacto.requestFocus();
            return false;
        }
        if (antecedentes.getText().toString().isEmpty()){
            antecedentes.setError(getString(R.string.mensaje_error));
            antecedentes.requestFocus();
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