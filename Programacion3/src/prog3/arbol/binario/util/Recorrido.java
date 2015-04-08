package prog3.arbol.binario.util;

import prog3.arbol.binario.ArbolBinario;

public class Recorrido<T> {

	public void imprimirPreOrder(ArbolBinario<T> aBinario) {

	}

	public void imprimirInOrder(ArbolBinario<T> aBinario) {

	}

	public void imprimirPostOrder(ArbolBinario<T> aBinario) {

	}
	
	
	public static void main(String[] args){
		ArbolBinario<Integer> arbolBinarioB=new ArbolBinario<Integer>(1);		
		ArbolBinario<Integer> hijoIzquierdoB=new ArbolBinario<Integer>(2);
		hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));		
		ArbolBinario<Integer> hijoDerechoB=new ArbolBinario<Integer>(6);
		hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));		
		arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioB.agregarHijoDerecho(hijoDerechoB);
		
		Recorrido<Integer> recorrido= new Recorrido<Integer>();
		recorrido.imprimirPreOrder(arbolBinarioB);
		recorrido.imprimirInOrder(arbolBinarioB);
		recorrido.imprimirPostOrder(arbolBinarioB);
	}
}
