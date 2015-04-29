package prog3.arbol.binariobusqueda;

import prog3.arbol.binario.NodoBinario;
import java.lang.Comparable;
//Hola esto se un comentario

public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {

	private NodoBinario<T> raiz;

	public ArbolBinarioDeBusqueda() {
		this.raiz = null;
	}

	public ArbolBinarioDeBusqueda(T dato) {
		this.raiz = new NodoBinario<T>(dato);
	}

	private ArbolBinarioDeBusqueda(NodoBinario<T> nodo) {
		this.raiz = nodo;
	}

	private NodoBinario<T> getRaiz() {
		return raiz;
	}

	public T getDatoRaiz() {
		if (this.getRaiz() != null) {
			return this.getRaiz().getDato();
		} else {
			return null;
		}
	}

	public ArbolBinarioDeBusqueda<T> getHijoIzquierdo() {
		return new ArbolBinarioDeBusqueda<T>(this.raiz.getHijoIzquierdo());
	}

	public ArbolBinarioDeBusqueda<T> getHijoDerecho() {
		return new ArbolBinarioDeBusqueda<T>(this.raiz.getHijoDerecho());
	}
	
	private NodoBinario<T> buscar(Comparable<T> x,
			NodoBinario<T> t) {
		if (t != null) {
			if (x.compareTo(t.getDato()) < 0) {
				t = this.buscar(x, t.getHijoIzquierdo());
			} else if (x.compareTo(t.getDato()) > 0) {
				t = this.buscar(x, t.getHijoDerecho());
			} else
				; // Se encontro el nodo, asi que es t
			return t;
		} else {
			return null;
		}
	}
	
	public boolean incluye(Comparable<T> dato) {
		return buscar(dato, this.raiz) != null;
	}

	public T buscar(T dato){
    	NodoBinario<T> result = this.buscar(dato, this.getRaiz());
    	if (result != null){
    		return result.getDato();
    	}
    	return null;
    }

	public void agregar(T dato) {
		if(this.esVacio()){
			this.raiz = new NodoBinario<T>(dato);
		}
		else{
			agregarRecu(dato, this);			
		}
	}
	
	private void agregarRecu(T dato, ArbolBinarioDeBusqueda<T> ab){
		if (ab.getDatoRaiz().compareTo(dato) == 1) {
			if(ab.getHijoIzquierdo().esVacio()){
				agregarRecu(dato, ab.getHijoIzquierdo());	
			}
			else{
				ab.getRaiz().setHijoIzquierdo(new NodoBinario<T>(dato));
			}
		}
		else{
			if(ab.getDatoRaiz().compareTo(dato) == -1){
				if(ab.getHijoDerecho().esVacio()){
					agregarRecu(dato,ab.getHijoDerecho());
				}
				else{
					ab.getRaiz().setHijoDerecho(new NodoBinario<T>(dato));
				}
			}
		}
	}

	public void eliminar(T dato, ArbolBinarioDeBusqueda<T> ab) {
		// Falta implementar. Ejercicio 3a.
	}
	private boolean esHoja(ArbolBinarioDeBusqueda<T> ab){
		if((ab.getHijoDerecho() == null)&&(ab.getHijoIzquierdo() == null)){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean esVacio() {
		return (this.getRaiz() == null);
	}

}
