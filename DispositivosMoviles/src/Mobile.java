
/**
 * @author Matias
 * 
 */
public class Mobile {
	public Mobile(String marca, String sistemaOperativo, String modelo,
			int costo) {
		super();
		this.marca = marca;
		this.sistemaOperativo = sistemaOperativo;
		this.modelo = modelo;
		this.costo = costo;
	}
	private String marca;
	private String sistemaOperativo;
	private String modelo;
	private int costo;
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return the sistemaOperativo
	 */
	public String getSistemaOperativo() {
		return sistemaOperativo;
	}
	/**
	 * @param sistemaOperativo the sistemaOperativo to set
	 */
	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}
	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the costo
	 */
	public int getCosto() {
		return costo;
	}
	/**
	 * @param costo the costo to set
	 */
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	
	

}
