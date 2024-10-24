package com.example.acessandoapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//aqui criamos o client do Retrofit
object RetrofitClient {
    private const val BASE_URL = "https://viacep.com.br/"

//    vai instanciar a nossa interface ViaCep
//    o by lazy é um modificador que iremos executar o código entre as chaves apenas uma vez
    val instance: ViaCepApi by lazy {
//        aqui criamos o objeto retrofit utilizando  a BASE_URL
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
//            nessa linha vamos converter a resposta obtida do viacep em json
            .addConverterFactory(GsonConverterFactory.create())
            .build()

//    aqui de fato criamos o retrofit utilizando a interface viacep
        retrofit.create(ViaCepApi::class.java)
    }
}
