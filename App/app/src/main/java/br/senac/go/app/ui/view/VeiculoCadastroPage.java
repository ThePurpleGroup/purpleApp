package br.senac.go.app.ui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.azimolabs.maskformatter.MaskFormatter;

import java.util.ArrayList;
import java.util.List;

import br.senac.go.app.R;
import br.senac.go.app.data.model.Veiculo;
import br.senac.go.app.data.repository.Callback;
import br.senac.go.app.data.repository.IVeiculoRepository;
import br.senac.go.app.data.repository.VeiculoRepository;
import br.senac.go.app.data.repository.source.VeiculoAPISource;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VeiculoCadastroPage extends AppCompatActivity {

    private static final String MASCARA_PLACA = "AAA 9999";
    private IVeiculoRepository veiculoRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculo_cadastro_page);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://192.168.31.19:8989")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VeiculoAPISource veiculoAPISource = retrofit.create(VeiculoAPISource.class);

        veiculoRepository = new VeiculoRepository(veiculoAPISource);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        final Long id_usuario = bundle.getLong("id_usuario");

        final Spinner spinner = findViewById(R.id.spinner);
        final Spinner spinnerCombustivel = findViewById(R.id.spinnerCombustivel);
        final EditText placa = findViewById(R.id.placa_veiculo_register);

        MaskFormatter maskFormatter = new MaskFormatter(MASCARA_PLACA, placa);
        placa.addTextChangedListener(maskFormatter);

        final List<String> listCarroTipo = new ArrayList<String>();
                listCarroTipo.add("Escolha o tipo do Veiculo...");
                listCarroTipo.add("Carro");
                listCarroTipo.add("Moto");
                listCarroTipo.add("caminhao");


        final List<String> listCombustivel = new ArrayList<String>();
                listCombustivel.add("Escolha o tipo do combustivel...");
                listCombustivel.add("Gasolina");
                listCombustivel.add( "Etanol");
                listCombustivel.add( "Flex");
                listCombustivel.add( "Diesel");




        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listCarroTipo) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @SuppressLint("ResourceAsColor")
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(R.color.midnight);
                }
                return view;
            }
        };
        final ArrayAdapter<String> spinnerCombustivelAdaper = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listCombustivel) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @SuppressLint("ResourceAsColor")
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(R.color.midnight);
                }
                return view;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCombustivelAdaper.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
        spinnerCombustivel.setAdapter(spinnerCombustivelAdaper);

        Button cadastroButton = findViewById(R.id.cadastroButton);
        final EditText descVeiculo = findViewById(R.id.desc_veiculo);
        final EditText placaVeiculoRegister = findViewById(R.id.placa_veiculo_register);


        cadastroButton.setOnClickListener(new View.OnClickListener() {

            String tipoCombustivel;
            String tipoVeiculo;

            @Override
            public void onClick(View v) {


                int positionCombustivel = spinnerCombustivel.getSelectedItemPosition();
                tipoCombustivel = listCombustivel.get(positionCombustivel);

                int positionTipoVeiculo = spinner.getSelectedItemPosition();
                tipoVeiculo = listCarroTipo.get(positionTipoVeiculo);

                String placaCorrigida = placaVeiculoRegister.getText().toString();
                String placaCerta = placaCorrigida.replaceAll("\\s", "-");

                Veiculo veiculo = new Veiculo();
                veiculo.setDesc_veiculo(descVeiculo.getText().toString());
                veiculo.setPlaca(placaCerta);
                veiculo.setTipo_combustivel(tipoCombustivel);
                veiculo.setTipo_veiculo(tipoVeiculo);
                veiculo.setId_usuario(id_usuario);

                veiculoRepository.createVeiculo(new Callback<Veiculo>() {
                    @Override
                    public void onResult(Veiculo result) {

                        Toast.makeText(VeiculoCadastroPage.this, "Veiculo " + descVeiculo.getText().toString() + " criado com sucesso!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(VeiculoCadastroPage.this, "Deu o erro : " + e.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onEmpty() {

                    }
                },veiculo);

            }
        });





    }
}
