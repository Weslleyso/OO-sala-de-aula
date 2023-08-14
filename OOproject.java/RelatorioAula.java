import java.util.*;

public class RelatorioAula {
    public void gerarRelatorio(Aula aula) {
        System.out.println("Relatório de Presença para a Aula: " + aula.getNome());
        Map<Aluno, Boolean> presenca = aula.getPresenca();
        for (Map.Entry<Aluno, Boolean> entry : presenca.entrySet()) {
            Aluno aluno = entry.getKey();
            boolean presente = entry.getValue();
            System.out.println("Aluno: " + aluno.getNome() + ", Presença: " + (presente ? "Presente" : "Ausente"));
        }
    }
}
