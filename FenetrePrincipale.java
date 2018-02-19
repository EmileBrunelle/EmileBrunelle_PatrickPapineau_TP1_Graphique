package EmileBrunelle_PatrickPapineau_TP1_Graphique;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetrePrincipale extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel panneau = new JPanel();

	public FenetrePrincipale() {
		super("Dessin Vectoriel");
		setSize(400, 350);
		BarreMenu barreMenu = new BarreMenu();
		setJMenuBar(barreMenu);

		panneau = new JPanel();
		panneau.setBackground(Color.white);
		add(panneau, BorderLayout.CENTER);
		
		BarreOutils barreOutils = new BarreOutils();
		add(barreOutils, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
