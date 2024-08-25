public class Candidato implements Votavel {
    private String nome;
    private Partido partido;
    private int numero;
    private int votos;

    public Candidato(String nome, Partido partido, int numero) {
        this.nome = nome;
        this.partido = partido;
        this.numero = numero;
        this.votos = 0;
    }

    @Override
    public void adicionarVoto() {
        this.votos++;
        this.partido.adicionarVoto();
    }

    @Override
    public int getVotos() {
        return this.votos;
    }

    public String getNome() {
        return nome;
    }

    public Partido getPartido() {
        return partido;
    }

    public int getNumero() {
        return numero;
    }
}
