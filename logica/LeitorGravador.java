package logica;

import estrutura.Aluno;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List; //Foi escolhido o tipo lista por manter a ordem dos elementos e ser de fácil iteração em um laço

public class LeitorGravador extends DefaultHandler { //Para usar o parser SAX, a classe precisa extender o DefaultHandler



    //Methods
    public List<Aluno> lerAlunosDoArquivoXml(String filename) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(filename, this);
    }

    //SAX methods
    public void startDocument () {
        //Empty
    }

    public void endDocument () {
        //Empty
    }

    public void startElement (String uri, String localName, String qName, Attributes attributes) {
        //Empty
    }

    public void endElement (String uri, String localName, String tag) {
        //Empty
    }

    public void characters (char[] ch, int start, int length) {
        //Empty
    }

    public void backup( String arquivoOriginal, String arquivoBackup ) {
    }

    public static void atualizarResumo( String filename, float mediaGeral, float notaMinima, float notaMaxima, int quantidadeDeAlunos ) throws Exception {
    }
}
