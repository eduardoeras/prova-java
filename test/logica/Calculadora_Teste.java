package test.logica;

import org.junit.Before;
import org.junit.Test;
import src.logica.Calculadora;
import src.logica.LeitorGravador;

public class Calculadora_Teste {

    private Calculadora calculadora;
    private LeitorGravador leitorGravador;

    @Before
    public void init () {
        calculadora = new Calculadora();
        leitorGravador = new LeitorGravador();
    }

    @Test
    public void testeCalcularMediaGeral () {
        System.out.println(calculadora.calcularMediaGeral(leitorGravador.lerAlunosDoArquivoXml("alunos.xml")));
    }
}
