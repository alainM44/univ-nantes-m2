package ens;

public class EnsembleDEntiers extends Ensemble<Integer> {
  public static  EnsembleDEntiers aPartirDe(int[] tab){
  // résultat : un nouvel ensemble contenant les éléments de tab
    EnsembleDEntiers resul=new EnsembleDEntiers();
    for (int i=0;i<tab.length;i++){
      resul.ajouteElement(tab[i]);
    }
    return resul;
  }

}
