package prog3.grafos.utiles;
import prog3.grafos.*;
import prog3.lista.*;

public class Delta {
	public int maxIslasDistintas(Grafo<String> grafo){
		ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoFinal = new ListaEnlazadaGenerica<String>();
		boolean[] visitados = new boolean[vertices.tamanio()];
		vertices.comenzar();
		Vertice<String> inicial = vertices.proximo();
		dfs_max(inicial,inicial,visitados,camino,caminoFinal, grafo);
		return caminoFinal.tamanio();
	}

	private void dfs_max(Vertice<String> inicial, Vertice<String> actual, boolean[] visitados, ListaGenerica<String> camino, ListaGenerica<String> caminoFinal, Grafo<String> grafo){
		visitados[actual.posicion()] = true;
		camino.agregarFinal(actual.dato());
		if (camino.tamanio() > caminoFinal.tamanio()) {
			copiar(camino, caminoFinal);
		} else {
			ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(actual);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				Arista<String> a_actual = adyacentes.proximo();
				if (!visitados[a_actual.verticeDestino().posicion()-1] && !a_actual.verticeDestino().equals(inicial)) {
					dfs_max(inicial, a_actual.verticeDestino(), visitados, camino, caminoFinal, grafo);
				}
			}
			visitados[actual.posicion()] = false;
			camino.eliminar(camino.tamanio());
		}
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
