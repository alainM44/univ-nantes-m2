package parcours;

public interface ParcoursModificateur<TypeElement>
                        extends Parcours<TypeElement>{

  public void modifElement(TypeElement e);
  // pr�requis : this n'est pas en fin de parcours
  // effet : modifie l'�l�ment courant de this en lui affectant e

  public void ajouteElement(TypeElement e);
  // effet : ins�re e apr�s l'�l�ment courant de this, ins�re en
  // t�te si this est en fin de parcours, et se positionne sur
  // l'�l�ment ajout�

  public void retireElement();
  // pr�requis : this n'est pas en fin de parcours
  // effet : retire l'�l�ment courant de this et se positionne sur
  // le suivant de l'�l�ment supprim�, ou en fin de parcours si
  // on a retir� le dernier

}
