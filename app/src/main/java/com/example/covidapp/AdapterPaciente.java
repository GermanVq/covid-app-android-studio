package com.example.covidapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterPaciente extends RecyclerView.Adapter<AdapterPaciente.PacienteViewHolder> {
    private ArrayList<Paciente> paciente;
    private OnPacienteClickListener clickListener;


    public AdapterPaciente(ArrayList<Paciente> paciente, OnPacienteClickListener clickListener) {
        this.paciente = paciente;
        this.clickListener=clickListener;
    }

    @NonNull
    @Override
    public PacienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_paciente,parent,false);
        return new PacienteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PacienteViewHolder holder, int position) {
        final Paciente p = paciente.get(position);

        holder.foto.setImageResource(p.getFoto());
        holder.nombre.setText(p.getNombre());
        holder.direccion.setText(p.getDireccion());
        holder.sexo.setText(p.getSexo());
        holder.covid.setText(p.getCovid());
        holder.eps.setText(p.getEps());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onPacienteClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return paciente.size();
    }

    public static class PacienteViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView foto;
        private TextView nombre;
        private TextView direccion;
        private TextView sexo;
        private TextView covid;
        private TextView eps;
        private View v;

        public PacienteViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            nombre = v.findViewById(R.id.lblNombre);
            direccion = v.findViewById(R.id.lblDireccion);
            sexo = v.findViewById(R.id.lblSexo);
            covid = v.findViewById(R.id.lblCovid);
            eps = v.findViewById(R.id.lblEps);
        }
    }
    public interface OnPacienteClickListener{
        void onPacienteClick(Paciente a);
    }

}
