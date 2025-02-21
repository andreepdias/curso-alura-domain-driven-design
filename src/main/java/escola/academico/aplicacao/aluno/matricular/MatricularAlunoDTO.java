package escola.academico.aplicacao.aluno.matricular;

import escola.academico.dominio.aluno.Aluno;
import escola.shared.dominio.CPF;
import escola.academico.dominio.aluno.Email;

public class MatricularAlunoDTO {

    private String nomeAluno;
    private String cpfAluno;
    private String emailAluno;

    public MatricularAlunoDTO(String nomeAluno, String cpfAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.emailAluno = emailAluno;
    }

    public Aluno criarAluno() {
        return new Aluno(new CPF(cpfAluno), nomeAluno, new Email(emailAluno));
    }
}
