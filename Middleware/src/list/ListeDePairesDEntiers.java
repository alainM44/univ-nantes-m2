package list;

import divers.PaireDEntiers;

public class ListeDePairesDEntiers extends Liste<PaireDEntiers>{
  public ListeDePairesDEntiers(){
  // liste vide
      super();
  }

  public ListeDePairesDEntiers aPartirDe(PaireDEntiers[] e){
  // liste contenant les �l�ments de e
      return (ListeDePairesDEntiers) Liste.aPartirDe(e);
  }
}
