package prog3.arbol.binario.util;

import prog3.arbol.binario.ArbolBinario;

public class Recorrido<T> {

	public void imprimirPreOrder(ArbolBinario<T> aBinario) {
		System.out.println("Dato: " + aBinario.getDatoRaiz());
		if (!aBinario.getHijoIzquierdo().esVacio()) {
			imprimirPreOrder(aBinario.getHijoIzquierdo());
		}
		if (!aBinario.getHijoDerecho().esVacio()) {
			imprimirPreOrder(aBinario.getHijoDerecho());
		}
	}

	public void imprimirInOrder(ArbolBinario<T> aBinario) {
		if (!aBinario.getHijoIzquierdo().esVacio()) {
			imprimirInOrder(aBinario.getHijoIzquierdo());
		}
		System.out.println("Dato: " + aBinario.getDatoRaiz());
		if (!aBinario.getHijoDerecho().esVacio()) {
			imprimirInOrder(aBinario.getHijoDerecho());
		}

	}

	public void imprimirPostOrder(ArbolBinario<T> aBinario) {
		if (!aBinario.getHijoIzquierdo().esVacio()) {
			imprimirPostOrder(aBinario.getHijoIzquierdo());
		}
		if (!aBinario.getHijoDerecho().esVacio()) {
			imprimirPostOrder(aBinario.getHijoDerecho());
		}
		System.out.println("Dato: " + aBinario.getDatoRaiz());
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
		System.out.println("Impresion PreOrder: ");
		recorrido.imprimirPreOrder(arbolBinarioB);
		System.out.println("Impresion InOrder");
		recorrido.imprimirInOrder(arbolBinarioB);
		System.out.println("Impresion PostOrder: ");
		recorrido.imprimirPostOrder(arbolBinarioB);
		System.out.println("Esta lleno: " + arbolBinarioB.lleno());
	}
}
