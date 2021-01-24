package escola.academico.infra.aluno;

import escola.academico.dominio.aluno.Aluno;
import escola.shared.dominio.CPF;
import escola.academico.dominio.aluno.RepositorioDeAlunos;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {

    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        return this.matriculados.stream()
                .filter(x -> x.getCpf().equals(cpf.getNumero()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Aluno com CPF " + cpf.getNumero() + " não foi encontrado."));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return this.matriculados;
    }
}
