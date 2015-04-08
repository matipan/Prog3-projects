
/**
 * @author Matias
 *
 */
public class EjercicioSobreEscritura {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmartPhone smart1 = new SmartPhone("motorola","moto g","android",2000,155309084);
		SmartPhone smart2 = new SmartPhone("motorola","moto g","android",2000,155309084);
		if(smart1.equals(smart2)){
			System.out.println(smart1.toString());
			System.out.println(smart2.toString());
		}
		else{
			System.out.println("Que onda");
		}
	}

}
