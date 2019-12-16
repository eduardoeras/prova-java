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
        System.out.println("Média Geral: " + calculadora.calcularMediaGeral(leitorGravador.lerAlunosDoArquivoXml("alunos.xml")));
    }

    @Test
    public void testeCalcularNotaMinima () {
        System.out.println("Nota Mínima: " + calculadora.calcularNotaMinima(leitorGravador.lerAlunosDoArquivoXml("alunos.xml")));
    }

    @Test
    public void testeCalcularNotaMaxima () {
        System.out.println("Nota Máxima: " + calculadora.calcularNotaMaxima(leitorGravador.lerAlunosDoArquivoXml("alunos.xml")));
    }

    @Test
    public void testeCalcularQuantidadeDeAlunos () {
        System.out.println("Quantidade de Alunos: " + calculadora.calcularQuantidadeDeAlunos(leitorGravador.lerAlunosDoArquivoXml("alunos.xml")));
    }
}
