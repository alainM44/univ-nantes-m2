package tests;

import es.*;
import list.*;
import divers.PaireDEntiers;

class Polynome {

  private ListeDePairesDEntiers monomes; 
  // monomes non nuls <coefs,degres>, degres faibles en tete

  private Polynome() {
  //constructeur (priv�) : cree la liste vide de monomes
    monomes = new ListeDePairesDEntiers();
  }

  public void dump() {
  // affiche la repr�sentation de this
      System.out.println(monomes);
  }

  public static Polynome aPartirDe(int[] T){
  // prerequis : le tableau T contient alternativement les coefficients
  // et les degr�s correspondant d'un polynome, [Cn,Dn,...,C1,D1,C0,D0],
  // par ordre d�croissant des degr�s
  // resultat : le polynome represente par le tableau T
    Polynome resul=new Polynome();
    for(int i=0; i<T.length-1; i=i+2) {
	resul.monomes.ajouteEnTete(new PaireDEntiers(T[i],T[i+1]));
    }
    return resul;
  }

  // le polynome nul
  public static Polynome zero = new Polynome();

  private void normaliser() {
  // effet : enleve les paires correspondant � des coefficients nuls
    ListeDePairesDEntiers.Parcours p = monomes.nouveauParcours();
    while(!p.estEnFin()){
      if (p.elementCourant().premier==0) {p.retireElement();}
      else {p.suivant();}
    }
  }

  public static Polynome lire(int degre) {
  // prerequis : degre>=0
  // lit un polynome au clavier, sous la forme :
  // cn dn...c1 d1 c0 d0, par ordre croissant des degr�s.
  // La lecture s'arr�te a la fourniture du degre indique en parametre.
  // r�sultat : le polynome lu
    Polynome resul = new Polynome();
    int coef=Lecture.unEntier(); int deg=Lecture.unEntier();
    resul.monomes.ajouteEnQueue(new PaireDEntiers(coef,deg));
    while (deg<degre){
      coef = Lecture.unEntier(); int nouveauDegre=Lecture.unEntier();
      while(nouveauDegre<=deg) { // recommence en cas d'erreur
        System.out.print("Degre incorrect, nouveau degre : "); 
        nouveauDegre=Lecture.unEntier();
      }
      deg=nouveauDegre;
      resul.monomes.ajouteEnQueue(new PaireDEntiers(coef,deg));
    }
    resul.normaliser(); // on a pu introduire des coefs nuls
    return resul;
  }

  private String monomeToString(PaireDEntiers m) {
  // resultat : forme textuelle "en clair" du monome m
    int coef=m.premier; int degre=m.second;
    if (coef!=1 && coef!=-1 && degre>1) {return coef+"X^"+degre;}
    else if (coef==1 && degre>1) {return "X^"+degre;}
    else if (coef==-1 && degre>1) {return "-X^"+degre;}
    else if (coef!=1 && coef!=-1 && degre==1) {return coef+"X";}
    else if (coef==1 && degre==1) {return "X";}
    else if (coef==-1 && degre==1) {return "-X";}
    else /* degre==0 */ {return coef+"";}
  }

  public String toString(){
  // resultat: forme textuelle "en clair" du polynome this
  //           an*X^n + ... + a2*X^2 + a1*X + a0 (ou 0 si nul)
    if(monomes.estVide()) { return "0";}
    ListeDePairesDEntiers.Parcours p = monomes.nouveauParcours();
    p.queue();
    String resul=monomeToString(p.elementCourant());
    p.precedent();
    while ( !p.estEnFin()) {
      int coef=p.elementCourant().premier;
      if (coef<0){resul= resul+monomeToString(p.elementCourant());}
      else /*coef>0*/ {resul= resul+"+"+monomeToString(p.elementCourant());}
      p.precedent();
    }
    return resul;
  }

  public double valeur (double x) {
  // resultat: la valeur de this en x
    ListeDePairesDEntiers.Parcours p = monomes.nouveauParcours();
    p.queue();
    double resul = 0;
    while (!p.estEnFin()){
    // schema de Horner generalise
      int coef=p.elementCourant().premier; resul = resul + coef;
      int deltaDegre=p.elementCourant().second;
      p.precedent();
      if (!p.estEnFin()){deltaDegre=deltaDegre-p.elementCourant().second;}
      for(int i=0; i<deltaDegre; i++) {resul = resul*x;}
    }
    return resul;
  }

  public int degre(){
  // resultat: degre du polynome this
  // le degre du polynome nul est -infini. On le repr�sentera par -1
      if (monomes.estVide()) {return -1;}
      else {
        ListeDePairesDEntiers.Parcours p = monomes.nouveauParcours();
        p.queue();
        return p.elementCourant().second;
      }
  }

  public static boolean egalite(Polynome x, Polynome y) {
  // resultat: indique si les polynomes x et y sont egaux
    boolean resul = true;
    ListeDePairesDEntiers.Parcours px = x.monomes.nouveauParcours();
    ListeDePairesDEntiers.Parcours py = y.monomes.nouveauParcours();
    while(resul && !px.estEnFin() && !py.estEnFin()) {
	resul = px.elementCourant().equals(py.elementCourant());
        px.suivant(); py.suivant();
    }
    return resul && px.estEnFin() && py.estEnFin();
  }

  public static Polynome somme(Polynome x, Polynome y){
  // resultat: polynome somme de x et de y
    Polynome resul = new Polynome();
    ListeDePairesDEntiers.Parcours px = x.monomes.nouveauParcours();
    ListeDePairesDEntiers.Parcours py = y.monomes.nouveauParcours();
    while (!px.estEnFin() && !py.estEnFin()) {
      PaireDEntiers mx=px.elementCourant();
      PaireDEntiers my=py.elementCourant();
      int xC= mx.premier; int xD= mx.second;
      int yC= my.premier; int yD =my.second;
      if (xD<yD) {
        resul.monomes.ajouteEnQueue(mx);
        px.suivant();
      }
      else if (yD<xD) {
        resul.monomes.ajouteEnQueue(my);
        py.suivant();
      }
      else /* xD==yD */ {
        if (xC+yC!=0){
          resul.monomes.ajouteEnQueue(new PaireDEntiers(xC+yC,yD));
	}
        px.suivant();
        py.suivant();
      }
    }
    while (!px.estEnFin()) {
      resul.monomes.ajouteEnQueue(px.elementCourant());
      px.suivant();
    }
    while (!py.estEnFin()) {
      resul.monomes.ajouteEnQueue(py.elementCourant());
      py.suivant();
    }
    return resul;    
  }

  private Polynome produitParMonome(PaireDEntiers m){
  // prerequis : d>=0
  // resultat : le polynome this multipli� par le monome m=c*X^d
    int c=m.premier; int d=m.second;
    if (c==0 || monomes.estVide()){return zero;}
    if (d==0 && c==1) {return this;}
    Polynome resul = new Polynome();
    ListeDePairesDEntiers.Parcours p = monomes.nouveauParcours();
    while (!p.estEnFin()){
	int nouvCoef = c*p.elementCourant().premier;
	int nouvDegre = d+p.elementCourant().second;
      resul.monomes.ajouteEnQueue(new PaireDEntiers(nouvCoef,nouvDegre));
      p.suivant();
    }
    return resul;
  }

  public static Polynome produit(Polynome x, Polynome y){
  // resultat : polynome produit de x par y
    if (x.monomes.estVide() || y.monomes.estVide()){return zero;}
    ListeDePairesDEntiers.Parcours px = x.monomes.nouveauParcours();
    Polynome resul = new Polynome();
    while(!px.estEnFin()) {
      resul=somme(resul,y.produitParMonome(px.elementCourant()));
      px.suivant();
    } 
    return resul;
  }

  public static Polynome derive(Polynome x){
  // resultat: le polynome deriv� de x
    int degreDeX=x.degre();
    if (degreDeX==-1||degreDeX==0){return zero;}
    Polynome resul = new Polynome();
    ListeDePairesDEntiers.Parcours px = x.monomes.nouveauParcours();
    // ignore terme de degre 0 :
    if (px.elementCourant().second==0) {px.suivant();}
    while(!px.estEnFin()) {
      int c = px.elementCourant().premier;
      int d = px.elementCourant().second;
      resul.monomes.ajouteEnQueue(new PaireDEntiers(d*c,d-1));
      px.suivant();
    }
    return resul;
  }

}

