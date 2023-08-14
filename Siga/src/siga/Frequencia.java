package siga;

import java.util.ArrayList;
import java.util.Scanner;

public class Frequencia {

    public static void menuFrequencia(ArrayList<Aula> aulas, ArrayList<Aluno> alunos) {
        Scanner teclado = new Scanner(System.in);
        int op = -1;
        while (op != 2) {
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            System.out.println("1 - Registrar presença de alunos em aula");
            System.out.println("2 - Retornar ao menu principal");
            op = teclado.nextInt();
            switch (op) {
                case 1:
                    registrarPresenca(aulas, alunos);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void registrarPresenca(ArrayList<Aula> aulas, ArrayList<Aluno> alunos) {
        Scanner teclado = new Scanner(System.in);
        if (aulas.size() > 0) {
            Aula.listaAulas(aulas);
            System.out.println("Escolha a aula para registrar a presença (n° do índice)");
            int indiceAula = teclado.nextInt();

            if (indiceAula >= 0 && indiceAula < aulas.size()) {
                Aula aulaSelecionada = aulas.get(indiceAula);
                Aluno.listaAlunos(alunos);
                System.out.println("Escolha o aluno para registrar a presença (n° do índice)");
                int indiceAluno = teclado.nextInt();

                if (indiceAluno >= 0 && indiceAluno < alunos.size()) {
                    Aluno alunoSelecionado = alunos.get(indiceAluno);
                    aulaSelecionada.incluirAluno(alunoSelecionado);
                    alunoSelecionado.incluirAula(aulaSelecionada);
                    System.out.println("Presença registrada!");
                } else {
                    System.out.println("Índice de aluno inválido!");
                }
            } else {
                System.out.println("Índice de aula inválido!");
            }
        } else {
            System.out.println("Não há nenhuma aula disponível!");
        }
    }
    public static void mostrarFrequencia(ArrayList<Aula> aulas) {
        Scanner teclado = new Scanner(System.in);
        if (aulas.size() > 0) {
            Aula.listaAulas(aulas);
            System.out.println("Escolha a aula para mostrar a frequência (n° do índice)");
            int indiceAula = teclado.nextInt();
    
            if (indiceAula >= 0 && indiceAula < aulas.size()) {
                Aula aulaSelecionada = aulas.get(indiceAula);
                ArrayList<Aluno> alunosPresentes = aulaSelecionada.getAlunos();
                
                System.out.println("Frequência da aula:");
                for (Aluno aluno : alunosPresentes) {
                    System.out.println("Aluno: " + aluno.getNome());
                }
            } else {
                System.out.println("Índice de aula inválido!");
            }
        } else {
            System.out.println("Não há nenhuma aula disponível!");
        }
    }
    
}
