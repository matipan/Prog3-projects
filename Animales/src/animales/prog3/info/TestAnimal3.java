package animales.prog3.info;

/**
 * @author Matias
 *
 */
public class TestAnimal3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gato gato1 = new Gato();
		gato1.saludo();
		Perro perro1 = new Perro();
		perro1.saludo();
		PerroGrande perrogrande1 = new PerroGrande();
		perrogrande1.saludo();
		
		Animal animal1 = new Gato();
		animal1.saludo();
		Animal animal2 = new Perro();
		animal2.saludo();
		Animal animal3 = new PerroGrande();
		animal3.saludo();
		
		//Perro perro2 = animal2;
		//PerroGrande perrogrande2 = animal3;
		//Perro perro3 = animal3;
		///Gato gato2 = animal2;
		//perro2.saludo(perro3);
		//perro3.saludo(perro2);
		//perro2.saludo(perrogrande2);
		//perrogrande2.saludo(perro2);
		//perrogrande2.saludo(perrogrande1);
	}

}
