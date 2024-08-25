abstract class Abstracao_Animal {
    abstract void som();

    void dormir() {
        System.out.println("O animal está dormindo");
    }
}

class Cachorro extends Abstracao_Animal {
    @Override
    void som() {
        System.out.println("O cachorro faz: Au Au");
    }
}
