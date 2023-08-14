
package siga;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno{
    
    private String nome;
    private String cpf;
    private ArrayList<Aula> aulas = new ArrayList<>();
    
    public Aluno(String nome, String cpf){
        
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String n){
        this.nome = n;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public void setCpf(String c){
        this.cpf = c;
    }
    
    public ArrayList<Aula> getAulas(){
        return aulas;
    }
    
    public void setAulas(ArrayList<Aula> aulas){
        this.aulas = aulas;
    }
    public void incluirAula(Aula aula){
        aulas.add(aula);
    }
    public String listarAulas(){
        String strAulas = "";
        for(int x = 0;x < this.aulas.size(); x++ ){
            strAulas += this.aulas.get(x).getMateria() + " ";
        }
        return strAulas;
    }
    public void detalhes(){
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Aulas: " + listarAulas());
    }
    
    public static void criarAluno(ArrayList<Aula> aulas, ArrayList<Aluno> alunos){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("ADICIONE AS INFORMAÇÕES DO ALUNO: ");
        System.out.println("Nome: ");
        String nome = teclado.nextLine();
        System.out.println("CPF: ");
        String cpf = teclado.nextLine();
        
        alunos.add(new Aluno(nome, cpf));
        
        System.out.println("AULAS A SEREM ADICIONADAS: ");

        Aula.listaAulas(aulas);
        
        int contador = 1;
        int index = 0;
        while(contador < aulas.size() || index == 99){
            System.out.println("Digite 99 para sair");
            System.out.println("Aula a ser adicionada(n° do índice): ");
            String strIndex = teclado.nextLine();

            index = Integer.parseInt(strIndex);
            
            aulas.get(index).incluirAluno(alunos.get(alunos.size() - 1));
            alunos.get(alunos.size() -1).incluirAula(aulas.get(index));
            
            System.out.println("AULA ADICIONADA!");
            contador++;
            
        }
        System.out.println("ALUNO CADASTRADO!");
        
    }
    public static void listaAlunos(ArrayList<Aluno> alunos){
        System.out.println("Lista de alunos: ");
        for(int x = 0; x < alunos.size(); x++){
            System.out.print(x + " - ");
            alunos.get(x).detalhes();
        }
    }
    public static void atualizarAluno(ArrayList<Aluno> alunos){
        Scanner teclado = new Scanner(System.in);
        
        
        if(alunos.size() > 0){
            Aluno.listaAlunos(alunos);
        
            System.out.println("Qual aluno deve ser atualizado (n° do índice)");
            String indice = teclado.nextLine();
            
            System.out.println("Atualize as informações: ");
            System.out.println("Nome: ");
            String nome = teclado.nextLine();
            System.out.println("CPF: ");
            String cpf = teclado.nextLine();
            
            int ind = Integer.parseInt(indice);
            
            alunos.get(ind).setNome(nome);
            alunos.get(ind).setCpf(cpf);
        }
        else{
            System.out.println("Não há nenhum aluno cadastrado!");
        }
        
    }
    
    public static void excluirAluno(ArrayList<Aluno> alunos){
        Scanner teclado = new Scanner(System.in);
        
        if(alunos.size() > 0){
            
            Aluno.listaAlunos(alunos);
            System.out.println("Escolha o aluno a ser excluído(n° do índice): ");
            String indice = teclado.nextLine();
            
            int ind = Integer.parseInt(indice);
            
            alunos.remove(ind);
            System.out.println("Aluno excluído!");
        }
        else{
            System.out.println("Não há nenhum aluno cadastrado!");
        }
    }
    
    
}
