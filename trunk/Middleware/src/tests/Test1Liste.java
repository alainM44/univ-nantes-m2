package tests;

import list.*;

class Test1Liste {

    public static void main(String[] z){

      Integer[] T1={12,25,67,14,12,14};
      Liste<Integer> li = new Liste<Integer>(T1);
      System.out.println("li="+li);
      Object o=new Object();
      Object[] T2={o,o,o,o};
      Liste<Object> lo = new Liste<Object>(T2);
      System.out.println("lo="+lo);

      Liste<Integer> li2 = Liste.aPartirDe(T1);
      System.out.println("li2="+li2);
      Liste<Object> lo2 = Liste.aPartirDe(T2);
      System.out.println("lo2="+lo2);
    }

}
