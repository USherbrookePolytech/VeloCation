package controller;

import javax.swing.UIManager;

import view.ConnexionTempoView;

/**
 * Contrôleur de la vue connexionTempo
 */
public class ConnexionTempoController extends AbstractController
{
    private ConnexionTempoView connexionTempoView;

    public ConnexionTempoController(ConnexionTempoView connexionTempoViewArg)
    {
        this.connexionTempoView = connexionTempoViewArg;
    }

    public void numTel()
    {
        connexionTempoView.getFrmConnexionTemporaire().setVisible(true);
    }
    
    private void validation()
    {
        connexionTempoView.getFrmConnexionTemporaire().setVisible(false);
        connexionTempoView.getFrmConnexionTempValidation().setVisible(true);
    }

    public void creerUserTemp(String code, String num)
    {
        session.connexionTemp(code + num);
    }
    
    public void setEmptyBorder()
    {        
        connexionTempoView.getCxTempTextFieldNumero().setBorder(UIManager.getBorder("TextField.border"));
        connexionTempoView.getCxTempTextFieldCode().setBorder(UIManager.getBorder("TextField.border"));
        connexionTempoView.getCxTempValidationTextFieldCode().setBorder(UIManager.getBorder("TextField.border"));
    }

    public void hideMessage()
    {
        connexionTempoView.getCxTempTextFieldNumero().setText("");
        connexionTempoView.getCxTempTextFieldCode().setText("+33");
        connexionTempoView.getCxTempValidationTextFieldCode().setText("");
    }
}