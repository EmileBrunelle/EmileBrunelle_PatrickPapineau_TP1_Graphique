package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import java.awt.Color;
import java.awt.Graphics2D;

public class Ovale extends Rectangle {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9088192920033311640L;

	public Ovale(int x1, int y1, Color colorCont, Color colorRem) {
		super(x1, y1, colorCont, colorRem);
	}

	@Override
	public void tracer(Graphics2D g) {
		/*
		 * Cette méthode s'occupe de dessiner l'ovale en appelant les méthodes
		 * spécifiées au point 2.1 de l'énoncé
		 */
		g.setColor(getColorRempli());
		g.fillOval(getFormeX1(), getFormeY1(), getLargeur(), getHauteur());
		g.setColor(getColorContour());
		g.drawOval(getFormeX1(), getFormeY1(), getLargeur(), getHauteur());
	}
}