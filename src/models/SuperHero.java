package models;

public class SuperHero {
    private String nome;
    private String grupo;
    private String descricao;
    private String poderes;
    private String habilidades;
    private String imagemPath;
    private String videoPath;

    public SuperHero(
        String nome,
        String grupo,
        String descricao,
        String poderes,
        String habilidades,
        String imagemPath,
        String videoPath
    ) {
        this.nome = nome;
        this.grupo = grupo;
        this.descricao = descricao;
        this.poderes = poderes;
        this.habilidades = habilidades;
        this.imagemPath = imagemPath;
        this.videoPath = videoPath;
    }

    // Getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPoderes() {
        return poderes;
    }

    public void setPoderes(String poderes) {
        this.poderes = poderes;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getImagemPath() {
        return imagemPath;
    }

    public void setImagemPath(String imagemPath) {
        this.imagemPath = imagemPath;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    @Override
    public String toString() {
        return "SuperHero{" +
            "nome='" + nome + '\'' +
            ", grupo='" + grupo + '\'' +
            ", descricao='" + descricao + '\'' +
            ", poderes='" + poderes + '\'' +
            ", habilidades='" + habilidades + '\'' +
            ", imagemPath='" + imagemPath + '\'' +
            ", videoPath='" + videoPath + '\'' +
            '}';
    }
}
