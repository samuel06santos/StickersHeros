package models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SuperHeroManager {
    private List<SuperHero> herois;
    private int currentIndex;
    private static final String FILE_PATH = "herois.json";
    private Gson gson;

    public SuperHeroManager() {
        this.herois = new ArrayList<>();
        this.currentIndex = 0;
        this.gson = new Gson();
        loadHeroisFromFile();
    }

    public List<SuperHero> listarTodos() {
        return herois;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void adicionarHeroi(SuperHero heroi) {
        herois.add(heroi);
        saveHeroisToFile();
    }

    public void removerHeroi(String nome) {
        herois.removeIf(heroi -> heroi.getNome().equals(nome));
        saveHeroisToFile();
    }

    public void atualizarHeroi(int index, SuperHero heroiAtualizado) {
        herois.set(index, heroiAtualizado);
        saveHeroisToFile();
    }

    public SuperHero getHeroiAtual() {
        return herois.get(currentIndex);
    }

    public SuperHero proximoHeroi() {
        currentIndex = (currentIndex + 1) % herois.size();
        return getHeroiAtual();
    }

    public SuperHero heroiAnterior() {
        currentIndex = (currentIndex - 1 + herois.size()) % herois.size();
        return getHeroiAtual();
    }

    private void saveHeroisToFile() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(herois, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadHeroisFromFile() {
        File file = new File(FILE_PATH);
        if (file.length() == 0) {
            herois = new ArrayList<>();
            return;
        }

        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<SuperHero>>() {}.getType();
            herois = gson.fromJson(reader, listType);
            if (herois == null) {
                herois = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {
            herois = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
