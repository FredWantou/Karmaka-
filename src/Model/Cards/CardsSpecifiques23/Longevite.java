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
 */
public class Longevite extends Card {

	transient Scanner keyboard = new Scanner(System.in);

    // =========================================== LE CONSTRUCTEUR ========================================= //
    public Longevite() {
        super("Longevite", 2, Couleur.VERT);
    }


    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Placez 02 cartes puisee a la source sur la pile d'un joueur */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'LONGEVITE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        try {

            System.out.println("\nPUISEZ 02 CARTES A LA SOURCE...");
            Thread.sleep(1000);

            Card carte1 = partie.getSource().removeCard();
            Card carte2 = partie.getSource().removeCard();

            System.out.println("\nSur la Pile de quel Joueur souhaitez vous ajouter ces cartes?\n" +
                    "•0 = Votre Pile\n" +
                    "•1 = OPPONENT PLAYER's Pile");
            int index = keyboard.nextInt();

            if (index == 0) {
                System.out.println("\nAJOUT DE CES CARTES A VOTRE PILE...");
                Thread.sleep(1000);

                partie.getActivePlayer().getPile().addCard(carte1);
                partie.getActivePlayer().getPile().addCard(carte2);
            }

            else if (index == 1) {
                System.out.println("\nAJOUT DE CES CARTES A OPPONENT PLAYER'S PILE...");
                Thread.sleep(1000);

                partie.getOpponentPlayer().getPile().addCard(carte1);
                partie.getOpponentPlayer().getPile().addCard(carte2);
            }

            else {
                System.out.println("\nInvalid index!");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
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
        /* Placez 02 cartes puisee a la source sur la pile d'un joueur */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'LONGEVITE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        Random random = new Random();

        try {

            System.out.println("\nPUISEZ 02 CARTES A LA SOURCE...");
            Thread.sleep(1000);

            Card carte1 = partie.getSource().removeCard();
            Card carte2 = partie.getSource().removeCard();

            System.out.println("\nSur la Pile de quel Joueur souhaitez vous ajouter ces cartes?\n" +
                    "•0 = Votre Pile\n" +
                    "•1 = OPPONENT PLAYER's Pile");
            int index = random.nextInt(0, 2);
            System.out.println(index);

            if (index == 0) {
                System.out.println("\nAJOUT DE CES CARTES A VOTRE PILE...");
                Thread.sleep(1000);

                partie.getActivePlayer().getPile().addCard(carte1);
                partie.getActivePlayer().getPile().addCard(carte2);
            }

            else if (index == 1) {
                System.out.println("\nAJOUT DE CES CARTES A OPPONENT PLAYER'S PILE...");
                Thread.sleep(1000);

                partie.getOpponentPlayer().getPile().addCard(carte1);
                partie.getOpponentPlayer().getPile().addCard(carte2);
            }

            else {
                System.out.println("\nInvalid index!");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
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
