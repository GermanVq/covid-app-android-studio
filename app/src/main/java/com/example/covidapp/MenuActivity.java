package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements AdapterPaciente.OnPacienteClickListener {
    private RecyclerView listadoPaciente;
    private AdapterPaciente adaptador;
    private LinearLayoutManager llm;
    private ArrayList<Paciente> paciente;
    private Context contexto;
    private Intent intent;
    Button logouthbtn;

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

        }


        listadoPaciente =(RecyclerView) findViewById(R.id.lstPaciente);

        paciente = Datos.obtener();
        paciente = new ArrayList<Paciente>();
        //ArrayList<String> sintomas = new ArrayList<String>();
        //sintomas.add(0, "tos");
        paciente.add(new Paciente(R.drawable.hombre, "sura", "sura","ninguno", "cr7", "322222", "no", "hombre", "ninguno", "tos", "si"));

        adaptador = new AdapterPaciente(paciente, this);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        listadoPaciente.setLayoutManager(llm);
        listadoPaciente.setAdapter(adaptador);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MenuActivity.this, CrearPaciente.class);
                startActivity(intent);
            }
        });

    }
    public void onPacienteClick(Paciente p){
        Intent intent;
        Bundle bundle;

        bundle = new Bundle();

        bundle.putInt("foto",p.getFoto());
        bundle.putString("nombre", p.getNombre());
        bundle.putString("eps", p.getEps());
        bundle.putString("motivo", p.getMotivio());
        bundle.putString("direccion", p.getDireccion());
        bundle.putString("numero", p.getNumero());
        bundle.putString("contacto", p.getContacto());
        bundle.putString("sexo", p.getSexo());
        bundle.putString("antecedentes", p.getAntecendentes());
        bundle.putString("sintomas", p.getSintomas());
        bundle.putString("covid", p.getCovid());

        intent = new Intent(MenuActivity.this, DetallePaciente.class);
        intent.putExtra("datos",bundle);
        startActivity(intent);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.salirit){
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onContextItemSelected(item);
    }


}