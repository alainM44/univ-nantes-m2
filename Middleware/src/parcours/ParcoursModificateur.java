package parcours;

public interface ParcoursModificateur<TypeElement>
                        extends Parcours<TypeElement>{

  public void modifElement(TypeElement e);
  // prérequis : this n'est pas en fin de parcours
  // effet : modifie l'élément courant de this en lui affectant e

  public void ajouteElement(TypeElement e);
  // effet : insère e après l'élément courant de this, insère en
  // tête si this est en fin de parcours, et se positionne sur
  // l'élément ajouté

  public void retireElement();
  // prérequis : this n'est pas en fin de parcours
  // effet : retire l'élément courant de this et se positionne sur
  // le suivant de l'élément supprimé, ou en fin de parcours si
  // on a retiré le dernier

}
