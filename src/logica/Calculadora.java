package src.logica;

import src.estrutura.Aluno;

import java.util.List;

public class Calculadora {

    public float calcularMediaGeral( List<Aluno> alunos ) {
        float mediaGeral = 0;
        for (Aluno aluno : alunos) {
            mediaGeral = mediaGeral + aluno.getMedia(); //Media aritimética simples: soma todas as médias
        }
        mediaGeral = mediaGeral / alunos.size(); //e divide pela quantidade de médias

        return  mediaGeral;
    }

    public float calcularNotaMinima( List<Aluno> alunos ) {
        return 0;
    }

    public float calcularNotaMaxima( List<Aluno> alunos ) {
        return 0;
    }

    public int calcularQuantidadeDeAlunos( List<Aluno> alunos ) {
        return 0;
    }
}
