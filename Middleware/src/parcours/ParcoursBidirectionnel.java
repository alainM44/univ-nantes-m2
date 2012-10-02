package parcours;

public interface ParcoursBidirectionnel<Element>
                        extends Parcours<Element>{

  public void precedent();
  // prérequis : this n'est pas en fin de parcours
  // effet : positionne this sur l'élément precedent

  public void queue();
  // effet : positionne this sur l'élément de queue
  // ou en fin de parcours si la collection est vide
}
