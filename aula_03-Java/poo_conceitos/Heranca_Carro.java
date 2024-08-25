

class Veiculo {
    String tipo;
    void mover() {
        System.out.println("O veículo está em movimento");
    }
}

class Heranca_Carro extends Veiculo {
    int portas;

    void exibirDetalhes() {
        System.out.println("Tipo: " + tipo + ", Portas: " + portas);
    }
}