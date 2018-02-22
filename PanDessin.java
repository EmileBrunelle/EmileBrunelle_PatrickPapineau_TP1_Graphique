package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanDessin extends JPanel {
	private static final long serialVersionUID = 1L;
	Forme formeCourant;
	Color Fg, Bg;
	ArrayList<Forme> liste = new ArrayList<Forme>();
	
	MouseEvent premierClick;
	
	
	
	
	
	public PanDessin() {
		super();
		// TODO Auto-generated constructor stub
		addMouseListener(new MouvementSourisListener());
		addMouseMotionListener(new MouvementSourisListener());
	}

	
	



	private class MouvementSourisListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			premierClick = e;
			// TODO Auto-generated method stub
			formeCourant = new Rectangle(e.getX(), e.getY(), Fg, Bg);
			liste.add(formeCourant);
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			formeCourant.setParametres(premierClick.getX(), premierClick.getY(), e.getX(), e.getY());
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
}
