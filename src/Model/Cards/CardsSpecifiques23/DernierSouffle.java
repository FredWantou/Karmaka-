package Model.Cards.CardsSpecifiques23;


import Model.Cards.Card;
import Model.Cards.Couleur;
import Model.Partie.Partie;

import java.util.Random;

/**
 * @author giovannizangue
 * @version 1.0
 *
 * <br>
 * Classe de la carte Dernier Souffle
 */
public class DernierSouffle extends Card {

    // =========================================== LE CONSTRUCTEUR ========================================= //
    public DernierSouffle() {
        super("DernierSouffle", 1, Couleur.ROUGE);
    }


    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Le joueur de votre choix defausse une carte de sa main */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'DERNIER SOUFFLE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        if (!partie.getOpponentPlayer().getMain().getCartesDeLaMain().isEmpty()) {
            int taille = partie.getOpponentPlayer().getMain().getCartesDeLaMain().size();
            Random random = new Random();
            partie.getFosse().addCard(
                    partie.getOpponentPlayer().getMain().getCartesDeLaMain().remove(random.nextInt(taille))
            );

        } else {
            System.out.println("OPPONENT PLAYER n'a pas assez de cartes dans sa main!");
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
        /* Le joueur de votre choix defausse une carte de sa main */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'DERNIER SOUFFLE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        if (!partie.getOpponentPlayer().getMain().getCartesDeLaMain().isEmpty()) {
            int taille = partie.getOpponentPlayer().getMain().getCartesDeLaMain().size();
            Random random2 = new Random(strategie);
            partie.getFosse().addCard(
                    partie.getOpponentPlayer().getMain().getCartesDeLaMain().remove(random2.nextInt(taille))
            );

        } else {
            System.out.println("OPPONENT PLAYER n'a pas assez de cartes dans sa main!");
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
