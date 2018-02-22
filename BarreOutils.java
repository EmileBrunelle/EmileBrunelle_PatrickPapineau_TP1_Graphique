package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class BarreOutils extends JToolBar {
	private static final long serialVersionUID = 1L;
	PanDessin panneau;
	private JToggleButton btRouge, btVert, btBlanc, btRBleu, btRJaune, btRNoir, btRond, btCarre, btTrait;
	private ButtonGroup groupeCouleurs, groupeCouleursRempli, groupeFormes;

	public BarreOutils(PanDessin panneau) {
		this.panneau = panneau;

		btRouge = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/ROUGE.gif")));
		btVert = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/VERT.gif")));
		btBlanc = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/BLANC.gif")));

		btRBleu = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/BLEU.gif")));
		btRJaune = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/JAUNE.gif")));
		btRNoir = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/NOIR.gif")));

		btRond = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/ROND.gif")));
		btCarre = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/CARRE.gif")));
		btTrait = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/TRAIT.gif")));

		btRouge.setSelected(true);
		btRNoir.setSelected(true);
		btTrait.setSelected(true);

		groupeCouleurs = new ButtonGroup();
		groupeCouleurs.add(btRouge);
		groupeCouleurs.add(btVert);
		groupeCouleurs.add(btBlanc);

		groupeCouleursRempli = new ButtonGroup();

		groupeCouleursRempli.add(btRBleu);
		groupeCouleursRempli.add(btRJaune);
		groupeCouleursRempli.add(btRNoir);

		groupeFormes = new ButtonGroup();
		groupeFormes.add(btRond);
		groupeFormes.add(btCarre);
		groupeFormes.add(btTrait);

		add(btRouge);
		add(btVert);
		add(btBlanc);
		add(btRBleu);
		add(btRJaune);
		add(btRNoir);

		add(btRond);
		add(btCarre);
		add(btTrait);
	}

	private class gestionForme implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Color colorContour, colorRempli;

			if (e.getSource() == btBlanc)
				colorContour = Color.WHITE;
			else if (e.getSource() == btRouge)
				colorContour = Color.RED;
			else
				colorContour = Color.GREEN;

			if (e.getSource() == btRBleu)
				colorRempli = Color.BLUE;
			else if (e.getSource() == btRJaune)
				colorRempli = Color.YELLOW;
			else
				colorRempli = Color.BLACK;

			panneau.setFg(colorContour);
			panneau.setBg(colorRempli);

			if (e.getSource() == btCarre)
				panneau.setIndiceForme('c');
			else if (e.getSource() == btRond)
				panneau.setIndiceForme('o');
			else
				panneau.setIndiceForme('t');

		}

	}
}