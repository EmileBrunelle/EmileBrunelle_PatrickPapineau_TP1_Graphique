package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

abstract class Forme implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5985247140737504336L;
	private int formeX1, formeY1;
	private Color colorContour, colorRempli;

	public Forme(int x1, int y1, Color colorCont, Color colorRem) {
		this.setFormeX1(x1);
		this.formeY1 = y1;
		this.colorContour = colorCont;
		this.colorRempli = colorRem;
	}

	public abstract void setParametres(int x1, int y1, int x2, int y2);

	public abstract void tracer(Graphics2D g);

	public int getFormeX1() {
		return formeX1;
	}

	public int getFormeY1() {
		return formeY1;
	}

	public void setFormeY1(int formeY1) {
		this.formeY1 = formeY1;
	}

	public Color getColorContour() {
		return colorContour;
	}

	public void setColorContour(Color colorContour) {
		this.colorContour = colorContour;
	}

	public Color getColorRempli() {
		return colorRempli;
	}

	public void setColorRempli(Color colorRempli) {
		this.colorRempli = colorRempli;
	}

	public void setFormeX1(int formeX1) {
		this.formeX1 = formeX1;
	}
}