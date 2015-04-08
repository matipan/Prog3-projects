
public class PruebaRetorno {
	public int sumaArreglo(int[] arreglo){
		int suma=0;
		for (int i : arreglo) {
			suma+=arreglo[i];
		}
		return suma;
	}
}
