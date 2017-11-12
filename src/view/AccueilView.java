package view;

import controller.AbstractController;
import controller.AccueilController;
import controller.ConnexionTempoController;
import controller.InscriptionController;
import controller.ProfilController;

/**
 * Vue qui s'occupe de la page d'accueil et de ses liens (inscription,
 * connexionTempo, profil)
 */
public class AccueilView extends AbstractView
{
    private AccueilController accueilController;
    private ConnexionTempoController connexionTempoController;
    private InscriptionController insccriptionController;
    private ProfilController profilController;
    
    public AccueilView()
    {
        // Initialisation de la session
        AbstractController.initSession();
        
        accueilController = new AccueilController();
        connexionTempoController = new ConnexionTempoController();
        insccriptionController = new InscriptionController();
        profilController = new ProfilController();
    }
}