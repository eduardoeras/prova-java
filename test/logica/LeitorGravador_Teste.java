package test.logica;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.logica.LeitorGravador;

public class LeitorGravador_Teste {

    private LeitorGravador leitorGravador;

    @Before
    public void init () {
        leitorGravador = new LeitorGravador();
    }

    @Test
    public void testeLerAlunosDoArquivoXml () {
        try {
            leitorGravador.lerAlunosDoArquivoXml("alunos.xml");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
