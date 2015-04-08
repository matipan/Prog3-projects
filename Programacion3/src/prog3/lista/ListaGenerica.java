package prog3.lista;

/**
 * @author Matias
 *
 */
public abstract class ListaGenerica <T> {
	public abstract void comenzar();
	public abstract T proximo();
	public abstract boolean fin();
	public abstract T elemento(int elem);
	public abstract boolean agregarEn(T var,int elem);
	public abstract boolean agregarInicio(T var);
	public abstract boolean agregarFinal(T var);
	public abstract boolean eliminar(T var);
	public abstract boolean eliminarEn(int pos);
	public abstract boolean incluye(T var);
	public abstract boolean esVacia();
	public abstract int tamanio();
}
