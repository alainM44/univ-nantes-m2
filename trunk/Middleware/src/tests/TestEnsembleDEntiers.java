package tests;


class TestEnsembleDEntiers {

  public static void main(String[] arg) {

    System.out.println("TEST D'OPERATIONS SUR LES ENSEMBLES");
    EnsembleDEntiers e0 = EnsembleDEntiers.vide;
    System.out.println("e0 = "+e0);
    int[] T1 = {6,12,14,20,100,100,135,147,150,155};
    EnsembleDEntiers e1 = EnsembleDEntiers.aPartirDe(T1);
    int[] T2 = {6,13,16,24,100,108,130,140,150,151};
    EnsembleDEntiers e2 = EnsembleDEntiers.aPartirDe(T2);
    System.out.println("e1 = "+e1);
    System.out.println("e2 = "+e2);
    System.out.println("e1\\/e2 = "+EnsembleDEntiers.union(e1,e2));
    System.out.println("e1\\/e2 = "+
       EnsembleDEntiers.complementaire(EnsembleDEntiers.intersection(
        EnsembleDEntiers.complementaire(e1),EnsembleDEntiers.complementaire(e2)
         )
       )
    );

    System.out.println("e1/\\e2 = "+EnsembleDEntiers.intersection(e1,e2));
    System.out.println("e1/\\e2 = "+
       EnsembleDEntiers.complementaire(EnsembleDEntiers.union(
	EnsembleDEntiers.complementaire(e1),EnsembleDEntiers.complementaire(e2)
         )
       )
    );
    System.out.println("compl e0 = "+EnsembleDEntiers.complementaire(e0));
    System.out.println("compl compl e0 = "
        +EnsembleDEntiers.complementaire(EnsembleDEntiers.complementaire(e0)));
    System.out.println("compl e1 = "+EnsembleDEntiers.complementaire(e1));
    System.out.println("e1-e2 = "+EnsembleDEntiers.difference(e1,e2));
    int[] T3 = {0,12,14,26,100,100,135,147,150,155};
    EnsembleDEntiers e3 = EnsembleDEntiers.aPartirDe(T3);
    EnsembleDEntiers e4 = EnsembleDEntiers.aPartirDe(T3);
    System.out.println("e3 = "+e3);
    System.out.println("e4 = "+e4);
    System.out.println("e3\\/e4 = "+EnsembleDEntiers.union(e3,e4));
    System.out.println("e3/\\e4 = "+EnsembleDEntiers.intersection(e3,e4));
    System.out.println("e3-e4 = "+EnsembleDEntiers.difference(e3,e4));
    System.out.println("e3\\/e3 = "+EnsembleDEntiers.union(e3,e3));
    System.out.println("e3/\\e3 = "+EnsembleDEntiers.intersection(e3,e3));
    System.out.println("e3-e3 = "+EnsembleDEntiers.difference(e3,e3));
    System.out.println("e0 contient 15 ? " + EnsembleDEntiers.contient(e0,15));
    System.out.println("e1 contient 15 ? " + EnsembleDEntiers.contient(e1,15));
    System.out.println("e2 contient 15 ? " + EnsembleDEntiers.contient(e2,15));
    System.out.println("e3 contient 15 ? " + EnsembleDEntiers.contient(e3,15));
    int[] T5 = {EnsembleDEntiers.minEntier,EnsembleDEntiers.maxEntier};
    EnsembleDEntiers e5 = EnsembleDEntiers.aPartirDe(T5);
    System.out.println("e5 = "+e5);
    System.out.println("compl e5 = "+EnsembleDEntiers.complementaire(e5));
 }
}
