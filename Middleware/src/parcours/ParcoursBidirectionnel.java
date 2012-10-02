package parcours;

public interface ParcoursBidirectionnel<Element>
                        extends Parcours<Element>{

  public void precedent();
  // pr�requis : this n'est pas en fin de parcours
  // effet : positionne this sur l'�l�ment precedent

  public void queue();
  // effet : positionne this sur l'�l�ment de queue
  // ou en fin de parcours si la collection est vide
}
