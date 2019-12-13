package br.senac.go.app.ui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.senac.go.app.R;
import br.senac.go.app.data.model.Login;
import br.senac.go.app.data.model.Usuario;
import br.senac.go.app.data.repository.Callback;
import br.senac.go.app.data.repository.IUsuarioRepository;
import br.senac.go.app.data.repository.UsuarioRepository;
import br.senac.go.app.data.repository.source.UsuarioAPISource;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPage extends AppCompatActivity {
    private IUsuarioRepository usuarioRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://192.168.31.19:8989")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsuarioAPISource usuarioAPISource = retrofit.create(UsuarioAPISource.class);
        usuarioRepository = new UsuarioRepository(usuarioAPISource);

        final EditText emailField = findViewById(R.id.login_email_field);
        final EditText passwordField = findViewById(R.id.login_password_field);



        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Login login = new Login();
                login.setEmail(emailField.getText().toString().toUpperCase());
                login.setSenha(passwordField.getText().toString());

                usuarioRepository.login(new Callback<Usuario>() {
                    @Override
                    public void onResult(Usuario result) {
                        Intent intent = new Intent(getApplicationContext(), VeiculosPage.class);
                        Bundle bundle = new Bundle();
                        bundle.putLong("id_usuario", result.getId());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(LoginPage.this, "Login Incorreto", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onEmpty() {
                        Toast.makeText(LoginPage.this, "Login Inexistente", Toast.LENGTH_SHORT).show();
                    }
                }, login);
            }
        });
    }
}
