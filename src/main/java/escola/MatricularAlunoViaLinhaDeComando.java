package escola;

import escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import escola.academico.aplicacao.aluno.matricular.MatricularAlunoDTO;
import escola.gamificacao.aplicacao.GeraSeloAlunoNovato;
import escola.gamificacao.infra.selo.RepositorioDeSelosEmMemoria;
import escola.shared.dominio.evento.PublicadorDeEventos;
import escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoViaLinhaDeComando {

    public static void main(String[] args) {
        String nome = "André Dias";
        String cpf = "123.456.789-88";
        String email = "andre@dias.com";

        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());
        publicador.adicionar(new GeraSeloAlunoNovato(new RepositorioDeSelosEmMemoria()));

        MatricularAluno matricularAluno = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicador);
        matricularAluno.matricular(new MatricularAlunoDTO(nome, cpf, email));

    }
}
