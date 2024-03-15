package Model.Cards.CardsSpecifiques23;

import Model.Cards.Card;
import Model.Cards.Couleur;
import Model.Joueur.OptionDeJeu;
import Model.Partie.Partie;

import java.util.Random;
import java.util.Scanner;

/**
 * @author giovannizangue
 * @version 1.0
 *
 * <br>
 * Classe de la carte Duperie
 */
public class Incarnation extends Card {

	transient Scanner keyboard = new Scanner(System.in);

    // =========================================== LE CONSTRUCTEUR ========================================= //
    public Incarnation() {
        super("Incarnation", 1, Couleur.MOSAIQUE);
    }


    // ================================================= METHODES ========================================== //

    // =========================================== EXECUTER CAPACITE ====================================== //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Choisissez une de vos Oeuvres. Copier son pouvoir */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'INCARNATION'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        if (partie.getActivePlayer().getOeuvre().getCartesDeLOeuvre().isEmpty()) {
            System.out.println("\nVous n'avez aucune carte dans votre Oeuvre");
        }
        else {
            System.out.println("\nACTIVE PLAYER's Oeuvre: " +
                    partie.getActivePlayer().getOeuvre().getCartesDeLOeuvre());

            System.out.println("\nChoisissez l'index de la carte a copier: ");
            int indexACopier = keyboard.nextInt();
            Card carteACopier = partie.getActivePlayer().getOeuvre().getCartesDeLOeuvre().remove(indexACopier);

            partie.getActivePlayer().setOptionDeJeu(OptionDeJeu.POUR_SON_POUVOIR);
            OptionDeJeu optionDeJeu = partie.getActivePlayer().getOptionDeJeu();
            partie.getActivePlayer().jouer(carteACopier, optionDeJeu);
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
        /* Choisissez une de vos Oeuvres. Copier son pouvoir */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'INCARNATION'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        Random random = new Random();

        if (partie.getActivePlayer().getOeuvre().getCartesDeLOeuvre().isEmpty()) {
            System.out.println("\nVous n'avez aucune carte dans votre Oeuvre");
        }
        else {
            System.out.println("\nACTIVE PLAYER's Oeuvre: " +
                    partie.getActivePlayer().getOeuvre().getCartesDeLOeuvre());

            System.out.println("\nChoisissez l'index de la carte a copier: ");
            int indexACopier = random.nextInt(0, partie.getActivePlayer().getOeuvre().getCartesDeLOeuvre().size());
            System.out.println(indexACopier);

            Card carteACopier = partie.getActivePlayer().getOeuvre().getCartesDeLOeuvre().remove(indexACopier);

            partie.getActivePlayer().setOptionDeJeu(OptionDeJeu.POUR_SON_POUVOIR);
            OptionDeJeu optionDeJeu = partie.getActivePlayer().getOptionDeJeu();
            partie.getActivePlayer().jouer(carteACopier, optionDeJeu);
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
