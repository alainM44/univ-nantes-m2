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

        public Parcours() {courant=tete;} // Parcours initialisé au debut

        private Liste<T> laListe() { return Liste.this; }

        public Parcours(Parcours p) {
        // Parcours initialisé avec l'état du Parcours p
          if (p.laListe()!=Liste.this) {
            System.out.println("erreur :\n"
                + "parcours initialisé avec celui d'une autre liste");
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
	// effet : positionne this sur l'élément suivant,
	// ne fait rien si estEnFin()
          if (courant!=null) {courant=courant.suivant;}
        }

	public void precedent() {
	// effet : positionne this sur l'élément précédent,
	// ne fait rien si estEnFin()
          if (courant!=null) {courant=courant.precedent;}
	}

        public boolean estEnFin() {
	// résultat : indique si this est en fin
	// (au dela de la queue, en deça de la tete)
          return courant==null;
        }
        public T elementCourant() {
	// prérequis : this n'est pas en fin
	// résultat : l'élément courant de this
	    return courant.element;
        }

        public void modifElement(T nouvelElement) {
	// prérequis : this n'est pas en fin
	// effet : remplace l'élément courant de this par nouvelElement
	    if (courant!=null) {courant.element=nouvelElement;}
        }

        public void ajouteElement(T nouvelElement) {
	// effet : insère nouvelElement à la suite de l'élément courant de this
	// insère en tête si this est en fin de parcours
	// l'élément inséré devient l'élément courant
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
	// prérequis : this n'est pas en fin
        // effet : retire l'élément courant de this
	// le suivant de l'élément retiré, s'il existe, 
	// devient l'élement courant, sinon this passe en fin de parcours
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
  // résultat : un nouveau parcours initialisé au début de this
      return new Parcours();
  }

  public Liste<T>.Parcours nouveauParcours
                        (Liste<T>.Parcours p) {
  // résultat : nouveau parcours initialisé à l'état de parcours de p
      return new Parcours(p);
  }

  public boolean estVide() {return tete==null;}
  // résulat : indique si this est vide

  public String toString() {
  // résultat : this en clair
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
  // effet : ajoute nouvelElement en tête de this
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
  // prérequis : this n'est pas vide
  // effet : retire l'élément de queue
  // résultat : l'élément retiré
      T resul = queue.element;
      queue = queue.precedent;
      if (queue!=null) {queue.suivant=null;}
      else {tete = null;}
      return resul;
  }

  public T retireEnTete() {
  // prérequis : this n'est pas vide
  // effet : retire l'élément de tête
  // résultat : l'élément retiré
      T resul = tete.element;
      tete = tete.suivant;
      if (tete!=null) {tete.precedent=null;}
      else {queue = null;}
      return resul;
  }


  public static <TE>  Liste<TE> aPartirDe(TE[] e){
  // résultat : une nouvelle liste contenant les éléments de e
      Liste<TE> resul=new Liste<TE>();
      for (int i=0;i<e.length;i++){
	  resul.ajouteEnQueue(e[i]);
      }
      return resul;
  }
 

  public Liste(T[] e){ // liste contenant les éléments de e
      tete=null; queue=null;
      for (int i=0;i<e.length;i++){
	  ajouteEnQueue(e[i]);
      }
  }

}
