package View;

import Controller.GameController;

public interface GameViewable {

    public void setController(GameController gameController);
    public void promptForTypeDePartie();
    public void doSomething();
    public void promptForNouvellePartie();
    public void promptForNomDuJoueur();
    public void afficherNomDuJoueur();
    public void afficherLeNomDuGagnant();
    public void promptForTerminerLaPartie();
    public int promptForIndexDeLaCarteDeLaMainAJouer();
    public int promptForOptionDeJeu();
}
