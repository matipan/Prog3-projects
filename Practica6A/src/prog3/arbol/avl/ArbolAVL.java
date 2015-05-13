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

	private NodoAVL<T> balancear(NodoAVL<T> avl , T dato){
		if (altura(avl.getHijoIzquierdo()) - altura(avl.getHijoDerecho()) == 2) {
			if (dato.compareTo(avl.getHijoIzquierdo().getDato()) < 0) {
				rotacionSimpleIzq(avl);
			}
			else {
				rotacionDobleIzq(avl);
			}
		}
		else {
			if (altura(avl.getHijoDerecho()) - altura(avl.getHijoIzquierdo()) == 2) {
				if (dato.compareTo(avl.getHijoDerecho().getDato()) > 0) {
					rotacionSimpleDer(avl);
				}
				else {
					rotacionDobleDer(avl);
				}
			}
		}
		avl.setAltura(Math.max(altura(avl.getHijoIzquierdo()),altura(avl.getHijoDerecho())) + 1);
		return avl;
	}


	public NodoAVL<T> agregar(T dato) {
		if (this == null) {
			this.raiz = new NodoAVL<T>(dato);
		}
		else {
			if (this.getDatoRaiz().compareTo(dato) > 0) {
				this.getHijoIzquierdo().agregar(dato);
			}
			else {
				if(this.getDatoRaiz().compareTo(dato) < 0){
					this.getHijoDerecho().agregar(dato);
				}
				else; // si el dato ya esta en el arbol, no hace nada
			}
		}
		this.raiz = balancear(this.raiz, dato);
		this.getDatoRaiz().setAltura(Math.max(altura(this.getHijoIzquierdo().getRaiz()),altura(this.getHijoDerecho().getDato())) + 1);
		return this.raiz;
	}

	public void eliminar(T dato) {
		// Falta implementar. Ejercicio 6a.
	}

	public boolean esVacio() {
		return (this.getRaiz() == null);
	}
	private int altura(NodoAVL<T> avl){
		if(avl == null){
			return -1;
		}
		else{
			return avl.getAltura();
		}
	}
	private NodoAVL<T> rotacionSimpleIzq(NodoAVL<T> k1){
		NodoAVL<T> k2 = k1.getHijoIzquierdo();
		k1.setHijoIzquierdo(k2.getHijoDerecho());
		k2.setHijoDerecho(k1);
		k1.setAltura(Math.max(altura(k1.getHijoIzquierdo()), altura(k1.getHijoDerecho()))+1);
		k2.setAltura(Math.max(altura(k2.getHijoIzquierdo()), k1.getAltura()) + 1);
		return k2;
	}
	
	private NodoAVL<T> rotacionSimpleDer(NodoAVL<T> k1){
		NodoAVL<T> k2 = k1.getHijoDerecho();
		k1.setHijoDerecho(k2.getHijoIzquierdo());
		k2.setHijoIzquierdo(k1);
		k1.setAltura(Math.max(altura(k1.getHijoIzquierdo()),altura(k1.getHijoDerecho()))+1);
		k2.setAltura(Math.max(altura(k2.getHijoDerecho()), altura(k1)) + 1);
		return k2;
	}
	
	private NodoAVL<T> rotacionDobleIzq(NodoAVL<T> k1){
		k1.setHijoIzquierdo(rotacionSimpleDer(k1.getHijoIzquierdo()));
		return rotacionSimpleIzq(k1);
	}
	
	private NodoAVL<T> rotacionDobleDer(NodoAVL<T> k1){
		k1.setHijoDerecho(rotacionSimpleIzq(k1.getHijoDerecho()));
		return rotacionSimpleDer(k1);
	}

}