package escola.academico.dominio.aluno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TelefoneTest {

    @Test
    @DisplayName("Não deveria crirar telefone com DDD inválido.")
    void telefoneDDDInvalido(){
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone(null, "123456789"));
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("", "123456789"));
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("1", "123456789"));
    }

    @Test
    @DisplayName("Não deveria crirar telefone com número inválido.")
    void telefoneNumeroInvalido(){
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("47", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("47", ""));
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("47", "123"));
    }

    @Test
    @DisplayName("Deveria criar telefone com DDD e número válidos.")
    void telefoneValido(){
        String ddd = "47";
        String numero = "123456789";
        Telefone telefone = new Telefone(ddd, numero);
        assertEquals(ddd, telefone.getDdd());
        assertEquals(numero, telefone.getNumero());
    }
}
