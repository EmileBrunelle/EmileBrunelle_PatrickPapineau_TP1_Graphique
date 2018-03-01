package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BarreMenu extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private JMenu menuFichier, menuAide;
	private JMenuItem nouveau, enregistrer, enregistrersous, ouvrir, quitter, afficherAide, aPropos;
	private PanDessin panneau;

	public BarreMenu(PanDessin panneau) {
		
		this.panneau = panneau;

		// Création du menu couleur
		menuFichier = new JMenu("Fichier");
		menuFichier.setMnemonic(KeyEvent.VK_F);

		nouveau = new JMenuItem("Nouveau");
		nouveau.setMnemonic(KeyEvent.VK_N);
		nouveau.addActionListener(new GestionBarreMenu());
		menuFichier.add(nouveau);

		enregistrer = new JMenuItem("Enregistrer");
		enregistrer.setMnemonic(KeyEvent.VK_E);
		enregistrer.addActionListener(new GestionBarreMenu());
		menuFichier.add(enregistrer);

		enregistrersous = new JMenuItem("Enregistrer-sous");
		enregistrersous.addActionListener(new GestionBarreMenu());
		menuFichier.add(enregistrersous);

		ouvrir = new JMenuItem("Ouvrir");
		ouvrir.setMnemonic(KeyEvent.VK_O);
		ouvrir.addActionListener(new GestionBarreMenu());
		menuFichier.add(ouvrir);

		quitter = new JMenuItem("Quitter");
		quitter.setMnemonic(KeyEvent.VK_Q);
		quitter.addActionListener(new GestionBarreMenu());
		menuFichier.add(quitter);

		add(menuFichier);

		menuAide = new JMenu("?");

		afficherAide = new JMenuItem("Afficher l'aide");
		menuAide.add(afficherAide);

		aPropos = new JMenuItem("A propos de Dessin Vectoriel");
		aPropos.addActionListener(new GestionBarreMenu());
		menuAide.add(aPropos);

		add(menuAide);

	}

	public PanDessin getPanneau() {
		return panneau;
	}

	public void setPanneau(PanDessin panneau) {
		this.panneau = panneau;
	}



	private class GestionBarreMenu implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			String indButton = e.getActionCommand();

			switch (indButton) {
			case "Nouveau":
				nouveau(e);
				break;
			case "Enregistrer":
				enregistrer();
				break;
			case "Enregistrer-sous":
				enregistrerSous();
				break;
			case "Ouvrir":
				ouvrir(e);
				break;
			case "Quitter":
				;
				break;
			case "A propos de Dessin Vectoriel":
				aPropos(e);
				break;

			default:
				System.out.println("Default case");
				break;
			}

		}

		private void nouveau(ActionEvent e) {
			panneau.resetListe();
			panneau.repaint();
			
		}

		private void enregistrer() {
			if (panneau.getNomFichier() != null) {
				ObjectOutputStream enregistrement = null;
				try
		        {
		            enregistrement = new ObjectOutputStream(new FileOutputStream(panneau.getNomFichier()));
		            enregistrement.writeObject(panneau.getListe());
		        } 
		        catch (FileNotFoundException fichierNonTrouve) 
		        {
		        	JOptionPane.showMessageDialog(panneau, "Fichier non trouvé");
		        } 
		        catch (IOException exc) 
		        {
		        	JOptionPane.showMessageDialog(panneau, "Problème d'enregistrement du fichier");
		        } finally {
		        	try {
						enregistrement.close();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(panneau, "Problème d'enregistrement du fichier");
					}
		        }
			} else {
				enregistrerSous();
			}
			
		}

		private void enregistrerSous() {
			JFileChooser sauvegarde = new JFileChooser();
			sauvegarde.setDialogTitle("Enregistrez sous");
			sauvegarde.addChoosableFileFilter(new FileNameExtensionFilter("Fichiers de formes", "formes"));
			
			if (sauvegarde.showSaveDialog(panneau) == JFileChooser.APPROVE_OPTION) {
				panneau.setNomFichier(sauvegarde.getSelectedFile().getAbsolutePath());
				enregistrer();
			}
		}

		private void ouvrir(ActionEvent e) {
			
		}

		private void quitter(ActionEvent e) {

		}

		private void aPropos(ActionEvent e) {
			String Auteurs = "Patrick Papineau et Emile Brunelle";
			JOptionPane.showMessageDialog(null,
					"Auteur : " + Auteurs + "\nNom de l'application : Dessin Vectoriel\nVersion : 1.0");
		}

	}

}