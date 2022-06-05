package estruturas;

/**
* Comparador usado de maneira equivalente ao {@link java.util.Comparator}
* so que retornando double no método compare
* 
* @author Wallace Alves Esteves Manzano
*		  Guilherme Domingos Faria Silva
*		  Wellington Fernando Molina
*
* @param <T>
*/
public interface ComparatorDouble<T> {
	public double compare(T a1, T a2);
}
