package prog3.arbol.binario;

import prog3.lista.ListaEnlazadaGenerica;
import prog3.lista.ListaGenerica;

public class ArbolBinario<T> {

	private NodoBinario<T> raiz;
	
	public ArbolBinario(){		
		this.raiz = null;
	}
	
	public ArbolBinario(T dato){		
		this.raiz = new NodoBinario<T>(dato);
	}	
	
	private ArbolBinario(NodoBinario<T> nodo){		
		this.raiz = nodo;
	}
	
	private NodoBinario<T> getRaiz(){		
		return raiz;
	}
	
	public T getDatoRaiz(){
		if (this.getRaiz() != null){
			return this.getRaiz().getDato();
		}else{
			return null;
		}
	}
	
	public ArbolBinario<T> getHijoIzquierdo(){		
		return new ArbolBinario<T>(this.raiz.getHijoIzquierdo());
	}
	
	public ArbolBinario<T> getHijoDerecho(){		
		return new ArbolBinario<T>(this.raiz.getHijoDerecho());
	}	
	
	public void agregarHijoIzquierdo(ArbolBinario<T> hijo){		
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo){		
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}	
	
	public void eliminarHijoIzquierdo(){		
		this.raiz.setHijoIzquierdo(new NodoBinario<T>(null));
	}
	
	public void eliminarHijoDerecho(){		
		this.raiz.setHijoDerecho(new NodoBinario<T>(null));
	}	
	
	public boolean esVacio(){
		return this.raiz==null;
	}
	
	public boolean esHoja(){
		return this.getDatoRaiz()!=null && this.getHijoIzquierdo().esVacio() && this.getHijoDerecho().esVacio();
	}
	public ListaGenerica<T> frontera() {
		ListaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		this.fronteraRecu(lista);
		return lista;
	}
	
	private void fronteraRecu(ListaGenerica<T> lista){
		if(!this.getHijoIzquierdo().esVacio()){
			this.getHijoIzquierdo().fronteraRecu(lista);
		}
		if(!this.getHijoDerecho().esVacio()){
			this.getHijoDerecho().fronteraRecu(lista);
		}
		if(this.esHoja()){
			lista.agregarFinal(this.getDatoRaiz());
		}
	}
	
	private int altura(){
		if(this.esVacio()){
			return -1;
		}
		else {
			return 1 + Math.max(this.getHijoIzquierdo().altura(),this.getHijoDerecho().altura());
		}
	}

	private int contar(){
		if (this.esVacio()) {
			return 0;
		}
		else {
			return (1 + this.getHijoIzquierdo().contar() + this.getHijoDerecho().contar());
		}
	}

	public boolean lleno() {
		System.out.println("Altura del arbol:" + this.altura());
		System.out.println("Cantidad de nodos: " + this.contar());
		return this.contar() == (Math.pow(2,this.altura()+1) - 1);
	}
	
	public boolean completo() {
		//Falta implementar. 
		return true;

	}
	
}
