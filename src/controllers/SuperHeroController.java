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
}
