package src.logica;

import src.estrutura.Aluno;

import java.text.DecimalFormat;
import java.util.List;

public class Impressora {
    //Attributes
    private Calculadora calculadora;

    //Constructor
    public Impressora () {
        calculadora = new Calculadora();
    }

    public void imprimirTabelaDeAlunos( List<Aluno> alunos ) {
        String tabela = "";
        tabela = tabela.concat("ID    Nome           Média\n");
        tabela = tabela.concat("--------------------------\n");
        for (Aluno aluno : alunos) {
            tabela = tabela.concat(aluno.getId());
            for (int i = aluno.getId().length(); i <= 6; i++) {
                tabela = tabela.concat(" "); //O nome começa depois da sexta posição, então será adicionado a quantidade espaços necessários para isso, independente do tamanho do ID
            }
            tabela = tabela.concat(aluno.getNome());
            for (int i = aluno.getNome().length(); i <= 14; i++) {
                tabela = tabela.concat(" "); //A média começa na posição 20, independente do tamanho do nome
            }
            tabela = tabela.concat(String.valueOf(aluno.getMedia())); //Só se pode concatenar String com String, como a média é um float a conversão é necessária
            tabela = tabela.concat("\n");
        }
        tabela = tabela.concat("--------------------------\n");
        tabela = tabela.concat("Média geral           ");
        DecimalFormat format = new DecimalFormat("###.#"); //Até três digitos, formata a nota com uma única casa decimal
        String mediaGeral = format.format(calculadora.calcularMediaGeral(alunos));
        tabela = tabela.concat(mediaGeral + "\n");

        System.out.println(tabela);
    }

}
