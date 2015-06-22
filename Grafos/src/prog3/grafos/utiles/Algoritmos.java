package prog3.grafos.utiles;
import prog3.lista.*;
import prog3.grafos.*;

/**
 * @author Matias
 *
 */
public class Algoritmos<T> {
	public boolean subgrafoCuadrado(Grafo<T> grafo){
		ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
		ListaGenerica<Vertice<T>> camino = new ListaEnlazadaGenerica<Vertice<T>>();
		if (vertices.tamanio() < 4) {
			return false;
		}
		boolean[] visitados = new boolean[vertices.tamanio()];
		vertices.comenzar();
		Vertice<T> origen = vertices.proximo();
		boolean[] resultado = new boolean[1];
		dfs(origen,origen,visitados, grafo, resultado, camino);
		return resultado[0];
	}

	private void dfs(Vertice<T> origen, Vertice<T> actual, boolean[] visitados, Grafo<T> grafo, boolean[] resultado, ListaGenerica<Vertice<T>> camino){
		visitados[actual.posicion() - 1] = true;
		camino.agregarFinal(actual);
		ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(actual);
		adyacentes.comenzar();
		while (!adyacentes.fin()) {
			Arista<T> a_actual = adyacentes.proximo();
			if (!visitados[a_actual.verticeDestino().posicion() - 1]) {
				if (a_actual.verticeDestino().equals(camino.elemento(camino.tamanio()-3))) {
					resultado[0] = true;
				}
				dfs(origen,a_actual.verticeDestino(), visitados, grafo, resultado, camino);
			}
		}
		visitados[actual.posicion()-1] = false;
		camino.eliminar(camino.tamanio());
	}

}
