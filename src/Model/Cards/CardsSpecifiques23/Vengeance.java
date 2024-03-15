package Model.Cards.CardsSpecifiques23;

import Model.Cards.Card;
import Model.Cards.Couleur;
import Model.Partie.Partie;

/**
 * @author giovannizangue
 * @version 1.0
 *
 * <br>
 * Classe de la carte Veangeance
 */
public class Vengeance extends Card {


    // =========================================== LES ATTRIBUTS ========================================= //

    // =========================================== LE CONSTRUCTEUR ========================================= //
    public Vengeance() {
        super("Vengeance", 3, Couleur.ROUGE);
    }


    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Defaussez l'Oeuvre exposee de votre rival */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'VENGEANCE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        try {

            if (partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre().isEmpty()) {
                System.out.println("\nOPPONENT PLAYER n'a aucune carte dans ses Oeuvres!");

            }
            else {
                System.out.println("\nDEFAUSSEZ L'OEUVRE EXPOSEE DE VOTRE RIVAL...");
                Thread.sleep(1000);

                partie.getFosse().addCard(partie.getOpponentPlayer().getOeuvre().removeCard());
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
        /* Defaussez l'Oeuvre exposee de votre rival */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'VENGEANCE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        try {

            if (partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre().isEmpty()) {
                System.out.println("\nOPPONENT PLAYER n'a aucune carte dans ses Oeuvres!");

            }
            else {
                System.out.println("\nDEFAUSSEZ L'OEUVRE EXPOSEE DE VOTRE RIVAL...");
                Thread.sleep(1000);

                partie.getFosse().addCard(partie.getOpponentPlayer().getOeuvre().removeCard());
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
