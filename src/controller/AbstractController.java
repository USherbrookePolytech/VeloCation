package controller;

import java.util.Date;

import model.Abonnement;
import model.Session;

/**
 * Controler principal qui permet l'accès au modèle grace à l'attribut de type
 * Session
 */
public abstract class AbstractController
{
    protected static Session session;
    
    public static void init() 
    {
        session = new Session();
        session.nouveauAbo("Baba", "Rere'", "+3369593949", "1 rue du truc", new Abonnement("1an", 500, 12, new Date()));
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