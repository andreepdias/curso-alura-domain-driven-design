package escola.academico.dominio.aluno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailTest {

    @Test
    @DisplayName("Não deveria criar email com endereço inválido.")
    void emailComEnderecoInvalido(){
        assertThrows(IllegalArgumentException.class,
                () -> new Email(null));

        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));

        assertThrows(IllegalArgumentException.class,
                () -> new Email("andre"));
    }
    @Test
    @DisplayName("Deveria criar email com endereço válido.")
    void emailComEnderecoValido(){
        String endereco = "andre.dias@msn.com";
        Email email = new Email(endereco);
        assertEquals(endereco, email.getEndereco()  );
    }
}
