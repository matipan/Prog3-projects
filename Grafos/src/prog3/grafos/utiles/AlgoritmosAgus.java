package prog3.grafos.utiles;
import prog3.grafos.*;
import prog3.lista.*;
public class AlgoritmosAgus<T> {

	public static void main(String[]args){
		Grafo<String> mapaCiudades=new GrafoImplListAdy<String>();
		Vertice<String> a=new VerticeImplListAdy<String>("Bariloche");
		Vertice<String> b=new VerticeImplListAdy<String>("Villa");
		Vertice<String> c=new VerticeImplListAdy<String>("Chile");
		Vertice<String> d=new VerticeImplListAdy<String>("SanMa");
		Vertice<String> e=new VerticeImplListAdy<String>("Pepe");
		Vertice<String> f=new VerticeImplListAdy<String>("Bolson");
		Vertice<String> g=new VerticeImplListAdy<String>("Nqn");
		mapaCiudades.agregarVertice(a);
		mapaCiudades.agregarVertice(b);
		mapaCiudades.agregarVertice(c);
		mapaCiudades.agregarVertice(d);
		mapaCiudades.agregarVertice(e);
		mapaCiudades.agregarVertice(f);
		mapaCiudades.agregarVertice(g);

		mapaCiudades.conectar(a,e,10);
		mapaCiudades.conectar(a,f,20);
		mapaCiudades.conectar(a,d,30);
		mapaCiudades.conectar(b,a,50);
		mapaCiudades.conectar(c,b,10);
		mapaCiudades.conectar(f,c,30);
		mapaCiudades.conectar(f,e,10);
		mapaCiudades.conectar(e,g,20);
		mapaCiudades.conectar(d,g,10);
		mapaCiudades.conectar(f,g,40);

		Algoritmos<String> alg=new Algoritmos<String>();
		System.out.println(alg.subgrafoCuadrado(mapaCiudades));
		System.out.println(alg.getGrado(mapaCiudades));
	}

	public boolean subgrafoCuadrado(Grafo<T> grafo){
		boolean[] visitados= new boolean[grafo.listaDeVertices().tamanio()];
		boolean[] hayCiclo={false};
		ListaGenerica<Vertice<T>> aux=new ListaEnlazadaGenerica<Vertice<T>>();
		int i=1;
		while(i<=visitados.length && !hayCiclo[0]){
			if(!visitados[i-1])
				dfsCuadrado(grafo,hayCiclo,visitados,grafo.listaDeVertices().elemento(i),aux);
			i++;
		}
		return hayCiclo[0];
	}

	private void dfsCuadrado(Grafo<T> grafo, boolean[] hayCiclo,boolean[] visitados,Vertice<T> entrada,ListaGenerica<Vertice<T>> aux){
		visitados[entrada.posicion()-1]=true;
		aux.agregarFinal(entrada);
		ListaGenerica<Arista<T>> ady=grafo.listaDeAdyacentes(entrada);
		ady.comenzar();
		while(!ady.fin() && !hayCiclo[0]){
			Arista<T> a=ady.proximo();
			if(a.verticeDestino().equals(aux.elemento(aux.tamanio()-3)))
				hayCiclo[0]=true;
			else
				if(!visitados[a.verticeDestino().posicion()-1])
					dfsCuadrado(grafo,hayCiclo,visitados,a.verticeDestino(),aux);
		}
		aux.eliminar(aux.tamanio());
		visitados[entrada.posicion()-1]=false;
	}

	public int getGrado(Grafo<T> grafo){
		int[]grados=new int[grafo.listaDeVertices().tamanio()];
		for(int i=1;i<=grados.length;i++){
			ListaGenerica<Arista<T>> ady=grafo.listaDeAdyacentes(grafo.vertice(i));
			ady.comenzar();
			while(!ady.fin()){
				Arista<T> a=ady.proximo();
				grados[i-1]++;
				grados[a.verticeDestino().posicion()-1]++;
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i:grados){
			if(i>max)
				max=i;
		}
		return max;
	}

}
