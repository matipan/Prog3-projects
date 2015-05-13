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



	public Integer altura() {
		// falta implementar
		return 0;
	}

	public Integer nivel(T dato) {
		// falta implementar
		return -1;
	}

	public Integer ancho() {
		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		int anchoMax=0;
		int anchoNivel=0;
		while(!cola.esVacia()){
			ArbolGeneral<T> ab=cola.desencolar();
			if(ab==null){
				anchoMax=(anchoNivel>anchoMax)?anchoNivel:anchoMax;
				anchoNivel=0;
				if(!cola.esVacia()){//si termino el nivel y no es vacia
					cola.encolar(null);
				}
			}else{
				anchoNivel++;
				ListaGenerica<ArbolGeneral<T>> hijos=ab.getHijos();
				hijos.comenzar();
				while(!hijos.fin()){
					cola.encolar(hijos.proximo());
				}
			}
		}
		return anchoMax;
	}
}
