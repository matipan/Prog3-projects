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
	private boolean esHoja(){
		if((ab.getHijoDerecho() == null)&&(ab.getHijoIzquierdo() == null)){
			return true;
		}
		else{
			return false;
		}
	}
	
	private void reemplazarRaizCon(ArbolBinarioDeBusqueda<T> ab){
		ab.setHijoIzquierdo() = this.getHijoIzquierdo();
		ab.setHijoDerecho() = this.getHijoDerecho();
		ab.getDatoRaiz() = this.getDatoRaiz();
	}

	private ArbolBinarioDeBusqueda<T> minimoIzquierdo(ArbolBinarioDeBusqueda<T> ab){
		if (ab.getHijoIzquierdo() != null) {
			minimoIzquierdo(ab.getHijoIzquierdo());
		}
		else {
			return ab;
		}
	}
	
	private ArbolBinarioDeBusqueda<T> maximoDerecho(ArbolBinarioDeBusqueda<T> ab){
		if (ab.getHijoDerecho() != null) {
			maximoDerecho(ab.getHijoDerecho());
		}
		else {
			return ab;
		}
	}
	private void eliminarRecu(T dato, ArbolBinarioDeBusqueda<T> ab){
		if(ab.getDatoRaiz().compareTo(dato)==0){
			//Entra porque encontro el dato
			if (!ab.esHoja()) {
				//Caso de que tengas hijos entra aca
				if (ab.getHijoDerecho()!=null) {
					if (ab.getHijoIzquierdo()!=null) {
						//Caso de que tiene hijo izquierdo y derecho
						ab.reemplazarRaizCon(maximoDerecho(ab));
					}
					else {
						//Caso de que tiene hijo derecho pero no izquierdo
						ab.reemplazarRaizCon(minimoIzquierdo(ab));
					}
				}
				else {
					//Entra aca porque tiene hijo izquierdo y no tiene hijo derecho
					ab.reemplazarRaizCon(maximoDerecho(ab));
				}
			}
		}
		else {
			// Entra aca porque no encontro el dato
			if (ab.getDatoRaiz().compareTo(dato) > 0) {
				eliminarRecu(dato,ab.getHijoIzquierdo());
			}
			else {
				eliminarRecu(dato,ab.getHijoDerecho());
			}
		}
	}

	public boolean esVacio() {
		return (this.getRaiz() == null);
	}

}
