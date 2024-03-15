package Model.Cards.CardsSpecifiques23;

import Model.Cards.Card;
import Model.Cards.Couleur;
import Model.Partie.Partie;

/**
 * @author giovannizangue
 * @version 1.0
 *
 * <br>
 * Classe de la carte Vol
 */
public class Vol extends Card {


    // =========================================== LE CONSTRUCTEUR ========================================= //
    public Vol() {
        super("Vol", 3, Couleur.BLEU);
    }


    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Placez dans votre main l'Oeuvre exposee de votre rival */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'VOL'...\n");


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
                System.out.println("\nAJOUT DE LA CARTE A VOTRE MAIN...");
                Thread.sleep(1000);

                partie.getActivePlayer().getMain().addCard(
                        partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre().remove(0)
                );
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
        /* Placez dans votre main l'Oeuvre exposee de votre rival */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'VOL'...\n");


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
                System.out.println("\nAJOUT DE LA CARTE A VOTRE MAIN...");
                Thread.sleep(1000);

                partie.getActivePlayer().getMain().addCard(
                        partie.getOpponentPlayer().getOeuvre().getCartesDeLOeuvre().remove(0)
                );
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
