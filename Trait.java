package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import java.awt.Color;
import java.awt.Graphics;



public class Trait extends Forme{
	private int formeX2, formeY2;
	

	

	public Trait(int x1, int y1, Color colorCont, Color colorRem, int x2, int y2) {
		super(x1, y1, colorCont, colorRem);
		this.formeX2 = x2;
		this.formeY2 = y2;
	}

	@Override
	public void setParametres(int x1, int x2, int y1, int y2) {
		this.setFormeX1(x1);
		this.setFormeY1(y1);
		this.formeX2 = x2;
		this.formeY2 = y2;
		
	}

	public int getFormeX2() {
		return formeX2;
	}

	public void setFormeX2(int formeX2) {
		this.formeX2 = formeX2;
	}

	public int getFormeY2() {
		return formeY2;
	}

	public void setFormeY2(int formeY2) {
		this.formeY2 = formeY2;
	}

	@Override
	public void tracer(Graphics g) {
		// TODO cette méthode s'occupera de dessiner la forme en appelant les méthodes spécifiées au point 2.1
		
	}

}