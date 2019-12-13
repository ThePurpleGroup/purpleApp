package br.senac.go.app.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.util.List;

import br.senac.go.app.R;
import br.senac.go.app.data.model.Abastecimento;
import br.senac.go.app.data.model.Veiculo;

public class AbastecimentoAdapter extends RecyclerView.Adapter<AbastecimentoAdapter.ViewHolderAbastecimento> {



    private LayoutInflater layoutInflaterAbastecimento;
    private List<Abastecimento> abastecimentoList;
    private Veiculo veiculo;


    public AbastecimentoAdapter(LayoutInflater layoutInflaterAbastecimento, List<Abastecimento> abastecimentoList, Veiculo veiculo) {
        this.layoutInflaterAbastecimento = layoutInflaterAbastecimento;
        this.abastecimentoList = abastecimentoList;
        this.veiculo = veiculo;
    }

    @NonNull
    @Override
    public ViewHolderAbastecimento onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderAbastecimento(layoutInflaterAbastecimento.inflate(R.layout.item_abastecimento, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAbastecimento holder, int position) {
        holder.bind(abastecimentoList.get(position), veiculo);
    }

    @Override
    public int getItemCount() {
        return abastecimentoList.size();
    }

    public class ViewHolderAbastecimento extends RecyclerView.ViewHolder {

        private TextView nomePostoAbastecimento;
        private TextView placaAbastecimento;
        private TextView dataAbastecimento;
        private TextView odoAbastecimento;
        private TextView precoAbastecimento;
        private TextView qtdAbastecimento;
        private ImageView iconeAbastecimento;



        public ViewHolderAbastecimento(@NonNull View itemView) {
            super(itemView);

            nomePostoAbastecimento = itemView.findViewById(R.id.nome_posto_abastecimento);
            placaAbastecimento = itemView.findViewById(R.id.placa_abastecimento);
            dataAbastecimento = itemView.findViewById(R.id.data_abastecimento);
            odoAbastecimento = itemView.findViewById(R.id.odo_abastecimento);
            precoAbastecimento = itemView.findViewById(R.id.preco_abastecimento);
            qtdAbastecimento = itemView.findViewById(R.id.qtd_litros_abastecimento);
            iconeAbastecimento = itemView.findViewById(R.id.icone_abastecimento);
        }

        public void bind(Abastecimento abastecimento, Veiculo veiculo) {

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



            nomePostoAbastecimento.setText(abastecimento.getNome_posto());
            DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.SHORT);
            String format = dateInstance.format(abastecimento.getData_abastecimento());
            dataAbastecimento.setText(format);
            odoAbastecimento.setText(abastecimento.getOdometro().toString());
            precoAbastecimento.setText(abastecimento.getValor_total_combustive().toString());
            qtdAbastecimento.setText(abastecimento.getTotal_litros().toString());
            iconeAbastecimento.setImageResource(id_image);
            placaAbastecimento.setText(veiculo.getPlaca());



        }
    }
}




