package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.GameController;

public class GUIview implements GameViewable{

    // =================================== LES ATTRIBUTS ========================================== //
	GameController controller;
	int typeDePartie;
	/*
	 * attribt pour la vue du type de la partie
	 */
	ViewAccueil viewAccueil;
	ViewNomPlayer viewNomPlayer;

    // =================================== LES METHODES ========================================== //
    @Override
    public void setController(GameController gameController) {
    	this.controller = gameController;
    }

    @Override
    public void promptForTypeDePartie() {
    	viewAccueil = new ViewAccueil();
    	viewAccueil.frame.setVisible(true);
    	viewAccueil.boutonPlayerCpu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				typeDePartie = 0;
			}
		});
		
		//ce qui se passe lorsqu'on choisit cpu vs cpu		
		viewAccueil.boutonCpuCpu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						typeDePartie = 1;
					}
				});
        //int typeDePartie = keyboard.nextInt();
        controller.setTypeDePartie(0);
    }

    @Override
    public void doSomething() {

    }

    @Override
    public void promptForNouvellePartie() {

    }

    @Override
    public void promptForNomDuJoueur() {
    	viewNomPlayer = new ViewNomPlayer();
    	viewAccueil.frame.setVisible(false);
    	viewNomPlayer.frame.setVisible(true);
    }

    @Override
    public void afficherNomDuJoueur() {

    }

    @Override
    public void afficherLeNomDuGagnant() {

    }

    @Override
    public void promptForTerminerLaPartie() {

    }

    @Override
    public int promptForIndexDeLaCarteDeLaMainAJouer() {
        return 0;
    }

    @Override
    public int promptForOptionDeJeu() {
        return 0;
    }
}
