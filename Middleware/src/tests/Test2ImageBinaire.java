package tests;


import es.*;


class Test2ImageBinaire {
  public static void main(String[] z) {
      String s=Lecture.chaine("/");
      System.out.println(s);
    ImageBinaire scene = ImageBinaire.aPartirDeChaine(29,40,s);
    System.out.println(scene);

    ImageBinaire copie = ImageBinaire.copie(scene);
    while (!copie.estBlanche()){
      System.out.println(copie.extraitPartieConnexe());
    }
  }
}


