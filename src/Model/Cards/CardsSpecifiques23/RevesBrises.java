package Model.Cards.CardsSpecifiques23;

import Model.Cards.Card;
import Model.Cards.Couleur;
import Model.Partie.Partie;

/**
 * @author giovannizangue
 * @version 1.0
 *
 * <br>
 * Classe de la carte Reves Brises
 */
public class RevesBrises extends Card {



    // =========================================== LE CONSTRUCTEUR ========================================= //
    public RevesBrises() {
        super("RevesBrises", 2, Couleur.BLEU);
    }





    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Placez la 1ere carte de la Vie Future de votre rival sur la votre */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'REVES BRISES'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        try {

            if (partie.getOpponentPlayer().getVieFuture().getCartesDeLaVieFuture().isEmpty()) {
                System.out.println("\nOPPONENT PLAYER's Vie Future est vide.");

            }
            else {
                System.out.println("\nAJOUT DE LA CARTE A VOTRE VIE FUTURE...");
                Thread.sleep(1000);

                Card carteAajouter = partie.getOpponentPlayer().getVieFuture().removeCard();
                partie.getActivePlayer().getVieFuture().addCard(carteAajouter);
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
        /* Placez la 1ere carte de la Vie Future de votre rival sur la votre */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'REVES BRISES'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        try {

            if (partie.getOpponentPlayer().getVieFuture().getCartesDeLaVieFuture().isEmpty()) {
                System.out.println("\nOPPONENT PLAYER's Vie Future est vide.");

            }
            else {
                System.out.println("\nAJOUT DE LA CARTE A VOTRE VIE FUTURE...");
                Thread.sleep(1000);

                Card carteAajouter = partie.getOpponentPlayer().getVieFuture().removeCard();
                partie.getActivePlayer().getVieFuture().addCard(carteAajouter);
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
