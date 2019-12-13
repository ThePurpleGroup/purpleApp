package br.senac.go.app.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import br.senac.go.app.R;
import br.senac.go.app.data.model.Abastecimento;
import br.senac.go.app.data.model.Veiculo;
import br.senac.go.app.data.repository.AbastecimentoRepository;
import br.senac.go.app.data.repository.Callback;
import br.senac.go.app.data.repository.IAbastecimentoRepository;
import br.senac.go.app.data.repository.source.AbastecimentoAPISource;
import br.senac.go.app.data.repository.source.VeiculoAPISource;
import br.senac.go.app.ui.adapter.AbastecimentoAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AbastecimentosPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private IAbastecimentoRepository abastecimentoRepository;
    private Button addAbastecimentoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastecimentos_page);

        recyclerView = findViewById(R.id.recycler_abastecimentos);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://192.168.31.19:8989")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AbastecimentoAPISource abastecimentoAPISource = retrofit.create(AbastecimentoAPISource.class);

        abastecimentoRepository = new AbastecimentoRepository(abastecimentoAPISource);

        addAbastecimentoButton = findViewById(R.id.addAbastecimentoButton);




    }

    @Override
    protected void onStart() {
        super.onStart();

        final Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        final Long id_veiculo = bundle.getLong("id_veiculo");
        final String tipo_veiculo = bundle.getString("tipo_veiculo");
        final String placa = bundle.getString("placa");

        final Veiculo veiculo = new Veiculo();
        veiculo.setId(id_veiculo);
        veiculo.setTipo_veiculo(tipo_veiculo);
        veiculo.setPlaca(placa);

        abastecimentoRepository.getAbastecimentosByIdVeiculo(new Callback<List<Abastecimento>>() {
            @Override
            public void onResult(List<Abastecimento> result) {
                RecyclerView.Adapter adapter = new AbastecimentoAdapter(getLayoutInflater(), result, veiculo);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(Exception e) {
                Log.e("mainAct", "Erro ao buscar lista de abastecimento", e);
            }

            @Override
            public void onEmpty() {
                Toast.makeText(AbastecimentosPage.this, "Lista de abastecimentos vazia", Toast.LENGTH_SHORT).show();
                recyclerView.setAdapter(null);
            }
        },veiculo);

    }
}
