package escola.academico.dominio.aluno;

import escola.shared.dominio.CPF;

public class FabricaDeAluno {

    private Aluno aluno;

    public FabricaDeAluno comNomeCPFEMail(String nome, String cpf, String email){
        this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public FabricaDeAluno comTelefone(String ddd, String numero){
        this.aluno.adicionarTelefone(ddd, numero);
        return this;
    }

    public Aluno criar(){
        return this.aluno;
    }
}
