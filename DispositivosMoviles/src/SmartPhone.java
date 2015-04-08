
/**
 * @author Matias
 *
 */
public class SmartPhone extends Mobile {
	private int numero;
	public SmartPhone(String marca, String sistemaOperativo, String modelo,
			int costo, int numero) {
		super(marca, sistemaOperativo, modelo, costo);
		this.numero = numero;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean equals(Object o){
		boolean result = false;
		if ((o!=null)&&(o instanceof SmartPhone)) {
			SmartPhone sp = (SmartPhone)o;
			if (sp.getNumero()==this.getNumero()) {
				result = true;
			}
		}
		return result;
	}

	public String toString(){
		return "Numero: " + getNumero();
	}

} 
