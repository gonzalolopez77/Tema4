package pruebaExamen;

import java.util.ArrayList;

public class ListaVehiculos {

	//Atributos
	private ArrayList<Coche> lista;
	
	//Constructores
	public ListaVehiculos() {
		this.lista = new ArrayList<>();
	}
	
	//Metodos
	/**
	 * Añade un nuevo vehiculo a nuestra lista
	 * 
	 * @param cocheNuevo Nuestro objeto Coche nuevo
	 * 
	 * @return true Si se ha añadido correctamente a la lista
	 */
	public boolean anadirVehiculo(Coche cocheNuevo) {
		if(buscarPorMatricula(cocheNuevo.getMatricula()) != null) {
			return false;
		}
		this.lista.add(cocheNuevo);
		return true;
	}
	
	/**
	 * Muestra todos los coches de nuestra lista
	 * 
	 */
	public void listarTodos() {
		if(this.lista.isEmpty()) {
			System.out.println("La lista esta vacia.");
			return;
		}
		
		System.out.println("--Listado de Vehiculos--");
		for(int i = 0; i < this.lista.size(); i++) {
			Coche cocheNuevo = this.lista.get(i);
			System.out.println(cocheNuevo);
			System.out.println("---------------------------------------");
		}
	}
	
	/**
	 * Buscar nuestro coche en la lista por su matricula
	 * 
	 * @param matricula Matricula el coche
	 * 
	 * @return cocheNuevo Devuelve nuetsro coche si lo ha encontrado en la lista o null si no encuentra nuestro coche
	 */
	public Coche buscarPorMatricula(String matricula) {
		for(int i = 0; i < this.lista.size(); i++) {
			Coche cocheNuevo = this.lista.get(i);
			if(cocheNuevo.getMatricula().equals(matricula)) {
				return cocheNuevo;
			}
		}
		return null;
	}
	
	/**
	 * Modifica los dias alquilado
	 * 
	 * @param matricula Matricula de nuestro coche
	 * @param dias Cambio de dias que vamos a hacer
	 * 
	 * @return true Si se cambia correctamente o false si no existe nuestro coche
	 */
	public boolean modificarDiasAlquilado(String matricula, int dias) {
		Coche coche = this.buscarPorMatricula(matricula);
		if(coche == null) {
			return false;
		}
		coche.setDiasAlquilado(dias);
		return true;
	}
	
	/**
	 * Modifica el recargo premium
	 * 
	 * @param matricula Matricula de nuestro coche
	 * @param porcentaje Porcentaje de recargo premium
	 * 
	 * @return true Si se ha modificado con exito o false Si ese coche no existe
	 */
	public boolean modificarRecargoPremium(String matricula, double porcentaje) {
		Coche coche = this.buscarPorMatricula(matricula);
		if(coche == null) {
			return false;
		}
		coche.setPorcentaje(porcentaje);
		return true;
	}
	
	/**
	 * Elimina un coche buscandolo por su matricula
	 * 
	 * @param matricula Matricula de nuestro coche
	 * 
	 * @return true Si se ha eliminado con exito o false Si el coche no existe
	 */
	public boolean eliminarPorMatricula(String matricula) {
		Coche coche = buscarPorMatricula(matricula);
		if(coche == null) {
			return false;
		}
		this.lista.remove(coche);
		return true;
	}
	
	/**
	 * Calcula el ingreso total de los recargos de todos los coches
	 * 
	 * @return sumaTotal Devuelve el ingreso total de los recargos de todos los coches
	 */
	public double calcularIngresoTotalRecargos() {
		double sumaTotal = 0.0;
		
		for(int i = 0; i<this.lista.size(); i++) {
			Coche coche = this.lista.get(i);
			sumaTotal += coche.calculoRecargoPremium();
		}
		return sumaTotal;
	}
	
	/**
	 * Lista todos los coches con un porcentaje de mas del 12%
	 */
	public void listarVehiculosPremium() {
		for(int i = 0; i < this.lista.size(); i++) {
			Coche cocheNuevo = this.lista.get(i);
			if(cocheNuevo.getPorcentaje() > 12) {
				System.out.println(cocheNuevo);
				System.out.println("------------------------------");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
