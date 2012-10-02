package ens;

import parcours.*;

public class Ensemble<T extends Comparable<T>> {

  private Object[] elements; // tableau d'éléments de type T
                             // de taille ajustée aux besoins
  private int nbElements;
  private static final int facteurDeCroissance=2;
  private static final int taillePourSingleton=1;

  public Ensemble() { // ensemble vide
      elements=null; nbElements=0;
  }

  public static <T extends Comparable<T>> Ensemble<T> aPartirDe(T[] elts){
  // résultat : un nouvel ensemble d'entiers composé des éléments de elts
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
    // Parcours initialisé au début
      courant=0;
    }
    Parcours(Parcours p) {
    // Parcours initialisé avec l'état du Parcours p
      courant=p.courant;
    }
    public void tete() {
    // effet : positionne this sur le plus petit élément de l'ensemble
    // (parcours en fin si ensemble vide)
      courant=0;
    }
    public void suivant() {
    // effet : positionne this sur l'élément suivant,
    // ne fait rien si estEnFin()
      if (courant<nbElements) {courant++;}
    }
    public boolean estEnFin() {
    // résultat : indique si this est en fin
    // (au dela de la queue, en deça de la tete)
      return courant==nbElements;
    }
    public void retireElement() {
    // prérequis : this n'est pas en fin
    // effet : retire l'élément courant de this
    // le suivant de l'élément retiré, s'il existe, 
    // devient l'élement courant, sinon this passe en fin de parcours
      retireIemeElement(courant);
    }
    public T elementCourant() {
    // prérequis : this n'est pas en fin
    // résultat : l'élément courant de this
      if (estEnFin()) {
         System.out.println("erreur : acces hors domaine de l'ensemble");
         Thread.dumpStack(); System.exit(0);
      }
      return (T) elements[courant];
    }
  }
  //==================================================================

  public int cardinal() {
  // résultat : le nombre d'éléments de this
    return nbElements;
  }

  public boolean estVide() {
  // résultat : indique si this est vide
    return nbElements==0;
  }

  public String toString() {
  // résultat : this en clair
    if (estVide()) {return "{}";}
    StringBuffer resul = new StringBuffer("{ "+ elements[0]);
    for (int i=1; i<nbElements; i++) {
      resul.append(" , " + elements[i]);
    }
    resul.append(" }"); return resul.toString();
  }
 
  private int indiceDe(T e) {
  // résultat : indice de l'élément égal à e, 0..nbElements-1,
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
  // résultat : indique si e appartient à this
    return indiceDe(e)!=-1;
  }

  public void ajouteElement(T e) {
  // effet : ajoute e à this (aucun effet si e est déjà dans this)
  // (après, e appartient à this)
    if (!contient(e)) {
       if (elements!=null && nbElements<elements.length){ // place suffisante
          int i=nbElements;
          while (i>0 && ((T) elements[i-1]).compareTo(e)>0) {
	       elements[i]=elements[i-1]; i--;
	  }
          elements[i]=e;
       }
       else { // place insuffisante, création d'un nouveau tableau
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
  // (après, e n'appartient pas à this)
      int k = indiceDe(e);
      if (k!=-1) {retireIemeElement(k);}
  }

  private void retireIemeElement(int k) {
  // prérequis : 0<=k<nbElements
  // effet : retire le k ième élément
    nbElements--;
    if (nbElements==0) {elements = null;}
    else if (nbElements < elements.length/facteurDeCroissance) {
      // création d'un tableau plus petit
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
    // effet : ajoute l'élément e "au bout" du tableau des éléments
    if (elements!=null && nbElements<elements.length){ // place suffisante
      elements[nbElements]=e;
    }
    // place insuffisante, création d'un nouveau tableau
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

