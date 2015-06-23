package prog3.grafos.utiles;
import prog3.lista.*;
import prog3.grafos.*;
import prog3.util.*;

public class GradosDeSeparacion {
	public int maximoGradoDeSeparacion(Grafo<String> grafo){
		ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
		int max_grad_s = 0;
		boolean es_cero = false;
		vertices.comenzar();
		while (!vertices.fin() && !es_cero) {
			Vertice<String> actual = vertices.proximo();
			int actual_gs = bfs_separacion(grafo, actual);
			if (actual_gs == 0) {
				es_cero = true;
				max_grad_s = 0;
			}
			if (actual_gs > max_grad_s) {
				max_grad_s = actual_gs;
			}
		}
		return max_grad_s;
	}

	private int bfs_separacion(Grafo<String> grafo,Vertice<String> actual){
		ColaGenerica<Vertice<String>> cola = new ColaGenerica<Vertice<String>>();
		int cant_visitados = 0;
		int ancho_nivel = 0;
		boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
		cola.encolar(actual);
		cola.encolar(null);
		visitados[actual.posicion() - 1] = true;
		cant_visitados += 1;
		while (!cola.esVacia()) {
			Vertice<String> n_actual = cola.desencolar();
			if (n_actual == null) {
				ancho_nivel += 1;
				if (!cola.esVacia()) {
					cola.encolar(null);
				}
			} else {
				ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(actual);
				adyacentes.comenzar();
				while (!adyacentes.fin()) {
					Arista<String> a_actual = adyacentes.proximo();
					if (!visitados[a_actual.verticeDestino().posicion() - 1]) {
						cant_visitados += 1;
						visitados[a_actual.verticeDestino().posicion() - 1] = true;
						cola.encolar(a_actual.verticeDestino());
					}
				}
			}
		}
		if (cant_visitados < grafo.listaDeVertices().tamanio()) {
			return 0;
		} else {
			return cant_visitados;
		}
	}
}
