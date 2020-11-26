package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallePaciente extends AppCompatActivity {
    private ImageView foto;
    private TextView nombre, eps, motivo, direccion, numero, contacto, sexo, antecedentes, sintomas, covid;
    private Intent intent;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_paciente);

        foto = findViewById(R.id.imgFotoDetalle);
        nombre = findViewById(R.id.lblNombreDetalle);
        eps = findViewById(R.id.lblEpsDetalle);
        motivo = findViewById(R.id.lblMotivoDetalle);
        direccion = findViewById(R.id.lblDireccionDetalle);
        numero = findViewById(R.id.lblNumeroDetalle);
        contacto = findViewById(R.id.lblContactoDetalle);
        sexo = findViewById(R.id.lblSexoDetalle);
        antecedentes = findViewById(R.id.lblAntecedentesDetalle);
        sintomas = findViewById(R.id.lblSintomasDetalle);
        covid = findViewById(R.id.lblCovidDetalle);

        intent = getIntent();
        bundle = intent.getBundleExtra("datos");

        foto.setImageResource(bundle.getInt("foto"));
        nombre.setText(bundle.getString("nombre"));
        eps.setText(bundle.getString("eps"));
        motivo.setText(bundle.getString("motivo"));
        direccion.setText(bundle.getString("direccion"));
        numero.setText(bundle.getString("numero"));
        contacto.setText(bundle.getString("contacto"));
        sexo.setText(bundle.getString("sexo"));
        antecedentes.setText(bundle.getString("antecedentes"));
        sintomas.setText(bundle.getString("sintomas"));
        covid.setText(bundle.getString("covid"));

        Paciente p = new Paciente(bundle.getInt("foto"),bundle.getString("nombre"), bundle.getString("eps"),
                bundle.getString("motivo"), bundle.getString("direccion"), bundle.getString("numero"),
                bundle.getString("contacto"), bundle.getString("sexo"), bundle.getString("antecedentes"),
                bundle.getString("sintomas"), bundle.getString("covid"));

    }
}