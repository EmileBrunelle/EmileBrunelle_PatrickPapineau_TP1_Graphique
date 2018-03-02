package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame {
	private static final long serialVersionUID = 1L;
	PanDessin panneau = new PanDessin();

	public FenetrePrincipale() {
		super("Dessin Vectoriel");
		setSize(400, 350);
		BarreMenu barreMenu = new BarreMenu(panneau);
		setJMenuBar(barreMenu);

		panneau.setBackground(Color.white);
		add(panneau, BorderLayout.CENTER);

		BarreOutils barreOutils = new BarreOutils(panneau);
		add(barreOutils, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void setTitle(String title) {
		this.setTitle(title);
	}

}