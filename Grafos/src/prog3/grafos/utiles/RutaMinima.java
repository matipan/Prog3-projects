package prog3.grafos.utiles;
import prog3.lista.*;

public class RutaMinima {
	private ListaGenerica<String> camino;
	private boolean pasa_por_muelle;

	public boolean isPasa_por_muelle() {
		return pasa_por_muelle;
	}

	public void setPasa_por_muelle(boolean pasa_por_muelle) {
		this.pasa_por_muelle = pasa_por_muelle;
	}

	public ListaGenerica<String> getCamino() {
		return camino;
	}

	public void setCamino(ListaGenerica<String> camino) {
		this.camino = camino;
	}
}
