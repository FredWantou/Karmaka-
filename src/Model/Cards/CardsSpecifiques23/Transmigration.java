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
 * Classe de la 1e carte Transmigration (il en exite 3)
 */
public class Transmigration extends Card {

	transient Scanner keyboard = new Scanner(System.in);


    // =========================================== LE CONSTRUCTEUR ========================================= //
    public Transmigration() {
        super("Transmigration", 1, Couleur.BLEU);
    }


    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Placer dans votre Main n'importe quelle carte de votre Vie Future */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'TRANSMIGRATION'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        try {

            if (partie.getActivePlayer().getVieFuture().getCartesDeLaVieFuture().isEmpty()) {
                System.out.println("\nVous n'avez aucune carte dans votre Vie Future!");
            }

            else {
                System.out.println("\nACTIVE PLAYER's Vie Future: " +
                        partie.getActivePlayer().getVieFuture().getCartesDeLaVieFuture());

                System.out.println("\nEntrez l'index de la carte que vous souhaitez ajouter a votre Main: ");
                int indexAajouter = keyboard.nextInt();

                Card carteAajouter = partie.getActivePlayer().getVieFuture().getCartesDeLaVieFuture().get(indexAajouter);

                System.out.println("\nAJOUT DE LA CARTE A VOTRE MAIN...");
                Thread.sleep(1000);

                partie.getActivePlayer().getMain().addCard(carteAajouter);

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
        /* Placer dans votre Main n'importe quelle carte de votre Vie Future */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'TRANSMIGRATION'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        Random random = new Random();

        try {

            if (partie.getActivePlayer().getVieFuture().getCartesDeLaVieFuture().isEmpty()) {
                System.out.println("\nVous n'avez aucune carte dans votre Vie Future!");
            }

            else {
                System.out.println("\nACTIVE PLAYER's Vie Future: " +
                        partie.getActivePlayer().getVieFuture().getCartesDeLaVieFuture());

                System.out.println("\nEntrez l'index de la carte que vous souhaitez ajouter a votre Main: ");
                int indexAajouter = random.nextInt(0, partie.getActivePlayer().getVieFuture().getCartesDeLaVieFuture().size());
                System.out.println(indexAajouter);

                Card carteAajouter = partie.getActivePlayer().getVieFuture().getCartesDeLaVieFuture().get(indexAajouter);

                System.out.println("\nAJOUT DE LA CARTE A VOTRE MAIN...");
                Thread.sleep(1000);

                partie.getActivePlayer().getMain().addCard(carteAajouter);

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
