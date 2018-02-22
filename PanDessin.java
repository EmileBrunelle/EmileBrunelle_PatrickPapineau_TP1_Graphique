package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.ArrayList;

import javax.swing.JPanel;

public class PanDessin extends JPanel {
	private static final long serialVersionUID = 1L;
	Forme formeCourant;
	Color Fg=Color.BLUE, Bg=Color.CYAN;
	ArrayList<Forme> liste = new ArrayList<Forme>();

	MouseEvent premierClick;

	public PanDessin() {
		super();
		addMouseListener(new MouvementSourisListener());
		addMouseMotionListener(new MouvementSourisListener());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Forme forme : liste) {
			forme.tracer(g);
		}
	}

	private class MouvementSourisListener implements MouseListener, MouseMotionListener {

		@Override
		public void mousePressed(MouseEvent e) {
			premierClick = e;
			formeCourant = new Rectangle(e.getX(), e.getY(), Fg, Bg);
			liste.add(formeCourant);

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			formeCourant.setParametres(premierClick.getX(), premierClick.getY(), e.getX(), e.getY());
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
}