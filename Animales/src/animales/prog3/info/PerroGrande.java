package animales.prog3.info;

/**
 * @author Matias
 *
 */
public class PerroGrande extends Perro {
	@Override
	public void saludo(){
		System.out.println("Guauuuuuuuuuuuu!");
	}
	@Override
	public void saludo(Perro otro){
		System.out.println("Guauuuuuuuuuuuuu Guauuuuuuuuuuuuu!");
	}
}
