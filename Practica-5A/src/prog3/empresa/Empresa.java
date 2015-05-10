package prog3.empresa;

import prog3.arbol.general.ArbolGeneral;
import prog3.lista.ListaEnlazadaGenerica;
import prog3.lista.ListaGenerica;
import prog3.util.ColaGenerica;

/**
 * @author Matias
 *
 */
public class Empresa {
	private ArbolGeneral<Empleado> empleados;
	
	public ListaGenerica<Integer> empleadosPorCategoria(){
		ListaGenerica<Integer> values = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Empleado>> cola = new ColaGenerica<ArbolGeneral<Empleado>>();
		int anchoNivel = 0;
		values.agregarInicio(1);
		cola.encolar(this.empleados);
		cola.encolar(null);
		while(!cola.esVacia()){
			ArbolGeneral<Empleado> aux = cola.desencolar();
			if(aux == null){
				cola.encolar(null);
				values.agregarFinal(anchoNivel);
				anchoNivel = 0;
			}
			else{
				ListaGenerica<ArbolGeneral<Empleado>> hijos = this.empleados.getHijos();
				hijos.comenzar();
				while(!hijos.fin()){
					cola.encolar(hijos.proximo());
					anchoNivel++;
				}
			}
		}
		return values;
	}
	
	public int categoriaConMasEmpleados(){
		ListaGenerica<Integer> lista = this.empleadosPorCategoria();
		int max = -1;
		lista.comenzar();
		while(!lista.fin()){
			max = (max > lista.proximo())?max:lista.proximo();
		}
		return max;
	}
	
	public int cantidadTotalDeEmpleados(){
		ListaGenerica<Integer> lista = this.empleadosPorCategoria();
		int suma = 0;
		while(!lista.fin()){
			suma = suma + lista.proximo();
		}
		return suma;
	}
	
	public void reemplazarPresidente(){
		reempRecu(this.empleados);
	}
	private ArbolGeneral<Empleado> reempRecu(ArbolGeneral<Empleado> emp){
			ListaGenerica<ArbolGeneral<Empleado>> hijos = this.empleados.getHijos();
			this.empleados = reempRecu(max(hijos));
	}

	private ArbolGeneral<Empleado> max(ListaGenerica<ArbolGeneral<Empleado>> hijos) {
		int max = -1;
		int i = 0;
		ArbolGeneral<Empleado> maximo;
		hijos.comenzar();
		while(!hijos.fin()){
			if(max <= hijos.elemento(i).getDatoRaiz().getAntiguedad()){
				max = hijos.elemento(i).getDatoRaiz().getAntiguedad();
				maximo = hijos.elemento(i);
			}
			i++;
		}
		return maximo;
	}
}
