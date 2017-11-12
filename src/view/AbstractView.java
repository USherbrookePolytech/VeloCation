package view;

/**
 * Vue principale du package. L'accès au contrôleur est établi grâce à
 * l'attribut de type AccueilView
 */
public abstract class AbstractView
{
    protected static AccueilView accueilView;

    // Initialisation de la vue d'accueil
    public static void initView()
    {
        accueilView = new AccueilView();
    }
}