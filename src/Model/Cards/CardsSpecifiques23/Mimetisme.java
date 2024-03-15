package Model.Cards.CardsSpecifiques23;

import Model.Cards.Card;
import Model.Cards.Couleur;
import Model.Joueur.OptionDeJeu;
import Model.Partie.Partie;

import java.util.Scanner;

/**
 * @author giovannizangue
 * @version 1.0
 *
 * <br>
 * Classe de la carte Duperie
 */
public class Mimetisme extends Card {

	transient Scanner keyboard = new Scanner(System.in);

    // =========================================== LE CONSTRUCTEUR ========================================= //
    public Mimetisme() {
        super("Mimetisme", 1, Couleur.MOSAIQUE);
    }


    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Copiez le pouvoir de l'Oeuvre exposee de votre rival */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'MIMETISME'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        try {
            Thread.sleep(2000);

            System.out.println(partie.getActivePlayer() + "\n");

            if (!partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre().isEmpty()) {
                Card carteAcopier = partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre().get(0);

                System.out.println("\nCOPIE DU POUVOIR...");
                Thread.sleep(1000);

                partie.getActivePlayer().setOptionDeJeu(OptionDeJeu.POUR_SON_POUVOIR);
                OptionDeJeu optionDeJeu = OptionDeJeu.POUR_SON_POUVOIR;

                partie.getActivePlayer().jouer(carteAcopier, optionDeJeu);

            } else {
                System.out.println("\nOPPONENT PLAYER n'a aucune carte dans ses Oeuvres!");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }



    // ================== JOUER VIRTUEL ============= //
    @Override
    public void executerCapaciteCPU(Partie partie, int strategie) {
        /* Copiez le pouvoir de l'Oeuvre exposee de votre rival */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'MIMETISME'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        try {
            Thread.sleep(2000);

            System.out.println(partie.getActivePlayer() + "\n");

            if (!partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre().isEmpty()) {
                Card carteAcopier = partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre().get(0);

                System.out.println("\nCOPIE DU POUVOIR...");
                Thread.sleep(1000);

                partie.getActivePlayer().setOptionDeJeu(OptionDeJeu.POUR_SON_POUVOIR);
                OptionDeJeu optionDeJeu = OptionDeJeu.POUR_SON_POUVOIR;

                partie.getActivePlayer().jouer(carteAcopier, optionDeJeu);

            } else {
                System.out.println("\nOPPONENT PLAYER n'a aucune carte dans ses Oeuvres!");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
