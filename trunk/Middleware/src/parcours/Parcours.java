package parcours;

public interface Parcours<Element> {

  public void tete();
  // effet : positionne this en d�but de collection
  // ou en fin de parcours si la collection est vide

  public void suivant();
  // pr�requis : this n'est pas en fin de parcours
  // effet : positionne this sur l'�l�ment suivant

  public boolean estEnFin();
  // r�sultat : indique si this est en fin de parcours
  // (au del� du dernier)

  public Element elementCourant();
  // pr�requis : this n'est pas en fin de parcours
  // r�sultat : l'�lement courant d�sign� par this
}

