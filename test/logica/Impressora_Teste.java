package test.logica;

import org.junit.Before;
import org.junit.Test;
import src.logica.Impressora;
import src.logica.LeitorGravador;

public class Impressora_Teste {

    private Impressora impressora;
    private LeitorGravador leitorGravador;

    @Before
    public void init () {
        leitorGravador = new LeitorGravador();
        impressora = new Impressora();
    }

    @Test
    public void testeImprimirTabelaDeAlunos () {
        impressora.imprimirTabelaDeAlunos(leitorGravador.lerAlunosDoArquivoXml("alunos.xml"));
    }
}
