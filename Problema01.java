import src.estrutura.Aluno;
import src.logica.Calculadora;
import src.logica.Impressora;
import src.logica.LeitorGravador;

import java.util.List;

class Problema01 {

  /*Todas as funções inicialmente colocadas aqui foram realocadas para classes e pacotes
    mais descritivos e mais organizados. As chamadas são feitas por objetos na classe main().
   */

  public static void main( String[] args ) {
    Calculadora calculadora = new Calculadora();
    LeitorGravador leitorGravador = new LeitorGravador();
    Impressora impressora = new Impressora();
    try {
      String filename = "alunos.xml";
      leitorGravador.backup(filename, filename + ".bak" );
      List<Aluno> alunos = leitorGravador.lerAlunosDoArquivoXml( filename );
      float mediaGeral = calculadora.calcularMediaGeral( alunos );
      float notaMaxima = calculadora.calcularNotaMaxima( alunos );
      float notaMinima = calculadora.calcularNotaMinima( alunos );
      int quantidadeDeAlunos = calculadora.calcularQuantidadeDeAlunos( alunos );
      //leitorGravador.atualizarResumo( filename, mediaGeral, notaMinima, notaMaxima, quantidadeDeAlunos );
      impressora.imprimirTabelaDeAlunos( alunos );
    } catch( Exception e ) {
      e.printStackTrace();
      System.out.println( e );
    }
  }
}

// vim: shiftwidth=2 tabstop=2
// vim? Quem usa vim?

