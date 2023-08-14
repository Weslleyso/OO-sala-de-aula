import java.util.*;

public class Aula {
    private int id;
    private String nome;
    private List<Aluno> alunos;
    private Map<Aluno, Boolean> presenca;

    public Aula(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.alunos = new ArrayList<>();
        this.presenca = new HashMap<>();
    }

    public void marcarPresenca(Aluno aluno) {
        presenca.put(aluno, true);
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public Map<Aluno, Boolean> getPresenca() {
        return presenca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
