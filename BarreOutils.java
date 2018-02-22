package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class BarreOutils extends JToolBar {
	private static final long serialVersionUID = 1L;
	PanDessin panneau;

	public BarreOutils(PanDessin panneau) {

		JToggleButton btRouge = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/ROUGE.gif")));
		JToggleButton btVert = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/VERT.gif")));
		JToggleButton btBlanc = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/BLANC.gif")));

		JToggleButton btRBleu = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/BLEU.gif")));
		JToggleButton btRJaune = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/JAUNE.gif")));
		JToggleButton btRNoir = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/NOIR.gif")));

		JToggleButton btRond = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/ROND.gif")));
		JToggleButton btCarre = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/CARRE.gif")));
		JToggleButton btTrait = new JToggleButton(new ImageIcon(BarreOutils.class.getResource("img/TRAIT.gif")));

		btRouge.setSelected(true);
		btRNoir.setSelected(true);
		btTrait.setSelected(true);

		ButtonGroup groupeCouleurs = new ButtonGroup();
		groupeCouleurs.add(btRouge);
		groupeCouleurs.add(btVert);
		groupeCouleurs.add(btBlanc);

		ButtonGroup groupeCouleursRempli = new ButtonGroup();

		groupeCouleursRempli.add(btRBleu);
		groupeCouleursRempli.add(btRJaune);
		groupeCouleursRempli.add(btRNoir);

		ButtonGroup groupeFormes = new ButtonGroup();
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

}