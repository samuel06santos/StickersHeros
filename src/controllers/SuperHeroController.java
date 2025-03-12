package controllers;

import models.SuperHero;
import models.SuperHeroManager;

import java.util.List;

public class SuperHeroController {
    private SuperHeroManager heroManager;

    public SuperHeroController() {
        this.heroManager = new SuperHeroManager();
    }

    public void adicionarHeroi(
        String nome,
        String descricao,
        String poderes,
        String grupo,
        String habilidades,
        String imagemPath,
        String videoPath
    ) {
        SuperHero novoHeroi = new SuperHero(
            nome,
            descricao,
            poderes,
            grupo,
            habilidades,
            imagemPath,
            videoPath
        );
        heroManager.adicionarHeroi(novoHeroi);
    }

    public void removerHeroi(String nome) {
        heroManager.removerHeroi(nome);
    }

    public void atualizarHeroi(
        int index,
        String nome,
        String descricao,
        String poderes,
        String grupo,
        String habilidades,
        String imagemPath,
        String videoPath
    ) {
        SuperHero heroiAtualizado = new SuperHero(
            nome,
            descricao,
            poderes,
            grupo,
            habilidades,
            imagemPath,
            videoPath
        );
        heroManager.atualizarHeroi(index, heroiAtualizado);
    }

    public List<SuperHero> listarTodosHerois() {
        return heroManager.listarTodos();
    }

    public SuperHero getHeroiAtual() {
        return heroManager.getHeroiAtual();
    }

    public SuperHero proximoHeroi() {
        return heroManager.proximoHeroi();
    }

    public SuperHero heroiAnterior() {
        return heroManager.heroiAnterior();
    }

    public int getIndiceAtual() {
        return heroManager.getCurrentIndex();
    }

    public void seedHerois() {
        adicionarHeroi("Homem-Aranha", "Herói da vizinhança", "Sentido Aranha, Agilidade", "Marvel", "Trepa paredes", "src/spiderman.png", "C:\\Users\\LabSC_01\\Videos\\Spider-Man_Theme.mp4");
        adicionarHeroi("Batman", "O Cavaleiro das Trevas", "Inteligência, Artes Marciais", "DC", "Detective", "src/batman.png", "batman.mp4");
        adicionarHeroi("Mulher-Maravilha", "Princesa Amazona", "Força, Agilidade", "DC", "Laço da Verdade", "src/wonderwoman.png", "wonderwoman.mp4");
        adicionarHeroi("Superman", "Homem de Aço", "Super força, Voo", "DC", "Visão de Raio-X", "src/superman.png", "superman.mp4");
    }
}
