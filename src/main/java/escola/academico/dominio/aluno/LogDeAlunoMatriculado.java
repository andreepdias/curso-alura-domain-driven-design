package escola.academico.dominio.aluno;

import escola.shared.dominio.evento.Evento;
import escola.shared.dominio.evento.Ouvinte;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado
        extends Ouvinte {

    public void reageAo(Evento evento){
        String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println("Aluno com CPF " + ((AlunoMatriculado)evento).getCpfDoAluno() + " matriculado em " + momentoFormatado);
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
