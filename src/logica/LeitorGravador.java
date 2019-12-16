package src.logica;

import src.estrutura.Aluno;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; //Foi escolhido o tipo lista por manter a ordem dos elementos e ser de fácil iteração em um laço

public class LeitorGravador extends DefaultHandler { //Para usar o parser SAX, a classe precisa extender o DefaultHandler

    //Attributes
    private List<Aluno> alunos;

    //Constructor
    public LeitorGravador () {
        alunos = new ArrayList<>();
    }

    //Methods
    public List<Aluno> lerAlunosDoArquivoXml(String filename) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(filename, this);

        return alunos;
    }

    //SAX methods
    public void startDocument () {
        //Empty
    }

    public void endDocument () {
        //Empty
    }

    public void startElement (String uri, String localName, String qName, Attributes attributes) {
        System.out.println("qName : " + qName);
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
