// import java.nio.file.*;
// import java.io.File;
// import java.util.*;
// import java.lang.*;
// import javax.xml.parsers.DocumentBuilderFactory;
// import javax.xml.parsers.DocumentBuilder;
// import org.w3c.dom.Document;
// import org.w3c.dom.NodeList;
// import org.w3c.dom.Node;
// import org.w3c.dom.Element;
// import javax.xml.transform.Transformer;
// import javax.xml.transform.TransformerFactory;
// import javax.xml.transform.dom.DOMSource;
// import javax.xml.transform.stream.StreamResult;

import logica.Calculadora;
import logica.Impressora;
import logica.LeitorGravador;

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
      backup( filename, filename + ".bak" );
      MeuContainerEscolhido alunos = leitorGravador.lerAlunosDoArquivoXml( filename );
      float mediaGeral = calculadora.calcularMediaGeral( alunos );
      float notaMaxima = calculadora.calcularNotaMaxima( alunos );
      float notaMinima = calculadora.calcularNotaMinima( alunos );
      int quantidadeDeAlunos = calculadora.calcularQuantidadeDeAlunos( alunos );
      leitorGravador.atualizarResumo( filename, mediaGeral, notaMinima, notaMaxima, quantidadeDeAlunos );
      impressora.imprimirTabelaDeAlunos( alunos );
    } catch( Exception e ) {
      e.printStackTrace();
      System.out.println( e );
    }
  }
}

// vim: shiftwidth=2 tabstop=2 

