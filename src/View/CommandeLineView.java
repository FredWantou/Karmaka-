package View;

import Controller.GameController;
import Model.Partie.Partie;

import java.util.Scanner;

public class CommandeLineView implements GameViewable {

    // ==================================== LES ATTRIBUTS ============================================ //
    GameController controller;
    Scanner keyboard = new Scanner(System.in);


    // =================================== PUBLIC STATIC VOID MAIN ========================================== //
    public static void main(String[] args) {

        //GameViewables views = new GameViewables();
        CommandeLineView myView = new CommandeLineView();
        //GUIview myView2 = new GUIview();
        //viewAccueil view2 = new viewAccueil();
        //views.addViewable(myView);

        GameController gameController = new GameController(myView, Partie.getPartie());
        gameController.run();

    }

    // ==================================== SET_CONTROLLER ============================================ //
    public void setController(GameController gameController) {
        this.controller = gameController;
    }


    // ==================================== LES METHODES ================================================= //

    // ==================================== PROMPT_FOR_NOM_DU_JOUEUR ========================================= //
    @Override
    public void promptForNomDuJoueur() {
        System.out.println("\nEntrez le nom du joueur: ");
        String name = keyboard.next();
        controller.ajouterLesJoueurs(name);
    }

    // ==================================== PROMPT_FOR_TYPE_PARTIE ========================================= //
    @Override
    public void promptForTypeDePartie() {
        System.out.println("\n*********************** BIENVENUE DANS LE JEU KARMAKA ***********************\n");
        System.out.println("Choisissez le type de partie:\n0 = Joueur reel VS CPU\n1 = CPU vs CPU");
        int typeDePartie = keyboard.nextInt();
        controller.setTypeDePartie(typeDePartie);
    }

    // ============================ PROMPT_FOR_INDEX_DE_CARTE_DE_LA_MAIN_A_JOUER ============================= //
    @Override
    public int promptForIndexDeLaCarteDeLaMainAJouer() {
        System.out.println("Entrez l'index de la carte de la main a jouer: ");
        return keyboard.nextInt();
    }

    // ========================================== PROMPT_FOR_OPTION_DE_JEU ================================== //
    @Override
    public int promptForOptionDeJeu() {
        System.out.println("""
                Choisir l'option de jeu:\s
                •0 = Jouer pour ses points
                •1 = Jouer pour ses pouvoirs
                •2 = Jouer pour la vie future""");
        return keyboard.nextInt();
    }

    @Override
    public void doSomething() {
    }

    @Override
    public void promptForNouvellePartie() {

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

}
