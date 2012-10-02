package tests;

class Rationnel {

  private int p; // num�rateur (sign�)
  private int q; // d�nominateur (positif)

  private int pgcd(int a, int b) {
  // pr�requis : a>0 et b>0
  // r�sultat : le pgcd de a et b
	int x=a; int y=b;
	if (x<y) {int t=x; x=y; y=t;}
        while (y!=0) {int t=x%y; x=y; y=t;}
	return x;
  }

  public Rationnel(int a, int b) {
  // pr�requis : b diff�rent de 0 (a et b de signe quelconque)
  // constructeur : cree un rationnel �gal � a/b
      if(a==0) {p=0; q=1;}
      else {
	if (b<0) { a=-a; b=-b;}
	int facteurCommun= pgcd(Math.abs(a),b);
	p = a/facteurCommun; q = b/facteurCommun;
      }
  }

  public Rationnel(int a) {
  // constructeur : cree un rationnel �gal � a
      p = a; q = 1;
  }

  public String toString() {return p+"/"+q;}

  public static boolean egal( Rationnel x, Rationnel y) {
  // indique si x et y sont egaux
      return (x.p==y.p) && (x.q==y.q);  
  }

  public static Rationnel somme(Rationnel x, Rationnel y) {
  // resultat: somme de x et y
      return new Rationnel(x.p*y.q + y.p*x.q, x.q*y.q);
  }

  public static Rationnel produit(Rationnel x, Rationnel y){
  // resultat : Rationnel produit de x par y
    return new Rationnel(x.p*y.p,x.q*y.q);
  }

  public static Rationnel quotient(Rationnel x, Rationnel y){
  // pr�requis : y diff�rent de z�ro
  // resultat : Rationnel quotient de x par y
	return new Rationnel(x.p*y.q,x.q*y.p);
  }

}
