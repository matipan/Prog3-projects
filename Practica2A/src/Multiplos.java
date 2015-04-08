
public class Multiplos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 3;
		Multiplos.getMultiplos(num);
	}
	public static int[] getMultiplos(int n){
		int[] arreglo = new int[n];
		for(int i=0; i <n ; i++){
			arreglo[i]=n*(i+1);
			System.out.println("Posicion" + i + " multiplo: " + arreglo[i]);
		}
		return arreglo;
	}
}
