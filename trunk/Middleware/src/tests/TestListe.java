import list.*;

public class TestListe{
  public static void main(String[] z){
    int[] T = {5,4,3,2,1};
    ListeDEntiers L = ListeDEntiers.aPartirDe(T);
    System.out.println("L = "+L);
    while(!L.estVide()){
      System.out.println(L.retireEnQueue());
    }
    L = ListeDEntiers.aPartirDe(T);
    System.out.println("L = "+L);
    while(!L.estVide()){
      System.out.println(L.retireEnTete());
    }
    L = ListeDEntiers.aPartirDe(T);
    System.out.println("L = "+L);
    ListeDEntiers.Parcours p = L.nouveauParcours();
    while(!p.estEnFin()){
      System.out.println(p.elementCourant());
      p.suivant();
    }
   }
}
