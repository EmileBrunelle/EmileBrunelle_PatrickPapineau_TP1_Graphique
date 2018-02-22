package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BarreMenu extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private JMenu menuFichier, menuAide;
	private JMenuItem nouveau, enregistrer, enregistrersous, ouvrir, quitter, afficherAide, aPropos;

	public BarreMenu() {

		// Création du menu couleur
		menuFichier = new JMenu("Fichier");
		menuFichier.setMnemonic(KeyEvent.VK_F);

		nouveau = new JMenuItem("Nouveau");
		nouveau.setMnemonic(KeyEvent.VK_N);
		menuFichier.add(nouveau);

		enregistrer = new JMenuItem("Enregistrer");
		enregistrer.setMnemonic(KeyEvent.VK_E);
		menuFichier.add(enregistrer);

		enregistrersous = new JMenuItem("Enregistrer-sous");
		menuFichier.add(enregistrersous);

		ouvrir = new JMenuItem("Ouvrir");
		ouvrir.setMnemonic(KeyEvent.VK_O);
		menuFichier.add(ouvrir);

		quitter = new JMenuItem("Quitter");
		quitter.setMnemonic(KeyEvent.VK_Q);
		menuFichier.add(quitter);

		add(menuFichier);

		menuAide = new JMenu("?");

		afficherAide = new JMenuItem("Afficher l'aide");
		menuAide.add(afficherAide);

		aPropos = new JMenuItem("À propos de Dessin Vectoriel");
		menuAide.add(aPropos);

		add(menuAide);

	}

}