package escola.academico.aplicacao.aluno.matricular;

import escola.shared.dominio.evento.PublicadorDeEventos;
import escola.academico.dominio.aluno.AlunoMatriculado;
import escola.academico.dominio.aluno.Aluno;
import escola.academico.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {

    private final RepositorioDeAlunos repositorio;
    private final PublicadorDeEventos publicador;

    public MatricularAluno(RepositorioDeAlunos repositorio, PublicadorDeEventos publicador) {
        this.repositorio = repositorio;
        this.publicador = publicador;
    }

    public void matricular(MatricularAlunoDTO dto){
        Aluno novo = dto.criarAluno();
        repositorio.matricular(novo);

        AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf()) ;
        publicador.publicar(evento);
    }
}
