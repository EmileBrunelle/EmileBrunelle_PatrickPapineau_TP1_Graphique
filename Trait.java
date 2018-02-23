package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import java.awt.Color;
import java.awt.Graphics2D;

public class Trait extends Forme {
	private int formeX2, formeY2;

	public Trait(int x1, int y1, Color colorCont, Color colorRem) {
		super(x1, y1, colorCont, colorRem);

	}
	
	public int getX2() {
		return formeX2;
	}

	public void setX2(int x2) {
		this.formeX2 = x2;
	}

	public int getY2() {
		return formeY2;
	}

	public void setY2(int y2) {
		this.formeY2 = y2;
	}

	@Override
	public void setParametres(int x1, int y1, int x2, int y2) {
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
	public void tracer(Graphics2D g) {
		g.setColor(getColorRempli());
		g.setColor(getColorContour());
		g.drawLine(getFormeX1(), getFormeY1(), formeX2, formeY2);
	}

}