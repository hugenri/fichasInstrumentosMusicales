package com.programa.fichasinstrumentos_es1821000615_hucr;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class InstrumentoAdapter extends RecyclerView.Adapter<InstrumentoAdapter.InstrumentoViewHolder> {

    private List<Instrumento> instrumentos;

    public InstrumentoAdapter(List<Instrumento> instrumentos) {
        this.instrumentos = instrumentos;
    }

    @NonNull
    @Override
    public InstrumentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_instrumento, parent, false);
        return new InstrumentoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InstrumentoViewHolder holder, int position) {
        Instrumento instrumento = instrumentos.get(position);
        holder.bind(instrumento);
    }

    @Override
    public int getItemCount() {
        return instrumentos.size();
    }

    public class InstrumentoViewHolder extends RecyclerView.ViewHolder {

        private TextView nombreTextView;
        private TextView descripcionTextView;
        private TextView caracteristicasTextView;
        private TextView resenaHistoricaTextView;
        private ImageView instrumentoImageView;
        private CheckBox checkboxEstudiado;

        public InstrumentoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            descripcionTextView = itemView.findViewById(R.id.descripcionTextView);
            caracteristicasTextView = itemView.findViewById(R.id.caracteristicasTextView);
            resenaHistoricaTextView = itemView.findViewById(R.id.resenaHistoricaTextView);
            instrumentoImageView = itemView.findViewById(R.id.instrumentoImageView);
            checkboxEstudiado = itemView.findViewById(R.id.checkboxEstudiado);
            // Establecer el texto en el CheckBox
            checkboxEstudiado.setText("Marcar como estudiado");
        }

        public void bind(final Instrumento instrumento) {
            instrumentoImageView.setImageResource(instrumento.getImagen()); // Asigna la imagen correspondiente al ImageView
            checkboxEstudiado.setChecked(instrumento.isEstudiado()); // Establece el estado del CheckBox
            nombreTextView.setText(instrumento.getNombre());
            descripcionTextView.setText(instrumento.getDescripcion());
            caracteristicasTextView.setText(instrumento.getCaracteristicas());
            resenaHistoricaTextView.setText(instrumento.getResenaHistorica());
            // Manejar el evento de clic en el CheckBox
            checkboxEstudiado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isChecked = checkboxEstudiado.isChecked();
                    instrumento.setEstudiado(isChecked);
                    ((VientoActivity) itemView.getContext()).onCheckboxClicked(v);
                }
            });
        }
    }
}
