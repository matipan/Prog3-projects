package prog3.grafos.utiles;

import prog3.grafos.*;
import prog3.lista.*;

/**
 * @author Matias
 *
 */
public class Mapa {
	private Grafo<String> mapaCiudades;

	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoFinal = new ListaEnlazadaGenerica<String>();
		Vertice<String> origen = null;
		Vertice<String> destino = null;
		ListaGenerica<Vertice<String>> ciudades = mapaCiudades.listaDeVertices();
		boolean[] visitados = new boolean[ciudades.tamanio()];
		ciudades.comenzar();
		while (!ciudades.fin() && (origen == null || destino == null)) {
			Vertice<String> ciudad_actual = ciudades.proximo();
			if (ciudad_actual.dato().equals(ciudad1)) {
				origen = ciudad_actual;
			}
			if (ciudad_actual.dato().equals(ciudad2)) {
				destino = ciudad_actual;
			}
		}
		dfs(camino,caminoFinal,origen,destino,visitados);
		return caminoFinal;
	}

	private void dfs(ListaGenerica<String> camino, ListaGenerica<String> caminoFinal, Vertice<String> origen, Vertice<String> destino, boolean[] visitados){
		visitados[origen.posicion()] = true; // visitamos el vertice actual
		camino.agregarFinal(origen.dato());
		if (origen.equals(destino)) {
			if (camino.tamanio() <= caminoFinal.tamanio() || caminoFinal.esVacia()) {
				this.copiar(camino,caminoFinal);
			}
		}
		else {
			ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(origen);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				Arista<String> actual = adyacentes.proximo();
				if (!visitados[actual.verticeDestino().posicion()]) {
					dfs(camino,caminoFinal,actual.verticeDestino(),destino,visitados); // llamado recursivo
				}
			}
		}
		visitados[origen.posicion()] = false;
		camino.eliminar(camino.tamanio());
	}

	public void copiar(ListaGenerica<String> fuente, ListaGenerica<String> destino){
		for (int i = 1; i<= destino.tamanio(); i++) {
			destino.eliminar(1);
		}
		for (int i = 1; i<=fuente.tamanio(); i++) {
			destino.agregarFinal(fuente.elemento(i));
		}
	}
}
