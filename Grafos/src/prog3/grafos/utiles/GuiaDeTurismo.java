package prog3.grafos.utiles;
import prog3.grafos.Vertice;
import prog3.lista.*;
import prog3.grafos.*;

public class GuiaDeTurismo {
	public static void main(String[] args){
		Grafo<String> mapa=new GrafoImplListAdy<String>();
		Vertice<String> o1=new VerticeImplListAdy<String>("Uno");
		Vertice<String> o2=new VerticeImplListAdy<String>("Dos");
		Vertice<String> o3=new VerticeImplListAdy<String>("Tres");
		Vertice<String> o4=new VerticeImplListAdy<String>("Cuatro");
		Vertice<String> o5=new VerticeImplListAdy<String>("Cinco");
		Vertice<String> o6=new VerticeImplListAdy<String>("Seis");
		Vertice<String> o7=new VerticeImplListAdy<String>("Siete");
		mapa.agregarVertice(o1);mapa.agregarVertice(o2);mapa.agregarVertice(o3);
		mapa.agregarVertice(o4);mapa.agregarVertice(o5);mapa.agregarVertice(o6);
		mapa.agregarVertice(o7);
		mapa.conectar(o1, o2, 30);mapa.conectar(o2, o1, 30);
		mapa.conectar(o1, o3, 15);mapa.conectar(o3, o1, 15);
		mapa.conectar(o1, o4, 10);mapa.conectar(o4, o1, 10);
		mapa.conectar(o2, o5, 60);mapa.conectar(o5, o2, 60);
		mapa.conectar(o2, o4, 25);mapa.conectar(o4, o2, 25);
		mapa.conectar(o3, o4, 40);mapa.conectar(o4, o3, 40);
		mapa.conectar(o3, o6, 20);mapa.conectar(o6, o3, 20);
		mapa.conectar(o4, o7, 35);mapa.conectar(o7, o4, 35);
		mapa.conectar(o6, o7, 30);mapa.conectar(o7, o6, 30);
		mapa.conectar(o5, o7, 20);mapa.conectar(o7, o5, 20);
		GuiaDeTurismo guia=new GuiaDeTurismo();
		ListaGenerica<String> camino=guia.caminoConMenorNroDeViajes(mapa, "Uno", "Siete");
		camino.comenzar();
		System.out.println("Camino: ");
		while(!camino.fin())
			System.out.print(camino.proximo()+" ");
	}

	public ListaGenerica<String> caminoConMenorNroDeViajes(Grafo<String> grafo, String puntoDeOrigen, String puntoDeInteres){
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoFinal = new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
		Vertice<String> v_inicial =null;
		Vertice<String> v_final   =null;
		boolean[] visitados = new boolean[vertices.tamanio()];
		vertices.comenzar();
		while (!vertices.fin()) {
			Vertice<String> actual = vertices.proximo();
			if (actual.dato().equals(puntoDeOrigen)) {
				v_inicial = actual;
			}
			if (actual.dato().equals(puntoDeInteres)) {
				v_final = actual;
			}
		}
		int[] peso_minimo = new int[2];
		peso_minimo[1] = 0;
		peso_minimo[0] = -1;
		dfs_menor_nro_de_viajes(camino, caminoFinal, grafo, v_inicial, v_final, visitados, peso_minimo);
		return caminoFinal;
	}

	private void dfs_menor_nro_de_viajes(ListaGenerica<String> camino, ListaGenerica<String> caminoFinal, Grafo<String> grafo, Vertice<String> v_inicial, Vertice<String> v_final, boolean[] visitados, int[] peso_minimo){
		visitados[v_inicial.posicion()-1]= true;
		camino.agregarFinal(v_inicial.dato());
		if (v_inicial.equals(v_final)) {
			if (peso_minimo[1] > peso_minimo[0]) {
				peso_minimo[0] = peso_minimo[1];
				copiar(camino, caminoFinal);
			}
		} else {
			ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(v_inicial);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				Arista<String> actual = adyacentes.proximo();
				if (!visitados[actual.verticeDestino().posicion()-1]) {
					peso_minimo[1] = actual.peso();
					dfs_menor_nro_de_viajes(camino, caminoFinal, grafo, actual.verticeDestino(), v_final, visitados, peso_minimo);
				}
			}
		}
		visitados[v_inicial.posicion()-1]= false;
		camino.eliminar(camino.tamanio());
	}

	public void copiar(ListaGenerica<String> fuente, ListaGenerica<String> destino){
		int tamanio = destino.tamanio();
		for (int i = 1; i<= tamanio; i++) {
			destino.eliminar(1);
		}
		for (int i = 1; i <= fuente.tamanio(); i++) {
			destino.agregarFinal(fuente.elemento(i));
		}
	}
}
