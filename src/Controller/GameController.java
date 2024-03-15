package Controller;

import Model.Cards.AnneauKarmique;
import Model.Cards.Card;
import Model.Cards.CardsSpecifiques23.Incarnation;
import Model.Cards.CardsSpecifiques23.Mimetisme;
import Model.Cards.CardsSpecifiques23.Sauvetage;
import Model.Joueur.*;
import Model.Partie.EtatDeLaPartie;
import Model.Partie.Partie;
import Model.Partie.TypeDePartie;
import View.GameViewable;

import java.util.Random;
import java.util.Scanner;

/**
 * @author giovannizangue
 * Cette classe correspond au controller de notre jeu
 */
public class GameController {

    // =============================================== LES ATTRIBUTS ======================================== //
    GameViewable view;
    //GameViewable view2;
    Partie partie = Partie.getPartie();

    Scanner keyboard = new Scanner(System.in);
    Random random = new Random();

    // ============================================ LE CONSTRUCTEUR ========================================= //
    public GameController(GameViewable view, Partie partie) {
        this.view = view;
        //this.view2 = view2;
        this.partie = partie;
        view.setController(this);
        //view2.setController(this);
    }


    // =============================================== LES METHODES ========================================== //

    // ================================================= RUN ================================================ //
    public void run() {
        view.promptForTypeDePartie();
        //view2.promptForTypeDePartie();
        if (partie.getTypeDePartie() == TypeDePartie.JOUEUR_REEL_VS_CPU) {

            // CREER LE JOUEUR
            creerLeJoueur();

            // MELANGER LA SOURCE
            melangerLaSource();

            // DISTRIBUER LA MAIN
            distribuerLesCartesDeLaMain();
            afficherListeDesJoueurs();

            // DISTRIBUER LA PILE
            distribuerLesCartesDeLaPile();
            afficherListeDesJoueurs();

            // WHO START
            whoStarts(partie.getListeDeJoueurs().get(0), partie.getListeDeJoueurs().get(1));

            // NEXT ACTION
            while (partie.getEtatDeLaPartie() != EtatDeLaPartie.FINISHED) {
                while (partie.getEtatDeLaPartie() == EtatDeLaPartie.JOUEUR_REEL_PLAYING) {
                    compterLesPoints();
                    piocher();

                    System.out.println("""
                            
                            VOULEZ VOUS JOUER OU BIEN PASSER VOTRE TOUR?
                            •0 = Jouer
                            •1 = Passer""");
                    int reponse = keyboard.nextInt();
                    System.out.println(reponse);
                    if (reponse  == 0) {
                        jouer();
                        endTurn();
                    }
                    else if(reponse == 1) {
                        endTurn();
                    }

                    else
                        System.out.println("Invalid Entry");


                    verifierCartesDeLASource();

                }
                while (partie.getEtatDeLaPartie() == EtatDeLaPartie.CPU_1_PLAYING) {
                    compterLesPoints();
                    piocher();

                    System.out.println("""

                            VOULEZ VOUS JOUER OU BIEN PASSER VOTRE TOUR?
                            •0 = Jouer
                            •1 = Passer""");

                    int reponse = Math.abs(random.nextInt());
                    System.out.println(reponse);
                    if (reponse % 2 == 0) {
                        jouerCPU();
                        endTurn();
                    }
                    else {
                        endTurn();
                    }

                }

            }


        } else if (partie.getTypeDePartie() == TypeDePartie.CPU_VS_CPU) {

            // CREER LE JOUEUR
            creerLeJoueur();

            // MELANGER LA SOURCE
            melangerLaSource();

            // DISTRIBUER LA MAIN
            distribuerLesCartesDeLaMain();
            afficherListeDesJoueurs();

            // DISTRIBUER LA PILE
            distribuerLesCartesDeLaPile();
            afficherListeDesJoueurs();

            // WHO START
            whoStarts(partie.getListeDeJoueurs().get(0), partie.getListeDeJoueurs().get(1));

            // NEXT ACTION
            while (partie.getEtatDeLaPartie() != EtatDeLaPartie.FINISHED) {
                while (partie.getEtatDeLaPartie() == EtatDeLaPartie.CPU_2_PLAYING) {
                    compterLesPoints();
                    piocher();

                    System.out.println("""

                            VOULEZ VOUS JOUER OU BIEN PASSER VOTRE TOUR?
                            •0 = Jouer
                            •1 = Passer""");

                    int reponse = Math.abs(random.nextInt());
                    System.out.println(reponse % 2);
                    if (reponse % 2 == 0) {
                        jouerCPU();
                        endTurn();
                    }
                    else {
                        endTurn();
                    }

                }
                while (partie.getEtatDeLaPartie() == EtatDeLaPartie.CPU_1_PLAYING) {
                    compterLesPoints();
                    piocher();

                    System.out.println("""

                            VOULEZ VOUS JOUER OU BIEN PASSER VOTRE TOUR?
                            •0 = Jouer
                            •1 = Passer""");

                    int reponse = Math.abs(random.nextInt());
                    System.out.println(reponse % 2);
                    if (reponse % 2 == 0) {
                        jouerCPU();
                        endTurn();
                    }
                    else {
                        endTurn();
                    }

                    verifierCartesDeLASource();

                }

            }

        }
    }


    // ======================================== AJOUTER_LES_JOUEURS ======================================== //
    public void ajouterLesJoueurs(String name) {
        partie.ajouterJoueurReelVsCPU(new JoueurReel(name));
    }

    public void afficherListeDesJoueurs() {
        System.out.println(partie.getListeDeJoueurs());
    }

    public void creerLeJoueur() {
        if (partie.getTypeDePartie() == TypeDePartie.JOUEUR_REEL_VS_CPU) {

            while (partie.getEtatDeLaPartie() == EtatDeLaPartie.CREATING) {
                view.promptForNomDuJoueur();
            	//view2.promptForNomDuJoueur();
                System.out.println("\nADDING PLAYERS...\n");
                try {
                    Thread.sleep(1500);
                    partie.setEtatDeLaPartie(EtatDeLaPartie.PLAYERS_ADDED);
                    afficherListeDesJoueurs();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
       else {
            partie.ajouterJoueurCPUvsCPU();
        }
    }

    // ======================================== SET_TYPE_PARTIE ======================================== //
    public void setTypeDePartie(int typeDePartie) {
        if (typeDePartie == 0) {
            partie.setTypeDePartie(TypeDePartie.JOUEUR_REEL_VS_CPU);
        } else if (typeDePartie == 1) {
            partie.setTypeDePartie(TypeDePartie.CPU_VS_CPU);
        }
    }

    // ======================================= MELANGER_LA_SOURCE ======================================== //
    public void melangerLaSource() {
        System.out.println("\nSHUFFLING LA SOURCE...\n");
        try {
            Thread.sleep(1500);
            partie.getSource().melanger();
            System.out.println(partie.getSource());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // ================================= DISTIBUER_LES_CARTES_DE_LA_MAIN ================================== //
    public void distribuerLesCartesDeLaMain() {
        System.out.println("\nDISTRIBUTION DES CARTES DE LA MAIN...\n");
        try {
            Thread.sleep(1500);
            for (int i = 0; i < 4; i++) {
                partie.getListeDeJoueurs().get(0).getMain().addCard(partie.getSource().removeCard());
                partie.getListeDeJoueurs().get(1).getMain().addCard(partie.getSource().removeCard());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // ================================= DISTIBUER_LES_CARTES_DE_LA_PILE ================================== //
    public void distribuerLesCartesDeLaPile() {
        System.out.println("\nDISTRIBUTION DES CARTES DE LA PILE...\n");
        try {
            Thread.sleep(1500);
            for (int i = 0; i < 2; i++) {
                partie.getListeDeJoueurs().get(0).getPile().addCard(partie.getSource().removeCard());
                partie.getListeDeJoueurs().get(1).getPile().addCard(partie.getSource().removeCard());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // ====================================== WHO_STARTS ============================================ //
    public void whoStarts(Joueur joueur1, Joueur joueur2) {
        System.out.println("\nCHOOSING WHO START...\n");
        try {
            Thread.sleep(1500);
            Random random = new Random();

            if (random.nextInt(2) == 0) {
                partie.setActivePlayer(joueur1);
                partie.setOpponentPlayer(joueur2);
            } else {
                partie.setActivePlayer(joueur2);
                partie.setOpponentPlayer(joueur1);
            }

            System.out.println("•ACTIVE PLAYER: " + partie.getActivePlayer());
            System.out.println("•OPPONENT PLAYER: " + partie.getOpponentPlayer());

            if (partie.getActivePlayer() instanceof JoueurReel)
                partie.setEtatDeLaPartie(EtatDeLaPartie.JOUEUR_REEL_PLAYING);
            else if(partie.getActivePlayer() instanceof JoueurVirtuel)
                partie.setEtatDeLaPartie(EtatDeLaPartie.CPU_1_PLAYING);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    // ====================================== NEXT_PLAYER ============================================ //
    public void endTurn() {
        Joueur temp = partie.getActivePlayer();
        partie.setActivePlayer(partie.getOpponentPlayer());
        partie.setOpponentPlayer(temp);

        try {

            if (partie.getTypeDePartie() == TypeDePartie.JOUEUR_REEL_VS_CPU) {
                if (partie.getEtatDeLaPartie() == EtatDeLaPartie.JOUEUR_REEL_PLAYING) {
                    partie.setEtatDeLaPartie(EtatDeLaPartie.CPU_1_PLAYING);
                    System.out.println("\n****************************** C'EST AU TOUR DU CPU DE JOUER! " +
                            "******************************\n");
                    Thread.sleep(3000);
                } else if (partie.getEtatDeLaPartie() == EtatDeLaPartie.CPU_1_PLAYING) {
                    partie.setEtatDeLaPartie(EtatDeLaPartie.JOUEUR_REEL_PLAYING);
                    System.out.println("\n****************************** C'EST A VOTRE TOUR DE JOUER! " +
                            "******************************\n");
                    Thread.sleep(3000);
                }
            }
            else if (partie.getTypeDePartie() == TypeDePartie.CPU_VS_CPU) {
                if (partie.getEtatDeLaPartie() == EtatDeLaPartie.CPU_1_PLAYING) {
                    partie.setEtatDeLaPartie(EtatDeLaPartie.CPU_2_PLAYING);
                    System.out.println("\n****************************** C'EST AU TOUR DU L'AUTRE CPU DE JOUER! " +
                            "******************************\n");
                    Thread.sleep(3000);
                } else if (partie.getEtatDeLaPartie() == EtatDeLaPartie.CPU_2_PLAYING) {
                    partie.setEtatDeLaPartie(EtatDeLaPartie.CPU_1_PLAYING);
                    System.out.println("\n****************************** C'EST AU TOUR DU L'AUTRE CPU DE JOUER! " +
                            "******************************\n");
                    Thread.sleep(3000);
                }
            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ====================================== PIOCHER ============================================ //
    public void piocher() {

        try {
            System.out.println("\nPHASE DE PIOCHE...\n");
            Thread.sleep(1500);

            if (partie.getActivePlayer().getPile().getCartesDeLaPile().isEmpty()) {
                System.out.println("\nVOUS N'AVEZ AUCUNE CARTE DANS VOTRE PILE");
                Thread.sleep(500);
            }
            else {
                System.out.println("\nACTIVE PLAYER PIOCHE UNE CARTE...\n");
                Thread.sleep(1500);
                partie.getActivePlayer().getMain().getCartesDeLaMain().add(
                        partie.getActivePlayer().getPile().removeCard()
                );
                System.out.println(partie.getActivePlayer().getMain().getCartesDeLaMain());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    // ====================================== JOUER ============================================ //

    // ======================== JOUEUR_REEL ======================= //
    public void jouer() {
        // Le joueur peut decider de jouer une carte, ou bien de passer son tour
        // Pour jouer, le Joueur choisit d'abord l'index de la carte a jouer
        // Puis il choisit l'option de jeu (points, pouvoir, vieFuture)

        System.out.println("\nPHASE DE JEU DE ACTIVE PLAYER...\n");
        try {
            Thread.sleep(1500);

            System.out.println(partie.getActivePlayer().getMain().getCartesDeLaMain() + "\n");

            int index = view.promptForIndexDeLaCarteDeLaMainAJouer();
            Card carteAJouer = partie.getActivePlayer().getMain().getCartesDeLaMain().get(index);

            Thread.sleep(1500);

            int index2 = view.promptForOptionDeJeu();
            setOptionDeJeu(index2);
            OptionDeJeu optionDeJeu = partie.getActivePlayer().getOptionDeJeu();
            System.out.println("\nOption de jeu = " + optionDeJeu);

            Thread.sleep(1500);

            partie.getActivePlayer().jouer(carteAJouer, optionDeJeu);
            System.out.println(partie.getActivePlayer());

            System.out.println("\n****************************** ACTIVE PLAYER'S TOUR EST TERMINE! " +
                    "******************************\n");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // ======================== JOUER_REEL ======================= //
    public void jouerCPU() {
        System.out.println("\nPHASE DE JEU DE ACTIVE PLAYER...\n");
        try {
            Thread.sleep(1500);

            System.out.println(partie.getActivePlayer().getMain().getCartesDeLaMain() + "\n");

            if(partie.getActivePlayer().getMain().getCartesDeLaMain().isEmpty())
                System.out.println("\nVous n'avez plus aucune carte dans votre Main\n");

            else {

                System.out.println("\nEntrez l'index de la carte de la main a jouer: ");

                Random random = new Random();
                int index = random.nextInt(0, partie.getActivePlayer().getMain().getCartesDeLaMain().size());

                System.out.println(index);

                Card carteAJouer = partie.getActivePlayer().getMain().getCartesDeLaMain().get(index);

                Thread.sleep(1500);

                System.out.println("""
                    Choisir l'option de jeu:\s
                    •0 = Jouer pour ses points
                    •1 = Jouer pour ses pouvoirs
                    •2 = Jouer pour la vie future""");

                int index2 = random.nextInt(0, 3);

                System.out.println(index2);

                setOptionDeJeu(index2);
                OptionDeJeu optionDeJeu = partie.getActivePlayer().getOptionDeJeu();
                System.out.println("\nOption de jeu = " + optionDeJeu);

                Thread.sleep(1500);

                partie.getActivePlayer().jouer(carteAJouer, optionDeJeu);
                System.out.println(partie.getActivePlayer());

                System.out.println("\n****************************** ACTIVE PLAYER'S TOUR EST TERMINE! ********" +
                        "**********************\n");

            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    // ==================================== SET_OPTION_DE_JEU ==================================== //
    public void setOptionDeJeu(int index) {
        if (index == 0) {
            partie.getActivePlayer().setOptionDeJeu(OptionDeJeu.POUR_SES_POINTS);
        } else if (index == 1) {
            partie.getActivePlayer().setOptionDeJeu(OptionDeJeu.POUR_SON_POUVOIR);
        } else if (index == 2) {
            partie.getActivePlayer().setOptionDeJeu(OptionDeJeu.POUR_LA_VIE_FUTURE);
        }
    }


    // ==================================== COMPTER LES POINTS ==================================== //
    public void compterLesPoints() {
        try {

            if (partie.getActivePlayer().getMain().getCartesDeLaMain().isEmpty() &&
                    partie.getActivePlayer().getPile().getCartesDeLaPile().isEmpty()) {
                int nombreDePointsTotal = partie.getActivePlayer().getOeuvre().CalculerNombreDePoints();
                int nbreDePointsMosaique = 0;
                int nombreDAnneauxKarmiques = partie.getActivePlayer().getReserveDAnneauxKarmique().getReserveDAnneaux().size();

                for (Card carte : partie.getActivePlayer().getOeuvre().getCartesDeLOeuvre()) {
                   if (carte instanceof Incarnation || carte instanceof Mimetisme) {
                       nbreDePointsMosaique += carte.getPoint();
                   }
                }

                if (nombreDePointsTotal + nbreDePointsMosaique + nombreDAnneauxKarmiques >= 4 &&
                partie.getActivePlayer().getNiveau() == Niveau.BOUSIER) {
                    System.out.println("\n🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳 FELICITATION, VOUS ETES MAINTENANT UN SERPENT " +
                            "🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳\n");
                    partie.getActivePlayer().setNiveau(Niveau.SERPENT);

                    // On defausse les Oeuvres
                    int tailleDeLOeuvre = partie.getActivePlayer().getOeuvre().getCartesDeLOeuvre().size();
                    for (int i=0; i<tailleDeLOeuvre; i++) {
                        partie.getActivePlayer().getOeuvre().removeCard();
                    }

                    // Vider la reserve d'anneaux karmique
                    int tailleDeLaReserve = partie.getActivePlayer().getReserveDAnneauxKarmique().getReserveDAnneaux().size();
                    for (int i=0; i<tailleDeLaReserve; i++) {
                        partie.getActivePlayer().getReserveDAnneauxKarmique().getReserveDAnneaux().remove(0);
                    }

                    // On prend toutes les cartes de la Vie Future pour composer une nouvelle main
                    int tailleDeLaVieFuture = partie.getActivePlayer().getVieFuture().getCartesDeLaVieFuture().size();
                    for(int i=0; i<tailleDeLaVieFuture; i++) {
                        partie.getActivePlayer().getMain().addCard(partie.getActivePlayer().getVieFuture().removeCard());
                    }

                    // Creer une nouvelle Pile
                    int tailleDeLaMain = partie.getActivePlayer().getMain().getCartesDeLaMain().size();
                    if (tailleDeLaMain <= 6 ) {
                        while (partie.getActivePlayer().getMain().getCartesDeLaMain().size() +
                        partie.getActivePlayer().getPile().getCartesDeLaPile().size() <= 6) {
                            partie.getActivePlayer().getPile().addCard(partie.getSource().removeCard());
                        }
                    }

                    endTurn();

                }
                else if (nombreDePointsTotal + nbreDePointsMosaique + nombreDAnneauxKarmiques >= 5 &&
                        partie.getActivePlayer().getNiveau() == Niveau.SERPENT) {
                    System.out.println("\n🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳 FELICITATION, VOUS ETES MAINTENANT UN LOUP" +
                            " 🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳\n");
                    partie.getActivePlayer().setNiveau(Niveau.LOUP);

                    // On defausse les Oeuvres
                    int tailleDeLOeuvre = partie.getActivePlayer().getOeuvre().getCartesDeLOeuvre().size();
                    for (int i=0; i<tailleDeLOeuvre; i++) {
                        partie.getActivePlayer().getOeuvre().removeCard();
                    }

                    // Vider la reserve d'anneaux karmique
                    int tailleDeLaReserve = partie.getActivePlayer().getReserveDAnneauxKarmique().getReserveDAnneaux().size();
                    for (int i=0; i<tailleDeLaReserve; i++) {
                        partie.getActivePlayer().getReserveDAnneauxKarmique().getReserveDAnneaux().remove(0);
                    }

                    // On prend toutes les cartes de la Vie Future pour composer une nouvelle main
                    int tailleDeLaVieFuture = partie.getActivePlayer().getVieFuture().getCartesDeLaVieFuture().size();
                    for(int i=0; i<tailleDeLaVieFuture; i++) {
                        partie.getActivePlayer().getMain().addCard(partie.getActivePlayer().getVieFuture().removeCard());
                    }

                    // Creer une nouvelle Pile
                    int tailleDeLaMain = partie.getActivePlayer().getMain().getCartesDeLaMain().size();
                    if (tailleDeLaMain <= 6 ) {
                        while (partie.getActivePlayer().getMain().getCartesDeLaMain().size() +
                                partie.getActivePlayer().getPile().getCartesDeLaPile().size() <= 6) {
                            partie.getActivePlayer().getPile().addCard(partie.getSource().removeCard());
                        }
                    }

                    endTurn();

                }
                else if (nombreDePointsTotal + nbreDePointsMosaique + nombreDAnneauxKarmiques >= 6 &&
                        partie.getActivePlayer().getNiveau() == Niveau.LOUP) {
                    System.out.println("\n🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳 FELICITATION, VOUS ETES MAINTENANT UN PRIMATE " +
                            "🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳\n");
                    partie.getActivePlayer().setNiveau(Niveau.PRIMATE);

                    // On defausse les Oeuvres
                    int tailleDeLOeuvre = partie.getActivePlayer().getOeuvre().getCartesDeLOeuvre().size();
                    for (int i=0; i<tailleDeLOeuvre; i++) {
                        partie.getActivePlayer().getOeuvre().removeCard();
                    }

                    // Vider la reserve d'anneaux karmique
                    int tailleDeLaReserve = partie.getActivePlayer().getReserveDAnneauxKarmique().getReserveDAnneaux().size();
                    for (int i=0; i<tailleDeLaReserve; i++) {
                        partie.getActivePlayer().getReserveDAnneauxKarmique().getReserveDAnneaux().remove(0);
                    }

                    // On prend toutes les cartes de la Vie Future pour composer une nouvelle main
                    int tailleDeLaVieFuture = partie.getActivePlayer().getVieFuture().getCartesDeLaVieFuture().size();
                    for(int i=0; i<tailleDeLaVieFuture; i++) {
                        partie.getActivePlayer().getMain().addCard(partie.getActivePlayer().getVieFuture().removeCard());
                    }

                    // Creer une nouvelle Pile
                    int tailleDeLaMain = partie.getActivePlayer().getMain().getCartesDeLaMain().size();
                    if (tailleDeLaMain <= 6 ) {
                        while (partie.getActivePlayer().getMain().getCartesDeLaMain().size() +
                                partie.getActivePlayer().getPile().getCartesDeLaPile().size() <= 6) {
                            partie.getActivePlayer().getPile().addCard(partie.getSource().removeCard());
                        }
                    }

                    endTurn();

                }
                else if (nombreDePointsTotal + nbreDePointsMosaique + nombreDAnneauxKarmiques >= 7 &&
                        partie.getActivePlayer().getNiveau() == Niveau.PRIMATE) {
                    System.out.println("\n🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳 FELICITATION, VOUS AVEZ ATTEINT LA TRANSCENDANCE " +
                            "🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳\n");
                    partie.getActivePlayer().setNiveau(Niveau.TRANSCENDANCE);

                    int tailleDeLOeuvre = partie.getActivePlayer().getOeuvre().getCartesDeLOeuvre().size();
                    for (int i=0; i<tailleDeLOeuvre; i++) {
                        partie.getActivePlayer().getOeuvre().removeCard();
                    }

                    System.out.println("\n🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆 VOUS AVEZ GAGNE " +
                            "🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆\n");
                    partie.setEtatDeLaPartie(EtatDeLaPartie.FINISHED);
                    System.exit(0);

                }
                else {
                    partie.getActivePlayer().getReserveDAnneauxKarmique().addAnneauKarmique(new AnneauKarmique());
                    partie.getActivePlayer().getMain().addCard(partie.getSource().removeCard());
                }


            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // ==================================== VERIFIER CARTES DE LA SOURCE ==================================== //
    public void verifierCartesDeLASource() {
        try {

            if(partie.getSource().getCartes().size() <= 3) {
                System.out.println("\nRESHUFFLING LA SOURCE...\n");
                Thread.sleep(1500);

                int tailleDeLaFosse = partie.getFosse().getCartes().size();

                for (int i=0; i<tailleDeLaFosse; i++) {
                    partie.getSource().getCartes().add(partie.getFosse().getCartes().remove(0));
                }

                partie.getSource().melanger();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public void determinerLeGagnant() {
        /* */
        view.doSomething();
        view.afficherLeNomDuGagnant();
    }

    public void terminerLaPartie() {
        /* Voulez vous rejouer une nouvelle partie? */
        /* */
        view.promptForTerminerLaPartie();
    }


}
