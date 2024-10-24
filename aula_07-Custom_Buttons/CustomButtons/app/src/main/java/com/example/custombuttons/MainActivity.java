package com.example.custombuttons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonEnviar = findViewById(R.id.buttonEnviar);
        EditText editTextNome = findViewById(R.id.editTextNome);
        TextView textViewSaida = findViewById(R.id.textViewSaida);

        AppCompatButton buttonFormulario = findViewById(R.id.buttonFormulario);
        AppCompatButton buttonGeradorUUID = findViewById(R.id.buttonGeradorUUID);
        AppCompatButton buttonAdicionar = findViewById(R.id.buttonAdicionar);

        String mensagemBoasVindas = getString(R.string.boas_vinda);


        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtendo o nome digitado pelo usuário
                String nome = editTextNome.getText().toString();

                // Exibindo a mensagem de boas-vindas
                textViewSaida.setText(mensagemBoasVindas + nome + "!");
            }
        });

        buttonFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FormularioActivity.class);
                startActivity(intent);
            }
        });

        buttonGeradorUUID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GeradorUUIDActivity.class);
                startActivity(intent);
            }
        });

        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FormularioActivity.class);
                startActivity(intent);
            }
        });


    }
}