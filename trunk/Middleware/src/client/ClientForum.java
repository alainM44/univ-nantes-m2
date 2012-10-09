package client;

import ihm.Placement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JFrame;

import serveur.IServeurForum;
import serveur.ISujetDiscussion;

@SuppressWarnings("serial")
public class ClientForum extends JFrame {
	JButton boutonInscriptionSport = new JButton("sport");
	JButton boutonInscriptionMusique = new JButton("musique");
	JButton boutonInscriptionCinema = new JButton("cinema");

	class ActionInscription implements ActionListener {
		private String titre;
		private boolean inscrit = false;
		private AffichageClient ihmSujet; // affichage client associé au bouton
		private ISujetDiscussion sujetDiscussionServeur; // Sujet associé au bouton

		public ActionInscription(String titre, ISujetDiscussion sujet)
				throws RemoteException {
			super();
			this.sujetDiscussionServeur = sujet;
			this.titre = titre;
			this.inscrit = true;
			

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				this.ihmSujet = new AffichageClient(titre, sujetDiscussionServeur);
				this.sujetDiscussionServeur.inscription(ihmSujet);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				System.out.println("erreur ClientForum.java actionPerformed");
			}

		}

	}

	IServeurForum leServeur;

	public ClientForum() throws RemoteException {
		try {
			leServeur = (IServeurForum) Naming
					.lookup("//localhost/ServeurForum");
			System.out.println("Connecté au serveur");
		} catch (Exception e) {
			System.out.println("ClientForum.java erreur nommage serveur");
			e.printStackTrace();
			return;
		}
		Placement.p(this, boutonInscriptionSport, 1, 1, 1, 1);
		Placement.p(this, boutonInscriptionMusique, 2, 1, 1, 1);
		Placement.p(this, boutonInscriptionCinema, 3, 1, 1, 1);
		System.out.println("blah"+leServeur.helloWorld());
		
//		ISujetDiscussion monSujetTemp =(ISujetDiscussion)
//				leServeur.obtientSujet("sport");
		
		boutonInscriptionSport.addActionListener(new ActionInscription("sport",
				leServeur.obtientSujet("sport")));
		boutonInscriptionMusique.addActionListener(new ActionInscription(
				"musique", leServeur.obtientSujet("musique")));
		boutonInscriptionCinema.addActionListener(new ActionInscription(
				"cinema", leServeur.obtientSujet("cinema")));
		setVisible(true);
		pack();
	}

	public static void main(String[] argv) throws RemoteException {


		System.setProperty("java.security.policy",
				"file:./no.policy");


		new ClientForum();
	}
}
