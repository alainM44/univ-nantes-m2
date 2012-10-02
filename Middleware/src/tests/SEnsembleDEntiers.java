package tests;

import divers.PaireDEntiers;
import list.ListeDePairesDEntiers;


class EnsembleDEntiers {

  public static final int minEntier = -999999999;
  public static final int maxEntier = +999999999;

  private ListeDePairesDEntiers intervalles; 
  // intervalles [inf,sup], disjoints, par ordre croissants

  private EnsembleDEntiers() {
  //constructeur (priv�) : cree la liste d'intervalles vide
    intervalles = new ListeDePairesDEntiers();
  }

  // l'ensemble vide
  public static EnsembleDEntiers vide = new EnsembleDEntiers();


  static int max(int i, int j) {
    if (i>j) { return i;} else {return j;}
  }

  static int min(int i, int j) {
    if (i>j) { return j;} else {return i;}
  }

  private static boolean fusionnables(PaireDEntiers x, PaireDEntiers y){
  // r�sultat : indique si les intervalles x et y sont fusionnables
    return max(x.premier,y.premier)<=min(x.second,y.second)+1;
  }

  private static boolean intersectionVide(PaireDEntiers x, PaireDEntiers y){
  // r�sultat : indique si l'intersection des intervalles x et y est vide
    return max(x.premier,y.premier)>min(x.second,y.second);
  }

  private static PaireDEntiers fusion(PaireDEntiers x, PaireDEntiers y){
  // prerequis : x et y sont des intervalles fusionnables
  // r�sultat : l'intervalle fusion de x et y
    return new PaireDEntiers(min(x.premier,y.premier),max(x.second,y.second));
  }

  private static PaireDEntiers intersection(PaireDEntiers x, PaireDEntiers y){
  // prerequis : x et y repr�sentent des intervalles d'intersection non vide
  // r�sultat : l'intervalle intersection de x et y
    return new PaireDEntiers(max(x.premier,y.premier),min(x.second,y.second));
  }


  public static EnsembleDEntiers aPartirDe(int[] T){
  // prerequis : le tableau T contient alternativement les bornes inf et sup
  // d'intervalles disjoints, par ordre croissant des bornes
  // resultat : l'ensemble d'entiers constitu� de ces intervalles
    EnsembleDEntiers resul=new EnsembleDEntiers();
    for(int i=0; i<T.length-1; i=i+2) {
	resul.intervalles.ajouteEnQueue(new PaireDEntiers(T[i],T[i+1]));
    }
    return resul;
  }

  private static String interp(int i){
      if(i==minEntier){return "-infini";}
      else if(i==maxEntier){return "+infini";}
      else {return String.valueOf(i);}
  }

  private static String intervalleToString(PaireDEntiers x) {
  // resultat : forme textuelle "en clair" de l'intervalle x
      // if (x.premier==x.second) {return String.valueOf(x.premier);}
      // else {return "["+x.premier+","+x.second+"]";}
    if (x.premier==x.second) {return interp(x.premier);}
    else {return "["+interp(x.premier)+","+interp(x.second)+"]";}
  }

  public String toString(){
  // resultat: forme textuelle "en clair" de this, de la forme :
  // { [a,b] [c,d] ... },  {} pour l'ensemble vide
    if(intervalles.estVide()) { return "{}";}
    String resul="{";
    ListeDePairesDEntiers.Parcours p = intervalles.nouveauParcours();
    while ( !p.estEnFin()) {
	resul=resul+" "+intervalleToString(p.elementCourant());
	p.suivant();
    }
    resul=resul+" }";
    return resul;
  }

  private void cumuleAuBout(PaireDEntiers nouvelIntervalle) {
  // pr�requis : si la liste d'intervalle n'est pas vide, la borne inf�rieure
  // de l'intervalle de queue est <= � la borne inf�rieure de nouvelIntervalle
  // effet : r�alise l'union normalis�e de de nouvelIntervalle � this
  // c'est-�-dire remplace l'intervalle de queue par sa fusion
  // avec nouvelIntervalle s'ils sont fusionnables,
  // ajoute nouvelIntervalle en queue sinon.
    if(intervalles.estVide()){intervalles.ajouteEnQueue(nouvelIntervalle);}
    else {
      ListeDePairesDEntiers.Parcours p = intervalles.nouveauParcours();
      p.queue();
      PaireDEntiers queue=p.elementCourant();
      if(fusionnables(nouvelIntervalle,queue)){
	  p.modifElement(fusion(nouvelIntervalle,queue));
      }
      else {intervalles.ajouteEnQueue(nouvelIntervalle);}
    }
  }


  public static EnsembleDEntiers
                         intersection(EnsembleDEntiers x,EnsembleDEntiers y){
  // resultat: l'intersection de x et de y
    EnsembleDEntiers resul = new EnsembleDEntiers();
    ListeDePairesDEntiers.Parcours px = x.intervalles.nouveauParcours();
    ListeDePairesDEntiers.Parcours py = y.intervalles.nouveauParcours();
    while (!px.estEnFin() && !py.estEnFin()) {
      PaireDEntiers ix=px.elementCourant();
      PaireDEntiers iy=py.elementCourant();
      if(!intersectionVide(ix,iy)){
	resul.intervalles.ajouteEnQueue(intersection(ix,iy));
      }
      if(ix.second<=iy.second){px.suivant();}
      if(ix.second>=iy.second){py.suivant();}
    }
    return resul;
  }

  public static EnsembleDEntiers union(EnsembleDEntiers x,EnsembleDEntiers y){
  // resultat: l'union de x et de y
    EnsembleDEntiers resul = new EnsembleDEntiers();
    ListeDePairesDEntiers.Parcours px = x.intervalles.nouveauParcours();
    ListeDePairesDEntiers.Parcours py = y.intervalles.nouveauParcours();
    while (!px.estEnFin() && !py.estEnFin()) {
      PaireDEntiers ix=px.elementCourant();
      PaireDEntiers iy=py.elementCourant();
      if(ix.premier<iy.premier){
	  resul.cumuleAuBout(ix); px.suivant();
      }
      else {
	  resul.cumuleAuBout(iy); py.suivant();
      }
    }
    while (!px.estEnFin()) {
       resul.cumuleAuBout(px.elementCourant()); px.suivant();
    }
    while (!py.estEnFin()) {
       resul.cumuleAuBout(px.elementCourant()); py.suivant();
    }
    return resul;
  }

  public static EnsembleDEntiers complementaire(EnsembleDEntiers x) {
  // r�sultat : le compl�mentaire de x dans [minEntier,maxEntier],
    EnsembleDEntiers resul = new EnsembleDEntiers();
    if(x.intervalles.estVide()){
      resul.intervalles.ajouteEnQueue(new PaireDEntiers(minEntier,maxEntier));
      return resul;
    }
    ListeDePairesDEntiers.Parcours p = x.intervalles.nouveauParcours();
    int inf;
    if(p.elementCourant().premier==minEntier){
	inf=p.elementCourant().second+1; p.suivant();
    }
    else {inf=minEntier;}
    while(!p.estEnFin()){
      int sup=p.elementCourant().premier-1;
      resul.intervalles.ajouteEnQueue(new PaireDEntiers(inf,sup));
      inf=p.elementCourant().second+1;
      p.suivant();
    }
    if(inf<maxEntier){
      resul.intervalles.ajouteEnQueue(new PaireDEntiers(inf,maxEntier));
    }
    return resul;
  }

  public static EnsembleDEntiers
                     difference(EnsembleDEntiers x,EnsembleDEntiers y){
  // resultat: la difference ensembliste x moins y
    return intersection(x,complementaire(y));
  }

  private static boolean contient(PaireDEntiers x, int k){
  // r�sultat : indique si k appartient � l'intervalle x
    return k>=x.premier && k<=x.second;
  }

  public static boolean contient(EnsembleDEntiers x, int k){
  // r�sultat : indique si k appartient � x
    boolean resul=false;
    ListeDePairesDEntiers.Parcours p = x.intervalles.nouveauParcours();
    while(!resul && !p.estEnFin()){
	resul=contient(p.elementCourant(),k); p.suivant();
    }
    return resul;
  }


}

