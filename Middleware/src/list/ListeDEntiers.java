package list;

public class ListeDEntiers  extends Liste<Integer>{
  public static  ListeDEntiers aPartirDe(int[] tab){
  // résultat : une nouvelle liste contenant les éléments de tab
    ListeDEntiers resul=new ListeDEntiers();
    for (int i=0;i<tab.length;i++){
      resul.ajouteEnQueue(tab[i]);
    }
    return resul;
  }
}
