package prog3.grafos.utiles;
import prog3.grafos.*;
import prog3.lista.ListaEnlazadaGenerica;
import prog3.lista.ListaGenerica;
import prog3.util.ColaGenerica;

/**
 * @author Matias
 *
 */
public class Recorridos<T> {

	public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo){
		ListaGenerica<Vertice<T>>lista_vertices = new ListaEnlazadaGenerica<Vertice<T>>();
		ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
		boolean[] visitados = new boolean[vertices.tamanio()];
		vertices.comenzar();
		while (!vertices.fin()){
			Vertice<T> vertice = vertices.proximo();
			if (visitados[vertice.posicion()] == false) {
				dfs_rec(grafo, vertice, visitados,lista_vertices);
			}
		}
		return lista_vertices;
	}

	private void dfs_rec(Grafo<T> grafo, Vertice<T> vertice, boolean[] visitados, ListaGenerica<Vertice<T>> lista_vertices){
		lista_vertices.agregarInicio(vertice);
		visitados[vertice.posicion()] = true;
		ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(vertice);
		adyacentes.comenzar();
		while (!adyacentes.fin()) {
			Arista<T> arista = adyacentes.proximo();
			if (!visitados[arista.verticeDestino().posicion()]) {
				dfs_rec(grafo,arista.verticeDestino(), visitados, lista_vertices);
			}
		}
	}

	public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo){
		ListaGenerica<Vertice<T>> lista_vertices = new ListaEnlazadaGenerica<Vertice<T>>();
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();
		boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
		cola.encolar(grafo.vertice(0));
		while (!cola.esVacia()) {
			Vertice<T> tmp = cola.desencolar();
			ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(tmp);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				Arista<T> act = adyacentes.proximo();
				if (!visitados[act.verticeDestino().posicion()]) {
					cola.encolar(act.verticeDestino());
					lista_vertices.agregarInicio(act.verticeDestino());
					visitados[act.verticeDestino().posicion()] = true;
				}
			}
		}
		return lista_vertices;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
