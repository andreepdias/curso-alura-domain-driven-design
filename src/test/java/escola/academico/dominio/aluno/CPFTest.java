package escola.academico.dominio.aluno;

import escola.shared.dominio.CPF;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CPFTest {

    @Test
    @DisplayName("Não deveria criar cpf com números inválidos.")
    void cpfInvalido(){
        assertThrows(IllegalArgumentException.class,
                () -> new CPF(null));

        assertThrows(IllegalArgumentException.class,
                () -> new CPF(""));

        assertThrows(IllegalArgumentException.class,
                () -> new CPF("12345678900"));
    }

    @Test
    @DisplayName("Deveria criar cpf com números válidos.")
    void cpfValido(){
        String numero = "073.459.657-08";
        CPF cpf = new CPF(numero);
        assertEquals(numero, cpf.getNumero());
    }

}
