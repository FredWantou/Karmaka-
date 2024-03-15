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
 * Classe de la 1e carte Basses (il en exite 2)
 */
public class Bassesse extends Card {

    // =========================================== LES ATTRIBUTS ========================================= //


    // =========================================== LE CONSTRUCTEUR ========================================= //
    public Bassesse() {
        super("Bassesse", 3, Couleur.ROUGE);
    }


    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Defausser 02 cartes au hasard de la main de votre rival */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'BASSESSE'...\n");


        // permet de defausser la carte en cours
        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        // Execution de la capacite
        if (partie.getOpponentPlayer().getMain().getCartesDeLaMain().size() >= 2) {
            int tailleDeLaMain = partie.getOpponentPlayer().getMain().getCartesDeLaMain().size() - 1;
            Random random = new Random();

            partie.getFosse().addCard(
                    partie.getOpponentPlayer().getMain().getCartesDeLaMain().remove(random.nextInt(tailleDeLaMain))
            );
            tailleDeLaMain -= 1;
            partie.getFosse().addCard(
                    partie.getOpponentPlayer().getMain().getCartesDeLaMain().remove(random.nextInt(tailleDeLaMain))
            );

        } else if (partie.getOpponentPlayer().getMain().getCartesDeLaMain().size() == 1) {
            partie.getFosse().addCard(
                    partie.getOpponentPlayer().getMain().getCartesDeLaMain().remove(0)
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
        /* Defausser 02 cartes au hasard de la main de votre rival */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'BASSESSE'...\n");


        // permet de defausser la carte en cours
        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        // Execution de la capacite
        if (partie.getOpponentPlayer().getMain().getCartesDeLaMain().size() >= 2) {
            int tailleDeLaMain = partie.getOpponentPlayer().getMain().getCartesDeLaMain().size();
            Random random = new Random();

            partie.getFosse().addCard(
                    partie.getOpponentPlayer().getMain().getCartesDeLaMain().remove(random.nextInt(0, tailleDeLaMain))
            );
            tailleDeLaMain -= 1;
            partie.getFosse().addCard(
                    partie.getOpponentPlayer().getMain().getCartesDeLaMain().remove(random.nextInt(0, tailleDeLaMain))
            );

        } else if (partie.getOpponentPlayer().getMain().getCartesDeLaMain().size() == 1) {
            partie.getFosse().addCard(
                    partie.getOpponentPlayer().getMain().getCartesDeLaMain().remove(0)
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
