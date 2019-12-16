package estrutura;

public class Aluno {
  //Escolhi manter o padrão no nome dos atributos de uma palavra simples
  private String id;
  private String nome;
  private float  media;

  //Setters
  public void setId (String id) {
    this.id = id;
  }

  public void setNome (String nome) {
    this.nome = nome;
  }

  public void setMedia (float media) {
    this.media = media;
  }

  //Getters
  public String getId () {
    return id;
  }

  public String getNome () {
    return nome;
  }

  public float getMedia () {
    return media;
  }

}

