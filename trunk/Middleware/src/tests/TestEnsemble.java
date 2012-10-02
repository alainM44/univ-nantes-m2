package tests;

import ens.*;

public class TestEnsemble{
  public static void main(String[] z){
    int[] T1 = {5,4,1,2,3,2,1,1,4,};
    EnsembleDEntiers E1 = EnsembleDEntiers.aPartirDe(T1);
    System.out.println("E1 = "+E1);
    int i=1;
//    while(!E1.estVide()){
//	E1.retireElement(i); i++;
//      System.out.println("E1 = "+E1);
//    }
    E1 = EnsembleDEntiers.aPartirDe(T1);
    int[] T2 = {4,2,12,35,56};
    EnsembleDEntiers E2 = EnsembleDEntiers.aPartirDe(T2);
    System.out.println("E1 = "+E1);
    System.out.println("E2 = "+E2);
    System.out.println("E1 U E2 = "+EnsembleDEntiers.union(E1,E2));
    System.out.println("E1 /\\ E2 = "+EnsembleDEntiers.intersection(E1,E2));
    System.out.println("E1 - E2 = "+EnsembleDEntiers.difference(E1,E2));
    System.out.println("E2 - E1 = "+EnsembleDEntiers.difference(E2,E1));
  }
}
