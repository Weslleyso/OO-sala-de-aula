import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();
        List<Aula> aulas = new ArrayList<>();
        RelatorioAula relatorio = new RelatorioAula();

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Incluir Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Excluir Aluno");
            System.out.println("4. Incluir Aula");
            System.out.println("5. Atualizar Aula");
            System.out.println("6. Excluir Aula");
            System.out.println("7. Marcar Presença");
            System.out.println("8. Imprimir Relatório");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do aluno: ");
                    String nomeAluno = scanner.next();
                    Aluno novoAluno = new Aluno(alunos.size() + 1, nomeAluno);
                    alunos.add(novoAluno);
                    System.out.println("Aluno cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome do aluno a ser atualizado: ");
                    String nomeAlunoAtualizar = scanner.next();
                    boolean alunoAtualizado = false;
                    for (Aluno aluno : alunos) {
                        if (aluno.getNome().equalsIgnoreCase(nomeAlunoAtualizar)) {
                            System.out.print("Digite o novo nome do aluno: ");
                            aluno.setNome(scanner.next());
                            System.out.println("Aluno atualizado com sucesso!");
                            alunoAtualizado = true;
                            break;
                        }
                    }
                    if (!alunoAtualizado) {
                        System.out.println("Aluno não encontrado!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do aluno a ser excluído: ");
                    String nomeAlunoExcluir = scanner.next();
                    Aluno alunoExcluir = null;
                    for (Aluno aluno : alunos) {
                        if (aluno.getNome().equalsIgnoreCase(nomeAlunoExcluir)) {
                            alunoExcluir = aluno;
                            break;
                        }
                    }
                    if (alunoExcluir != null) {
                        alunos.remove(alunoExcluir);
                        System.out.println("Aluno excluído com sucesso!");
                    } else {
                        System.out.println("Aluno não encontrado!");
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome da aula: ");
                    String nomeAula = scanner.next();
                    Aula novaAula = new Aula(aulas.size() + 1, nomeAula);
                    aulas.add(novaAula);
                    System.out.println("Aula cadastrada com sucesso!");
                    break;

                case 5:
                    System.out.print("Digite o ID da aula a ser atualizada: ");
                    int idAula = scanner.nextInt();
                    for (Aula aula : aulas) {
                        if (aula.getId() == idAula) {
                            System.out.print("Digite o novo nome da aula: ");
                            aula.setNome(scanner.next());
                            System.out.println("Aula atualizada com sucesso!");
                            break;
                        }
                    }
                    break;

                case 6:
                    System.out.print("Digite o ID da aula a ser excluída: ");
                    int idAulaExcluir = scanner.nextInt();
                    Aula aulaExcluir = null;
                    for (Aula aula : aulas) {
                        if (aula.getId() == idAulaExcluir) {
                            aulaExcluir = aula;
                            break;
                        }
                    }
                    if (aulaExcluir != null) {
                        aulas.remove(aulaExcluir);
                        System.out.println("Aula excluída com sucesso!");
                    } else {
                        System.out.println("Aula não encontrada!");
                    }
                    break;

                case 7:
                    System.out.println("Escolha a aula para marcar a presença:");
                    for (int i = 0; i < aulas.size(); i++) {
                        System.out.println(i + 1 + ". " + aulas.get(i).getNome());
                    }
                    int escolhaAula = scanner.nextInt();
                    if (escolhaAula >= 1 && escolhaAula <= aulas.size()) {
                        Aula aulaSelecionada = aulas.get(escolhaAula - 1);
                        System.out.println("Escolha o aluno para marcar a presença:");
                        for (int i = 0; i < alunos.size(); i++) {
                            System.out.println(i + 1 + ". " + alunos.get(i).getNome());
                        }
                        int escolhaAluno = scanner.nextInt();
                        if (escolhaAluno >= 1 && escolhaAluno <= alunos.size()) {
                            Aluno alunoSelecionado = alunos.get(escolhaAluno - 1);
                            aulaSelecionada.marcarPresenca(alunoSelecionado);
                            System.out.println("Presença marcada com sucesso!");
                        } else {
                            System.out.println("Aluno inválido!");
                        }
                    } else {
                        System.out.println("Aula inválida!");
                    }
                    break;

                case 8:
                    System.out.println("Escolha a aula para gerar o relatório:");
                    for (int i = 0; i < aulas.size(); i++) {
                        System.out.println(i + 1 + ". " + aulas.get(i).getNome());
                    }
                    int escolhaAulaRelatorio = scanner.nextInt();
                    if (escolhaAulaRelatorio >= 1 && escolhaAulaRelatorio <= aulas.size()) {
                        Aula aulaSelecionada = aulas.get(escolhaAulaRelatorio - 1);
                        relatorio.gerarRelatorio(aulaSelecionada);
                    } else {
                        System.out.println("Aula inválida!");
                    }
                    break;

                case 9:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 9);

        scanner.close();
    }
}
