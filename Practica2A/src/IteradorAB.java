public class IteradorAB {
	public static void iteracion_con_for(int a, int b)	{
		int cuenta = b - a;
		int helper;
		if (b < a) {
			helper=a;
			a=b;
			b=helper;
		}
		for (int i=0; i < cuenta; i++) {
			System.out.println("Numero " + (i+a));
		}
		return;
	}
	public static void iteracion_con_while(int a, int b){
		int i=0;
		int helper;
		if (b < a) {
			helper=a;
			a=b;
			b=helper;
		}
		while (i+a < b) {
			System.out.println("Numero: "+ (i+a));
			i++;
		}
		return;
	}
	public static void recursion(int a, int b){
		int i = 0;
		int helper;
		if (b < a) {
			helper=a;
			a=b;
			b=helper;
		}
		if (i+a < b) {
			System.out.println("Numbero: " + (i+a));
			i++;
			recursion(a,b);
		}
		else {
			return;
		}
	}
}
