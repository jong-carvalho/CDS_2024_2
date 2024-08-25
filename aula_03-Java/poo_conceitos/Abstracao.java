public class Abstracao {
    public static void main(String[] args) {
        Abstracao_Animal animal = new Cachorro();
        animal.som(); // Saída: O cachorro faz: Au Au
        animal.dormir(); // Saída: O animal está dormindo
    }
}
