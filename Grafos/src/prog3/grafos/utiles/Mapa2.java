package prog3.grafos.utiles;

import prog3.lista.*;
import prog3.grafos.*;

public class Mapa2 {
	private Grafo<String> mapaCiudades;

	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){
		ListaGenerica<String> camino=new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> aux=new ListaEnlazadaGenerica<String>();
		//busco los vertices correspondientes a las ciudades
		Vertice<String> origen=null;
		Vertice<String> destino=null;
		ListaGenerica<Vertice<String>> vertices=this.mapaCiudades.listaDeVertices();
		vertices.comenzar();
		while(!vertices.fin() && (origen==null || destino==null)){
			Vertice<String> v=vertices.proximo();
			if(v.dato()==ciudad1)
				origen=v;
			if(v.dato()==ciudad2)
				destino=v;
		}
		//dfs,que devuelve una lista con el camino de origen a destino
		boolean[] visitados=new boolean[vertices.tamanio()];
		System.out.println("Origen: "+origen.dato());
		dfs(origen,destino,visitados,camino,aux);
		System.out.println("Antes de devolver del metodo: "+camino.tamanio());
		return camino;
	}

	private void dfs(Vertice<String> entrada,Vertice<String>destino,boolean[] visitados,ListaGenerica<String> camino,ListaGenerica<String> aux){
		System.out.println(entrada.dato());
		System.out.println("aux= "+aux.tamanio());
		visitados[entrada.posicion()-1]=true;
		aux.agregarFinal(entrada.dato());
		if(entrada.dato()==destino.dato()){//encontro un camino
			copia(aux, camino);
			System.out.println("camino despues de copiar: "+camino.tamanio());
			//corto recursion
		}else{
			ListaGenerica<Arista<String>> ady=this.mapaCiudades.listaDeAdyacentes(entrada);
			ady.comenzar();
			while(!ady.fin()){
				Arista<String> a=ady.proximo();
				if(!visitados[a.verticeDestino().posicion()-1])
					dfs(a.verticeDestino(),destino,visitados,camino,aux);
			}
		}
		visitados[entrada.posicion()-1]=false;
		System.out.println("Camino: "+camino.tamanio());
		aux.eliminar(aux.tamanio());
		System.out.println("Camino1: "+camino.tamanio());

	}

	public void copia(ListaGenerica<String> aux, ListaGenerica<String> camino){
		int tamanio = camino.tamanio();
		for (int i = 1; i<= tamanio; i++) {
			camino.eliminar(1);
		}
		for (int i = 1; i <= aux.tamanio(); i++) {
			camino.agregarFinal(aux.elemento(i));
		}
	}
	public Mapa2(){
		mapaCiudades=new GrafoImplListAdy<String>();
		Vertice<String> a=new VerticeImplListAdy<String>("Bariloche");
		Vertice<String> b=new VerticeImplListAdy<String>("Villa");
		Vertice<String> c=new VerticeImplListAdy<String>("Chile");
		Vertice<String> d=new VerticeImplListAdy<String>("SanMa");
		Vertice<String> e=new VerticeImplListAdy<String>("Pepe");
		Vertice<String> f=new VerticeImplListAdy<String>("Bolson");
		Vertice<String> g=new VerticeImplListAdy<String>("Nqn");
		this.mapaCiudades.agregarVertice(a);
		this.mapaCiudades.agregarVertice(b);
		this.mapaCiudades.agregarVertice(c);
		this.mapaCiudades.agregarVertice(d);
		this.mapaCiudades.agregarVertice(e);
		this.mapaCiudades.agregarVertice(f);
		this.mapaCiudades.agregarVertice(g);
		this.mapaCiudades.conectar(a,e);
		this.mapaCiudades.conectar(a,f);
		this.mapaCiudades.conectar(a,d);
		this.mapaCiudades.conectar(a,b);
		this.mapaCiudades.conectar(c,b);
		this.mapaCiudades.conectar(c,f);
		this.mapaCiudades.conectar(f,e);
		this.mapaCiudades.conectar(e,g);
		this.mapaCiudades.conectar(d,g);
		this.mapaCiudades.conectar(e,a);
		this.mapaCiudades.conectar(f,a);
		this.mapaCiudades.conectar(d,a);
		this.mapaCiudades.conectar(b,a);
		this.mapaCiudades.conectar(b,c);
		this.mapaCiudades.conectar(f,c);
		this.mapaCiudades.conectar(e,f);
		this.mapaCiudades.conectar(g,e);
		this.mapaCiudades.conectar(g,d);
	}
}
