package com.example.covidapp;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<Paciente> paciente = new ArrayList();

    public static void guardar(Paciente p){
        paciente.add(p);
    }

    public static ArrayList<Paciente> obtener(){
        return paciente;
    }
}
