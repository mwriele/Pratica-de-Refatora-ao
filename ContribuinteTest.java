package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import source.Contribuinte;

public class ContribuinteTest {

    @Test
    public void testAposentadoriaMulherIdadeAbaixo() {
        Contribuinte mulher = new Contribuinte(60, 'F', 20, 0);
        assertFalse(mulher.podeAposentar(), "Mulher com idade abaixo do mínimo deveria estar inapta.");
    }

    @Test
    public void testAposentadoriaMulherContribuicaoAbaixo() {
        Contribuinte mulher = new Contribuinte(62, 'F', 10, 0);
        assertFalse(mulher.podeAposentar(), "Mulher com tempo de contribuição abaixo do mínimo deveria estar inapta.");
    }

    @Test
    public void testAposentadoriaMulherContribuicaoPrecaro() {
        Contribuinte mulher = new Contribuinte(62, 'F', 13, 2);
        assertTrue(mulher.podeAposentar(), "Mulher deveria estar apta com tempo adicional de condições precárias.");
    }

    @Test
    public void testAposentadoriaMulherApta() {
        Contribuinte mulher = new Contribuinte(62, 'F', 15, 0);
        assertTrue(mulher.podeAposentar(), "Mulher com idade e tempo de contribuição mínimos deveria estar apta.");
    }

    @Test
    public void testAposentadoriaHomemIdadeAbaixo() {
        Contribuinte homem = new Contribuinte(64, 'M', 25, 0);
        assertFalse(homem.podeAposentar(), "Homem com idade abaixo do mínimo deveria estar inapto.");
    }

    @Test
    public void testAposentadoriaHomemContribuicaoAbaixo() {
        Contribuinte homem = new Contribuinte(65, 'M', 19, 0);
        assertFalse(homem.podeAposentar(), "Homem com tempo de contribuição abaixo do mínimo deveria estar inapto.");
    }

    @Test
    public void testAposentadoriaHomemContribuicaoPrecaro() {
        Contribuinte homem = new Contribuinte(65, 'M', 18, 2);
        assertTrue(homem.podeAposentar(), "Homem deveria estar apto com tempo adicional de condições precárias.");
    }

    @Test
    public void testAposentadoriaHomemApto() {
        Contribuinte homem = new Contribuinte(65, 'M', 20, 0);
        assertTrue(homem.podeAposentar(), "Homem com idade e tempo de contribuição mínimos deveria estar apto.");
    }

    @Test
    public void testAposentadoriaSexoInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contribuinte(65, 'X', 20, 0).podeAposentar();
        });
        assertEquals("Sexo inválido: deve ser 'M' ou 'F'", exception.getMessage());
    }
}
