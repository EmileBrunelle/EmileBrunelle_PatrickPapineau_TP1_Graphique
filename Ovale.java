package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import java.awt.Color;
import java.awt.Graphics;

public class Ovale extends Forme{
	private int largeur, hauteur;

	public Ovale(int x1, int y1, Color colorCont, Color colorRem, int largeur, int hauteur) {
		super(x1, y1, colorCont, colorRem);
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	@Override
	public void setParametres(int x1, int x2, int y1, int y2) {
		// TODO Auto-generated method stub
		this.setFormeX1(x1);
		this.setFormeY1(y1);
		this.largeur = x2;
		this.hauteur = y2;
	}

	@Override
	public void tracer(Graphics g) {
		// TODO cette méthode s’occupera de dessiner la forme en appelant les méthodes spécifiées au point 2.1
		
	}
}
