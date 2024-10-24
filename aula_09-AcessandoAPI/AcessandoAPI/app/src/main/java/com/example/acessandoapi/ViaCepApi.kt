package com.example.acessandoapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepApi {
//    a notação GET vai ir no endereço informado
    @GET("ws/{cep}/json/")
// a notação @Path vai substituir o cep pelo que a gente passou e então ele vai fazer uma chamada e devolver uma resposta com o cep
    fun buscarCep(@Path("cep") cep: String): Call<CepResponse>
}
