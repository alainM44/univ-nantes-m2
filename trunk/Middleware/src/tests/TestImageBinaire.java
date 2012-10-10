package tests;


class TestImageBinaire {

  public static void main(String[] z) {
    ImageBinaire scene = ImageBinaire.aPartirDeChaine(29,40,
                  "..................................***..."
                + "....................................***."
                + "........***..........................***"
                + ".......*****.........................***"
                + "........***.........................***."
                + ".........*........................***..."
                + ".......*******.........................."
                + "......*.***...*........................."
                + ".....*..***....*........................"
                + "....*...***............................."
                + "........***............................."
                + ".......*****............................"
                + "......**...**..........................."
                + ".....**....**..........................."
                + ".....**....**..........................."
                + "....***....***.........................."
                + "........................................"
                + "........................................"
                + "...**..................................."
                + "....***.............********............"
                + ".....****............*********.........."
                + "......*****....*********************...."
                + "......*****************************.***."
                + "......****************************...***"
                + ".....****....**************************."
                + "....***........*********************...."
                + "...**..............***********.........."
                + "........................................"
                + "........................................"
					      );
    System.out.println(scene);

    ImageBinaire copie = ImageBinaire.copie(scene);
    while (!copie.estBlanche()){
      System.out.println(copie.extraitPartieConnexe());
    }
  }
}

