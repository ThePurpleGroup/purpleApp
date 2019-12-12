package br.senac.go.app.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import br.senac.go.app.R;
import br.senac.go.app.data.model.Usuario;
import br.senac.go.app.data.model.Veiculo;
import br.senac.go.app.data.repository.Callback;
import br.senac.go.app.data.repository.IVeiculoRepository;
import br.senac.go.app.data.repository.VeiculoRepository;
import br.senac.go.app.data.repository.source.VeiculoAPISource;
import br.senac.go.app.ui.adapter.VeiculoAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VeiculosPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private IVeiculoRepository veiculoRepository;
    private Button addVeiculoButton;


    private static final String TAG = "VeiculosPage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculos_page);

        recyclerView = findViewById(R.id.recycler_veiculos);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://192.168.31.30:8989")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VeiculoAPISource veiculoAPISource = retrofit.create(VeiculoAPISource.class);

        veiculoRepository = new VeiculoRepository(veiculoAPISource);

        addVeiculoButton = findViewById(R.id.addVeiculoButton);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        final Long id_usuario = bundle.getLong("id_usuario");

        final Usuario usuario = new Usuario();
        usuario.setId(id_usuario);


        addVeiculoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putLong("id_usuario", usuario.getId());
                Intent intent = new Intent(getApplicationContext(), VeiculoCadastroPage.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        veiculoRepository.getVeiculosUsuario(new Callback<List<Veiculo>>() {
            @Override
            public void onResult(List<Veiculo> result) {
                RecyclerView.Adapter adapter = new VeiculoAdapter(getApplicationContext(), result, new VeiculoAdapter.VeiculoListener() {
                    @Override
                    public void onClick(Veiculo veiculo) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("id_veiculo", veiculo.getId());
                        bundle.putString("tipo_veiculo", veiculo.getTipo_veiculo());
                        bundle.putString("placa", veiculo.getPlaca());
                        Intent intent = new Intent(getApplicationContext(), AbastecimentosPage.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onError(Exception e) {
                Log.e("mainAct", "Erro ao buscar lista de carros", e);
            }

            @Override
            public void onEmpty() {
                recyclerView.setAdapter(null);
            }
        }, usuario);


    }
}


