package tests;


class TestPolynome {

  public static void main(String[] arg) {

    System.out.println("TEST DE SOMME");
    Polynome A = Polynome.zero;
    int[] T1 = {6,12,1,4,1,0}; Polynome B = Polynome.aPartirDe(T1);
    Polynome C = Polynome.somme(A,B); 
    System.out.println("A="+A+"   B="+B+"   C="+C);
    int[] T2 = {-1,4,2,3}; A = Polynome.aPartirDe(T2);
    C = Polynome.somme(A,B); 
    System.out.println("A="+A+"   B="+B+"   C="+C);
    int[] T3 = {5,4,2,3}; A = Polynome.aPartirDe(T3);
    C = Polynome.somme(A,B); 
    System.out.println("A="+A+"   B="+B+"   C="+C);
    System.out.println("TEST DE PRODUIT");
    A=C;
    B = Polynome.zero;
    C = Polynome.produit(A,B); 
    System.out.println("A="+A+"   B="+B+"   C="+C);
    int[] TT1 = {6,12}; int[] TT2 = {3,12}; 
    A = Polynome.aPartirDe(TT1);
    B = Polynome.aPartirDe(TT2);
    C = Polynome.produit(A,B); 
    System.out.println("A="+A+"   B="+B+"   C="+C);
    B = Polynome.aPartirDe(T1);
    C = Polynome.produit(A,B); 
    System.out.println("A="+A+"   B="+B+"   C="+C);
    int[] T4={1,1,-1,0}; A=Polynome.aPartirDe(T4);
    int[] T5={1,6,1,5,1,4,1,3,1,2,1,1,1,0}; B=Polynome.aPartirDe(T5);
    C = Polynome.produit(A,B); 
    System.out.println("A="+A+"   B="+B+"   C="+C);
    System.out.println("TEST DE DERIVEE");
    A = Polynome.derive(A); 
    B = Polynome.derive(B); 
    C = Polynome.derive(C); 
    System.out.println("A="+A+"   B="+B+"   C="+C);
    System.out.println("TEST DE VALEUR");
    System.out.println("A(2)="+A.valeur(2)
                   +"   B(2)="+B.valeur(2)
                   +"   C(2)="+C.valeur(2));

     int[] T6={1,6,-1,2,55,0}; B=Polynome.aPartirDe(T6);
     System.out.println("B = "+B);

 }
}
