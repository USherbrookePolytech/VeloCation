package controller;

import java.time.LocalDate;
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

    /**
     * @return the session
     */
    public static Session getSession()
    {
        return session;
    }
    
    
}