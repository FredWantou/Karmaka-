package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

import Controller.Board;
import Controller.ControllerGraphique;
import Controller.ControllerPartie;
import Controller.GameController;
import Model.Cards.Card;
import Model.Cards.CardsSpecifiques23.CoupDOeil;
import Model.Cards.CardsSpecifiques23.Panique;
import Model.Cards.CardsSpecifiques23.Recyclage;
import Model.Cards.CardsSpecifiques23.Sauvetage;
import Model.Joueur.Joueur;
import Model.Joueur.JoueurReel;
import Model.Partie.Partie;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JTextArea;

public class View2 extends JFrame implements Observer{

	private JTextArea textArea;
	private int optionJeu;
	private Joueur joueur1;
	private Partie partie;
	JLabel labelPlayerName;
	JLabel labelNiveau_1;
	JLabel description;
	JPanel panelDescription;
	public DefaultListModel<Card> model1;
	public JList<Card> listMain;
	public DefaultListModel<Card> model2;
	public JList<Card> list_oeuvre;
	public DefaultListModel<Card> model3;
	public JList<Card> list_VieFuture;
	ControllerGraphique controller;
	private JButton btnPlay;
	private JButton btnReincarnation;
	private JLabel labelDeroulement;
	private JButton btnPasser;
	private JButton btnSauvegarder;
	private JButton btnChargerPartie;
	
	public void setController(ControllerGraphique gameController) {
        this.controller = gameController;
    }
	
	public Joueur getJoueur1() {
		return this.joueur1;
	}
	
	//================================================== Main de l'application en vue graphique =================================================
	
	public static void main(String[] args) {
					
					//================================ ouverture de la page d'accueil pour choix d type de partie =========================
					//frame de la page d'accueil
					JFrame accueil= new JFrame();
						accueil.setVisible(true);
						JButton boutonPlayerCpu = new JButton("player vs cpu");
						JButton boutonCpuCpu = new JButton("CPU vs CPU");
						accueil.setBounds(100, 100, 642, 402);
						accueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						accueil.getContentPane().setLayout(null);
						
						
						boutonPlayerCpu.setBackground(Color.LIGHT_GRAY);
						boutonPlayerCpu.setBounds(243, 138, 118, 23);
						accueil.getContentPane().add(boutonPlayerCpu);
						
						
						boutonCpuCpu.setBackground(Color.LIGHT_GRAY);
						boutonCpuCpu.setBounds(243, 186, 118, 23);
						accueil.getContentPane().add(boutonCpuCpu);
						
						JLabel labelTitreAccueil = new JLabel("Choose the type for the partie");
						labelTitreAccueil.setFont(new Font("Tahoma", Font.PLAIN, 16));
						labelTitreAccueil.setBounds(198, 65, 362, 40);
						accueil.getContentPane().add(labelTitreAccueil);
						
						JLabel labelAccueil = new JLabel("");
						labelAccueil.setForeground(Color.WHITE);
						
						labelAccueil.setIcon(new ImageIcon("C:\\Users\\fredd\\Documents\\KarmakaFullProject\\src\\img\\accueil.jpg"));
						labelAccueil.setBounds(0, 0, 626, 363);
						accueil.getContentPane().add(labelAccueil);
					
					//=================================== Player VS CPU ====================================================
						//ce qui se passe lorsqu'on choisit player vs cpu
						boutonPlayerCpu.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								//ouverture du frame d'ajout des noms de joueurs
								
								//on cache le frame accueil et ouvre le frame pour remplir les noms
								accueil.setVisible(false);
								JFrame playerName = new JFrame();
								JTextField textFieldName = new JTextField();
									playerName.setVisible(true);
									playerName.setBounds(100, 100, 626, 363);
									playerName.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									playerName.getContentPane().setLayout(null);
									
							
									textFieldName.setBounds(178, 108, 206, 27);
									playerName.getContentPane().add(textFieldName);
									textFieldName.setColumns(10);
									
									JLabel labelName = new JLabel("Player Name");
									labelName.setFont(new Font("Tahoma", Font.PLAIN, 13));
									labelName.setBounds(78, 107, 100, 27);
									playerName.getContentPane().add(labelName);
									
									JButton boutonPlay = new JButton("Play");
									boutonPlay.setBounds(225, 167, 89, 23);
									playerName.getContentPane().add(boutonPlay);
									JLabel lblNewLabel = new JLabel("");
									lblNewLabel.setIcon(new ImageIcon("C:\\Users\\fredd\\Documents\\KarmakaFullProject\\src\\img\\accueil.jpg"));
									lblNewLabel.setBounds(0, 0, 626, 363);
									playerName.getContentPane().add(lblNewLabel);
									
									// ce qui se passe quand on lance le bouton play
									boutonPlay.addActionListener(new ActionListener() {	
										@Override									
										public void actionPerformed(ActionEvent e) {
											if(textFieldName.getText().length() == 0){
												JOptionPane.showMessageDialog(playerName, "All Fields Are Required");
											}else {
												playerName.setVisible(false);
												try {
													View2 window = new View2(new JoueurReel(textFieldName.getText()),Partie.getPartie());
													
													
												} catch (Exception e2) {
													// TODO: handle exception
												}
												
											}
										}
									});
									
									
							}
						});
						
						
						//===========================ce qui se passe lorsqu'on choisit cpu vs cpu
						boutonCpuCpu.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								int typeDePartie = 1;
							}
						});			
		

	}

	/**
	 * Create the application.
	 */
	
	public  View2(Joueur j, Partie partie) {
		super();
		getContentPane().setBackground(Color.CYAN);
		this.partie = partie;
		joueur1 = j;
		this.setVisible(true);
		this.setBounds(100, 100, 1207, 779);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		labelPlayerName = new JLabel(joueur1.getPseudo());
		labelPlayerName.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		labelPlayerName.setBackground(UIManager.getColor("Button.background"));
		labelPlayerName.setHorizontalAlignment(SwingConstants.LEFT);
		labelPlayerName.setBounds(189, 37, 140, 44);
		this.getContentPane().add(labelPlayerName);
		
		JLabel lblPlayername = new JLabel("playerName:");
		lblPlayername.setForeground(Color.BLACK);
		lblPlayername.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayername.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblPlayername.setBackground(UIManager.getColor("Button.highlight"));
		lblPlayername.setBounds(10, 37, 229, 44);
		this.getContentPane().add(lblPlayername);
		
		JLabel labelNiveau = new JLabel("Niveau:");
		labelNiveau.setForeground(Color.BLACK);
		labelNiveau.setHorizontalAlignment(SwingConstants.CENTER);
		labelNiveau.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		labelNiveau.setBounds(395, 49, 98, 20);
		this.getContentPane().add(labelNiveau);
		
		labelNiveau_1 = new JLabel("Niveau");
		labelNiveau_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelNiveau_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		labelNiveau_1.setBounds(503, 49, 98, 20);
		this.getContentPane().add(labelNiveau_1);
		
		//============================================== Description de la carte  ========================================
		panelDescription = new JPanel();
		panelDescription.setBackground(Color.CYAN);
		panelDescription.setBounds(549, 108, 285, 346);
		this.getContentPane().add(panelDescription);
		panelDescription.setLayout(null);
		
		description = new JLabel();
		description.setBounds(0, 11, 264, 340);
		panelDescription.add(description);
		
		
		// =========================================== image par defaut de la description =====================================
		// Charger l'image
        ImageIcon icon = new ImageIcon(View2.class.getResource("/img/Card23/CoupDOeil.png"));

        // Redimensionner l'image
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
                   
        // Appliquer l'image redimensionnée à votre label
        description.setIcon(new ImageIcon(newImg));
		
		//JList list = new JList();
        model1 = new DefaultListModel<Card>();
		listMain = new JList<Card>();
		listMain.setModel(model1);
		listMain.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listMain.setBounds(54, 139, 207, 195);
		this.getContentPane().add(listMain);
		
		model2 = new DefaultListModel<Card>();
		list_oeuvre = new JList<Card>();
		list_oeuvre.setModel(model2);
		list_oeuvre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list_oeuvre.setBounds(305, 139, 207, 195);
		this.getContentPane().add(list_oeuvre);
		
		model3 = new DefaultListModel<Card>();
		list_VieFuture = new JList<Card>();
		list_VieFuture.setModel(model3);
		list_VieFuture.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list_VieFuture.setBounds(54, 381, 207, 195);
		this.getContentPane().add(list_VieFuture);
		
		
		
		
		JLabel labelMain = new JLabel("Main");
		labelMain.setHorizontalAlignment(SwingConstants.CENTER);
		labelMain.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		labelMain.setBounds(33, 108, 98, 20);
		this.getContentPane().add(labelMain);
		
		JLabel labelOeuvre = new JLabel("Oeuvre");
		labelOeuvre.setHorizontalAlignment(SwingConstants.CENTER);
		labelOeuvre.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		labelOeuvre.setBounds(288, 108, 98, 20);
		this.getContentPane().add(labelOeuvre);
		
		JLabel labelVieFuture = new JLabel("Vie Future");
		labelVieFuture.setHorizontalAlignment(SwingConstants.CENTER);
		labelVieFuture.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		labelVieFuture.setBounds(54, 350, 98, 20);
		this.getContentPane().add(labelVieFuture);
		
		JLabel lblCpu = new JLabel("CPU");
		lblCpu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpu.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblCpu.setBackground(Color.WHITE);
		lblCpu.setBounds(902, 37, 229, 44);
		this.getContentPane().add(lblCpu);
		
		textArea = new JTextArea();
		textArea.setBounds(882, 111, 285, 259);
		this.getContentPane().add(textArea);
		textArea.setColumns(10);
		
		btnPlay = new JButton("PLAY");		
		btnPlay.setBounds(628, 492, 89, 23);
		getContentPane().add(btnPlay);
		
		btnReincarnation = new JButton("reincarnation");
		btnReincarnation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReincarnation.setBounds(356, 473, 89, 23);
		getContentPane().add(btnReincarnation);
		btnReincarnation.setVisible(false);
		
		labelDeroulement = new JLabel("");
		labelDeroulement.setHorizontalAlignment(SwingConstants.CENTER);
		labelDeroulement.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		labelDeroulement.setBounds(549, 114, 152, 20);
		getContentPane().add(labelDeroulement);
		
		btnPasser = new JButton("passer");
		
		btnPasser.setBounds(356, 431, 89, 23);
		getContentPane().add(btnPasser);
		
		btnSauvegarder = new JButton("Sauvegarder");
		
		btnSauvegarder.setBounds(958, 492, 89, 23);
		getContentPane().add(btnSauvegarder);
		
		btnChargerPartie = new JButton("Charger Partie");
		
		btnChargerPartie.setBounds(628, 544, 89, 23);
		getContentPane().add(btnChargerPartie);
		
		new ControllerGraphique(this, listMain, list_oeuvre, description,btnPlay,btnReincarnation,btnPasser,btnSauvegarder,btnChargerPartie,partie);
		
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		//textAreaDerou.setText("Tour "+partie.getActivePlayer().getPseudo());
		if (o instanceof Joueur) {
	        
	        	if(Partie.getPartie().getListeDeJoueurs().get(0).getMain().getCartesDeLaMain().isEmpty() && Partie.getPartie().getListeDeJoueurs().get(0).getPile().getCartesDeLaPile().isEmpty()) {
	        		btnReincarnation.setVisible(true);
	        	}
	        	labelPlayerName.setText(partie.getListeDeJoueurs().get(0).getPseudo());
	            labelNiveau_1.setText(partie.getListeDeJoueurs().get(0).getNiveau().toString());
	            model1.clear();
	            model1.addAll(partie.getListeDeJoueurs().get(0).getMain().getCartesDeLaMain());
	            model2.clear();
	            model2.addAll(Partie.getPartie().getListeDeJoueurs().get(0).getOeuvre().getCartesDeLOeuvre());
	            model3.clear();
	            model3.addAll(Partie.getPartie().getListeDeJoueurs().get(0).getVieFuture().getCartesDeLaVieFuture());
	        	textArea.setText("Joueur Virtuel\n"+( Partie.getPartie().getListeDeJoueurs().get(1).getMain().toString())+"\n"+partie.getListeDeJoueurs().get(1).getOeuvre().toString()+"\n"+partie.getListeDeJoueurs().get(1).getVieFuture().toString()+"\n Niveau:"+partie.getListeDeJoueurs().get(1).getNiveau());

	        } 
	    
	}

	
}
