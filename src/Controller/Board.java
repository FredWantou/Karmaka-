package Controller;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Scanner;

import javax.swing.SwingWorker;

import Model.Cards.AnneauKarmique;
import Model.Cards.Card;
import Model.Cards.CardsSpecifiques23.Incarnation;
import Model.Cards.CardsSpecifiques23.Mimetisme;
import Model.Joueur.Joueur;
import Model.Joueur.JoueurReel;
import Model.Joueur.JoueurVirtuel;
import Model.Joueur.Niveau;
import Model.Joueur.OptionDeJeu;
import Model.Partie.EtatDeLaPartie;
import Model.Partie.Partie;
import Model.Partie.TypeDePartie;
import View.CommandeLineView;
import View.View2;

public class Board {
	
	private Partie partie;
	private View2 view;
	Joueur joueur1;
	Joueur joueur2;
	
	public Board(Partie partie,View2 view) {
		this.partie = partie;
		this.view = view;
		
	}
	// ====================================== WHO_STARTS ============================================ //
    public void whoStarts(Joueur joueur1, Joueur joueur2) {
        
            Random random = new Random();

            if (random.nextInt(2) == 0) {
                partie.setActivePlayer(joueur1);
                partie.setOpponentPlayer(joueur2);
            } else {
                partie.setActivePlayer(joueur2);
                partie.setOpponentPlayer(joueur1);
            }

            if (partie.getActivePlayer() instanceof JoueurReel)
                partie.setEtatDeLaPartie(EtatDeLaPartie.JOUEUR_REEL_PLAYING);
            else if(partie.getActivePlayer() instanceof JoueurVirtuel)
                partie.setEtatDeLaPartie(EtatDeLaPartie.CPU_1_PLAYING);

    }
    

   
    
 // ======================================== SET_TYPE_PARTIE ======================================== //
    public void setTypeDePartie(int typeDePartie) {
        if (typeDePartie == 0) {
            partie.setTypeDePartie(TypeDePartie.JOUEUR_REEL_VS_CPU);
        } else if (typeDePartie == 1) {
            partie.setTypeDePartie(TypeDePartie.CPU_VS_CPU);
        }
    }


    // ================================= DISTIBUER_LES_CARTES_DE_LA_MAIN ================================== //
    public void distribuerLesCartesDeLaMain() {
        
            for (int i = 0; i < 4; i++) {
                partie.getListeDeJoueurs().get(0).getMain().addCard(partie.getSource().removeCard());
                partie.getListeDeJoueurs().get(1).getMain().addCard(partie.getSource().removeCard());
            }
        
    }
    
    public void distribuerLesCartesDeLaPile() {
        
            for (int i = 0; i < 2; i++) {
                partie.getListeDeJoueurs().get(0).getPile().addCard(partie.getSource().removeCard());
                partie.getListeDeJoueurs().get(1).getPile().addCard(partie.getSource().removeCard());
            }
        
    }
       

	public void ajouterLesJoueurs(String name) {
	    partie.ajouterJoueurReelVsCPU(new JoueurReel(name));
	}
	

		
	
	public void compterLesPoints(Partie partie) {
        try {

            
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
                        System.out.println("On defausse les oeuvres du "+partie.getActivePlayer().getPseudo());
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
                        System.out.println("On compose la nouvelle main à partir de la vie future  du "+partie.getActivePlayer().getPseudo());
                    }

                    // Creer une nouvelle Pile
                    int tailleDeLaMain = partie.getActivePlayer().getMain().getCartesDeLaMain().size();
                    if (tailleDeLaMain <= 6 ) {
                        while (partie.getActivePlayer().getMain().getCartesDeLaMain().size() +
                        partie.getActivePlayer().getPile().getCartesDeLaPile().size() <= 6) {
                            partie.getActivePlayer().getPile().addCard(partie.getSource().removeCard());
                            System.out.println("On cree une nouvelle pile pour "+partie.getActivePlayer().getPseudo());
                        }
                    }

                    //endTurn();

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

                    //endTurn();

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

                    //endTurn();

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


            

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
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
	
	// ====================================== JOUER ============================================ //

    
    public void setOptionDeJeu(int index) {
        if (index == 0) {
            partie.getActivePlayer().setOptionDeJeu(OptionDeJeu.POUR_SES_POINTS);
        } else if (index == 1) {
            partie.getActivePlayer().setOptionDeJeu(OptionDeJeu.POUR_SON_POUVOIR);
        } else if (index == 2) {
            partie.getActivePlayer().setOptionDeJeu(OptionDeJeu.POUR_LA_VIE_FUTURE);
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
    
    
    
    
    
    
	
    
	
	public void run() {
		// TODO Auto-generated method stub
		ajouterLesJoueurs(view.getJoueur1().getPseudo());
		partie.getListeDeJoueurs().get(0).addObserver(view);
		partie.getListeDeJoueurs().get(1).addObserver(view);
		whoStarts(partie.getListeDeJoueurs().get(0),partie.getListeDeJoueurs().get(1));
		partie.getSource().melanger();
    	partie.getActivePlayer().setNiveau(Niveau.BOUSIER);
    	partie.getOpponentPlayer().setNiveau(Niveau.BOUSIER);
    	distribuerLesCartesDeLaMain();
    	distribuerLesCartesDeLaPile();
    	
    	
    }
    	
	
}
