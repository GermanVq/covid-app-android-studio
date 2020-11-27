package com.example.covidapp;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<Paciente> paciente = new ArrayList();

    public static void guardar(Paciente p){
        paciente.add(p);
    }

    public static void eliminar(Paciente p){
        for (int i = 0; i < paciente.size(); i++){
            if(paciente.get(i).getNumero().equals(p.getNumero())){
                paciente.remove(i);
                break;
            }
        }
    }

    public static ArrayList<Paciente> obtener(){
        return paciente;
    }


}
