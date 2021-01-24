package escola.academico.dominio.aluno;

import escola.shared.dominio.CPF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    void beforeEEach(){
        this.aluno = new Aluno(
                new CPF("123.456.123-00"),
                "André Pacheco",
                new Email("andre@dias.com")
        );
    }

    @Test
    @DisplayName("Deveria permitir adicionar um telefone.")
    void adicionarTelefone(){
        this.aluno.adicionarTelefone("47", "123456789");
        assertEquals(1, this.aluno.getTelefones().size());
    }

    @Test
    @DisplayName("Deveria permitir adicionar dois telefones.")
    void adicionarDoisTelefones(){
        this.aluno.adicionarTelefone("47", "123456789");
        this.aluno.adicionarTelefone("47", "123456780");
        assertEquals(2, this.aluno.getTelefones().size());
    }

    @Test
    @DisplayName("Não deveria permitir adicionar três telefones.")
    void naoAdicionarTelefones() {
        assertThrows(IllegalArgumentException.class,
            () -> {
                this.aluno.adicionarTelefone("47", "123456789");
                this.aluno.adicionarTelefone("47", "123456780");
                this.aluno.adicionarTelefone("47", "123456781");
            });
    }
}
