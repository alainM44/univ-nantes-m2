package ens;

import parcours.*;

public class Ensemble<T extends Comparable<T>> {

  private Object[] elements; // tableau d'�l�ments de type T
                             // de taille ajust�e aux besoins
  private int nbElements;
  private static final int facteurDeCroissance=2;
  private static final int taillePourSingleton=1;

  public Ensemble() { // ensemble vide
      elements=null; nbElements=0;
  }

  public static <T extends Comparable<T>> Ensemble<T> aPartirDe(T[] elts){
  // r�sultat : un nouvel ensemble d'entiers compos� des �l�ments de elts
    Ensemble<T> resul = new Ensemble();
    for (int i=0; i<elts.length; i++){
	resul.ajouteElement(elts[i]);
    }
    return resul;
  }

  //======================= parcoureur d'ensemble =====================
  public class Parcours implements parcours.Parcours<T>{
    private int courant;
    Parcours() {
    // Parcours initialis� au d�but
      courant=0;
    }
    Parcours(Parcours p) {
    // Parcours initialis� avec l'�tat du Parcours p
      courant=p.courant;
    }
    public void tete() {
    // effet : positionne this sur le plus petit �l�ment de l'ensemble
    // (parcours en fin si ensemble vide)
      courant=0;
    }
    public void suivant() {
    // effet : positionne this sur l'�l�ment suivant,
    // ne fait rien si estEnFin()
      if (courant<nbElements) {courant++;}
    }
    public boolean estEnFin() {
    // r�sultat : indique si this est en fin
    // (au dela de la queue, en de�a de la tete)
      return courant==nbElements;
    }
    public void retireElement() {
    // pr�requis : this n'est pas en fin
    // effet : retire l'�l�ment courant de this
    // le suivant de l'�l�ment retir�, s'il existe, 
    // devient l'�lement courant, sinon this passe en fin de parcours
      retireIemeElement(courant);
    }
    public T elementCourant() {
    // pr�requis : this n'est pas en fin
    // r�sultat : l'�l�ment courant de this
      if (estEnFin()) {
         System.out.println("erreur : acces hors domaine de l'ensemble");
         Thread.dumpStack(); System.exit(0);
      }
      return (T) elements[courant];
    }
  }
  //==================================================================

  public int cardinal() {
  // r�sultat : le nombre d'�l�ments de this
    return nbElements;
  }

  public boolean estVide() {
  // r�sultat : indique si this est vide
    return nbElements==0;
  }

  public String toString() {
  // r�sultat : this en clair
    if (estVide()) {return "{}";}
    StringBuffer resul = new StringBuffer("{ "+ elements[0]);
    for (int i=1; i<nbElements; i++) {
      resul.append(" , " + elements[i]);
    }
    resul.append(" }"); return resul.toString();
  }
 
  private int indiceDe(T e) {
  // r�sultat : indice de l'�l�ment �gal � e, 0..nbElements-1,
  // -1 si e est absent
    int i = 0; int j = nbElements-1;
    while(j>=i){
       int m=(i+j)/2;
       int comparaison = ((T) elements[m]).compareTo(e);
       if (comparaison==0) {return m;}
       else if (comparaison<0) {i=m+1;}
       else {j=m-1;}
    }
    return -1;
  }

  public boolean contient(T e) {
  // r�sultat : indique si e appartient � this
    return indiceDe(e)!=-1;
  }

  public void ajouteElement(T e) {
  // effet : ajoute e � this (aucun effet si e est d�j� dans this)
  // (apr�s, e appartient � this)
    if (!contient(e)) {
       if (elements!=null && nbElements<elements.length){ // place suffisante
          int i=nbElements;
          while (i>0 && ((T) elements[i-1]).compareTo(e)>0) {
	       elements[i]=elements[i-1]; i--;
	  }
          elements[i]=e;
       }
       else { // place insuffisante, cr�ation d'un nouveau tableau
          Object[] nouveau;
          if (nbElements==0) {nouveau = new Object[taillePourSingleton];}
          else {nouveau=new Object[facteurDeCroissance*elements.length];}
          int i=nbElements;
          while (i>0 && ((T) elements[i-1]).compareTo(e)>0) {
	     nouveau[i]=elements[i-1]; i--;
	  }
          nouveau[i] = e; i--;
          while (i>=0) { nouveau[i]=elements[i]; i--;}           
          elements=nouveau;
       }
       nbElements++;
    }
  }
  
  public void retireElement(T e) {
  // effet : retire e de this (aucun effet si e n'est pas dans this)
  // (apr�s, e n'appartient pas � this)
      int k = indiceDe(e);
      if (k!=-1) {retireIemeElement(k);}
  }

  private void retireIemeElement(int k) {
  // pr�requis : 0<=k<nbElements
  // effet : retire le k i�me �l�ment
    nbElements--;
    if (nbElements==0) {elements = null;}
    else if (nbElements < elements.length/facteurDeCroissance) {
      // cr�ation d'un tableau plus petit
      Object[] nouveau = new Object[elements.length/facteurDeCroissance];
      for (int i=0;i<k; i++) {nouveau[i]=elements[i];}
      for (int i=k;i<nbElements; i++) {nouveau[i]=elements[i+1];}
      elements=nouveau;
    }
    else {
      for (int i=k;i<nbElements; i++) {elements[i]=elements[i+1];}
    }
  }

  private void ajouteAuBout(T e) {
    // effet : ajoute l'�l�ment e "au bout" du tableau des �l�ments
    if (elements!=null && nbElements<elements.length){ // place suffisante
      elements[nbElements]=e;
    }
    // place insuffisante, cr�ation d'un nouveau tableau
    else if (nbElements==0) {
      elements= new Object[taillePourSingleton]; elements[0]=e;
    }
    else {
      Object[] nouveau = new Object[facteurDeCroissance*elements.length];
      for (int i=0; i<nbElements; i++) {nouveau[i]=elements[i];}
      nouveau[nbElements] = e;
      elements=nouveau;
    }
    nbElements++;
  }

  public static <T extends Comparable<T>> 
       Ensemble<T> union(Ensemble<T> e1, Ensemble<T> e2) {
    Ensemble<T> resul = new Ensemble();
    int i1=0; int i2=0;
    while (i1<e1.nbElements && i2<e2.nbElements) {
      T v1 = (T) e1.elements[i1]; T v2 = (T) e2.elements[i2];
      int compar=v1.compareTo(v2);
      if (compar<0) {resul.ajouteAuBout(v1); i1++;}
      else if (compar>0) {resul.ajouteAuBout(v2); i2++;}
      else {resul.ajouteAuBout(v1); i1++; i2++;}
    }
    while (i1<e1.nbElements) {
      resul.ajouteAuBout((T) e1.elements[i1]); i1++;
    }
    while (i2<e2.nbElements) {
      resul.ajouteAuBout((T) e2.elements[i2]); i2++;
    }
    return resul;
  }

  public static <T extends Comparable<T>>
         Ensemble<T> intersection(Ensemble<T> e1, Ensemble<T> e2) {
    Ensemble<T> resul = new Ensemble();
    int i1=0; int i2=0;
    while (i1<e1.nbElements && i2<e2.nbElements) {
      T v1 = (T) e1.elements[i1]; T v2 = (T) e2.elements[i2];
      int compar=v1.compareTo(v2);
      if (compar<0) {i1++;}
      else if (compar>0) {i2++;}
      else {resul.ajouteAuBout(v1); i1++; i2++;}
    }
    return resul;
  }

  public static <T extends Comparable<T>>
         Ensemble<T> difference(Ensemble<T> e1, Ensemble<T> e2) {
    Ensemble<T> resul = new Ensemble();
    int i1=0; int i2=0;
    while (i1<e1.nbElements && i2<e2.nbElements) {
      T v1 = (T) e1.elements[i1]; T v2 = (T) e2.elements[i2];
      int compar=v1.compareTo(v2);
      if (compar<0) {resul.ajouteAuBout(v1); i1++;}
      else if (compar>0) {i2++;}
      else {i1++; i2++;}
    }
    while (i1<e1.nbElements) {
      resul.ajouteAuBout((T) e1.elements[i1]); i1++;
    }
    return resul;
  }
}

