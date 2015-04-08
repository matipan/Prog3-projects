
public class TestEstudiante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estudiante[] estudiantes = new Estudiante[3];
		Estudiante estd1 = new Estudiante();
		Estudiante estd2 = new Estudiante();
		Estudiante estd3 = new Estudiante();
		estd1.setNombre("Matias");
		estd1.setApellido("Pan");
		estd1.setEmail("matias.pan26@gmail.com");
		estd1.setLegajo("783/9");
		estd1.setCelular(155309084);
		estd2.setNombre("Agustin");
		estd2.setApellido("Sanchez");
		estd2.setEmail("agustin@gmail.com");
		estd2.setLegajo("784/9");
		estd2.setCelular(155309082);
		estd3.setNombre("Pablo");
		estd3.setApellido("Pan");
		estd3.setEmail("pablo@gmail.com");
		estd3.setLegajo("784/2");
		estd3.setCelular(154111204);
		estudiantes[0]= estd1;
		estudiantes[1]= estd2;
		estudiantes[2]= estd3;
		for (int i=0; i < 3; i++) {
			System.out.println("Datos del alumno numero: " + (i+1));
			estudiantes[i].tusDatos();
		}
	}

}
