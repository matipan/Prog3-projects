package animales.prog3.info;

/**
 * @author Matias
 *
 */
public class Perro extends Animal {
	@Override
	public void saludo(){
		System.out.println("Guau!");
	}
	public void saludo(Perro otro){
		System.out.println("Guau Guau!");
	}
}
