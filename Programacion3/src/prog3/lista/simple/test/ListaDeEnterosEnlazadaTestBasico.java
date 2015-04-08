package prog3.lista.simple.test;

import prog3.lista.simple.ListaDeEnteros;
import prog3.lista.simple.ListaDeEnterosEnlazada;

/**
 * @author Matias
 *
 */
public class ListaDeEnterosEnlazadaTestBasico {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//programa asume que los argumentos pasados al main son numeros, entonces hacemos conversion
		int cant = args.length;
		Integer[] arreglo = new Integer[cant];
		if(cant > 0){
			for(int i=0; i < cant ; i++){
				arreglo[i] = Integer.parseInt(args[i]);
			}
		}
		else{
			System.out.println("Debe proveer 1 o mas argumentos");
			System.exit(1);
		}
		ListaDeEnteros lista = new ListaDeEnterosEnlazada();
		int j = 0;
		while(j < cant){
			lista.agregarInicio(arreglo[j]);
			j++;
		}
		lista.comenzar();
		for (int k = 0; k < cant ; k++) {
			System.out.println("Elemento: " + lista.elemento(k));
			lista.proximo();
		}
	}

}
