package br.senac.go.app.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
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


    private static final String TAG = "VeiculosPage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculos_page);

        recyclerView = findViewById(R.id.recycler_veiculos);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://192.168.1.34:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VeiculoAPISource veiculoAPISource = retrofit.create(VeiculoAPISource.class);

        veiculoRepository = new VeiculoRepository(veiculoAPISource);


    }

    @Override
    protected void onStart() {
        super.onStart();

        Usuario usuario = new Usuario();
        usuario.setId(3L);

        veiculoRepository.getVeiculosUsuario(new Callback<List<Veiculo>>() {
            @Override
            public void onResult(List<Veiculo> result) {
                RecyclerView.Adapter adapter = new VeiculoAdapter(getApplicationContext(),result);
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


