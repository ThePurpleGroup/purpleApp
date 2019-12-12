package br.senac.go.app.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import br.senac.go.app.R;
import br.senac.go.app.data.model.Relatorio;
import br.senac.go.app.data.model.Veiculo;
import br.senac.go.app.data.repository.Callback;
import br.senac.go.app.data.repository.IVeiculoRepository;
import br.senac.go.app.data.repository.VeiculoRepository;
import br.senac.go.app.data.repository.source.VeiculoAPISource;
import br.senac.go.app.ui.adapter.RelatorioAdapter;
import br.senac.go.app.ui.adapter.VeiculoAdapter;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RelatorioPage extends AppCompatActivity {


    private RecyclerView recyclerView;
    private IVeiculoRepository veiculoRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_page);

        recyclerView = findViewById(R.id.recycler_relatorios);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://192.168.31.30:8989")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VeiculoAPISource veiculoAPISource = retrofit.create(VeiculoAPISource.class);

        veiculoRepository = new VeiculoRepository(veiculoAPISource);


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


        veiculoRepository.getRelatorioByIdVeiculo(new Callback<Relatorio>() {
            @Override
            public void onResult(Relatorio result) {
                RecyclerView.Adapter adapter = new RelatorioAdapter(getLayoutInflater(), result );
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(Exception e) {
                Log.e("mainAct", "Erro ao buscar lista de abastecimento", e);
            }

            @Override
            public void onEmpty() {
                Toast.makeText(RelatorioPage.this, "Lista de Relatorios vazia!", Toast.LENGTH_SHORT).show();
                recyclerView.setAdapter(null);
            }
        }, veiculo);

    }
}
