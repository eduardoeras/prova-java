package src.logica;

import src.estrutura.Aluno;

import java.util.List;

public class Calculadora {

    public float calcularMediaGeral( List<Aluno> alunos ) {
        float mediaGeral = 0;
        for (Aluno aluno : alunos) {
            mediaGeral = mediaGeral + aluno.getMedia(); //Media aritimética simples: soma todas as médias
        }
        if (alunos.size() != 0) { //Caso a lista de alunos esteja vazia, evita erro de divisão por zero
            mediaGeral = mediaGeral / alunos.size(); //divide a soma das médias pela quantidade de médias
        }
        return  mediaGeral;
    }

    public float calcularNotaMinima( List<Aluno> alunos ) {
        if (alunos.size() > 0) { //precisa existir alunos na lista para calcular a menor nota
            float notaMinima = alunos.get(0).getMedia();
            for (Aluno aluno : alunos) {
                if (aluno.getMedia() < notaMinima) { //Essa forma do laço for não é otimizada
                    // pois vai comparar a nota do primeiro aluno com a dele mesmo; em um programa
                    // com entradas maiores ou exigência de performançe pediria um laço for mais elaborado
                    notaMinima = aluno.getMedia();
                }
            }
            return notaMinima;
        } else {
            return 0; //caso a lista de alunos esteja vazia, a média será zero
        }
    }

    public float calcularNotaMaxima( List<Aluno> alunos ) {
        if (alunos.size() > 0) { //precisa existir alunos na lista para calcular a maior nota
            float notaMaxima = alunos.get(0).getMedia();
            for (Aluno aluno : alunos) {
                if (aluno.getMedia() > notaMaxima) { //Novamente o laço for não é otimizada
                    notaMaxima = aluno.getMedia();
                }
            }
            return notaMaxima;
        } else {
            return 0; //caso a lista de alunos esteja vazia, a média será zero
        }
    }

    public int calcularQuantidadeDeAlunos( List<Aluno> alunos ) {
        return alunos.size(); //Retorna a quantidade de alunos da lista
    }
}
