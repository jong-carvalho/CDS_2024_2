package com.example.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val campoPeso: EditText = findViewById(R.id.editTextPeso)
        val campoAltura: EditText = findViewById(R.id.editTextAltura)
        val botaoCalcular: Button = findViewById(R.id.buttonCalcular)
        val textoResultado: TextView = findViewById(R.id.editTextResultado)

        botaoCalcular.setOnClickListener {
            val pesoTexto = campoPeso.text.toString()
            val alturaTexto = campoAltura.text.toString()

            if (pesoTexto.isNotEmpty() && alturaTexto.isNotEmpty()) {
                val peso = pesoTexto.toDouble()
                val altura = alturaTexto.toDouble()

                val imc = peso / altura.pow(2)

                val categoria = when {
                    imc < 18.5 -> "Baixo peso"
                    imc in 18.5..24.9 -> "Peso normal"
                    imc in 25.0..29.9 -> "Sobrepeso"
                    imc in 30.0..34.9 -> "Obesidade Grau I"
                    imc in 35.0..39.9 -> "Obesidade Grau II"
                    else -> "Obesidade Grau III"
                }

                textoResultado.text = "IMC: %.2f\nCategoria: %s".format(imc, categoria)
            } else {
//                SHORT dura 2seg
//                LONG dura 4seg
//                o context devemos passar o this, pois é na activity que vamos exibir
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
