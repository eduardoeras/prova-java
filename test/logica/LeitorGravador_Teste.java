package test.logica;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.estrutura.Aluno;
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
            for(Aluno aluno : leitorGravador.lerAlunosDoArquivoXml("alunos.xml")) {
                System.out.println("-----------");
                System.out.println("ID = " + aluno.getId());
                System.out.println("NOME = " + aluno.getNome());
                System.out.println("MEDIA = " + aluno.getMedia());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
