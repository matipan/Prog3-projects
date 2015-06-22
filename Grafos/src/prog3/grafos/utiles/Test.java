package prog3.grafos.utiles;
import prog3.lista.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mapa mapa = new Mapa();
		ListaGenerica<String> ignorar = new ListaEnlazadaGenerica<String>();
		ignorar.agregarInicio("Bariloche");
		ListaGenerica<String> lista = mapa.devolverCaminoExceptuando(ignorar,"Chile","SanMa");
		lista.comenzar();
		while(!lista.fin()){
			System.out.println("Ciudad:" + lista.proximo());
		}
	}

}
