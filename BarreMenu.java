package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BarreMenu extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private JMenu menuFichier, menuAide;
	private JMenuItem nouveau, enregistrer, enregistrersous, ouvrir, quitter, afficherAide, aPropos;
	private PanDessin panneau;

	public BarreMenu(PanDessin panneau) {
		
		this.panneau = panneau;

		// Création du menu couleur
		menuFichier = new JMenu("Fichier");
		menuFichier.setMnemonic(KeyEvent.VK_F);

		nouveau = new JMenuItem("Nouveau");
		nouveau.setMnemonic(KeyEvent.VK_N);
		nouveau.addActionListener(new GestionBarreMenu());
		menuFichier.add(nouveau);

		enregistrer = new JMenuItem("Enregistrer");
		enregistrer.setMnemonic(KeyEvent.VK_E);
		enregistrer.addActionListener(new GestionBarreMenu());
		menuFichier.add(enregistrer);

		enregistrersous = new JMenuItem("Enregistrer-sous");
		enregistrersous.addActionListener(new GestionBarreMenu());
		menuFichier.add(enregistrersous);

		ouvrir = new JMenuItem("Ouvrir");
		ouvrir.setMnemonic(KeyEvent.VK_O);
		ouvrir.addActionListener(new GestionBarreMenu());
		menuFichier.add(ouvrir);

		quitter = new JMenuItem("Quitter");
		quitter.setMnemonic(KeyEvent.VK_Q);
		quitter.addActionListener(new GestionBarreMenu());
		menuFichier.add(quitter);

		add(menuFichier);

		menuAide = new JMenu("?");

		afficherAide = new JMenuItem("Afficher l'aide");
		menuAide.add(afficherAide);

		aPropos = new JMenuItem("A propos de Dessin Vectoriel");
		aPropos.addActionListener(new GestionBarreMenu());
		menuAide.add(aPropos);

		add(menuAide);

	}

	public PanDessin getPanneau() {
		return panneau;
	}

	public void setPanneau(PanDessin panneau) {
		this.panneau = panneau;
	}



	private class GestionBarreMenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String indButton = e.getActionCommand();
			System.out.println(indButton);
			switch (indButton) {
			case "Nouveau":
				;
				break;
			case "Enregistrer":
				enregistrer(e);
				break;
			case "Enregistrer-sous":
				enregistrerSous(e);
				break;
			case "Ouvrir":
				;
				break;
			case "Quitter":
				;
				break;
			case "A propos de Dessin Vectoriel":
				;
				break;

			default:
				System.out.println("Default case");
				break;
			}

		}

		private void nouveau(ActionEvent e) {
			
		}

		private void enregistrer(ActionEvent e) {
			PanDessin panDessin = (PanDessin) e.getSource();
			ArrayList<Forme> liste = panDessin.getListe();
			for (Forme forme : liste) {
				System.out.println(forme.toString());
			}
		}

		private void enregistrerSous(ActionEvent e) {

		}
		
		private void ouvrir(ActionEvent e) {

		}
		
		private void quitter(ActionEvent e) {

		}

	}

}