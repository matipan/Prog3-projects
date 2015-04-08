package animales.prog3.info;

/**
 * @author Matias
 *
 */
public class Gato extends Animal {
	@Override
	public void saludo(){
		System.out.println("Miau!");
	}
	
	public void sonarCascable(){
		System.out.println("Clin");
	}
}
