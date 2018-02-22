package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Forme{
private int largeur, hauteur;

	public Rectangle(int x1, int y1, Color colorCont, Color colorRem) {
	super(x1, y1, colorCont, colorRem);
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
		this.setFormeX1(x1);
		this.setFormeY1(y1);
		this.largeur = x2;
		this.hauteur = y2;
	}

	@Override
	public void tracer(Graphics g) {
		g.setColor(getColorRempli());
		g.fillRect(getFormeX1(), getFormeY1(), getLargeur(), getHauteur());
		g.setColor(getColorContour());
		g.drawRect(getFormeX1(), getFormeY1(), getLargeur(), getHauteur());
	}

}