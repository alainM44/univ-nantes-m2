package divers;

public class Paire<T1,T2>{
    public T1 premier;
    public T2 second;

    public Paire(T1 p, T2 s){premier=p; second=s;}

    public T1 getPremier(){return premier;}

    public T2 getSecond(){return second;}

    public boolean equals(Paire<T1,T2> p) {
     // r�sultat : indique si this est �gal � p
	return premier.equals(p.premier)
               && second.equals(p.second);
    }

    public String toString(){
    // r�sultat : this en clair
	return "<"+premier+","+second+">";
    }

    public static <Tp,Ts> Paire<Tp,Ts> aPartirDe(Tp p, Ts s){
    // r�sultat : une nouvelle paire <p,s>
	return new Paire<Tp,Ts>(p,s);
    } 
}
