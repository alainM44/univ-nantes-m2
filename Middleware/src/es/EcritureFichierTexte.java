package es;
import java.io.*;

public class EcritureFichierTexte {
// pour ecrire dans un fichier texte
// exemple d'utilisation :
// EcritureFichierTexte maSortie = new EcritureFichierTexte("monFichier.txt");
// maSortie.ecrire("\nje m'appelle toto et j'ai "); // ecrit une String
// maSortie.ecrire(12); // ecrit un int (�criture d�cimale d'un entier)
// maSortie.ecrire(" ans.") // ecrit une String
// maSortie.fermer();

  private PrintWriter leFichier;
  private String nom;

  public EcritureFichierTexte(String nom) {
  // initialise un acc�s en �criture sur le fichier de nom nom
  // cr�e le fichier s'il n'existe pas
    this.nom=nom;
    try {
      leFichier = new PrintWriter(new FileOutputStream(nom));
    } 
    catch(IOException e){
      System.out.println("erreur lors de la cr�ation du fichier "+nom);
      Thread.dumpStack();
    }
  }

  public void fermer() { // ferme le fichier
    leFichier.close();
  }

    public void ecrire(char c) { // �crit un caract�re
    leFichier.print(c);
  }

  public void ecrire(String s) { // �crit une cha�ne de caract�res
    leFichier.print(s);
  }

  public void ecrire(int k) { // �crit un entier sous forme d�cimale
     leFichier.print(k);
  }

  public void ecrire(boolean b) { // �crit un bool�en, "true" ou "false"
     leFichier.print(b); 
  }

  public void ecrire(double x) { // �crit un r�el sous forme usuelle 
     leFichier.print(x);   
  }
}








