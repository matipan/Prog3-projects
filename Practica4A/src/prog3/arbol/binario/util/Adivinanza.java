package prog3.arbol.binario.util;
import prog3.arbol.binario.*;
import prog3.lista.*;

/**
 * @author Matias
 *
 */
public class Adivinanza<T> {
	public ListaEnlazadaGenerica<String> secuenciaMasLarga(ArbolBinario<String> abinario){
		ListaEnlazadaGenerica<String> listaTotal = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> listaTmp = new ListaEnlazadaGenerica<String>();
		secuenciaRecu(abinario,listaTotal,listaTmp);
		return listaTotal;
	}

	private void copiarListas(ListaEnlazadaGenerica<String> listaTotal, ListaEnlazadaGenerica<String> listaTmp){
		for (int i = 1; i < listaTotal.tamanio() ; i++) {
			listaTotal.eliminarEn(1);
		}
		for (int i = 1; i < listaTmp.tamanio() ; i++) {
			listaTotal.agregarFinal(listaTmp.elemento(i));
		}
	}

	private void secuenciaRecu(ArbolBinario<String> arbol, ListaEnlazadaGenerica<String> listaTotal, ListaEnlazadaGenerica<String> listaTmp){
		listaTmp.agregarFinal(arbol.getDatoRaiz());
		if(arbol.esHoja()){
			if(listaTmp.tamanio() > listaTotal.tamanio()){
				copiarListas(listaTmp,listaTotal);
			}
		}
		else{
			if(!arbol.getHijoIzquierdo().esVacio()){
				listaTmp.agregarFinal("SI");
				secuenciaRecu(arbol.getHijoIzquierdo(),listaTotal,listaTmp);
				listaTmp.eliminarEn(listaTmp.tamanio());
			}
			if(!arbol.getHijoDerecho().esVacio()){
				listaTmp.agregarFinal("NO");
				secuenciaRecu(arbol.getHijoDerecho(),listaTotal,listaTmp);
				listaTmp.eliminarEn(listaTmp.tamanio());
			}
		}
		listaTmp.eliminarEn(listaTmp.tamanio());
	}
}
