package com.programa.fichasinstrumentos_es1821000615_hucr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InstrumentosNoEstudiadosAdapter extends RecyclerView.Adapter<InstrumentosNoEstudiadosAdapter.ViewHolder> {
    private List<Instrumento> instrumentosNoEstudiados;

    public InstrumentosNoEstudiadosAdapter(List<Instrumento> instrumentosNoEstudiados) {
        this.instrumentosNoEstudiados = instrumentosNoEstudiados;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_estudiados, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Instrumento instrumento = instrumentosNoEstudiados.get(position);
        holder.nombreTextView.setText(instrumento.getNombre());
        // Establece la imagen y el estado de estudiado según sea necesario
        holder.imagenImageView.setImageResource(instrumento.getImagen());
        holder.estudiadoTextView.setText(instrumento.isEstudiado() ? "Estudiado" : "No estudiado");
    }

    @Override
    public int getItemCount() {
        return instrumentosNoEstudiados.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView;
        ImageView imagenImageView;
        TextView estudiadoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            imagenImageView = itemView.findViewById(R.id.imagenImageView);
            estudiadoTextView = itemView.findViewById(R.id.estudiadoTextView);
        }
    }
}
