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
		visitados[origen.posicion()-1] = true; // visitamos el vertice actual
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
				if (!visitados[actual.verticeDestino().posicion()-1]) {
					dfs(camino,caminoFinal,actual.verticeDestino(),destino,visitados); // llamado recursivo
				}
			}
		}
		visitados[origen.posicion()-1] = false;
		camino.eliminar(camino.tamanio());
	}

	public ListaGenerica<String> devolverCaminoExceptuando(ListaGenerica<String> ignorar, String ciudad1, String ciudad2){
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
		dfs_exceptuando(camino,caminoFinal,origen,destino,visitados, ignorar);
		return caminoFinal;
	}

	private void dfs_exceptuando(ListaGenerica<String> camino, ListaGenerica<String> caminoFinal, Vertice<String> origen, Vertice<String> destino, boolean[] visitados, ListaGenerica<String> ignorar){
		visitados[origen.posicion()-1] = true;
		camino.agregarFinal(origen.dato());
		if (camino.tamanio() <= caminoFinal.tamanio() || caminoFinal.esVacia()) {
			this.copiar(camino,caminoFinal);
		} else {
			ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(origen);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				Arista<String> actual = adyacentes.proximo();
				if (!visitados[actual.verticeDestino().posicion()-1] && !ignorar.incluye(actual.verticeDestino().dato())) {
					dfs_exceptuando(camino,caminoFinal,actual.verticeDestino(), destino, visitados, ignorar);
				}
			}
		}
		visitados[origen.posicion() - 1] = false;
		camino.eliminar(camino.tamanio());
	}

	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2){
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
		int[] pesoTotal = new int[1];
		pesoTotal[0] = 0;
		int pesoAct = 0;
		dfs_mas_corto(camino,caminoFinal,origen,destino,visitados, pesoAct, pesoTotal);
		return caminoFinal;
	}

	private void dfs_mas_corto(ListaGenerica<String> camino, ListaGenerica<String> caminoFinal, Vertice<String> origen, Vertice<String> destino, boolean[] visitados, int pesoAct, int[] pesoTotal){
		visitados[origen.posicion()-1] = true;
		camino.agregarFinal(origen.dato());
		if (origen.equals(destino)) {
			if (pesoAct <= pesoTotal[0]) {
				pesoTotal[0] = pesoAct;
				this.copiar(camino,caminoFinal);
			}
		} else {
			ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(origen);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				Arista<String> actual = adyacentes.proximo();
				if (!visitados[actual.verticeDestino().posicion() - 1]) {
					dfs_mas_corto(camino,caminoFinal,actual.verticeDestino(), destino, visitados, pesoAct + actual.peso(), pesoTotal);
				}
			}
		}
		visitados[origen.posicion()-1] = false;
		camino.eliminar(camino.tamanio());
	}

	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		ListaGenerica<String> caminoFinal = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
		Vertice<String> origen = null;
		Vertice<String> destino = null;
		boolean[] visitados = new boolean[vertices.tamanio()];
		vertices.comenzar();
		while (!vertices.fin()) {
			Vertice<String> ciudad_actual = vertices.proximo();
			if (ciudad_actual.dato().compareTo(ciudad1) == 0) {
				origen = ciudad_actual;
			}
			if (ciudad_actual.dato().compareTo(ciudad2)== 0) {
				destino = ciudad_actual;
			}
		}
		dfs_combustible(camino,caminoFinal,visitados,tanqueAuto,origen,destino);
		return caminoFinal;
	}

	private void dfs_combustible(ListaGenerica<String> camino, ListaGenerica<String> caminoFinal, boolean[] visitados, int tanqueAuto, Vertice<String> origen, Vertice<String> destino){
		visitados[origen.posicion()-1] = true;
		camino.agregarFinal(origen.dato());
		if (origen.equals(destino)) {
			if (camino.tamanio() <= caminoFinal.tamanio() || caminoFinal.esVacia()) {
				this.copiar(camino,caminoFinal);
			}
		} else {
			ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(origen);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				Arista<String> actual = adyacentes.proximo();
				if (!visitados[actual.verticeDestino().posicion()-1]) {
					if (tanqueAuto - actual.peso() > 0) {
						dfs_combustible(camino,caminoFinal,visitados,tanqueAuto - actual.peso(), actual.verticeDestino(), destino);
					}
				}
			}
		}
		visitados[origen.posicion()-1] = false;
		camino.eliminar(camino.tamanio());
	}

	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoFinal = new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
		boolean[] visitados = new boolean[vertices.tamanio()];
		Vertice<String> origen = null;
		Vertice<String> destino = null;
		vertices.comenzar();
		while (!vertices.fin() && (origen == null || destino == null)) {
			Vertice<String> ciudad_actual = vertices.proximo();
			if (ciudad_actual.dato().equals(ciudad1)) {
				origen = ciudad_actual;
			}
			if (ciudad_actual.dato().equals(ciudad2)) {
				destino = ciudad_actual;
			}
		}
		int[] cargaTotal = new int[1];
		cargaTotal[0] = 9999999;
		int cargaActual = 0;
		dfs_menor_carga(camino,caminoFinal,visitados,origen,destino,tanqueAuto,cargaTotal,cargaActual);
		return caminoFinal;
	}

	private void dfs_menor_carga(ListaGenerica<String> camino, ListaGenerica<String> caminoFinal, boolean[] visitados, Vertice<String> origen, Vertice<String> destino, int tanqueAuto, int[] cargaTotal, int cargaActual){
		visitados[origen.posicion()-1] = true;
		camino.agregarFinal(origen.dato());
		if (origen.equals(destino)) {
			if (cargaActual < cargaTotal[0]) {
				cargaTotal[0] = cargaActual;
				this.copiar(camino,caminoFinal);
			}
		} else {
			ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(origen);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				Arista<String> actual = adyacentes.proximo();
				if (!visitados[actual.verticeDestino().posicion()-1]) {
					if (tanqueAuto - actual.peso() < 0) {
						dfs_menor_carga(camino,caminoFinal, visitados, actual.verticeDestino(), destino, tanqueAuto - actual.peso(), cargaTotal, cargaActual + 1);
					} else {
						dfs_menor_carga(camino,caminoFinal, visitados,actual.verticeDestino(), destino, tanqueAuto - actual.peso(), cargaTotal, cargaActual);
					}
				}
			}
		}
		visitados[origen.posicion()-1] = false;
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
