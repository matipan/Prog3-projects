package prog3.arbol.avl;



public class ArbolAVL<T extends Comparable<T>> {

	private NodoAVL <T> raiz;

	public ArbolAVL() {
		this.raiz = null;
	}

	public ArbolAVL(T dato) {
		this.raiz = new NodoAVL<T>(dato);
	}

	private ArbolAVL(NodoAVL<T> nodo) {
		this.raiz = nodo;
	}

	private NodoAVL<T> getRaiz() {
		return raiz;
	}

	public T getDatoRaiz() {
		if (this.getRaiz() != null) {
			return this.getRaiz().getDato();
		} else {
			return null;
		}
	}

	public ArbolAVL<T> getHijoIzquierdo() {
		return new ArbolAVL<T>(this.raiz.getHijoIzquierdo());
	}

	public ArbolAVL<T> getHijoDerecho() {
		return new ArbolAVL<T>(this.raiz.getHijoDerecho());
	}

	private NodoAVL<T> buscar(T x, NodoAVL<T> t) {
		if (t != null) {
			if (x.compareTo(t.getDato()) < 0) {
				t = this.buscar(x, t.getHijoIzquierdo());
			} else if (x.compareTo(t.getDato()) > 0) {
				t = this.buscar(x, t.getHijoDerecho());
			} 
			// Se encontro el nodo, asi que es t
			return t;
		} else {
			return null;
		}
	}

	public boolean incluye(T x) {
		return buscar(x, this.raiz) != null;
	}

	public T buscar(T dato) {
		NodoAVL<T> nodo = buscar(dato, this.raiz);
		if (nodo != null) {
			return nodo.getDato();
		} else {
			return null;
		}
	}


	public void agregar(T dato) {
		// Falta implementar. Ejercicio 6a.

	}

	public void eliminar(T dato) {
		// Falta implementar. Ejercicio 6a.
	}

	public boolean esVacio() {
		return (this.getRaiz() == null);
	}
	
	private void rotacionSimpleIzq(NodoAVL<T> nodo){
		// Falta implementar.Ejercicio 6a.
	}
	
	private void rotacionSimpleDer(NodoAVL<T> nodo){
		// Falta implementar.Ejercicio 6a.
	}
	
	private void rotacionDobleIzq(NodoAVL<T> nodo){
		// Falta implementar.Ejercicio 6a.
	}
	
	private void rotacionDobleDer(NodoAVL<T> nodo){
		// Falta implementar.Ejercicio 6a.
	}

}