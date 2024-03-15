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
 * Classe de la carte Jubile
 */
public class Jubile extends Card {

	transient Scanner keyboard = new Scanner(System.in);

    // =========================================== LE CONSTRUCTEUR ======================================= //
    public Jubile() {
        super("Jubile", 3, Couleur.VERT);
    }


    // ================================================= METHODES ========================================== //

    // =========================================== EXECUTER CAPACITE ======================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Placez jusqu'a 02 cartes de votre main sur vos Oeuvres */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'JUBILE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        System.out.println("\nCombien de cartes de votre main souhaitez vous placer dans vos Oeuvres? ");
        int nbreDeCartes = keyboard.nextInt();

        try{

            if(partie.getActivePlayer().getMain().getCartesDeLaMain().isEmpty()) {
                System.out.println("\nVous n'avez aucune carte dans votre main!");
            }

            else {
                System.out.println("\nACTIVE PLAYER's Main: " +
                        partie.getActivePlayer().getMain().getCartesDeLaMain());

                if (nbreDeCartes == 1) {
                    System.out.println("\nEntrez l'index de la carte que vous souhaitez placer" +
                            " dans vos Oeuvres: ");
                    int index = keyboard.nextInt();
                    Card carteAajouter = partie.getActivePlayer().getMain().getCartesDeLaMain().remove(index);

                    System.out.println("\nAJOUT DE LA CARTE DANS VOS OEUVRES...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getOeuvre().addCard(carteAajouter);
                }

                else if(nbreDeCartes == 2 && partie.getActivePlayer().getMain().getCartesDeLaMain().size() == 1)
                    System.out.println("\nVous n'avez qu'une seule carte dans votre main!");

                else if (nbreDeCartes == 2 && partie.getActivePlayer().getMain().getCartesDeLaMain().size() >= 2) {
                    System.out.println("\nEntrez l'index dee la 1ere carte que vous souhaitez placer" +
                            " dans vos Oeuvres: ");
                    int index1 = keyboard.nextInt();
                    System.out.println("\nEntrez l'index de la 2eme carte que vous souhaitez placer " +
                            "dans vos Oeuvres: ");
                    int index2 = keyboard.nextInt();

                    Card carteAajouter1 = partie.getActivePlayer().getMain().getCartesDeLaMain().remove(index1);
                    Card carteAajouter2 = partie.getActivePlayer().getMain().getCartesDeLaMain().remove(index2);

                    System.out.println("\nAJOUT DES CARTES DANS VOS OEUVRES...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getOeuvre().addCard(carteAajouter1);
                    partie.getActivePlayer().getOeuvre().addCard(carteAajouter2);
                }

                else {
                    System.out.println("\nInvalid nombre de carte!");
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
        /* Placez jusqu'a 02 cartes de votre main sur vos Oeuvres */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'JUBILE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        Random random = new Random();

        System.out.println("\nCombien de cartes de votre main souhaitez vous placer dans vos Oeuvres? ");
        int nbreDeCartes = random.nextInt(0, 2);
        System.out.println(nbreDeCartes);

        try{

            if(partie.getActivePlayer().getMain().getCartesDeLaMain().isEmpty()) {
                System.out.println("\nVous n'avez aucune carte dans votre main!");
            }

            else {
                System.out.println("\nACTIVE PLAYER's Main: " +
                        partie.getActivePlayer().getMain().getCartesDeLaMain());

                if (nbreDeCartes == 1) {
                    System.out.println("\nEntrez l'index de la carte que vous souhaitez placer" +
                            " dans vos Oeuvres: ");
                    int index = random.nextInt(0, partie.getActivePlayer().getMain().getCartesDeLaMain().size());
                    System.out.println(index);

                    Card carteAajouter = partie.getActivePlayer().getMain().getCartesDeLaMain().remove(index);

                    System.out.println("\nAJOUT DE LA CARTE DANS VOS OEUVRES...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getOeuvre().addCard(carteAajouter);
                }

                else if(nbreDeCartes == 2 && partie.getActivePlayer().getMain().getCartesDeLaMain().size() == 1)
                    System.out.println("\nVous n'avez qu'une seule carte dans votre main!");

                else if (nbreDeCartes == 2 && partie.getActivePlayer().getMain().getCartesDeLaMain().size() >= 2) {
                    System.out.println("\nEntrez l'index dee la 1ere carte que vous souhaitez placer" +
                            " dans vos Oeuvres: ");
                    int index1 = random.nextInt(0, partie.getActivePlayer().getMain().getCartesDeLaMain().size());
                    System.out.println(index1);

                    System.out.println("\nEntrez l'index de la 2eme carte que vous souhaitez placer " +
                            "dans vos Oeuvres: ");
                    int index2 = random.nextInt(0, partie.getActivePlayer().getMain().getCartesDeLaMain().size()- 1);
                    System.out.println(index2);

                    Card carteAajouter1 = partie.getActivePlayer().getMain().getCartesDeLaMain().remove(index1);
                    Card carteAajouter2 = partie.getActivePlayer().getMain().getCartesDeLaMain().remove(index2);

                    System.out.println("\nAJOUT DES CARTES DANS VOS OEUVRES...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getOeuvre().addCard(carteAajouter1);
                    partie.getActivePlayer().getOeuvre().addCard(carteAajouter2);
                }

                else {
                    System.out.println("\nInvalid nombre de carte!");
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
