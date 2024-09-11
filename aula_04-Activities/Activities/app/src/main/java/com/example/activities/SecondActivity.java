package com.example.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.activities.Modelos;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        Button buttonSortear = findViewById(R.id.buttonSortear);
        TextView textViewModelo = findViewById(R.id.textViewModelo);
        Modelos modelos = new Modelos();

        buttonSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acessando o array de modelos de carros da classe Kotlin

                String[] modelosDeCarros = modelos.getModelosCDeCarros();

                // Sorteando um índice aleatório
                int randomIndex = new Random().nextInt(modelosDeCarros.length);

                // Exibindo o modelo sorteado na TextView
                textViewModelo.setText(modelosDeCarros[randomIndex]);
            }
        });
    }
}