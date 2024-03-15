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
 * Classe de la carte Duperie
 */
public class Recyclage extends Card {

	transient Scanner keyboard = new Scanner(System.in);

    // =========================================== LE CONSTRUCTEUR ========================================= //
    public Recyclage() {
        super("Recyclage", 1, Couleur.VERT);
    }


    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Ajouter a votre Vie Future une des 03 derniers cartes de la Fosses */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'RECYCLAGE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        try {

            if (partie.getFosse().getCartes().isEmpty()) {
                System.out.println("\nLa Fosse est vide");

            } else if (partie.getFosse().getCartes().size() == 1) {
                System.out.println("\n•Derniere carte de la FOSSE: " +
                        partie.getFosse().getCartes().get(partie.getFosse().getCartes().size() -1));

                Card carteAajouter = partie.getFosse().getCartes().remove(partie.getFosse().getCartes().size() -1);

                System.out.println("\nAJOUT DE LA CARTE A VOTRE VIE FUTURE...");
                Thread.sleep(1000);

                partie.getActivePlayer().getVieFuture().addCard(carteAajouter);

            }
            else if (partie.getFosse().getCartes().size() == 2) {
                System.out.println("\n•Derniere carte de la FOSSE (index = 0): " +
                        partie.getFosse().getCartes().get(partie.getFosse().getCartes().size() -1));
                System.out.println("\n•Avant Derniere carte de la FOSSE (index = 1): " +
                        partie.getFosse().getCartes().get(partie.getFosse().getCartes().size() -2));

                System.out.println("\nEntrez l'index de la carte a ajouter a votre Vie Future: ");
                int indexAajouter = keyboard.nextInt();

                if (indexAajouter == 0) {
                    Card carteAajouter = partie.getFosse().getCartes().remove(partie.getFosse().getCartes().size() -1);

                    System.out.println("\nAJOUT DE LA CARTE A VOTRE VIE FUTURE...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getVieFuture().addCard(carteAajouter);
                }

                else if(indexAajouter == 1) {
                    Card carteAajouter = partie.getFosse().getCartes().remove(partie.getFosse().getCartes().size() -2);

                    System.out.println("\nAJOUT DE LA CARTE A VOTRE VIE FUTURE...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getVieFuture().addCard(carteAajouter);
                }

                else {
                    System.out.println("\nInvalid index");

                }

            }
            else {
                System.out.println("\n•Derniere carte de la FOSSE (index = 0): " +
                        partie.getFosse().getCartes().get(partie.getFosse().getCartes().size() -1));
                System.out.println("\n•Avant Derniere carte de la FOSSE (index = 1): " +
                        partie.getFosse().getCartes().get(partie.getFosse().getCartes().size() -2));
                System.out.println("\n•Avant Avant Derniere carte de la FOSSE (index = 2): " +
                        partie.getFosse().getCartes().get(partie.getFosse().getCartes().size() -3));

                System.out.println("\nEntrez l'index de la carte a ajouter a votre Vie Future: ");
                int indexAajouter = keyboard.nextInt();

                if (indexAajouter == 0) {
                    Card carteAajouter = partie.getFosse().getCartes().remove(partie.getFosse().getCartes().size() -1);

                    System.out.println("\nAJOUT DE LA CARTE A VOTRE VIE FUTURE...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getVieFuture().addCard(carteAajouter);
                }

                else if(indexAajouter == 1) {
                    Card carteAajouter = partie.getFosse().getCartes().remove(partie.getFosse().getCartes().size() -2);

                    System.out.println("\nAJOUT DE LA CARTE A VOTRE VIE FUTURE...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getVieFuture().addCard(carteAajouter);
                }

                else if(indexAajouter == 2) {
                    Card carteAajouter = partie.getFosse().getCartes().remove(partie.getFosse().getCartes().size() -3);

                    System.out.println("\nAJOUT DE LA CARTE A VOTRE VIE FUTURE...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getVieFuture().addCard(carteAajouter);
                }

                else {
                    System.out.println("\nInvalid index");

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
        /* Ajouter a votre Vie Future une des 03 derniers cartes de la Fosses */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'RECYCLAGE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        Random random = new Random();

        try {

            if (partie.getFosse().getCartes().isEmpty()) {
                System.out.println("\nLa Fosse est vide");

            } else if (partie.getFosse().getCartes().size() == 1) {
                System.out.println("\n•Derniere carte de la FOSSE: " +
                        partie.getFosse().getCartes().get(partie.getFosse().getCartes().size() -1));

                Card carteAajouter = partie.getFosse().getCartes().remove(partie.getFosse().getCartes().size() -1);

                System.out.println("\nAJOUT DE LA CARTE A VOTRE VIE FUTURE...");
                Thread.sleep(1000);

                partie.getActivePlayer().getVieFuture().addCard(carteAajouter);

            }
            else if (partie.getFosse().getCartes().size() == 2) {
                System.out.println("\n•Derniere carte de la FOSSE (index = 0): " +
                        partie.getFosse().getCartes().get(partie.getFosse().getCartes().size() -1));
                System.out.println("\n•Avant Derniere carte de la FOSSE (index = 1): " +
                        partie.getFosse().getCartes().get(partie.getFosse().getCartes().size() -2));

                System.out.println("\nEntrez l'index de la carte a ajouter a votre Vie Future: ");
                int indexAajouter = random.nextInt(0, 2);
                System.out.println(indexAajouter);

                if (indexAajouter == 0) {
                    Card carteAajouter = partie.getFosse().getCartes().remove(partie.getFosse().getCartes().size() -1);

                    System.out.println("\nAJOUT DE LA CARTE A VOTRE VIE FUTURE...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getVieFuture().addCard(carteAajouter);
                }

                else if(indexAajouter == 1) {
                    Card carteAajouter = partie.getFosse().getCartes().remove(partie.getFosse().getCartes().size() -2);

                    System.out.println("\nAJOUT DE LA CARTE A VOTRE VIE FUTURE...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getVieFuture().addCard(carteAajouter);
                }

                else {
                    System.out.println("\nInvalid index");

                }

            }
            else {
                System.out.println("\n•Derniere carte de la FOSSE (index = 0): " +
                        partie.getFosse().getCartes().get(partie.getFosse().getCartes().size() -1));
                System.out.println("\n•Avant Derniere carte de la FOSSE (index = 1): " +
                        partie.getFosse().getCartes().get(partie.getFosse().getCartes().size() -2));
                System.out.println("\n•Avant Avant Derniere carte de la FOSSE (index = 2): " +
                        partie.getFosse().getCartes().get(partie.getFosse().getCartes().size() -3));

                System.out.println("\nEntrez l'index de la carte a ajouter a votre Vie Future: ");
                int indexAajouter = random.nextInt(0, 3);
                System.out.println(indexAajouter);

                if (indexAajouter == 0) {
                    Card carteAajouter = partie.getFosse().getCartes().remove(partie.getFosse().getCartes().size() -1);

                    System.out.println("\nAJOUT DE LA CARTE A VOTRE VIE FUTURE...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getVieFuture().addCard(carteAajouter);
                }

                else if(indexAajouter == 1) {
                    Card carteAajouter = partie.getFosse().getCartes().remove(partie.getFosse().getCartes().size() -2);

                    System.out.println("\nAJOUT DE LA CARTE A VOTRE VIE FUTURE...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getVieFuture().addCard(carteAajouter);
                }

                else if(indexAajouter == 2) {
                    Card carteAajouter = partie.getFosse().getCartes().remove(partie.getFosse().getCartes().size() -3);

                    System.out.println("\nAJOUT DE LA CARTE A VOTRE VIE FUTURE...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getVieFuture().addCard(carteAajouter);
                }

                else {
                    System.out.println("\nInvalid index");

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
