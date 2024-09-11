package com.example.consoleantigos;

public class ConsolesAntigos {
    private String nome;
    private int anoLancamento;
    private String publisher;
    private String historia;

    // Construtor
    public ConsolesAntigos(String nome, int anoLancamento, String publisher, String historia) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.publisher = publisher;
        this.historia = historia;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getHistoria() {
        return historia;
    }

}
