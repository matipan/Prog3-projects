
/**
 * @author Matias
 *
 */
public class Tablet extends Mobile {
	public Tablet(String marca, String sistemaOperativo, String modelo,
			int costo, int pulgadas) {
		super(marca, sistemaOperativo, modelo, costo);
		this.pulgadas = pulgadas;
	}
	private int pulgadas;
	/**
	 * @return the pulgadas
	 */
	public int getPulgadas() {
		return pulgadas;
	}
	/**
	 * @param pulgadas the pulgadas to set
	 */
	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}
	
	public boolean equals(Object o){
		boolean result = false;
		if ((o!=null)&&(o instanceof Tablet)) {
			Tablet t = (Tablet)o;
			if (t.getPulgadas()==this.getPulgadas()) {
				result = true;
			}
		}
		return result;
	}

	public String toString(){
		return "Pulgadas: " + getPulgadas();
	}

}
