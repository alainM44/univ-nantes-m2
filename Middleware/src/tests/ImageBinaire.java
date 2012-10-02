import list.*;
import divers.PaireDEntiers;

public class ImageBinaire {
// représentations d'images en noir et blanc

  private boolean[][] M; // matrice des points de l'image 
                         // true pour noir, false pour blanc

  private ImageBinaire(int hauteur, int largeur) {
  // prérequis : hauteur>0, largeur>0
  // image non initialisée de taille largeur x hauteur
    M = new boolean[hauteur][largeur];
  }

  public static ImageBinaire blanche(int hauteur, int largeur) {
  // prérequis : hauteur>0, largeur>0
  // résultat : nouvelle image blanche de taille largeur x hauteur
    ImageBinaire resul = new ImageBinaire(hauteur,largeur);
    for (int i=0; i<resul.hauteur(); i++)
    for (int j=0; j<resul.largeur(); j++) {
      resul.M[i][j]=false;
    }
    return resul;
  }

  public static ImageBinaire 
            aPartirDeChaine(int hauteur, int largeur, String s) {
  // prérequis : hauteur>0, largeur>0, s figure une image de cette taille
  // résultat : image de taille largeur x hauteur figurée par la chaîne de
  // caractères s, '*' pour noir, '.' pour blanc, présentée ligne par ligne.
    ImageBinaire resul = blanche(hauteur,largeur);
    int k=0;
    for (int i=0; i<resul.hauteur(); i++)
    for (int j=0; j<resul.largeur(); j++) {
      char c=s.charAt(k);
      while(c!='*'&&c!='.'){k++; c=s.charAt(k);}
      if (c=='*') {resul.noircir(i,j);}
      k++;
    }
    return resul;
  }

  public static ImageBinaire copie(ImageBinaire original) {
  // résultat : nouvelle image, copie de image
    ImageBinaire resul =
          new ImageBinaire(original.hauteur(),original.largeur());
    for (int i=0; i<resul.hauteur(); i++)
    for (int j=0; j<resul.largeur(); j++) {
      resul.M[i][j]= original.M[i][j];
    }
    return resul;
  }

  public int hauteur() {
  // résultat : hauteur de this
    return M.length;
  }

  public int largeur() {
  // résultat : largeur de this
    return M[0].length;
  }

  public void noircir(int h, int l) {
  // prérequis : 0=<h<hauteur, 0=<l<largeur
  // effet : met à noir le point (h,l)
    M[h][l] = true;
  }

  public void blanchir(int h, int l) {
  // prérequis : 0=<h<hauteur, 0=<l<largeur
  // effet : met à blanc le point (h,l)
    M[h][l] = false;
  }

  public boolean estNoir(int h, int l) {
  // prérequis : 0=<h<hauteur, 0=<l<largeur
  // résultat : indique si le point (h,l) est noir
    return M[h][l];
  }

  public String toString() {
  // résultat : visualisation textuelle de this
  // les points noir sont des '*' et les points blancs des '.'
    String resul = "";
    for (int i=0; i<M.length; i++) {
      for (int j=0; j<M[0].length; j++) {
	if (estNoir(i,j)){resul = resul+'*';} else{resul = resul+'.';}
      }
      resul=resul+'\n';
    }
    return resul;
  }

  private PaireDEntiers premierPointNoir() {
  // resultat : si this contient des points noirs,
  // coordonnées du premier point noir rencontré, null sinon
    for (int i=0; i<M.length; i++)
    for (int j=0; j<M[0].length; j++) {
      if(estNoir(i,j)) {return new PaireDEntiers(i,j);}
    }
    return null;
  }

  private int max(int i, int j) {
  // résultat : le maximum de i et j
    if (i>j) {return i;} else {return j;}
  }

  private int min(int i, int j) {
  // résultat : le minimum de i et j
    if (i<j) {return i;} else {return j;}
  }

  public boolean estBlanche() {
  // résultat : indique si this est blanche
    return premierPointNoir()==null;
  }

  public ImageBinaire extraitPartieConnexe() {
  // prérequis : this n'est pas blanche
  // résultat : image constituée des points noirs de this qui constituent
  // une partie connexe.
  // effet : met à blanc dans this les points de cette partie connexe
    PaireDEntiers pt = premierPointNoir();
    ListeDePairesDEntiers aVisiter = new ListeDePairesDEntiers();
    ImageBinaire resul = blanche(hauteur(),largeur());
    aVisiter.ajouteEnQueue(pt);
    int ipt=pt.premier; int jpt=pt.second; blanchir(ipt,jpt);
    ListeDePairesDEntiers.Parcours p = aVisiter.nouveauParcours();
    while(!aVisiter.estVide()) {
      // prend un point de aVisiter
      p.tete(); pt=p.elementCourant(); aVisiter.retireEnTete();
      ipt=pt.premier; jpt=pt.second;
      // le place dans resul
      resul.noircir(ipt,jpt);
      // ajoute les voisins de ce point dans aVisiter
      // et les met à blanc dans this
      for(int i=max(ipt-1,0);i<=min(ipt+1,hauteur()-1);i++)
      for(int j=max(jpt-1,0);j<=min(jpt+1,largeur()-1);j++){
	if (estNoir(i,j)){
          aVisiter.ajouteEnQueue(new PaireDEntiers(i,j));
          blanchir(i,j);
	}
      }
    }
    return resul;
  }
}
