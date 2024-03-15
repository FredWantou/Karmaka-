package Model.Cards.CardsSpecifiques23;

import Model.Cards.Card;
import Model.Cards.Couleur;
import Model.Partie.Partie;

/**
 * @author giovannizangue
 * @version 1.0
 *
 * <br>
 * Classe de la carte Duperie
 */
public class Fournaise extends Card {

    // =========================================== LE CONSTRUCTEUR ========================================= //
    public Fournaise() {
        super("Fournaise", 2, Couleur.ROUGE);
    }


    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Defaussez les 02 premieres cartes de la Vie Future de votre rival */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'FOURNAISE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        if(partie.getOpponentPlayer().getVieFuture().getCartesDeLaVieFuture().isEmpty()) {
            System.out.println("\nOPPONENT PLAYER's Vie Future est vide.");
        }
        else if(partie.getOpponentPlayer().getVieFuture().getCartesDeLaVieFuture().size() == 1) {
            partie.getFosse().addCard(partie.getOpponentPlayer().getVieFuture().removeCard());
        }
        else if (partie.getOpponentPlayer().getVieFuture().getCartesDeLaVieFuture().size() == 2) {
            partie.getFosse().addCard(partie.getOpponentPlayer().getVieFuture().removeCard());
            partie.getFosse().addCard(partie.getOpponentPlayer().getVieFuture().removeCard());
        }
        else {
            partie.getFosse().addCard(
                    partie.getOpponentPlayer().getVieFuture().getCartesDeLaVieFuture().remove(0)
            );
            partie.getFosse().addCard(
                    partie.getOpponentPlayer().getVieFuture().getCartesDeLaVieFuture().remove(1)
            );
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
        /* Defaussez les 02 premieres cartes de la Vie Future de votre rival */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'FOURNAISE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        if(partie.getOpponentPlayer().getVieFuture().getCartesDeLaVieFuture().isEmpty()) {
            System.out.println("\nOPPONENT PLAYER's Vie Future est vide.");
        }
        else if(partie.getOpponentPlayer().getVieFuture().getCartesDeLaVieFuture().size() == 1) {
            partie.getFosse().addCard(partie.getOpponentPlayer().getVieFuture().removeCard());
        }
        else if (partie.getOpponentPlayer().getVieFuture().getCartesDeLaVieFuture().size() == 2) {
            partie.getFosse().addCard(partie.getOpponentPlayer().getVieFuture().removeCard());
            partie.getFosse().addCard(partie.getOpponentPlayer().getVieFuture().removeCard());
        }
        else {
            partie.getFosse().addCard(
                    partie.getOpponentPlayer().getVieFuture().getCartesDeLaVieFuture().remove(0)
            );
            partie.getFosse().addCard(
                    partie.getOpponentPlayer().getVieFuture().getCartesDeLaVieFuture().remove(1)
            );
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
