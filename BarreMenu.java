package EmileBrunelle_PatrickPapineau_TP1_Graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
	private JMenuItem nouveau, enregistrer, enregistrersous, ouvrir, quitter,
			afficherAide, aPropos;
	private PanDessin panneau, panneauTemp;

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
				nouveau();
				break;
			case "Enregistrer":
				enregistrer();
				break;
			case "Enregistrer-sous":
				enregistrerSous();
				break;
			case "Ouvrir":
				try {
					ouvrir();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "Quitter":
				quitter();
				break;
			case "A propos de Dessin Vectoriel":
				aPropos();
				break;

			default:
				System.out.println("Default case");
				break;
			}

		}

		private void nouveau() {
			if (panneau != panneauTemp && panneau.getListe().size() != 0) {
				int choix = JOptionPane.showConfirmDialog(null,
						"Voulez-vous sauvegarder vos changement ?");
				if (choix == 0) {
					enregistrer();
				} else if (choix == 1) {
					panneau.resetListe();
					panneau.repaint();
				}
			} else {
				panneau.resetListe();
				panneau.repaint();
			}

		}

		private void enregistrer() {
			if (panneau.getNomFichier() != null) {
				ObjectOutputStream enregistrement = null;
				try {
					enregistrement = new ObjectOutputStream(
							new FileOutputStream(panneau.getNomFichier()));
					enregistrement.writeObject(panneau.getListe());
					panneauTemp = panneau;
				} catch (FileNotFoundException fichierNonTrouve) {
					JOptionPane.showMessageDialog(panneau,
							"Fichier non trouvé");
				} catch (IOException exc) {
					JOptionPane.showMessageDialog(panneau,
							"Problème d'enregistrement du fichier");
				} finally {
					try {
						enregistrement.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				enregistrerSous();
			}

		}

		private void enregistrerSous() {
			JFileChooser sauvegarde = new JFileChooser();
			sauvegarde.setDialogTitle("Enregistrez sous");
			sauvegarde.addChoosableFileFilter(new FileNameExtensionFilter(
					"Fichiers de formes", "formes"));

			if (sauvegarde.showSaveDialog(panneau) == JFileChooser.APPROVE_OPTION) {
				panneau.setNomFichier(sauvegarde.getSelectedFile()
						.getAbsolutePath());
				enregistrer();
			}
		}

		private void ouvrir() throws ClassNotFoundException {
			if (panneau != panneauTemp && panneau.getListe().size() != 0) {
				int choix = JOptionPane.showConfirmDialog(null,
						"Voulez-vous sauvegarder vos changement ?");
				if (choix == 0) {
					enregistrer();
				} else if (choix == 1) {
					ouvrirFichier();
				}
			} else {
				ouvrirFichier();
			}
		}

		private void ouvrirFichier() throws ClassNotFoundException {
			JFileChooser choixFichier = new JFileChooser();
			if (choixFichier.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File file = choixFichier.getSelectedFile();
				try (FileInputStream fileObject = new FileInputStream(file)) {
					ObjectInputStream objectCourant = new ObjectInputStream(
							fileObject);
					ArrayList<Forme> liste;
					liste = (ArrayList) objectCourant.readObject();
					panneau.setListe(liste);
					panneau.repaint();
					// Cette ligne de commande ne marche pas parce que
					// ma FenetrePrincipale n'est pas internet.
					// FenetrePrincipale.this.setTitle(choixFichier.getSelectedFile().getName());
					objectCourant.close();
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(choixFichier,
							"Fichier non trouv\u00E9");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(choixFichier,
							"Probl\u00E9me de lecture du fichier");
				}
			}
		}

		private void quitter() {
			if (panneau != panneauTemp && panneau.getListe().size() != 0) {
				// TODO Ajouter confirmation pour quitter et enregistrer
				int choix = JOptionPane.showConfirmDialog(null,
						"Voulez-vous sauvegarder vos changement ?");
				if (choix == 0) {
					enregistrer();
				} else if (choix == 1) {
					System.exit(0);
				}
			} else {
				System.exit(0);
			}
		}

		private void aPropos() {
			String Auteurs = "Patrick Papineau et Emile Brunelle";
			JOptionPane
					.showMessageDialog(
							null,
							"Auteur : "
									+ Auteurs
									+ "\nNom de l'application : Dessin Vectoriel\nVersion : 1.0");
		}

	}

}