package com.example.acessandoapi

//data class é uma classe que contém os getters, setters e construtores embutidos
data class CepResponse(
    val cep: String,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    val localidade: String,
    val uf: String,
    val ibge: String
)
