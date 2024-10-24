package com.example.senhaaleatoria

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var btnGeneratePassword: Button
    lateinit var textViewPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGeneratePassword = findViewById(R.id.btnGeneratePassword)
        textViewPassword = findViewById(R.id.textViewPassword)

        btnGeneratePassword.setOnClickListener {
            val password = generatePassword()
            textViewPassword.text = "Senha: $password"
        }
    }

    // Função para gerar a senha com 3 letras minúsculas, 3 números e 3 símbolos, sem shuffle
    private fun generatePassword(): String {
        val lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz"
        val numbers = "0123456789"
        val symbols = "!@#$%&"

        // Gerar 3 letras aleatórias
        val letter1 = lowerCaseLetters.random()
        val letter2 = lowerCaseLetters.random()
        val letter3 = lowerCaseLetters.random()

        // Gerar 3 números aleatórios
        val number1 = numbers.random()
        val number2 = numbers.random()
        val number3 = numbers.random()

        // Gerar 3 símbolos aleatórios
        val symbol1 = symbols.random()
        val symbol2 = symbols.random()
        val symbol3 = symbols.random()

        // Intercalar os caracteres diretamente na senha final
        val password = "$letter1$number1$symbol1$letter2$number2$symbol2$letter3$number3$symbol3"

        return password
    }
}
