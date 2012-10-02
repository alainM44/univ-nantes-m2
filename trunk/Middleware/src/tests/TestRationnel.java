package tests;

import es.*;

class TestRationnel {

  public static void main(String[] arg) {

    System.out.println("TEST DE SOMME");
    Rationnel A = new Rationnel(0);
    Rationnel B = new Rationnel(19125,34425);
    Rationnel C = Rationnel.somme(A,B); 
    System.out.println("A="+A+"   B="+B+"   C="+C); // 5/9
    A = new Rationnel(38,27);
    C = Rationnel.somme(A,B); 
    System.out.println("A="+A+"   B="+B+"   C="+C); // 477/243 = 53/27
    A = new Rationnel(-234,243);
    C = Rationnel.somme(A,C); 
    System.out.println("A="+A+"   C="+C+"   C="+C); // -11/27
    C = Rationnel.somme(A,B); 
    System.out.println("A="+A+"   B="+B+"   C="+C); // 1
    System.out.println("TEST DE PRODUIT");
    A=C;
    B = new Rationnel(0);
    C = Rationnel.produit(A,B); 
    System.out.println("A="+A+"   B="+B+"   C="+C); // 0
    B = new Rationnel(477,243);
    C = Rationnel.produit(A,B); 
    System.out.println("A="+A+"   B="+B+"   C="+C); // -583/729
  }
}
