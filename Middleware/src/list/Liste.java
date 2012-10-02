package list;

import parcours.*;

public class Liste<T> {

    private static class Maillon<TE> {
	Maillon<TE> suivant; Maillon<TE> precedent; TE element;
	Maillon(Maillon<TE> s,Maillon<TE> p,TE e) {
            suivant=s;precedent=p;element=e;
        }
    }

    private Maillon<T> tete;
    private Maillon<T> queue;


  //======================= parcoureur de liste =====================
    public class Parcours implements ParcoursBidirectionnel<T>,
                                     ParcoursModificateur<T>     {

	private Maillon<T> courant;

        public Parcours() {courant=tete;} // Parcours initialis� au debut

        private Liste<T> laListe() { return Liste.this; }

        public Parcours(Parcours p) {
        // Parcours initialis� avec l'�tat du Parcours p
          if (p.laListe()!=Liste.this) {
            System.out.println("erreur :\n"
                + "parcours initialis� avec celui d'une autre liste");
            Thread.dumpStack(); System.exit(0);
          }
          courant=p.courant;
	}


	public void tete() {
	// effet : positionne this en tete de liste
        // (parcours en fin si liste vide)
          courant=tete;
        }
	public void queue() {
	// effet : positionne this en queue de liste
        // (parcours en fin si liste vide)
          courant=queue;
        }
	public void suivant() {
	// effet : positionne this sur l'�l�ment suivant,
	// ne fait rien si estEnFin()
          if (courant!=null) {courant=courant.suivant;}
        }

	public void precedent() {
	// effet : positionne this sur l'�l�ment pr�c�dent,
	// ne fait rien si estEnFin()
          if (courant!=null) {courant=courant.precedent;}
	}

        public boolean estEnFin() {
	// r�sultat : indique si this est en fin
	// (au dela de la queue, en de�a de la tete)
          return courant==null;
        }
        public T elementCourant() {
	// pr�requis : this n'est pas en fin
	// r�sultat : l'�l�ment courant de this
	    return courant.element;
        }

        public void modifElement(T nouvelElement) {
	// pr�requis : this n'est pas en fin
	// effet : remplace l'�l�ment courant de this par nouvelElement
	    if (courant!=null) {courant.element=nouvelElement;}
        }

        public void ajouteElement(T nouvelElement) {
	// effet : ins�re nouvelElement � la suite de l'�l�ment courant de this
	// ins�re en t�te si this est en fin de parcours
	// l'�l�ment ins�r� devient l'�l�ment courant
	    if (courant!=null) {courant.element=nouvelElement;}
            Maillon<T> suivant; Maillon<T> nouveau;
	    if (courant==null) { // chaine en tete
                suivant=tete;
		nouveau = new Maillon<T>(tete,null,nouvelElement);
                tete=nouveau; courant=nouveau;
            }
            else { // chaine sur courant
		suivant=courant.suivant;            
		nouveau = new Maillon<T>(suivant,courant,nouvelElement);
                courant.suivant=nouveau; courant=nouveau;
            }
            if (suivant!=null) {suivant.precedent=courant;}
            else {// nouvel element de queue
		    queue=courant;
            }
	}

	public void retireElement() {
	// pr�requis : this n'est pas en fin
        // effet : retire l'�l�ment courant de this
	// le suivant de l'�l�ment retir�, s'il existe, 
	// devient l'�lement courant, sinon this passe en fin de parcours
          Maillon<T> suivant=courant.suivant;
          Maillon<T> precedent=courant.precedent;
	  if (precedent!=null) {precedent.suivant=suivant;}
          else {tete=suivant;}
	  if (suivant!=null) {suivant.precedent=precedent;}
          else {queue=precedent;}
          courant=suivant;
	}
  }
  //==================================================================


  public Liste() { // liste vide
      tete=null; queue=null;
  }

  public Liste<T>.Parcours nouveauParcours() { 
  // r�sultat : un nouveau parcours initialis� au d�but de this
      return new Parcours();
  }

  public Liste<T>.Parcours nouveauParcours
                        (Liste<T>.Parcours p) {
  // r�sultat : nouveau parcours initialis� � l'�tat de parcours de p
      return new Parcours(p);
  }

  public boolean estVide() {return tete==null;}
  // r�sulat : indique si this est vide

  public String toString() {
  // r�sultat : this en clair
      if (estVide()) {return "<>";}
      Parcours p= new Parcours();
      StringBuffer resul = 
           new StringBuffer("< "+ p.elementCourant().toString());
      p.suivant();
      while (!p.estEnFin()) {
	  resul.append(" | " + p.elementCourant().toString());
          p.suivant();
      }
      resul.append(" >"); return resul.toString();
  }

  public void ajouteEnQueue(T nouvelElement) {
  // effet : ajoute nouvelElement en queue de this
       if (queue==null) { // cas liste vide
	   queue = new Maillon<T>(null,null,nouvelElement);
           tete = queue;
       }
       else { // chaine en queue
           Maillon<T> exDernier = queue;
	   queue = new Maillon<T>(null,exDernier,nouvelElement);
           exDernier.suivant=queue;
           
       }
  }

  public void ajouteEnTete(T nouvelElement) {
  // effet : ajoute nouvelElement en t�te de this
       if (tete==null) { // cas liste vide
	   tete = new Maillon<T>(null,null,nouvelElement);
           queue = tete;
       }
       else { // chaine en tete
           Maillon<T> exPremier = tete;
	   tete = new Maillon<T>(exPremier,null,nouvelElement);
           exPremier.precedent=tete;
       }
  }

  public T retireEnQueue() {
  // pr�requis : this n'est pas vide
  // effet : retire l'�l�ment de queue
  // r�sultat : l'�l�ment retir�
      T resul = queue.element;
      queue = queue.precedent;
      if (queue!=null) {queue.suivant=null;}
      else {tete = null;}
      return resul;
  }

  public T retireEnTete() {
  // pr�requis : this n'est pas vide
  // effet : retire l'�l�ment de t�te
  // r�sultat : l'�l�ment retir�
      T resul = tete.element;
      tete = tete.suivant;
      if (tete!=null) {tete.precedent=null;}
      else {queue = null;}
      return resul;
  }


  public static <TE>  Liste<TE> aPartirDe(TE[] e){
  // r�sultat : une nouvelle liste contenant les �l�ments de e
      Liste<TE> resul=new Liste<TE>();
      for (int i=0;i<e.length;i++){
	  resul.ajouteEnQueue(e[i]);
      }
      return resul;
  }
 

  public Liste(T[] e){ // liste contenant les �l�ments de e
      tete=null; queue=null;
      for (int i=0;i<e.length;i++){
	  ajouteEnQueue(e[i]);
      }
  }

}
