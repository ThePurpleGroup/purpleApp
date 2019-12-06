package br.senac.go.app.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.senac.go.app.R;
import br.senac.go.app.data.model.Veiculo;
import br.senac.go.app.ui.adapter.VeiculoAdapter;

public class VeiculosPage extends AppCompatActivity implements VeiculoAdapter.OnVeiculoListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculos_page);

        recyclerView = findViewById(R.id.recycler_veiculos);

        List<Veiculo> veiculoList = new ArrayList<>();


        for (int i = 0; i < 30; i++) {
            Veiculo veiculo = new Veiculo();
            Long id = new Long(i);
            veiculo.setId(id);
            veiculo.setDescricao("Carro" + i);
            veiculo.setPlaca("SNC-00" + i);
            veiculo.setTipo("Nicholas");

            veiculoList.add(veiculo);

        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new VeiculoAdapter(getApplicationContext(), veiculoList));

    }


    @Override
    public void onVeiculoClick(int position) {
        Intent intent = new Intent(this, AbastecimentosPage.class);
        startActivity(intent);
    }
}


