package models;

import java.util.ArrayList;
import java.util.List;

public class SuperHeroManager {
    private List<SuperHero> herois;
    private int currentIndex;

    public SuperHeroManager() {
        this.herois = new ArrayList<>();
        this.currentIndex = -1;
    }

    public void adicionarHeroi(SuperHero heroi) {
        herois.add(heroi);
        if (herois.size() == 1) {
            currentIndex = 0;
        }
    }

    public void removerHeroi(String nome) {
        herois.removeIf(heroi -> heroi.getNome().equalsIgnoreCase(nome));
        if (herois.isEmpty()) {
            currentIndex = -1;
        } else if (currentIndex >= herois.size()) {
            currentIndex = herois.size() - 1;
        }
    }

    public void atualizarHeroi(int index, SuperHero heroiAtualizado) {
        if (index >= 0 && index < herois.size()) {
            herois.set(index, heroiAtualizado);
        }
    }

    public SuperHero getHeroiAtual() {
        if (currentIndex >= 0 && currentIndex < herois.size()) {
            return herois.get(currentIndex);
        }
        return null;
    }

    public SuperHero proximoHeroi() {
        if (!herois.isEmpty() && currentIndex < herois.size() - 1) {
            currentIndex++;
        }
        return getHeroiAtual();
    }

    public SuperHero heroiAnterior() {
        if (!herois.isEmpty() && currentIndex > 0) {
            currentIndex--;
        }
        return getHeroiAtual();
    }

    public List<SuperHero> listarTodos() {
        return herois;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }
}
