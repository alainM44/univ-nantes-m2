package parcours;

public interface Parcours<Element> {

  public void tete();
  // effet : positionne this en début de collection
  // ou en fin de parcours si la collection est vide

  public void suivant();
  // prérequis : this n'est pas en fin de parcours
  // effet : positionne this sur l'élément suivant

  public boolean estEnFin();
  // résultat : indique si this est en fin de parcours
  // (au delà du dernier)

  public Element elementCourant();
  // prérequis : this n'est pas en fin de parcours
  // résultat : l'élement courant désigné par this
}

