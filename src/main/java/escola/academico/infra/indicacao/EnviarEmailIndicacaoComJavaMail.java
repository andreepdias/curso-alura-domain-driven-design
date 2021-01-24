package escola.academico.infra.indicacao;

import escola.academico.aplicacao.indicacao.EnviarEmailIndicacao;
import escola.academico.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

    @Override
    public void enviarParaAluno(Aluno indicado) {
        // lógica de envio de email
    }
}
