package escola.gamificacao.infra.selo;

import escola.gamificacao.dominio.selo.RepositorioDeSelos;
import escola.gamificacao.dominio.selo.Selo;
import escola.shared.dominio.CPF;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {

    private List<Selo> selos = new ArrayList<>();

    @Override
    public void adicionar(Selo selo) {
        this.selos.add(selo);
    }

    @Override
    public List<Selo> selosDoAlunoDeCPF(CPF cpf) {
        return this.selos.stream()
                    .filter(s -> s.getCpfDoAluno().getNumero().equals(cpf.getNumero()))
                    .collect(Collectors.toList());
    }
}
