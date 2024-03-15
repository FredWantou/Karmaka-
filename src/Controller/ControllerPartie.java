package Controller;

import java.util.Random;

import Model.Cards.AnneauKarmique;
import Model.Cards.Card;
import Model.Cards.CardsSpecifiques23.Incarnation;
import Model.Cards.CardsSpecifiques23.Mimetisme;
import Model.Joueur.JoueurReel;
import Model.Joueur.JoueurVirtuel;
import Model.Joueur.Niveau;
import Model.Joueur.OptionDeJeu;
import Model.Partie.EtatDeLaPartie;
import Model.Partie.Partie;
import View.View2;

public class ControllerPartie {
	
	public ControllerPartie(Partie partie, View2 view) {
			
		//=========================================  Action du CPU ======================================================
            if(partie.getActivePlayer() == partie.getListeDeJoueurs().get(1)) {
            	
            	//s'il n'a plus de carte dans sa main
            	if(partie.getListeDeJoueurs().get(1).getMain().getCartesDeLaMain().isEmpty() && partie.getListeDeJoueurs().get(1).getPile().getCartesDeLaPile().isEmpty()) {
            		//On compte les points de son oeuvre et il se reincarne
            		compterLesPoints(partie);
            		partie.getListeDeJoueurs().get(1).endTurnCPU(partie);
            	}else {
            		//s'il a tjrs des cartes dans sa main        
                   // partie.getListeDeJoueurs().get(1).piocher();
                    
            				partie.getListeDeJoueurs().get(1).piocher();
                        	//choix de la carte de la main à jouer
                        	System.out.println("==================== phase de jeu cpu ========================");
                            Random random = new Random();
                            int index = random.nextInt(0, partie.getActivePlayer().getMain().getCartesDeLaMain().size());
                           // System.out.println(index);
                            Card carteAJouer = partie.getListeDeJoueurs().get(1).getMain().getCartesDeLaMain().remove(index);
                                                   
         
                            //Choix de l'option de jeu
                            int index2 = random.nextInt(0, 2);
                            System.out.println(index2);
                            if(index2 == 0) {
                            	//((JoueurVirtuel)partie.getListeDeJoueurs().get(1)).jouer(partie.getListeDeJoueurs().get(1).getMain().removeCard(), OptionDeJeu.POUR_SES_POINTS);
                            	((JoueurVirtuel)partie.getListeDeJoueurs().get(1)).jouer(carteAJouer, OptionDeJeu.POUR_SES_POINTS);
                            	System.out.println("cpu a joue"+carteAJouer.getNom()+"pour ses points");
                                partie.getListeDeJoueurs().get(1).endTurnCPU(partie);
                            }else{
                            	//((JoueurVirtuel)partie.getListeDeJoueurs().get(1)).jouer(partie.getListeDeJoueurs().get(1).getMain().removeCard(), OptionDeJeu.POUR_SES_POINTS);
                            	((JoueurVirtuel)partie.getListeDeJoueurs().get(1)).jouer(carteAJouer, OptionDeJeu.POUR_LA_VIE_FUTURE);
                            	System.out.println("cpu a joue "+carteAJouer.getNom()+" pour sa vie future");
                                partie.getListeDeJoueurs().get(1).endTurnCPU(partie);
                            }
                            System.out.println("==================== Fin phase de jeu cpu ========================");
                    
                    /*((JoueurVirtuel)partie.getListeDeJoueurs().get(1)).jouer(partie.getListeDeJoueurs().get(1).getMain().removeCard(), OptionDeJeu.POUR_SES_POINTS);
                    System.out.println("cpu a joue");
                    partie.getListeDeJoueurs().get(1).endTurnCPU(partie);*/
            	}          	           	
          // =====================================  Action du joueur =================================================================
            }else {
            	
            		//Le joueur pioche au cas ou c'est lui qui commence la partie
                	partie.getListeDeJoueurs().get(0).piocher();
            	
            }
        
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
	
}
