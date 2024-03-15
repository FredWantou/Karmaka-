package Model.Cards.CardsSpecifiques23;

import Model.Cards.Card;
import Model.Cards.Couleur;
import Model.Partie.Partie;

import java.util.Random;
import java.util.Scanner;

/**
 * @author giovannizangue
 * @version 1.0
 *
 * <br>
 * Classe de la carte Crise
 */
public class Crise extends Card {

    transient Scanner keyboard = new Scanner(System.in);


    // =========================================== LE CONSTRUCTEUR ========================================= //
    public Crise() {
        super("Crise", 2, Couleur.ROUGE);
    }


    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Le joueur de votre choix defausse une de ses oeuvres */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'CRISE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        if (!partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre().isEmpty()) {
            int taille = partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre().size() - 1;
            Random random = new Random();
            int index = random.nextInt(taille);

            partie.getFosse().addCard(
                    partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre().remove(index)
            );
        }
        else {
            System.out.println("OPPONENT PLAYER n'a pas assez de cartes dans son Oeuvre!");
        }

        System.out.println("\nOPPONENT PLAYER's Oeuvre: " +
                partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre());
        System.out.println("FOSSE: " +
                partie.getFosse().getCartes());
        System.out.println("•Nombre de cartes de la Fosse = " +
                partie.getFosse().getCartes().size());
        System.out.println("•Nombre de cartes de la Source = " +
                partie.getSource().getCartes().size());
    }

    // ================== JOUER VIRTUEL ============= //
    @Override
    public void executerCapaciteCPU(Partie partie, int strategie) {
        /* Le joueur de votre choix defausse une de ses oeuvres */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'CRISE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        if (!partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre().isEmpty()) {
            int taille = partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre().size();
            Random random = new Random();
            int index = random.nextInt(0, taille);

            partie.getFosse().addCard(
                    partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre().remove(index)
            );
        }
        else {
            System.out.println("OPPONENT PLAYER n'a pas assez de cartes dans son Oeuvre!");
        }

        System.out.println("\nOPPONENT PLAYER's Oeuvre: " +
                partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre());
        System.out.println("FOSSE: " +
                partie.getFosse().getCartes());
        System.out.println("•Nombre de cartes de la Fosse = " +
                partie.getFosse().getCartes().size());
        System.out.println("•Nombre de cartes de la Source = " +
                partie.getSource().getCartes().size());
    }
}
