package com.ultimaschool.java.clientes;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class ClienteBuilderTest extends TestCase {

    private ClienteBuilder clienteBuilder;
    private ClienteBuilder clienteBuilder2;

    @Before
    public void setUp() throws Exception {
        clienteBuilder2 = new ClienteBuilder();
        clienteBuilder = new ClienteBuilder().comIdentificacao("Joana", "Maria",
                "Rocha","123.456.789-00",
                "10/01/1993", 'F');
    }

    @Test
    public void testGetCpf() {
        Assertions.assertNull(clienteBuilder2.getCpf());
        Assertions.assertEquals(clienteBuilder.getCpf(), "123.456.789-00");
    }

    @Test
    public void testSetCpf() {
        clienteBuilder.setCpf("000.000.000-00");
        Assertions.assertEquals(clienteBuilder.getCpf(), "000.000.000-00");
        clienteBuilder2.setCpf("111.111.111-11");
        Assertions.assertEquals(clienteBuilder2.getCpf(), "111.111.111-11");
    }

    @Test
    public void testGetNomeCompleto() {
        Assertions.assertNull(clienteBuilder2.getNomeCompleto());
        Assertions.assertEquals(clienteBuilder.getNomeCompleto(), "Joana Maria Rocha");
    }

    @Test
    public void testSetNomeCompleto() {
        clienteBuilder.setNomeCompleto("Aline Maria Rocha");
        Assertions.assertEquals(clienteBuilder.getNomeCompleto(), "Aline Maria Rocha");
        clienteBuilder2.setNomeCompleto("João Cardoso Miltoni");
        Assertions.assertEquals(clienteBuilder2.getNomeCompleto(), "João Cardoso Miltoni");
    }

    @Test
    public void testToStringIndentificacao() {
        Assertions.assertEquals(clienteBuilder.toStringIndentificacao(),
                "Os dados pessoais são: Sra. Joana Maria Rocha, com CPF 123.456.789-00, data de nascimento 10/01/1993 com idade de 31");
        clienteBuilder.setGenero('M');
        Assertions.assertEquals(clienteBuilder.toStringIndentificacao(),
                "Os dados pessoais são: Sr. Joana Maria Rocha, com CPF 123.456.789-00, data de nascimento 10/01/1993 com idade de 31");
        clienteBuilder.setGenero(' ');
        Assertions.assertEquals(clienteBuilder.toStringIndentificacao(),
                "Os dados pessoais são:  Joana Maria Rocha, com CPF 123.456.789-00, data de nascimento 10/01/1993 com idade de 31");
        clienteBuilder.setGenero('@');
        Assertions.assertEquals(clienteBuilder.toStringIndentificacao(),
                "Os dados pessoais são:  Joana Maria Rocha, com CPF 123.456.789-00, data de nascimento 10/01/1993 com idade de 31");
    }


    @After
    public void tearDown() throws Exception {
        clienteBuilder = null;
        clienteBuilder2 = null;
    }
}