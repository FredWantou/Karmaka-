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
public class Duperie extends Card {

	transient Scanner keyboard = new Scanner(System.in);

    // =========================================== LE CONSTRUCTEUR ========================================= //
    public Duperie() {
        super("Duperie", 3, Couleur.BLEU);
    }


    // ================================================= METHODES ============================================== //

    // =========================================== EXECUTER CAPACITE ========================================= //

    // ================== JOUER REEL ============= //
    @Override
    public void executerCapacite(Partie partie) {
        /* Regardez 03 cartes de la main du rival. Ajoutez en une a votre main */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'DUPERIE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        int nbreDeCartes = partie.getOpponentPlayer().getMain().getCartesDeLaMain().size();

        if (partie.getOpponentPlayer().getMain().getCartesDeLaMain().isEmpty()) {
            System.out.println("OPPONENT PLAYER's Main est vide.");
        }

        else if (nbreDeCartes <= 3) {
            System.out.println("OPPONENT PLAYER's Main: " +
                    partie.getOpponentPlayer().getMain().getCartesDeLaMain());

            System.out.println("\nChoisissez l'index de la carte que vous souhaitez ajouter " +
                    "a votre main: ");
            int index = keyboard.nextInt();
            System.out.println("\nAJOUT DE LA CARTE A VOTRE MAIN...");
            try {
                Thread.sleep(1000);

                Card carteAajouter = partie.getOpponentPlayer().getMain().getCartesDeLaMain().remove(index);
                partie.getActivePlayer().getMain().addCard(carteAajouter);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        else {
            System.out.println("\nOPPONENT PLAYER's Main contient " + nbreDeCartes + " cartes.");

            System.out.println("\nChoisissez l'index de la 1ere carte que vous souhaitez voir: ");
            int index1 = keyboard.nextInt();
            System.out.println("\nChoisissez l'index de la 2eme carte que vous souhaitez voir: ");
            int index2 = keyboard.nextInt();
            System.out.println("\nChoisissez l'index de la 3eme carte que vous souhaitez voir: ");
            int index3 = keyboard.nextInt();

            System.out.println("OPPONENT PLAYER's cartes devoilees de la Main: ");
            System.out.println(partie.getOpponentPlayer().getMain().getCartesDeLaMain().get(index1) +
                    " , " + partie.getOpponentPlayer().getMain().getCartesDeLaMain().get(index2) +
                    " , " + partie.getOpponentPlayer().getMain().getCartesDeLaMain().get(index3));

            System.out.println("\nParmi les cartes devoilee, entrez l'index de la carte que vous" +
                    " souhaitez ajouter a votre main (parmi les index de l'etape precedente): ");
            int indexAajouter = keyboard.nextInt();
            System.out.println("\nAJOUT DE LA CARTE A VOTRE MAIN...");

            try {
                Thread.sleep(1000);

                Card carteAajouter = partie.getOpponentPlayer().getMain().getCartesDeLaMain().remove(indexAajouter);
                partie.getActivePlayer().getMain().addCard(carteAajouter);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
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
        /* Regardez 03 cartes de la main du rival. Ajoutez en une a votre main */
        System.out.println("EXECUTION DE LA CAPACITE DE LA CARTE 'DUPERIE'...\n");

        if (partie.getActivePlayer().getMain().getCartesDeLaMain().contains(this)) {
            int indexOfThis = partie.getActivePlayer().getMain().getCartesDeLaMain().indexOf(this);
            partie.getFosse().addCard(
                    partie.getActivePlayer().getMain().getCartesDeLaMain().remove(indexOfThis)
            );
        }

        Random random = new Random();

        int nbreDeCartes = partie.getOpponentPlayer().getMain().getCartesDeLaMain().size();

        if (partie.getOpponentPlayer().getMain().getCartesDeLaMain().isEmpty()) {
            System.out.println("OPPONENT PLAYER's Main est vide.");
        }

        else if (nbreDeCartes <= 3) {
            System.out.println("OPPONENT PLAYER's Main: " +
                    partie.getOpponentPlayer().getMain().getCartesDeLaMain());

            System.out.println("\nChoisissez l'index de la carte que vous souhaitez ajouter " +
                    "a votre main: ");

            int index = random.nextInt(0, nbreDeCartes);
            System.out.println(index);

            System.out.println("\nAJOUT DE LA CARTE A VOTRE MAIN...");
            try {
                Thread.sleep(1000);

                Card carteAajouter = partie.getOpponentPlayer().getMain().getCartesDeLaMain().remove(index);
                partie.getActivePlayer().getMain().addCard(carteAajouter);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        else {
            System.out.println("\nOPPONENT PLAYER's Main contient " + nbreDeCartes + " cartes.");

            System.out.println("\nChoisissez l'index de la 1ere carte que vous souhaitez voir: ");
            int index1 = random.nextInt(0, nbreDeCartes);
            System.out.println(index1);

            System.out.println("\nChoisissez l'index de la 2eme carte que vous souhaitez voir: ");
            int index2 = random.nextInt(0, nbreDeCartes);
            System.out.println(index2);

            System.out.println("\nChoisissez l'index de la 3eme carte que vous souhaitez voir: ");
            int index3 = random.nextInt(0, nbreDeCartes);
            System.out.println(index3);

            System.out.println("OPPONENT PLAYER's cartes devoilees de la Main: ");
            System.out.println(partie.getOpponentPlayer().getMain().getCartesDeLaMain().get(index1) +
                    " , " + partie.getOpponentPlayer().getMain().getCartesDeLaMain().get(index2) +
                    " , " + partie.getOpponentPlayer().getMain().getCartesDeLaMain().get(index3));

            System.out.println("\nParmi les cartes devoilee, entrez l'index de la carte que vous" +
                    " souhaitez ajouter a votre main (parmi les index de l'etape precedente): ");

            int indexAajouter;

            if (Math.max(index3,Math.max(index1, index2)) == 0)
                 indexAajouter = 0;
            else {
                indexAajouter = random.nextInt(0, Math.max(index3,Math.max(index1, index2)));
            }

            System.out.println(indexAajouter);

            System.out.println("\nAJOUT DE LA CARTE A VOTRE MAIN...");

            try {
                Thread.sleep(1000);

                Card carteAajouter = partie.getOpponentPlayer().getMain().getCartesDeLaMain().remove(indexAajouter);
                partie.getActivePlayer().getMain().addCard(carteAajouter);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
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
