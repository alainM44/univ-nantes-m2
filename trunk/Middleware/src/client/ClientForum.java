package client;

import ihm.Placement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;


public class ClientForum extends JFrame
{
	JButton boutonInscriptionSport = new JButton("sport");
	JButton boutonInscriptionMusique = new JButton("musique");
	JButton boutonInscriptionCinema = new JButton("cinema");

	class ActionInscription implements ActionListener
	{
		private String titre;
		private boolean inscrit = false;
		private AffichageClient c; // affichage client associé au bouton
		private InterfaceSujetDiscussion sujet; // Sujet associé au bouton

		public ActionInscription(String titre)
		{
			// TODO implement
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub

		}

	}

	InterfaceServeurFrom leServeur;

	public ClienForum()
	{
		try
		{
			leServeur = (InterfaceServeurFrom) Naming.lookup("remplir");
		}
		catch (Exception e)
		{
			System.out.println("erreur nommage serveur");
			return;
		}
		Placement.p(this, boutonInscriptionSport, 1, 1, 1, 1);
	}
}
