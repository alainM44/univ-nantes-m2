package list;

import divers.PaireDEntiers;

public class ListeDePairesDEntiers extends Liste<PaireDEntiers>{
  public ListeDePairesDEntiers(){
  // liste vide
      super();
  }

  public ListeDePairesDEntiers aPartirDe(PaireDEntiers[] e){
  // liste contenant les éléments de e
      return (ListeDePairesDEntiers) Liste.aPartirDe(e);
  }
}
