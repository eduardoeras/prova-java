package src.logica;

import src.estrutura.Aluno;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LeitorGravador extends DefaultHandler { //Para usar o parser SAX, a classe precisa extender o DefaultHandler

    //Attributes
    private List<Aluno> alunos; //Foi escolhido o tipo lista por manter a ordem dos elementos e ser de fácil iteração em um laço

    //Constructor
    public LeitorGravador () {
        alunos = new ArrayList<>();
    }

    // Public Methods //
    public List<Aluno> lerAlunosDoArquivoXml(String filename) {
        parser(filename);
        return alunos;
    }

    public void backup( String arquivoOriginal, String arquivoBackup ) {
        salvar(arquivoBackup + ".xml", ler(arquivoOriginal));
    }

    public void atualizarResumo( String filename, float mediaGeral, float notaMinima, float notaMaxima, int quantidadeDeAlunos ) throws Exception {
        String conteudo = ler(filename);
        String atualizado = "";

        atualizado = atualizado.concat( //Recorta do arquivo original, do começo até a posição da "média geral"
                conteudo.substring(0, conteudo.lastIndexOf("</media_geral>") - 3)
        );
        DecimalFormat format = new DecimalFormat("###.#");
        atualizado = atualizado.concat(String.valueOf(format.format(mediaGeral)));

        atualizado = atualizado.concat( //Recorta do arquivo original, da posição da "média geral" até "nota máxima
                conteudo.substring(conteudo.lastIndexOf("</media_geral>"), conteudo.lastIndexOf("</nota_maxima>") - 3)
        );
        atualizado = atualizado.concat(String.valueOf(notaMaxima));

        atualizado = atualizado.concat( //Recorta do arquivo original, da posição de "nota máxima" até "nota mínima"
                conteudo.substring(conteudo.lastIndexOf("</nota_maxima>"), conteudo.lastIndexOf("</nota_minima>") - 3)
        );
        atualizado = atualizado.concat(String.valueOf(notaMinima));

        atualizado = atualizado.concat( //Recorta do arquivo original, da posição de "nota mínima" até "quantidade de alunos"
                conteudo.substring(conteudo.lastIndexOf("</nota_minima>"), conteudo.lastIndexOf("</quantidade_alunos>") - 1)
        );
        atualizado = atualizado.concat(String.valueOf(quantidadeDeAlunos));

        atualizado = atualizado.concat( //Recorta do arquivo original, da posição de "quantidade de alunos" até o final
                conteudo.substring(conteudo.lastIndexOf("</quantidade_alunos>"))
        );

        salvar(filename, atualizado);
    }

    //SAX Methods //
    public void startElement (String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("aluno")) {
            Aluno aluno = new Aluno(); //Esse hardcode para popular os atributos do aluno é horrível, mas para um programa dessa escala e pelo tempo disponível dá pra passar
            aluno.setId(attributes.getValue(0));
            aluno.setNome(attributes.getValue(1));
            aluno.setMedia(Float.parseFloat(attributes.getValue(2)));
            alunos.add(aluno);
        }
    }

    // Private Methods //

    //Parser SAX
    private void parser (String filename) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance(); //Inicialização do parser SAX
            SAXParser parser = factory.newSAXParser();
            parser.parse(filename, this);
        } catch (ParserConfigurationException e) {
            System.out.println("Erro ao configurar o parser XML");
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Erro ao parserar o arquivo XML, o arquivo é um XML válido?");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado!");
            e.printStackTrace();
        }
    }

    //Lê o conteúdo do arquivo original
    private String ler (String arquivoOriginal) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(arquivoOriginal)); //Lê o arquivo original como texto plano por meio de um buffer
            try {
                StringBuilder buider = new StringBuilder();
                String line = buffer.readLine();

                while (line != null) {
                    buider.append(line);
                    buider.append(System.lineSeparator());
                    line = buffer.readLine();
                }
                return buider.toString();
            } finally {
                buffer.close();
            }
        } catch (IOException e) {
            System.out.println("O arquivo original não foi encontrado!");
            e.printStackTrace();
        }
        return "";
    }

    //Salva um novo arquivo à partir de uma String
    private void salvar(String nomeDoArquivo, String conteudo) {
        try {
            PrintWriter printWriter = new PrintWriter(nomeDoArquivo);
            printWriter.print(conteudo);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
