package prog3.lista;

/**
 * @author Matias
 *
 */
public class ListaEnlazadaGenerica <T> extends ListaGenerica<T>{
	private NodoGenerico<T> inicio;
	private NodoGenerico<T> actual;
	private NodoGenerico<T> fin;
	private int tamanio;
	public ListaEnlazadaGenerica(){}
	public void comenzar(){
		actual = inicio;
	}
	public T proximo(){
		T aux = actual.getDato();
		actual = actual.getSiguiente();
		return aux;
	}
	public boolean fin(){
		if(actual == fin){
			return true;
		}
		else{
			return false;
		}
	}
	public T elemento(int pos){
		if (pos < 1 || pos > this.tamanio) {
			return null;			
		}
		NodoGenerico<T> nodo = this.inicio;
		while (pos-- > 1) {
			nodo = nodo.getSiguiente();
		}
		return nodo.getDato();
	}

	public boolean agregarEn(T dato, int pos){
		if (pos < 1 || pos > this.tamanio() + 1 ) {
			return false;
		}
		this.tamanio++;
		NodoGenerico<T> aux = new NodoGenerico<T>();
		aux.setDato(dato);
		if (pos == 1) {
			aux.setSiguiente(inicio);
			inicio = aux;
		}
		else {
			NodoGenerico<T> nodo = inicio;
			NodoGenerico<T> ant = null;
			int posicionActual = 1;
			while((nodo!=null)&&(posicionActual < pos)){
				ant = nodo;
				nodo.getSiguiente();
				posicionActual++;
			}
			aux.setSiguiente(nodo);
			ant.setSiguiente(aux);
			if(aux.getSiguiente() == null){
				fin = aux;
			}
		}
		return true;
	}

	public boolean agregarInicio(T dato){
		NodoGenerico<T> aux = new NodoGenerico<T>();
		aux.setDato(dato);
		if (inicio == null) {
			inicio = aux;
			fin = aux;
		}
		else {
			aux.setSiguiente(inicio);
			inicio = aux;
		}
		tamanio++;
		return true;
	}

	public boolean agregarFinal(T dato){
		NodoGenerico<T> aux = new NodoGenerico<T>();
		aux.setDato(dato);
		if(inicio == null){
			inicio = aux;
			fin = aux;
		}
		else {
			fin.setSiguiente(aux);
			fin = aux;
		}
		tamanio++;
		return true;
	}

	public boolean eliminar(T dato){
		NodoGenerico<T> aux = inicio;
		NodoGenerico<T> ant = null;
		while ((aux!=null)&&(aux.getDato().equals(dato))) {
			ant = aux;
			aux = aux.getSiguiente();
		}
		if (aux == null) {
			return false;
		}
		else {
			if (ant == null) {
				inicio = null;
			}
			else {
				ant.setSiguiente(aux.getSiguiente());
			}
			this.tamanio++;
			return true;
		}
	}

	public boolean eliminarEn(int pos){
		if((pos < 1)||(pos > this.tamanio)){
			return false;
		}
		NodoGenerico<T> aux = this.inicio;
		NodoGenerico<T> ant = null;
		while (pos-- > 1) {
			ant = aux;
			aux = aux.getSiguiente();
		}
		ant.setSiguiente(aux.getSiguiente());
		return true;
	}
	
	public boolean incluye(T dato){
		NodoGenerico<T> aux = this.inicio;
		while ((aux!=null)&&(aux.getDato().equals(dato))) {
			aux = aux.getSiguiente();
		}
		return !(aux == null);
	}

	public String toString(){
		return ("El tamanio de la lista es: " + this.tamanio);
	}

	public int tamanio(){
		return this.tamanio;
	}

	public boolean esVacia(){
		if(this.inicio == null){
			return true;
		}
		else{
			return false;
		}
	}
}
