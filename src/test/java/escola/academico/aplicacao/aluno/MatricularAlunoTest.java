package escola.academico.aplicacao.aluno;

import escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import escola.academico.aplicacao.aluno.matricular.MatricularAlunoDTO;
import escola.academico.dominio.aluno.Aluno;
import escola.shared.dominio.CPF;
import escola.academico.dominio.aluno.RepositorioDeAlunos;
import escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatricularAlunoTest {

    @Test
    @DisplayName("Deveria persistir aluno.")
    void persistirAluno(){
        RepositorioDeAlunos repositorio = new RepositorioDeAlunosEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio, null);

        MatricularAlunoDTO dto = new MatricularAlunoDTO("André", "123.456.789-00", "andre.dias@msn.com");
        useCase.matricular(dto);

        Aluno encontrado = repositorio.buscarPorCPF(new CPF("123.456.789-00"));

        assertEquals("André", encontrado.getNome());
        assertEquals("123.456.789-00", encontrado.getCpf());
        assertEquals("andre.dias@msn.com", encontrado.getEmail());
    }
}
