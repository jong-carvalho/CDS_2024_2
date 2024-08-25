import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaVotacao sistema = new SistemaVotacao();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Criar Partido");
            System.out.println("2. Criar Candidato");
            System.out.println("3. Votar");
            System.out.println("4. Exibir Resultados");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do partido: ");
                    String nomePartido = scanner.nextLine();
                    Partido partido = new Partido(nomePartido);
                    sistema.adicionarPartido(partido);
                    System.out.println("Partido " + nomePartido + " criado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o nome do candidato: ");
                    String nomeCandidato = scanner.nextLine();
                    System.out.print("Digite o nome do partido do candidato: ");
                    String nomePartidoCandidato = scanner.nextLine();
                    System.out.print("Digite o número do candidato: ");
                    int numeroCandidato = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    Partido partidoDoCandidato = sistema.buscarPartidoPorNome(nomePartidoCandidato);

                    if (partidoDoCandidato != null) {
                        Candidato candidato = new Candidato(nomeCandidato, partidoDoCandidato, numeroCandidato);
                        sistema.adicionarCandidato(candidato);
                        System.out.println("Candidato " + nomeCandidato + " do partido " + nomePartidoCandidato + " com número " + numeroCandidato + " criado com sucesso!");
                    } else {
                        System.out.println("Partido não encontrado. Crie o partido primeiro.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o número do candidato para votar: ");
                    int numeroVotoCandidato = scanner.nextInt();
                    sistema.votar(numeroVotoCandidato);
                    break;
                case 4:
                    sistema.exibirResultados();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
