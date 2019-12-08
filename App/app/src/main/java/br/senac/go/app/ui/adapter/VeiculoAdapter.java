package br.senac.go.app.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.senac.go.app.R;
import br.senac.go.app.data.model.Veiculo;
import br.senac.go.app.ui.view.AbastecimentosPage;

public class VeiculoAdapter extends RecyclerView.Adapter<VeiculoAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Veiculo> veiculoList;




    public VeiculoAdapter(Context context, List<Veiculo> veiculoList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.veiculoList = veiculoList;
    }

    @NonNull
    @Override
    public VeiculoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_veiculo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VeiculoAdapter.ViewHolder holder, int position) {
        holder.bind(veiculoList.get(position), position);


    }

    @Override
    public int getItemCount() {
        return veiculoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView desc_veiculo ;
        private TextView placa_veiculo ;
        private ImageView imageView ;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            desc_veiculo = itemView.findViewById(R.id.descricao_veiculo);
            placa_veiculo = itemView.findViewById(R.id.placa_veiculo);
            imageView = itemView.findViewById(R.id.icon_veiculo);
        }

        public void bind(Veiculo veiculo, int position) {

            int id_image;

            switch (veiculo.getTipo_veiculo()) {
                case "Moto":
                    id_image = R.drawable.chopper;
                    break;

                case "Carro":
                    id_image = R.drawable.van;
                    break;

                case "Caminhao":
                    id_image = R.drawable.truck;
                    break;

                default:
                    id_image = R.drawable.spaceship;
                    break;
            }

            desc_veiculo.setText(veiculo.getDesc_veiculo());
            placa_veiculo.setText(veiculo.getPlaca());
            imageView.setImageResource(id_image);


        }

    }


}
