package ens;

public class EnsembleDEntiers extends Ensemble<Integer> {
  public static  EnsembleDEntiers aPartirDe(int[] tab){
  // r�sultat : un nouvel ensemble contenant les �l�ments de tab
    EnsembleDEntiers resul=new EnsembleDEntiers();
    for (int i=0;i<tab.length;i++){
      resul.ajouteElement(tab[i]);
    }
    return resul;
  }

}
