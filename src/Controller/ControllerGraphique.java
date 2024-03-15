package Controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Model.Cards.Card;
import Model.Joueur.Joueur;
import Model.Joueur.OptionDeJeu;
import Model.Partie.ChargementPartie;
import Model.Partie.EtatDeLaPartie;
import Model.Partie.Partie;
import View.View2;

public class ControllerGraphique{
	
	//private View2 view;
	
	
	public ControllerGraphique(View2 view, JList<Card> listMain,JList<Card> list_oeuvre, JLabel description,JButton btnPlay,JButton btnReincarnation,JButton btnPasser,JButton btnSauvegarder,JButton btnChargerPartie,Partie partie) {
		//this.view = view;
		
		listMain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Récupérer l'élément sélectionné dans la liste
            	int optionJeu;
            	Card selectedCard =listMain.getSelectedValue();
            	
    
                // Charger l'image correspondante
                if (selectedCard != null) {
                    String imagePath = "/img/Card23/" + selectedCard.getNom() + ".png";
                    ImageIcon icon = new ImageIcon(View2.class.getResource(imagePath));
                    Image img = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    description.setIcon(new ImageIcon(img));
                    
                    //affiche un menu presentant les differentes options de jeu pour une carte
                    Object[] options = {"point","pouvoir","vieFuture"};
					optionJeu = JOptionPane.showOptionDialog(view, "What is your action?",null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,options, options[2]);
					Joueur player = partie.getListeDeJoueurs().get(0);
					//jouer pour les points
					if(optionJeu == 0) {
						
						//player.jouerPourSesPoints(selectedCard, partie);
						player.jouer(selectedCard, OptionDeJeu.POUR_SES_POINTS);
						partie.getListeDeJoueurs().get(0).endTurn(partie);
				        new ControllerPartie(partie,view);
					}
					//jouer pour le pouvoir
					if(optionJeu == 1) {
						player.jouer(selectedCard, OptionDeJeu.POUR_SON_POUVOIR);
						partie.getListeDeJoueurs().get(0).endTurn(partie);
				        new ControllerPartie(partie,view);
					}					
					//jouer pour la vie future
					if(optionJeu == 2) {
						player.jouer(selectedCard, OptionDeJeu.POUR_LA_VIE_FUTURE);
						partie.getListeDeJoueurs().get(0).endTurn(partie);
				        new ControllerPartie(partie,view);
					}
                    //Jouer frame2 = new Jouer();
					//frame2.setVisible(true);
                }
            }
        });
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board b=new Board(partie, view);
				b.run();
				new ControllerPartie(partie, view);
				btnPlay.setVisible(false);
				btnChargerPartie.setVisible(false);
				//System.out.println("Yo c'est moi");
							
			}
		});
		
		
		btnReincarnation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board b =new Board(partie,view);
				b.compterLesPoints(partie);
				btnReincarnation.setVisible(false);
        		partie.getListeDeJoueurs().get(0).endTurn(partie);
        		new ControllerPartie(partie,view);
			}
		});
		
		btnPasser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				partie.getListeDeJoueurs().get(0).endTurn(partie);
		        new ControllerPartie(partie,view);
			}
		});
		
		btnSauvegarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				partie.sauvegarderPartie();
				System.out.println("La partie a ete sauvegarde");
				//new ControllerPartie(partie,view);
			}
		});
		
		btnChargerPartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partie partysaved = ChargementPartie.chargerPartie("Partie.karma");
				Partie newPartie = Partie.getPartie();
	        	newPartie.setActivePlayer(partysaved.getActivePlayer());
	        	newPartie.setOpponentPlayer(partysaved.getOpponentPlayer());
	        	newPartie.setEtatDeLaPartie(partysaved.getEtatDeLaPartie());
	        	newPartie.setTypeDePartie(partysaved.getTypeDePartie());
	        	newPartie.setFosse(partysaved.getFosse());
	        	newPartie.setListeDeJoueurs(partysaved.getListeDeJoueurs());
	        	newPartie.setSource(partysaved.getSource());
				//System.out.println(partysaved.getActivePlayer().getPseudo());
	        	newPartie.getListeDeJoueurs().get(0).addObserver(view);
	    		newPartie.getListeDeJoueurs().get(1).addObserver(view);
				new ControllerPartie(newPartie, view);
				btnChargerPartie.setVisible(false);
				btnPlay.setVisible(false);
			}
		});
		
	}
	
}