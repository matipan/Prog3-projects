package prog3.lista;

/**
 * @author Matias
 *
 */
public class NodoGenerico <T>{
	private T dato;
	private NodoGenerico<T> siguiente;
	
	public NodoGenerico(){}
	
	public T getDato(){
		return dato;
	}
	public void setDato(T elem){
		this.dato = elem;
	}
	public NodoGenerico<T> getSiguiente(){
		return siguiente;
	}
	public void setSiguiente(NodoGenerico<T> sig){
		this.siguiente = sig;
	}
}
