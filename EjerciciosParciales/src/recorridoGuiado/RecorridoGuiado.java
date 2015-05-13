package recorridoGuiado;
import prog3.arbol.binario.ArbolBinario;
import prog3.lista.ListaEnlazadaGenerica;
import prog3.lista.ListaGenerica;

public class RecorridoGuiado {
	public void recorridoGuiado(ArbolBinario<Integer> ab){
		ListaGenerica<ArbolBinario<Integer>> lis=new ListaEnlazadaGenerica<ArbolBinario<Integer>>();
		lis.agregarFinal(ab);
		while(!lis.esVacia()){
			ArbolBinario<Integer> min=sacarMinimo(lis);//devuelve el minimo y lo elimina de la lista
			System.out.print(min.getDatoRaiz()+" ");
			if(!min.getHijoIzquierdo().esVacio())
				lis.agregarFinal(min.getHijoIzquierdo());
			if(!min.getHijoDerecho().esVacio())
				lis.agregarFinal(min.getHijoDerecho());
		}
	}
	private ArbolBinario<Integer> sacarMinimo(ListaGenerica<ArbolBinario<Integer>> lis){
		ArbolBinario<Integer> min=lis.elemento(1);
		lis.comenzar();
		while(!lis.fin()){
			ArbolBinario<Integer> temp=lis.proximo();
			if(temp.getDatoRaiz()<min.getDatoRaiz())
				min=temp;
		}
		lis.eliminar(min);
		return min;
	}

	public static void main(String []args){
		/*
		 *        20
		 *      /    \
		 *     7      4
		 *    / \    / \
		 *   9   6  3   8
		 *  /   /    \
		 * 6   1      1
		 *
		 */
		ArbolBinario<Integer> nueve=new ArbolBinario<Integer>(9);
		ArbolBinario<Integer> seis=new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> tres=new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> ocho=new ArbolBinario<Integer>(8);
		nueve.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
		seis.agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
		tres.agregarHijoDerecho(new ArbolBinario<Integer>(1));
		ArbolBinario<Integer> raiz=new ArbolBinario<Integer>(20);
		ArbolBinario<Integer> siete=new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> cuatro=new ArbolBinario<Integer>(4);
		siete.agregarHijoDerecho(seis);
		siete.agregarHijoIzquierdo(nueve);
		cuatro.agregarHijoDerecho(ocho);
		cuatro.agregarHijoIzquierdo(tres);
		raiz.agregarHijoDerecho(cuatro);
		raiz.agregarHijoIzquierdo(siete);
		RecorridoGuiado rg=new RecorridoGuiado();
		rg.recorridoGuiado(raiz);
	}

}

