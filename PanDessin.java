package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.ArrayList;

import javax.swing.JPanel;

public class PanDessin extends JPanel {
	private static final long serialVersionUID = 1L;
	private Forme formeCourant;
	private Color Fg = Color.RED, Bg = Color.BLACK;
	private ArrayList<Forme> liste = new ArrayList<Forme>();
	private char indiceForme = 't';
	private String nomFichier = null;

	public char getIndiceForme() {
		return indiceForme;
	}

	public void setIndiceForme(char indiceForme) {
		this.indiceForme = indiceForme;
	}
	
	public String getNomFichier() {
		return nomFichier;
	}
	
	public void nomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}

	MouseEvent premierClick;

	public PanDessin() {
		super();
		addMouseListener(new MouvementSourisListener());
		addMouseMotionListener(new MouvementSourisListener());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (Forme forme : liste) {
			forme.tracer(g2);
		}
	}

	public void setFormeCourant(Forme formeCourant) {
		this.formeCourant = formeCourant;
	}

	public void setFg(Color fg) {
		Fg = fg;
	}

	public void setBg(Color bg) {
		Bg = bg;
	}

	public Color getFg() {
		return Fg;
	}

	public Color getBg() {
		return Bg;
	}

	public void setListe(ArrayList<Forme> liste) {
		this.liste = liste;
	}
	
	public ArrayList<Forme> getListe() {
		return liste;
	}

	public void setPremierClick(MouseEvent premierClick) {
		this.premierClick = premierClick;
	}

	private class MouvementSourisListener implements MouseListener, MouseMotionListener {

		@Override
		public void mousePressed(MouseEvent e) {
			premierClick = e;
			if (indiceForme == 't') {
				formeCourant = new Trait(e.getX(), e.getY(), Fg, Bg);
			} else if (indiceForme == 'c') {
				formeCourant = new Rectangle(e.getX(), e.getY(), Fg, Bg);
			} else if (indiceForme == 'o') {
				formeCourant = new Ovale(e.getX(), e.getY(), Fg, Bg);
			}
			liste.add(formeCourant);

		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			formeCourant.setParametres(premierClick.getX(), premierClick.getY(), e.getX(), e.getY());
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

	}
}