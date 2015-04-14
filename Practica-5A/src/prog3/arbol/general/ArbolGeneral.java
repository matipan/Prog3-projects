package prog3.arbol.general;

import prog3.lista.ListaEnlazadaGenerica;
import prog3.lista.ListaGenerica;

public class ArbolGeneral<T> {

	private NodoGeneral<T> raiz;

	public ArbolGeneral() {

		this.raiz = null;
	}

	public ArbolGeneral(T dato) {

		this.raiz = new NodoGeneral<T>(dato);

	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> lista) {

		this(dato);
		ListaGenerica<NodoGeneral<T>> hijos = new ListaEnlazadaGenerica<NodoGeneral<T>>();

		lista.comenzar();
		while (!lista.fin()) {
			ArbolGeneral<T> arbolTemp = lista.proximo();
			hijos.agregarFinal(arbolTemp.getRaiz());

		}

		raiz.setListaHijos(hijos);
	}

	private ArbolGeneral(NodoGeneral<T> nodo) {

		this.raiz = nodo;
	}

	private NodoGeneral<T> getRaiz() {

		return this.raiz;
	}

	public T getDatoRaiz() {

		return this.raiz.getDato();
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {

		ListaGenerica<ArbolGeneral<T>> lista = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		ListaGenerica<NodoGeneral<T>> hijos = (ListaGenerica<NodoGeneral<T>>) this.getRaiz().getHijos();
		lista.comenzar();
		hijos.comenzar();

		while (!hijos.fin()) {
			lista.agregarFinal(new ArbolGeneral<T>(hijos.proximo()));

		}

		return lista;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		this.raiz.getHijos().agregarFinal(hijo);
	}

	public void eliminarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		boolean ok = false;

		ListaGenerica<NodoGeneral<T>> listaHijos = (ListaGenerica<NodoGeneral<T>>) this.getRaiz().getHijos();
		listaHijos.comenzar();

		while (!listaHijos.fin() && !ok) {

			NodoGeneral<T> hijoTemp = listaHijos.proximo();
			if (hijoTemp.getDato().equals(hijo.getDato())) {
				ok = listaHijos.eliminar(hijoTemp);

			}
		}

	}

	public boolean esHoja(){
		return (this.raiz.getHijos().esVacia());
	}

	public boolean esVacio(){
		return this.raiz == null;
	}
	public Integer altura() {
		return recuAltura(this);
	}
	
	private Integer recuAltura(ArbolGeneral<T> ageneral){
		if(ageneral.esHoja()){
			return 0;
		}
		else{
			int maxAltura = -1;
			ListaGenerica<ArbolGeneral<T>> hijos = ageneral.getHijos();
			hijos.comenzar();
			while(!hijos.fin()){
				int alturaHijo = recuAltura(hijos.proximo());
				if(maxAltura < alturaHijo){
					maxAltura = alturaHijo;
				}
			}
			return 1 + maxAltura;
		}
	}

	public boolean include(T dato){
		return recuInclude(this,dato);
	}
	
	private boolean recuInclude(ArbolGeneral<T> ageneral, T dato){
		if (ageneral.getDatoRaiz() == dato) {
			return true;
		}else{
			ListaGenerica<ArbolGeneral<T>> hijos = ageneral.getHijos();
			hijos.comenzar();
			boolean encontro = false;
			while(!hijos.fin() && !encontro){
				encontro = recuInclude(hijos.proximo(),dato);
			}
			return encontro;
		}
		
	}
	public Integer nivel(T dato) {
		return recuNivel(this,dato);
	}

	private Integer recuNivel(ArbolGeneral<T> ageneral, T dato){
		return 0;
	}
	public Integer ancho() {
		// Falta implementar..
		return 0;
	}

}
