package list;

public class ListeDEntiers  extends Liste<Integer>{
  public static  ListeDEntiers aPartirDe(int[] tab){
  // r�sultat : une nouvelle liste contenant les �l�ments de tab
    ListeDEntiers resul=new ListeDEntiers();
    for (int i=0;i<tab.length;i++){
      resul.ajouteEnQueue(tab[i]);
    }
    return resul;
  }
}
