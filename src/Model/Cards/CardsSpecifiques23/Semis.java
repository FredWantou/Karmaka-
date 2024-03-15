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
 * Classe de la carte Semis
 */
public class Semis extends Card {


	transient Scanner keyboard = new Scanner(System.in);


    // =========================================== LE CONSTRUCTEUR ========================================= //
    public Semis() {
        super("Semis", 2, Couleur.VERT);
    }


    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Puisez 02 cartes a la Source. Puis placez sur votre Vie Future 02 Cartes de votre Main */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'SEMIS'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        try {

            System.out.println("\nVOUS PUISEZ 02 CARTES A LA SOURCE...");
            Thread.sleep(1000);

            partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());
            partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());

            System.out.println("\nACTIVE PLAYER's Main: " +
                    partie.getActivePlayer().getMain().getCartesDeLaMain());

            System.out.println("\nEntrez l'index de la 1ere carte que vous souhaitez placer sur " +
                    "votre Vie Future (le plus grand index)");
            int indexAajouter1 = keyboard.nextInt();
            System.out.println("\nEntrez l'index de la 2eme carte que vous souhaitez placer sur " +
                    "votre Vie Future (le plus petit index)");
            int indexAajouter2 = keyboard.nextInt();

            Card carteAajouter1 = partie.getActivePlayer().getMain().getCartesDeLaMain().get(indexAajouter1);
            Card carteAajouter2 = partie.getActivePlayer().getMain().getCartesDeLaMain().get(indexAajouter2);

            System.out.println("\nAJOUT DES CARTES SUR VOTRE VIE FUTURE...");
            Thread.sleep(1000);

            partie.getActivePlayer().getVieFuture().addCard(carteAajouter1);
            partie.getActivePlayer().getVieFuture().addCard(carteAajouter2);


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
        /* Puisez 02 cartes a la Source. Puis placez sur votre Vie Future 02 Cartes de votre Main */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'SEMIS'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        Random random = new Random();

        try {

            System.out.println("\nVOUS PUISEZ 02 CARTES A LA SOURCE...");
            Thread.sleep(1000);

            partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());
            partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());

            System.out.println("\nACTIVE PLAYER's Main: " +
                    partie.getActivePlayer().getMain().getCartesDeLaMain());

            System.out.println("\nEntrez l'index de la 1ere carte que vous souhaitez placer sur " +
                    "votre Vie Future (le plus grand index)");
            int indexAajouter1 = random.nextInt(0, partie.getActivePlayer().getMain().getCartesDeLaMain().size());
            System.out.println(indexAajouter1);

            System.out.println("\nEntrez l'index de la 2eme carte que vous souhaitez placer sur " +
                    "votre Vie Future (le plus petit index)");
            int indexAajouter2 = random.nextInt(0, partie.getActivePlayer().getMain().getCartesDeLaMain().size());
            System.out.println(indexAajouter2);

            Card carteAajouter1 = partie.getActivePlayer().getMain().getCartesDeLaMain().get(indexAajouter1);
            Card carteAajouter2 = partie.getActivePlayer().getMain().getCartesDeLaMain().get(indexAajouter2);

            System.out.println("\nAJOUT DES CARTES SUR VOTRE VIE FUTURE...");
            Thread.sleep(1000);

            partie.getActivePlayer().getVieFuture().addCard(carteAajouter1);
            partie.getActivePlayer().getVieFuture().addCard(carteAajouter2);


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
