package prog3.lista.simple;

public class ListaDeEnterosEnlazada extends ListaDeEnteros {
	private NodoEntero inicio;
	private NodoEntero actual;
	private NodoEntero fin;

	private int tamanio;

	@Override
	public void comenzar() {
		actual = inicio;
	}

	@Override
	public Integer proximo() {
		Integer elto = actual.getDato();
		actual = actual.getSiguiente();
		return elto;
	}

	@Override
	public boolean fin() {
		return (actual == null);
	}

	@Override
	public Integer elemento(int pos) {
		if (pos < 1 || pos > this.tamanio())
			return null;
		NodoEntero n = this.inicio;
		while (pos-- > 1)
			n = n.getSiguiente();
		return n.getDato();
	}

	@Override
	public boolean agregarEn(Integer elem, int pos) {
		if (pos < 1 || pos > this.tamanio() + 1)
			return false;
		this.tamanio++;
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (pos == 1) {
			aux.setSiguiente(inicio);
			inicio = aux;
		} else {
			NodoEntero n = this.inicio;
			NodoEntero ant = null;
			int posActual = 1;
			while (!(n == null) && (posActual < pos)) {
				ant = n;
				n = n.getSiguiente();
				posActual++;
			}
			aux.setSiguiente(n);
			ant.setSiguiente(aux);
			// Nuevo
			if (aux.getSiguiente() == null)
				fin = aux;
		}
		return true;
	}

	// agregarInicio agrega en la primer posicion (1) el elemento elem recibido
	// y devuelve true, dado que siempre puede agregar el elemento
	@Override
	public boolean agregarInicio(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if(inicio == null){
			inicio = aux;
			fin = aux;
		}
		else{
			aux.setSiguiente(inicio);
			inicio = aux;
		}
		tamanio++;
		return true;
	}

	@Override
	public boolean agregarFinal(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (inicio == null) {
			inicio = aux;
			fin = aux;
		} else {
			fin.setSiguiente(aux);
			fin = aux;
		}
		tamanio++;
		return true;
	}

	@Override
	public boolean eliminar(Integer elem) {
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while ((n != null) && (!n.getDato().equals(elem))) {
			ant = n;
			n = n.getSiguiente();
		}
		if (n == null)
			return false;
		else {
			if (ant == null)
				inicio = null;
			else
				ant.setSiguiente(n.getSiguiente());
			this.tamanio--;
			// Nuevo
			// if (ant.getSiguiente()==null)
			// fin=ant;

			return true;
		}
	}

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 1 || pos > this.tamanio())
			return false;
		this.tamanio--;
		if (pos == 1) {
			inicio = inicio.getSiguiente();
			return true;
		}
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while (!(n == null) && (pos > 1)) {
			pos--;
			ant = n;
			n = n.getSiguiente();
		}
		ant.setSiguiente(n.getSiguiente());
		// Nuevo
		if (ant.getSiguiente() == null)
			fin = ant;
		return true;
	}

	@Override
	public boolean incluye(Integer elem) {
		NodoEntero n = this.inicio;
		while (!(n == null) && !(n.getDato().equals(elem)))
			n = n.getSiguiente();
		return !(n == null);
	}

	@Override
	public String toString() {
		String str = "";
		NodoEntero n = this.inicio;
		while (n != null) {
			str = str + n.getDato() + " -> ";
			n = n.getSiguiente();
		}
		if (str.length() > 1)
			str = str.substring(0, str.length() - 4);
		return str;
	}

	@Override
	public int tamanio() {
		return this.tamanio;
	}

	// esVacia devuelve true si la lista no tiene elementos, false en caso
	// contrario
	@Override
	public boolean esVacia() {
		if(inicio == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public ListaDeEnterosEnlazada ordenar(){
		ListaDeEnterosEnlazada listaResultado = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		lista = this;
		System.out.println("Tamanio: " + lista.tamanio());
		while(!lista.esVacia()){
			int min=999;
			int min2= 0;
			for(int m = 1 ; m <= lista.tamanio() ; m++){
				if(lista.elemento(m) < min){
					min = lista.elemento(m);
					min2 = m;
				}
			}
			listaResultado.agregarFinal(min);
			lista.eliminarEn(min2);
		}
		return listaResultado;
	}
}
