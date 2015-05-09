package prog3.arbol.binariobusqueda;

import prog3.lista.ListaEnlazadaGenerica;
import prog3.lista.simple.ListaDeEnterosEnlazada;

/**
 * @author Matias
 *
 */

public class ABBUtil{
	ArbolBinarioDeBusqueda<Integer> abb = new ArbolBinarioDeBusqueda<Integer>();
	abb.agregar(7);
	abb.agregar(3);
	abb.agregar(8);
	abb.agregar(1);
	abb.agregar(5);
	abb.agregar(12);
	
	
	
	public ListaEnlazadaGenerica<ListaEnlazadaGenerica<Integer>> sumaCaminos(ArbolBinarioDeBusqueda<Integer> ABB, int valor){
		ListaEnlazadaGenerica<ListaEnlazadaGenerica<Integer>> lista = new ListaEnlazadaGenerica<ListaEnlazadaGenerica<Integer>>();
		ListaDeEnterosEnlazada lista2 = new ListaDeEnterosEnlazada();
	}
	
	private int sumaCaminosRecu(ArbolBinarioDeBusqueda<Integer> abb, ListaDeEnterosEnlazada aux, ListaEnlazadaGenerica<ListaEnlazadaGenerica<Integer>> lista, int valor){
		if (valor - abb.getDatoRaiz() == 0) {
			aux.agregarFinal(abb.getDatoRaiz());
		}
		else {
			if (valor - abb.getDatoRaiz() > 0) {
				aux.agregarFinal(abb.getDatoRaiz());
				sumaCaminosRecu(abb.getHijoDerecho(), aux, lista, valor - abb.getDatoRaiz());
				sumaCaminosRecu(abb.getHijoIzquierdo(), aux, lista, valor - abb.getDatoRaiz());
				aux.eliminar(abb.getDatoRaiz());
			}
		}
		lista.agregarFinal(aux);
	}
}
