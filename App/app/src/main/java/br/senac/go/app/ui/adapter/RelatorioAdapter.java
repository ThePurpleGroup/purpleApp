package br.senac.go.app.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.senac.go.app.R;
import br.senac.go.app.data.model.Relatorio;


public class RelatorioAdapter extends RecyclerView.Adapter<RelatorioAdapter.ViewHolderRelatorio> {


    private LayoutInflater layoutInflater;
    private Relatorio relatorio;

    public RelatorioAdapter(LayoutInflater layoutInflater, Relatorio relatorio) {
        this.layoutInflater = layoutInflater;
        this.relatorio = relatorio;
    }

    @NonNull
    @Override
    public RelatorioAdapter.ViewHolderRelatorio onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RelatorioAdapter.ViewHolderRelatorio holder, int position) {
        holder.bind(relatorio);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolderRelatorio extends RecyclerView.ViewHolder{

        private TextView postoMaisCaro;
        private  TextView postoMaisBarato;
        private TextView mediaCarro;



        public ViewHolderRelatorio(@NonNull View itemView) {
            super(itemView);

            postoMaisBarato = itemView.findViewById(R.id.posto_mais_barato);
            postoMaisCaro = itemView.findViewById(R.id.posto_mais_caro);
            mediaCarro = itemView.findViewById(R.id.media_carro);

        }

        public void bind(Relatorio relatorio){
            postoMaisCaro.setText(relatorio.getPostoMaisCaro());
            postoMaisBarato.setText(relatorio.getPostoMaisBarato());
            mediaCarro.setText(relatorio.getMediaConsumo().toString());
        }
    }
}
