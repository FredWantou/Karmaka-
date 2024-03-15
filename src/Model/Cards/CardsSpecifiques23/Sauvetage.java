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
 * Classe de la carte Sauvetage
 */
public class Sauvetage extends Card {

	transient Scanner keyboard = new Scanner(System.in);

    // =========================================== LE CONSTRUCTEUR ========================================= //
    public Sauvetage() {
        super("Sauvetage", 2, Couleur.VERT);
    }


    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Ajoutez a votre Main une des 03 dernieres cartes de la Fosse */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'SAUVETAGE'...\n");


        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        try {

            if (partie.getFosse().getCartes().isEmpty()) {
                System.out.println("\nIl n y a aucune carte dans la Fosse!");

            } else {

                if (partie.getFosse().getCartes().size() <= 3) {
                    System.out.println("\nCartes de la Fosse devoilee: " +
                            partie.getFosse().getCartes());

                    System.out.println("\nEntrez l'index de la carte que vous souhaitez ajouter a" +
                            " votre main: ");
                    int indexAajouter = keyboard.nextInt();

                    System.out.println("\nAJOUT DE LA CARTE A VOTRE MAIN...");
                    Thread.sleep(1000);

                    Card carteAajouter = partie.getFosse().getCartes().remove(indexAajouter);
                    partie.getActivePlayer().getMain().addCard(carteAajouter);
                } else {

                    System.out.println("\nCartes de la Fosse devoilee: ");
                    System.out.println(partie.getSource().getCartes().get(partie.getFosse().getCartes().size() - 1));
                    System.out.println(partie.getSource().getCartes().get(partie.getFosse().getCartes().size() - 2));
                    System.out.println(partie.getSource().getCartes().get(partie.getFosse().getCartes().size() - 3));

                    System.out.println("\nEntrez l'index de la carte que vous souhaitez ajouter a" +
                            " votre main: ");
                    int indexAajouter = keyboard.nextInt();

                    System.out.println("\nAJOUT DE LA CARTE A VOTRE MAIN...");
                    Thread.sleep(1000);

                    Card carteAajouter = partie.getFosse().getCartes().remove(partie.getFosse().getCartes().size() - 1 - indexAajouter);
                    partie.getActivePlayer().getMain().addCard(carteAajouter);

                }

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
        /* Ajoutez a votre Main une des 03 dernieres cartes de la Fosse */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'SAUVETAGE'...\n");


        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        Random random = new Random();

        try {

            if (partie.getFosse().getCartes().isEmpty()) {
                System.out.println("\nIl n y a aucune carte dans la Fosse!");

            } else {

                if (partie.getFosse().getCartes().size() <= 3) {
                    System.out.println("\nCartes de la Fosse devoilee: " +
                            partie.getFosse().getCartes());

                    System.out.println("\nEntrez l'index de la carte que vous souhaitez ajouter a" +
                            " votre main: ");

                    int indexAajouter;

                    if (partie.getFosse().getCartes().size() == 1) {
                        indexAajouter = 0;
                        System.out.println(indexAajouter);
                    }
                    else if (partie.getFosse().getCartes().size() == 2) {
                        indexAajouter = random.nextInt(0, 2);
                        System.out.println(indexAajouter);
                    }
                    else {
                        indexAajouter = random.nextInt(0, 3);
                        System.out.println(indexAajouter);
                    }

                    System.out.println("\nAJOUT DE LA CARTE A VOTRE MAIN...");
                    Thread.sleep(1000);

                    Card carteAajouter = partie.getFosse().getCartes().remove(indexAajouter);
                    partie.getActivePlayer().getMain().addCard(carteAajouter);
                } else {

                    System.out.println("\nCartes de la Fosse devoilee: ");
                    System.out.println(partie.getFosse().getCartes().get(partie.getFosse().getCartes().size() - 1));
                    System.out.println(partie.getFosse().getCartes().get(partie.getFosse().getCartes().size() - 2));
                    System.out.println(partie.getFosse().getCartes().get(partie.getFosse().getCartes().size() - 3));

                    System.out.println("\nEntrez l'index de la carte que vous souhaitez ajouter a" +
                            " votre main: ");
                    int indexAajouter = random.nextInt(0, 4);
                    System.out.println(indexAajouter);

                    System.out.println("\nAJOUT DE LA CARTE A VOTRE MAIN...");
                    Thread.sleep(1000);

                    Card carteAajouter = partie.getFosse().getCartes().remove(partie.getFosse().getCartes().size() - indexAajouter -1);
                    partie.getActivePlayer().getMain().addCard(carteAajouter);

                }

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
