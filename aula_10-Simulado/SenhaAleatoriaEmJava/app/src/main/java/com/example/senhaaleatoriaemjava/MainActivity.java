package com.example.senhaaleatoriaemjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnGeneratePassword;
    private TextView textViewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGeneratePassword = findViewById(R.id.btnGeneratePassword);
        textViewPassword = findViewById(R.id.textViewPassword);

        btnGeneratePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = generatePassword();
                textViewPassword.setText("Senha: " + password);
            }
        });
    }

    // Função para gerar a senha com 3 letras minúsculas, 3 números e 3 símbolos, sem shuffle
    private String generatePassword() {
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&";

        // Gerar 3 letras aleatórias
        char letter1 = lowerCaseLetters.charAt(new Random().nextInt(lowerCaseLetters.length()));
        char letter2 = lowerCaseLetters.charAt(new Random().nextInt(lowerCaseLetters.length()));
        char letter3 = lowerCaseLetters.charAt(new Random().nextInt(lowerCaseLetters.length()));

        // Gerar 3 números aleatórios
        char number1 = numbers.charAt(new Random().nextInt(numbers.length()));
        char number2 = numbers.charAt(new Random().nextInt(numbers.length()));
        char number3 = numbers.charAt(new Random().nextInt(numbers.length()));

        // Gerar 3 símbolos aleatórios
        char symbol1 = symbols.charAt(new Random().nextInt(symbols.length()));
        char symbol2 = symbols.charAt(new Random().nextInt(symbols.length()));
        char symbol3 = symbols.charAt(new Random().nextInt(symbols.length()));

        // Intercalar os caracteres na senha final, manualmente
        String password = "" + letter1 + number1 + symbol1
                + letter2 + number2 + symbol2
                + letter3 + number3 + symbol3;

        return password;
    }
}