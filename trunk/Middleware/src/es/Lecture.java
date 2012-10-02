package es;
import java.io.*;

public class Lecture {
  public static char unCar() {
  // effet : lit un caract�re frapp�
  // r�sultat : le caract�re frapp�
    char c;
    try { c = (char) System.in.read();}
    catch(IOException e) {c= (char) 0;};
    return c;
  }

  public static char unCarCmde() {
  // effet : lit caract�re et consomme les suivants
  // jusqu'� la fin de ligne
  // r�sultat : le premier caract�re frapp�
    char c;
    try { c = (char) System.in.read();
          while(System.in.read()!='\r'){};
    }
    catch(IOException e) {c= (char) 0;};
    return c;
  }

  public static String chaine(String delimiteurs) {
  // pr�requis : delimiteurs.length()!=0
  // effet : lit une s�quence de caract�res constitu�e de d�limiteurs
  // puis de caract�res autres que des d�limiteurs.
  // les d�limiteurs sont les caract�res de d�limiteurs.
  // r�sultat : la chaine form�e des caract�res compris entre les delimiteurs
    StringBuffer b = new  StringBuffer();
    char c=unCar();
    // ignore les delimiteurs de tete
    while (delimiteurs.indexOf(c)!=-1) {c=unCar();};
    // lit jusqu'au prochain delimiteur
    while (delimiteurs.indexOf(c)==-1) {b.append(c); c=unCar();};
    return b.toString();
  }

  public static String chaine() {
  // r�sultat : Lecture.chaine(" \r\n")
    return  chaine(" \r\n");
  }

  public static int unEntier() {
  // effet : lit une cha�ne de caract�res comprise entre les d�limiteurs
  // ' ', '\r' ou '\n'
  // r�sultat : l'entier represent� en decimal par cette cha�ne
  // si la cha�ne ne respecte pas la syntaxe d'un entier d�cimal,
  // affiche un message d'erreur et retourne 0.
    String s=Lecture.chaine(" \r\n");
    try { return Integer.parseInt(s);}
    catch(NumberFormatException e) {
      System.err.println("\nErreur lecture d'entier");
      System.err.println("valeur 0 retourn�e");     
      return 0;
    }
  }

  public static double unReel() {
  // effet : lit une cha�ne de caract�res comprise entre les d�limiteurs
  // ' ', '\r' ou '\n'
  // r�sultat : le flottant represent� en format usuel par cette cha�ne
  // si la cha�ne ne respecte pas la syntaxe usuelle pour un nombre r�el,
  // affiche un message d'erreur et retourne 0.
    String s=Lecture.chaine(" \r\n");
    try { return  (Double.valueOf(s)).doubleValue();}
    catch(NumberFormatException e) {
      System.err.println("\nErreur lecture de re�l");
      System.err.println("valeur 0 retourn�e");     
      return 0;
    }
  }

}
