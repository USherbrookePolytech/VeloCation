package controller;

import model.Session;

/**
 * Controler principal qui permet l'accès au modèle grace à l'attribut de type
 * Session
 */
public abstract class AbstractController
{
    private static Session session;

    // Initalisation de la session
    public static void initSession()
    {
        session = new Session();
    }

    public void afficherAide()
    {

    }

    public void afficherContact()
    {

    }

    public void afficherCarte()
    {

    }
}