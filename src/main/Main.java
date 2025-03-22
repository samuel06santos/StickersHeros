package main;

import views.SuperHeroView;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SuperHeroView();
        });
    }
}