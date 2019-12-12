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

class Problema01 {

  public static void backup( String arquivoOriginal, String arquivoBackup ) {
  }

  public static MeuContainerEscolhido lerAlunosDoArquivoXml( String filename ) throws Exception {
  }

  public static float calcularMediaGeral( MeuContainerEscolhido alunos ) {
  }

  public static float calcularNotaMinima( MeuContainerEscolhido alunos ) {
  }

  public static float calcularNotaMaxima( MeuContainerEscolhido alunos ) {
  }

  public static int calcularQuantidadeDeAlunos( MeuContainerEscolhido alunos ) {
  }

  public static void atualizarResumo( String filename, float mediaGeral, float notaMinima, float notaMaxima, int quantidadeDeAlunos ) throws Exception {
  }

  public static void imprimirTabelaDeAlunos( MeuContainerEscolhido alunos ) {
  }

  public static void main( String[] args ) {
    try {
      String filename = "alunos.xml";
      backup( filename, filename + ".bak" );
      MeuContainerEscolhido alunos = lerAlunosDoArquivoXml( filename );
      float mediaGeral = calcularMediaGeral( alunos );
      float notaMaxima = calcularNotaMaxima( alunos );
      float notaMinima = calcularNotaMinima( alunos );
      int quantidadeDeAlunos = calcularQuantidadeDeAlunos( alunos );
      atualizarResumo( filename, mediaGeral, notaMinima, notaMaxima, quantidadeDeAlunos );
      imprimirTabelaDeAlunos( alunos );
    } catch( Exception e ) {
      e.printStackTrace();
      System.out.println( e );
    }
  }
}

// vim: shiftwidth=2 tabstop=2 

