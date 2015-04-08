package prog3.lista.simple.test;

import prog3.lista.simple.ListaDeEnterosEnlazada;

/**
 * @author Matias
 *
 */
public class TestOrdenamiento {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cant = args.length;
		Integer[] arreglo = new Integer[cant];
		if(cant > 0){
			for(int i=0; i < cant ; i++){
				arreglo[i] = Integer.parseInt(args[i]);
				System.out.println("Elemento " + i + " es: " + arreglo[i]);
			}
		}
		else{
			System.out.println("Debe proveer 1 o mas argumentos");
			System.exit(1);
		}
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada listaChequeo = new ListaDeEnterosEnlazada();
		int j = 0;
		while(j < cant){
			lista.agregarFinal(arreglo[j]);
			j++;
		}
		listaChequeo = lista.ordenar();
		System.out.println("Se definio listaChequeo ");
		int i = 0, anterior = 9999;
		while((!listaChequeo.fin()) && (anterior > listaChequeo.elemento(i))){
			anterior = listaChequeo.elemento(i);
			listaChequeo.proximo();
			i++;
		}
		if(listaChequeo.fin()){
			System.out.println("Funciono");
		}
		System.out.println("Lista desordenada: " + lista);
		System.out.println("Lista ordenada: " + listaChequeo);
	}
}
