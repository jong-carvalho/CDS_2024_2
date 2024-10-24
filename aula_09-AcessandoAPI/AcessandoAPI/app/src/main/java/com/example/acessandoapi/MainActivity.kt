package com.example.acessandoapi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var editTextCep: EditText
    private lateinit var buttonBuscar: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextCep = findViewById(R.id.editTextCep)
        buttonBuscar = findViewById(R.id.buttonBuscar)
        textViewResultado = findViewById(R.id.textViewResultado)

        buttonBuscar.setOnClickListener {
            val cep = editTextCep.text.toString()

            if (cep.isNotEmpty()) {
                buscarCep(cep)
            } else {
                Toast.makeText(this, "Por favor, digite um CEP", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun buscarCep(cep: String) {

//        armazena a chamada na variavel call
        val call = RetrofitClient.instance.buscarCep(cep)

//       e deixa que a resposta seja respondida assincronamente
        call.enqueue(object : Callback<CepResponse> {

//            se a chamada for respondida
//            aqui passamos
            override fun onResponse(call: Call<CepResponse>, response: Response<CepResponse>) {
//                se a api der uma resposta válida vamos exibir  os dados do endereço
                if (response.isSuccessful) {
                    val cepResponse = response.body()

//                    aqui fazemos uma garantia de que o cepresponse não é nulo utilizando o safecall e então
//                    o let faz a execução de atribuir o texto ao resultado e identa utilizando o trimIndent() e depois exibe na tela
                    cepResponse?.let {
                        val resultado = """
                            CEP: ${it.cep}
                            Logradouro: ${it.logradouro}
                            Bairro: ${it.bairro}
                            Localidade: ${it.localidade}
                            UF: ${it.uf}
                        """.trimIndent()
                        textViewResultado.text = resultado
                    }
                } else {
//                    o toast não aceita apenas o this pois estamos executando em uma função externa
                    Toast.makeText(this@MainActivity, "CEP não encontrado", Toast.LENGTH_SHORT).show()
                }
            }

//
            override fun onFailure(call: Call<CepResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Erro ao buscar o CEP", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
