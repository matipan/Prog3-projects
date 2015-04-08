
public class Estudiante {
	private String nombre;
	private String apellido;
	private String legajo;
	private String email;
	private int celular;
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the legajo
	 */
	public String getLegajo() {
		return legajo;
	}
	/**
	 * @param legajo the legajo to set
	 */
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the celular
	 */
	public int getCelular() {
		return celular;
	}
	/**
	 * @param celular the celular to set
	 */
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public void tusDatos(){
		System.out.println("Nombre: " + this.getNombre() + ", Apellido: " + this.getApellido() + ", Legajo: " + this.getLegajo() + ", Email: " + this.getEmail() + ", Celular: " + this.getCelular());
	}
	
}
