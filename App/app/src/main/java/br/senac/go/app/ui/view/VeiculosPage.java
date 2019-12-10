package br.senac.go.app.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
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
    private Button addVeiculoButton;


    private static final String TAG = "VeiculosPage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculos_page);

        recyclerView = findViewById(R.id.recycler_veiculos);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://192.168.31.9:8989")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VeiculoAPISource veiculoAPISource = retrofit.create(VeiculoAPISource.class);

        veiculoRepository = new VeiculoRepository(veiculoAPISource);

        addVeiculoButton = findViewById(R.id.addVeiculoButton);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final Usuario usuario = new Usuario();
        usuario.setId(1L);

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


