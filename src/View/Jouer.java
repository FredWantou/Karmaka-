package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jouer extends JFrame {

	private JPanel contentPane;
	private JButton btnJouerPouvoir = new JButton("Jouer Pouvoir");
	private JButton btnJouerOeuvre = new JButton("Jouer Oeuvre");
	private JButton btnJouerFuture = new JButton("Jouer Vie Future");

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jouer frame = new Jouer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Jouer() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//action lorsqu'on choisit de jouer pour le future
		btnJouerPouvoir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnJouerPouvoir.setBounds(130, 61, 120, 23);
		contentPane.add(btnJouerPouvoir);
		
		//action lorsqu'on choisit de jouer dans l'oeuvre
		btnJouerOeuvre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJouerOeuvre.setBounds(130, 111, 120, 23);
		contentPane.add(btnJouerOeuvre);
		
		//action lorsqu'on choisit de jouer pour le future
		btnJouerFuture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJouerFuture.setBounds(130, 167, 120, 23);
		contentPane.add(btnJouerFuture);
	}

}
