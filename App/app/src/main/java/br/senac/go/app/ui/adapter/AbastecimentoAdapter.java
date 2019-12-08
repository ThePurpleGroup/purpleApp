package br.senac.go.app.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.senac.go.app.R;
import br.senac.go.app.data.model.Abastecimento;

public class AbastecimentoAdapter extends RecyclerView.Adapter<AbastecimentoAdapter.ViewHolderAbastecimento> {



    LayoutInflater layoutInflaterAbastecimento;
    List<Abastecimento> abastecimentoList;

    public AbastecimentoAdapter(LayoutInflater layoutInflaterAbastecimento, List<Abastecimento> abastecimentoList) {
        this.layoutInflaterAbastecimento = layoutInflaterAbastecimento;
        this.abastecimentoList = abastecimentoList;
    }

    @NonNull
    @Override
    public ViewHolderAbastecimento onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderAbastecimento(layoutInflaterAbastecimento.inflate(R.layout.item_abastecimento, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAbastecimento holder, int position) {
        holder.bind(abastecimentoList.get(position));
    }

    @Override
    public int getItemCount() {
        return abastecimentoList.size();
    }

    public class ViewHolderAbastecimento extends RecyclerView.ViewHolder {


        public ViewHolderAbastecimento(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Abastecimento abastecimento) {
        }
    }
}




