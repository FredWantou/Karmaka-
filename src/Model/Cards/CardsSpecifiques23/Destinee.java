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
 * Classe de la 1ere carte Destine (il en exite 3)
 */
public class Destinee extends Card {

	transient Scanner keyboard = new Scanner(System.in);

    // =========================================== LE CONSTRUCTEUR ========================================= //
    public Destinee() {
        super("Destinee", 2, Couleur.BLEU);
    }


    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Regardez les 03 premieres cartes de la source. Ajoutez en jusqu'a 02 à votre Vie Future.
         * Replacez le reste dans l'ordre souhaité */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'DESTINEE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        System.out.println("•1ere carte de la Source: " + partie.getSource().getCartes().get(0));
        System.out.println("•2eme carte de la Source: " + partie.getSource().getCartes().get(1));
        System.out.println("•3eme carte de la Source: " + partie.getSource().getCartes().get(2));

        System.out.println("\nCombien de ces cartes souhaitez vous ajouter a votre Vie Future? (" +
                "02 maximum)");
        int nbreDeCarte = keyboard.nextInt();

        if (nbreDeCarte == 2) {
            System.out.println("\nEntrez l'index de la 1ere carte a ajouter: (Le plus grand index) ");
            int index1 = keyboard.nextInt();
            Card carte1 = partie.getSource().getCartes().remove(index1);
            partie.getActivePlayer().getVieFuture().addCard(carte1);

            System.out.println("\nEntrez l'index de la 2eme carte a ajouter: (Le plus petit index) ");
            int index2 = keyboard.nextInt();
            if (index1 == 0) {
                Card carte2 = partie.getSource().getCartes().remove(index2 - 1);
                partie.getActivePlayer().getVieFuture().addCard(carte2);
            }
            else if (index1 == 1 && index2 == 0) {
                Card carte2 = partie.getSource().getCartes().remove(index2);
                partie.getActivePlayer().getVieFuture().addCard(carte2);
            }
            else if(index1 == 1 && index2 == 2) {
                Card carte2 = partie.getSource().getCartes().remove(index2 - 1);
                partie.getActivePlayer().getVieFuture().addCard(carte2);
            }
            else if(index1 == 2) {
                Card carte2 = partie.getSource().getCartes().remove(index2);
                partie.getActivePlayer().getVieFuture().addCard(carte2);
            }
        }
        else if (nbreDeCarte == 1) {
            System.out.println("\nEntrez l'index de la carte a ajouter: ");
            int index = keyboard.nextInt();
            Card carte = partie.getSource().getCartes().remove(index);
            partie.getActivePlayer().getVieFuture().addCard(carte);
        }
        else if (nbreDeCarte == 0) {
            System.out.println("\nVous avez decider de n'ajoutez aucune carte.");
        }
        else {
            System.out.println("\nInvalid nombre de cartes!");
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
        /* Regardez les 03 premieres cartes de la source. Ajoutez en jusqu'a 02 à votre Vie Future.
         * Replacez le reste dans l'ordre souhaité */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'DESTINEE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        if (partie.getSource().getCartes().size() >= 3) {

            System.out.println("•1ere carte de la Source: " + partie.getSource().getCartes().get(0));
            System.out.println("•2eme carte de la Source: " + partie.getSource().getCartes().get(1));
            System.out.println("•3eme carte de la Source: " + partie.getSource().getCartes().get(2));

            System.out.println("\nCombien de ces cartes souhaitez vous ajouter a votre Vie Future? (" +
                    "02 maximum)");

            Random random = new Random();
            int nbreDeCarte = random.nextInt(0, 3);
            System.out.println(nbreDeCarte);

            if (nbreDeCarte == 2) {
                System.out.println("\nEntrez l'index de la 1ere carte a ajouter: (Le plus grand index) ");
                int index1 = random.nextInt(0, 3);
                System.out.println("\nEntrez l'index de la 2eme carte a ajouter: (Le plus petit index) ");
                int index2 = random.nextInt(0, 3);

                if (index1 == index2 && index1 == 0)
                    index2 += 1;
                else if(index1 == index2 && index1 == 2)
                    index2 -= 1;
                else {
                    index1 = Math.max(index1, index2);
                }

                Card carte1 = partie.getSource().getCartes().remove(index1);
                partie.getActivePlayer().getVieFuture().addCard(carte1);


                if (index1 == 0) {
                    Card carte2 = partie.getSource().getCartes().remove(index2 - 1);
                    partie.getActivePlayer().getVieFuture().addCard(carte2);
                }
                else if (index1 == 1 && index2 == 0) {
                    Card carte2 = partie.getSource().getCartes().remove(index2);
                    partie.getActivePlayer().getVieFuture().addCard(carte2);
                }
                else if(index1 == 1 && index2 == 2) {
                    Card carte2 = partie.getSource().getCartes().remove(index2 - 1);
                    partie.getActivePlayer().getVieFuture().addCard(carte2);
                }
                else if(index1 == 2) {
                    Card carte2 = partie.getSource().getCartes().remove(index2);
                    partie.getActivePlayer().getVieFuture().addCard(carte2);
                }
            }
            else if (nbreDeCarte == 1) {
                System.out.println("\nEntrez l'index de la carte a ajouter: ");
                int index = random.nextInt(0, 3);
                Card carte = partie.getSource().getCartes().remove(index);
                partie.getActivePlayer().getVieFuture().addCard(carte);
            }
            else if (nbreDeCarte == 0) {
                System.out.println("\nVous avez decider de n'ajoutez aucune carte.");
            }
            else {
                System.out.println("\nInvalid nombre de cartes!");
            }

        }

        else {
            System.out.println("\nIl n'y a pas assez de cartes dans la Source!\n");
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
