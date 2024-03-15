package Model.Cards.CardsSpecifiques23;

import Model.Cards.Card;
import Model.Cards.Couleur;
import Model.Partie.Partie;

import javax.swing.plaf.TableHeaderUI;
import java.util.Random;
import java.util.Scanner;

/**
 * @author giovannizangue
 * @version 1.0
 *
 * <br>
 * Classe de la carte Roulette
 */
public class Roulette extends Card {

	transient Scanner keyboard = new Scanner(System.in);


    // =========================================== LE CONSTRUCTEUR ========================================= //
    public Roulette() {
        super("Roulette", 2, Couleur.ROUGE);
    }


    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Defaussez jusqu'a 02 cartes de votre main. Vous pouvez ensuite puiser a la source autant de cartes + 1 */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'ROULETTE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }


        try {

            System.out.println("\nACTIVE PLAYER's Main: " +
                    partie.getActivePlayer().getMain().getCartesDeLaMain());

            if (partie.getActivePlayer().getMain().getCartesDeLaMain().isEmpty()) {
                System.out.println("\nVous n'avez aucune carte dans la Main.");

            }
            else {

                if (partie.getActivePlayer().getMain().getCartesDeLaMain().size() == 1) {
                    System.out.println("\nLA CARTE DE VOTRE MAIN EST DEFAUSSEE...");
                    Thread.sleep(1000);

                    partie.getFosse().addCard(partie.getActivePlayer().getMain().removeCard());

                    System.out.println("\nVOUS PUISEZ ENSUITE 02 CARTES A LA SOURCE...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());
                    partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());

                }
                else if(partie.getActivePlayer().getMain().getCartesDeLaMain().size() >= 2) {
                    System.out.println("\nCombien de cartes de votre main souhaitez vous defausser?");
                    int nbreDeCartes = keyboard.nextInt();

                    if (nbreDeCartes == 1) {
                        System.out.println("\nEntrez l'index de la carte a defausser: ");
                        int indexAdefausser = keyboard.nextInt();

                        System.out.println("\nLA CARTE DE VOTRE MAIN EST DEFAUSSEE...");
                        Thread.sleep(1000);

                        partie.getFosse().addCard(
                                partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexAdefausser));

                        System.out.println("\nVOUS PUISEZ ENSUITE 02 CARTES A LA SOURCE...");
                        Thread.sleep(1000);

                        partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());
                        partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());

                    }
                    else if (nbreDeCartes == 2) {
                        System.out.println("\nEntrez l'index de la 1ere carte a defausser(le plus grand index): ");
                        int indexAdefausser1 = keyboard.nextInt();
                        System.out.println("\nEntrez l'index de la 2eme carte a defausser(le plus petit index): ");
                        int indexAdefausser2 = keyboard.nextInt();

                        System.out.println("\nLES CARTES DE VOTRE MAIN SONT DEFAUSSEE...");
                        Thread.sleep(1000);

                        partie.getFosse().addCard(
                                partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexAdefausser1));
                        partie.getFosse().addCard(
                                partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexAdefausser2));

                        System.out.println("\nVOUS PUISEZ ENSUITE 03 CARTES A LA SOURCE...");
                        Thread.sleep(1000);

                        partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());
                        partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());
                        partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());

                    }
                    else {
                        System.out.println("\nInvalid nombre de cartes!");
                    }

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
        /* Defaussez jusqu'a 02 cartes de votre main. Vous pouvez ensuite puiser a la source autant de cartes + 1 */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'ROULETTE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        Random random = new Random();


        try {

            System.out.println("\nACTIVE PLAYER's Main: " +
                    partie.getActivePlayer().getMain().getCartesDeLaMain());

            if (partie.getActivePlayer().getMain().getCartesDeLaMain().isEmpty()) {
                System.out.println("\nVous n'avez aucune carte dans la Main.");

            }
            else {

                if (partie.getActivePlayer().getMain().getCartesDeLaMain().size() == 1) {
                    System.out.println("\nLA CARTE DE VOTRE MAIN EST DEFAUSSEE...");
                    Thread.sleep(1000);

                    partie.getFosse().addCard(partie.getActivePlayer().getMain().removeCard());

                    System.out.println("\nVOUS PUISEZ ENSUITE 02 CARTES A LA SOURCE...");
                    Thread.sleep(1000);

                    partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());
                    partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());

                }
                else if(partie.getActivePlayer().getMain().getCartesDeLaMain().size() >= 2) {
                    System.out.println("\nCombien de cartes de votre main souhaitez vous defausser?");
                    int nbreDeCartes = random.nextInt(1, 3);
                    System.out.println(nbreDeCartes);

                    if (nbreDeCartes == 1) {
                        System.out.println("\nEntrez l'index de la carte a defausser: ");
                        int indexAdefausser = random.nextInt(0, partie.getActivePlayer().getMain().getCartesDeLaMain().size());
                        System.out.println(indexAdefausser);

                        System.out.println("\nLA CARTE DE VOTRE MAIN EST DEFAUSSEE...");
                        Thread.sleep(1000);

                        partie.getFosse().addCard(
                                partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexAdefausser));

                        System.out.println("\nVOUS PUISEZ ENSUITE 02 CARTES A LA SOURCE...");
                        Thread.sleep(1000);

                        partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());
                        partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());

                    }
                    else if (nbreDeCartes == 2) {
                        System.out.println("\nEntrez l'index de la 1ere carte a defausser(le plus grand index): ");
                        int indexAdefausser1 = random.nextInt(0, partie.getActivePlayer().getMain().getCartesDeLaMain().size());
                        System.out.println(indexAdefausser1);

                        System.out.println("\nEntrez l'index de la 2eme carte a defausser(le plus petit index): ");
                        int indexAdefausser2 = random.nextInt(0, partie.getActivePlayer().getMain().getCartesDeLaMain().size() - 1);
                        System.out.println(indexAdefausser2);

                        System.out.println("\nLES CARTES DE VOTRE MAIN SONT DEFAUSSEE...");
                        Thread.sleep(1000);

                        partie.getFosse().addCard(
                                partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexAdefausser1));
                        partie.getFosse().addCard(
                                partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexAdefausser2));

                        System.out.println("\nVOUS PUISEZ ENSUITE 03 CARTES A LA SOURCE...");
                        Thread.sleep(1000);

                        partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());
                        partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());
                        partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());

                    }
                    else {
                        System.out.println("\nInvalid nombre de cartes!");
                    }

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
