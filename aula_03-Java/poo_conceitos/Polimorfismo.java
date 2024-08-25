public class Polimorfismo {

    public static void main(String[] args) {
        Polimorfismo_Veiculo veiculo1 = new Polimorfismo_Carro();
        Polimorfismo_Veiculo veiculo2 = new Polimorfismo_Bicicleta();

        veiculo1.mover(); // Saída: O carro está em movimento
        veiculo2.mover(); // Saída: A bicicleta está em movimento
    }
}
