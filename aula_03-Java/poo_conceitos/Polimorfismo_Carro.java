class Polimorfismo_Veiculo {
    void mover() {
        System.out.println("O veículo está em movimento");
    }
}

class Polimorfismo_Carro extends Polimorfismo_Veiculo {
    @Override
    void mover() {
        System.out.println("O carro está em movimento");
    }
}

class Polimorfismo_Bicicleta extends Polimorfismo_Veiculo {
    @Override
    void mover() {
        System.out.println("A bicicleta está em movimento");
    }
}