package tests;


class TestImageBinaire1 {
  public static void main(String[] z) {
    ImageBinaire rectangle = ImageBinaire.aPartirDeChaine(10,15,
                  "..............."
                + "..............."
                + "...*********..."
                + "...*********..."
                + "...*********..."
                + "...*********..."
                + "...*********..."
                + "..............."
                + "..............."
                + "..............."
					      );
    System.out.println(rectangle);

    ImageBinaire copie = ImageBinaire.copie(rectangle);
    copie.blanchir(4,7); copie.blanchir(4,8); copie.noircir(7,8);
    System.out.println(copie);

  }
}
