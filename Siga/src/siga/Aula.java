
package siga;

import java.util.ArrayList;
import java.util.Scanner;

public class Aula{

    String professor;
    int id;
    String materia;
    ArrayList<Aluno> alunos = new ArrayList<>();
    
    public Aula(int id, String materia, String professor){
        this.id = id;
        this.materia = materia;
        this.professor = professor;
    }

    
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getMateria(){
        return this.materia;
    }
    public void setMateria(String materia){
        this.materia = materia;
    }
    public String getProfessor(){
        return this.professor;
    }
    public void setProfessor(String professor){
        this.professor = professor;
    }
    
    public ArrayList<Aluno> getAlunos(){
        return alunos;
    }
    public void incluirAluno(Aluno aluno){
        alunos.add(aluno);
    }
    
    public static void alunosDaAula(ArrayList<Aula> aulas){
        Scanner teclado = new Scanner(System.in);
        if(aulas.size() > 0){
            listaAulas(aulas);
            System.out.println("Escolha a aula a ter os alunos listados(n° do índice)");
            String indice = teclado.nextLine();
            
            int ind  = Integer.parseInt(indice);
            
            ArrayList<Aluno> alunos = aulas.get(ind).getAlunos();
            
            for(int x = 0; x < alunos.size(); x++){
                alunos.get(x).detalhes();
            }
        }
        else{
            System.out.println("Não há nenhuma aula disponível!");
        }
    }
        
    public static void criarAula(ArrayList<Aula> aulas){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Cadastre as informações da aula: ");
        System.out.println("Matéria: ");
        String materia = teclado.nextLine();
        System.out.println("ID: ");
        String id = teclado.nextLine();
        System.out.println("Professor: ");
        String professor = teclado.nextLine();
        
        int iden = Integer.parseInt(id);
        aulas.add(new Aula(iden, materia, professor));
        
        System.out.println("Aula Cadastrada!");
        
    }
    
    public static void atualizarAula(ArrayList<Aula> aulas){
        Scanner teclado = new Scanner(System.in);
        if(aulas.size() > 0){
            listaAulas(aulas);
            System.out.println("Escolha a aula a ser atualizada (nº do índice)");
            String indice = teclado.nextLine();
            int ind = Integer.parseInt(indice);
            
            System.out.println("Atualize as informações: ");
            System.out.println("Matéria: ");
            String materia = teclado.nextLine();
            System.out.println("ID: ");
            String id = teclado.nextLine();
            String professor = teclado.nextLine();
            
            int iden = Integer.parseInt(id);
            aulas.get(ind).setId(iden);
            aulas.get(ind).setProfessor(professor);
            aulas.get(ind).setMateria(materia);
            
            System.out.println("Aula Atualizada!");
        }
        else{
            System.out.println("Não há nenhuma aula disponível!");
        }
    }
    
    public static void excluirAula(ArrayList<Aula> aulas){
        Scanner teclado = new Scanner(System.in);
        if(aulas.size() > 0){
            listaAulas(aulas);
            System.out.println("Escolha a aula a ser excluída (nº do índice)");
            String indice = teclado.nextLine();
            int ind = Integer.parseInt(indice);
            
            aulas.remove(ind);
            
            System.out.println("Aula excluída!");
        }
        else{
            System.out.println("Não há nenhuma aula disponível!");
        }
    }
        
    public static void listaAulas(ArrayList<Aula> aulas){
        System.out.println("AULAS DISPONÍVEIS: ");
        for(int x = 0; x < aulas.size(); x++){
            System.out.println(x + " - Matéria: " + aulas.get(x).getMateria()+ " - ID: " + aulas.get(x).getId() + " - Professor: " + aulas.get(x).getProfessor());
            System.out.println(" ----------------------------------------------- ");
        }
    }

    
}
