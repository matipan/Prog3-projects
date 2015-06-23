package prog3.grafos.utiles;
import prog3.grafos.Vertice;
import prog3.lista.*;
import prog3.grafos.*;

public class GuiaDeTurismo {
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
				if (!visitados[actual.verticeDestino().posicion()]) {
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
