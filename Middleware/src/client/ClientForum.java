package client;

import ihm.Placement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;

import serveur.InterfaceServeurForum;
import serveur.InterfaceSujetDiscussion;


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

	InterfaceServeurForum leServeur;

	public ClientForum()
	{
		try
		{
			leServeur = (InterfaceServeurForum) Naming.lookup("remplir");
		}
		catch (Exception e)
		{
			System.out.println("erreur nommage serveur");
			return;
		}
		Placement.p(this, boutonInscriptionSport, 1, 1, 1, 1);
		Placement.p(this, boutonInscriptionMusique, 2, 1, 1, 1);
		Placement.p(this, boutonInscriptionCinema, 3, 1, 1, 1);
		boutonInscriptionSport.addActionListener(null);//TODO argument missing
		boutonInscriptionMusique.addActionListener(null);//TODO argument missing
		boutonInscriptionCinema.addActionListener(null);//TODO argument missing
		setVisible(true);
		pack();
	}
	
	public static void main(String[] argv){
		new ClientForum();
	}
}
