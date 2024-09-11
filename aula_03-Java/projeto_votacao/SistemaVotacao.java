import java.util.ArrayList;
import java.util.List;

public class SistemaVotacao {

//    aqui criamos os arrays que vão armazenar os objetos candidatos e partidos
    private List<Candidato> candidatos;
    private List<Partido> partidos;

    public SistemaVotacao() {
        this.candidatos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

//    adiciona um candidado ao array
    public void adicionarCandidato(Candidato candidato) {
        this.candidatos.add(candidato);
    }

//    adiciona o partido ao array
    public void adicionarPartido(Partido partido) {
        this.partidos.add(partido);
    }

//    faz um for no array de partidos procurando o nome passado, se encontrar retorna o partido se não retorna nulo
    public Partido buscarPartidoPorNome(String nome) {
        for (Partido partido : partidos) {
            if (partido.getNome().equalsIgnoreCase(nome)) {
                return partido;
            }
        }
        return null;
    }

//    faz um for no array de candidadtos procurando o candidato pelo número, se encontrar registra o voto
    public void votar(int numeroCandidato) {
        for (Candidato candidato : candidatos) {
            if (candidato.getNumero() == numeroCandidato) {
                candidato.adicionarVoto();
                System.out.println("Voto registrado para " + candidato.getNome() + " do partido " + candidato.getPartido().getNome());

            }
        }
        System.out.println("Candidato não encontrado.");
    }

//    esse método vai exibir os resultados da votação se houver candidatos registrados
    public void exibirResultados() {
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato registrado.");

        }

//        coloca o ponteiro na primeira posição do array para então fazer as comparações para achar qual candidato venceu a eleição
        Candidato candidatoVencedor = candidatos.get(0);
        Partido partidoVencedor = partidos.get(0);

//        faz um for no array candidatos procurando qual candidato recebeu mais votos
        for (Candidato candidato : candidatos) {
            if (candidato.getVotos() > candidatoVencedor.getVotos()) {
                candidatoVencedor = candidato;
            }
        }

//        faz um for no array candidatos procurando qual candidato recebeu mais votos
        for (Partido partido : partidos) {
            if (partido.getVotos() > partidoVencedor.getVotos()) {
                partidoVencedor = partido;
            }
        }

//        printa os resultados
        System.out.println("Candidato vencedor: " + candidatoVencedor.getNome() + " do " + candidatoVencedor.getPartido().getNome() + " com " + candidatoVencedor.getVotos() + " votos.");
        System.out.println("Partido vencedor: " + partidoVencedor.getNome() + " com " + partidoVencedor.getVotos() + " votos.");
    }
}
