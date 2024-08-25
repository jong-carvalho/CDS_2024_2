public class Encapsulamento_Carro {
    // Atributos privados
    private String marca;
    private String modelo;
    private int ano;

    // Métodos públicos para acessar os atributos
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void exibirDetalhes() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano);
    }
}
