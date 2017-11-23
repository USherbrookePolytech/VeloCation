package tests;

import controller.AbstractController;
import view.AbstractView;

/**
 * Classe principale
 */
public class Launcher
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // Permet d'initialiser la vue d'accueil.
        AbstractView.initView();
        AbstractController.init();
    }
}