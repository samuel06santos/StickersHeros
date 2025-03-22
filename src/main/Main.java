package main;
// JOAO SAMUEL DIAS SANTOS - 202211140033
// KIM LIMA DE LIMA - 202211140014


import views.SuperHeroView;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SuperHeroView();
        });
    }
}