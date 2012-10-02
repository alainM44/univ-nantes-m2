package list;

public class ListeDeChaines {

    private static class Maillon {
	Maillon suivant; Maillon precedent; String element;
	Maillon(Maillon s,Maillon p,String e) {
            suivant=s;precedent=p;element=e;
        }
    }

    private Maillon tete;
    private Maillon queue;


  //======================= parcoureur de liste =====================
    public class Parcours {

	private Maillon courant;

        public Parcours() {courant=tete;} // Parcours initialis� au debut

        private ListeDeChaines laListe() {
               return ListeDeChaines.this;
        }

        public Parcours(Parcours p) {
        // Parcours initialis� avec l'�tat du Parcours p
          if (p.laListe()!=ListeDeChaines.this) {
            System.out.println("erreur :");
            System.out.println(
                 "parcours initialis� avec celui d'une autre liste");
            Thread.dumpStack(); System.exit(0);
          }
          courant=p.courant;
	}


	// positionnement en debut de liste, estEnFin si liste vide
	public void tete() {courant=tete;}

	// positionnement en fin de liste, estEnFin si liste vide
	public void queue() {courant=queue;}

	// positionnement sur l'�l�ment suivant, ne fait rien si estEnFin
	public void suivant() {
            if (courant!=null) {courant=courant.suivant;}
        }

	// positionnement  sur l'�l�ment pr�c�dent, ne fait rien si estEnFin
	public void precedent() {
           if (courant!=null) {courant=courant.precedent;}
	}

	// indique si en fin de parcours
	// (au dela de la queue, en de�a de la tete)
        public boolean estEnFin() {return courant==null;}

        public String elementCourant() {
	    if (courant!=null) {return courant.element;}
            else {return null;}
        }

        public void modifElement(String nouvelElement) {
	    if (courant!=null) {courant.element=nouvelElement;}
        }

        public void ajouteElement(String nouvelElement) {
            Maillon suivant; Maillon nouveau;
	    if (courant==null) { // chaine en tete
                suivant=tete;
		nouveau = new Maillon(tete,null,nouvelElement);
                tete=nouveau; courant=nouveau;
            }
            else { // chaine sur courant
		suivant=courant.suivant;            
		nouveau = new Maillon(suivant,courant,nouvelElement);
                courant.suivant=nouveau; courant=nouveau;
            }
            if (suivant!=null) {suivant.precedent=courant;}
            else {// nouvel element de queue
		    queue=courant;
            }
	}

	public void retireElement() {
            // retire l'�l�ment courant du parcours
	    // s'il existe, le suivant de l'�l�ment retir�
	    // devient le courant, sinon estEnFin devient vrai
	    // ne fait rien si le parcours estEnFin
	    if (courant!=null) {
                Maillon suivant=courant.suivant;
                Maillon precedent=courant.precedent;
		if (precedent!=null) {precedent.suivant=suivant;}
                else {tete=suivant;}
		if (suivant!=null) {suivant.precedent=precedent;}
                else {queue=precedent;}
                courant=suivant;
            }
	}
  }
  //==================================================================


  public ListeDeChaines() { // liste vide
      tete=null; queue=null;
  }

  public ListeDeChaines.Parcours nouveauParcours() { 
  // un nouveau parcours initialis� au d�but de la liste
      return new Parcours();
  }

  public ListeDeChaines.Parcours nouveauParcours
                        (ListeDeChaines.Parcours p) {
  // nouveau parcours initialis� � l'�tat de parcours de p
      return new Parcours(p);
  }

  public boolean estVide() {return tete==null;}

  public String toString() {
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

  public void ajouteEnQueue(String nouvelElement) {
       if (queue==null) { // cas liste vide
	   queue = new Maillon(null,null,nouvelElement);
           tete = queue;
       }
       else { // chaine en queue
           Maillon exDernier = queue;
	   queue = new Maillon(null,exDernier,nouvelElement);
           exDernier.suivant=queue;
           
       }
  }

  public void ajouteEnTete(String nouvelElement) {
       if (tete==null) { // cas liste vide
	   tete = new Maillon(null,null,nouvelElement);
           queue = tete;
       }
       else { // chaine en tete
           Maillon exPremier = tete;
	   tete = new Maillon(exPremier,null,nouvelElement);
           exPremier.precedent=tete;
       }
  }

  public String retireEnQueue() {
  // effet : retire le dernier �l�ment - ne fait rien si estVide
  // r�sultat : le dernier �l�ment - null si estVide
      String resul=null;
      if (queue!=null) {
	 resul=queue.element;
	 queue = queue.precedent;
	 if (queue!=null) {queue.suivant=null;}
         else {tete = null;}
      }
      return resul;
  }

  public String retireEnTete() {
  // effet : retire le premier �l�ment - ne fait rien si estVide
  // r�sultat : le premier �l�ment - null si estVide
      String resul=null;
      if (tete!=null) {
	 resul=tete.element;
	 tete = tete.suivant;
	 if (tete!=null) {tete.precedent=null;}
         else {queue = null;}
      }
      return resul;
  }
}
