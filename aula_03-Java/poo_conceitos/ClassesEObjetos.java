

public class ClassesEObjetos {
    public static void main(String[] args) {
        // Criando um objeto da classe Carro
        ClassesEObjetos_Carro meuCarro = new ClassesEObjetos_Carro();
        meuCarro.marca = "Toyota";
        meuCarro.modelo = "Corolla";
        meuCarro.ano = 2021;

        // Usando o método do objeto
        meuCarro.exibirDetalhes();
    }
}
