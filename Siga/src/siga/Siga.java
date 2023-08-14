package siga;

import java.util.ArrayList;
import java.util.Scanner;

public class Siga {
    private static ArrayList<Aula> aulas = new ArrayList<>();
    private static ArrayList<Aluno> alunos = new ArrayList<>();
    
    public static void main(String[] args) {
        menu();
    }
    
    public static void menu(){
        Scanner teclado = new Scanner(System.in);
        int op = -1;
        while (op != 0) {
            System.out.println("ESCOLHA UMA OPÇÃO!");
            System.out.println("1 - Menu Alunos");
            System.out.println("2 - Menu Aulas");
            System.out.println("3 - Menu Frequência");
            System.out.println("4 - Mostrar Frequência");
            System.out.println("0 - Encerrar");
            op = teclado.nextInt();
            switch(op) {
                case 1:
                    menuAluno();
                    break;
                case 2:
                    menuAula();
                    break;
                case 3:
                    Frequencia.menuFrequencia(aulas, alunos);
                    break;
                
                case 4:
                    Frequencia.mostrarFrequencia(aulas);
                    break;
                
                case 0:
                    System.out.println("PROGRAMA ENCERRADO!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
    
    public static void menuAluno(){
        Scanner teclado = new Scanner(System.in);
        int op = -1;
        while (op != 5) {
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Atualizar aluno");
            System.out.println("3 - Remover aluno");
            System.out.println("4 - Listar alunos");
            System.out.println("5 - Retornar ao menu principal");
            op = teclado.nextInt();
            switch(op){
                case 1:
                    Aluno.criarAluno(aulas, alunos);
                    break;
                case 2:
                    Aluno.atualizarAluno(alunos);
                    break;
                case 3:
                    Aluno.excluirAluno(alunos);
                    break;
                case 4:
                    Aluno.listaAlunos(alunos);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    public static void menuAula(){
        Scanner teclado = new Scanner(System.in);
        int op = -1;
        while (op != 5) {
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            System.out.println("1 - Criar aula");
            System.out.println("2 - Atualizar aula");
            System.out.println("3 - Remover aula");
            System.out.println("4 - Listar aulas");
            System.out.println("5 - Retornar ao menu principal");
            op = teclado.nextInt();
            switch(op){
                case 1:
                    Aula.criarAula(aulas);
                    break;
                case 2:
                    Aula.atualizarAula(aulas);
                    break;
                case 3:
                    Aula.excluirAula(aulas);
                    break;
                case 4:
                    Aula.listaAulas(aulas);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

// Resto do código das classes Aula e Aluno permanece igual.
