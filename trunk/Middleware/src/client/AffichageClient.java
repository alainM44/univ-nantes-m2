package client;

import ihm.Placement;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import serveur.InterfaceAffichageClient;
import serveur.InterfaceSujetDiscussion;

public class AffichageClient extends UnicastRemoteObject implements
		InterfaceAffichageClient
{
private static final long serialVersionUID=2L;
	InterfaceSujetDiscussion sujetDiscussion;
	
	JFrame f = new JFrame();
	
	JTextArea discussion = new JTextArea(10,20);
	
	JTextField composeMessage =new JTextField(20);
	
	JButton boutonEnvoi = new JButton("ENVOI");
	class ActionEnvoi implements ActionListener {
		public synchronized void actionPerformed(ActionEvent e)
		{
			//TODO to implement
		}
	}
	public AffichageClient(String titre, InterfaceSujetDiscussion s) throws RemoteException {
		sujetDiscussion = s ;
		Placement.p(f, new Label(titre), 1, 1, 1, 1);
		Placement.p(f, discussion, 1, 2, 1, 1);
		Placement.p(f, composeMessage, 1, 3, 1, 1);
		Placement.p(f, boutonEnvoi, 1, 4, 1, 1);
		boutonEnvoi.addActionListener(new ActionEnvoi());
		f.pack();
		f.setVisible(true);
	}
	@Override
	public void affiche(String message)
	{
		// TODO Auto-generated method stub

	}

	public void termine(){
		f.dispose();
	}
}
