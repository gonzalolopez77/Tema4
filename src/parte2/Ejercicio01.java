package parte2;

public class Ejercicio01 {

	//private
	private String dni;
	private String nombre;
	private double saldo;
	private Nacionalidad nacionalidad;
	
	public enum Nacionalidad{
		ESPAÑOLA, EXTRANGERA
	}
	
	//constructores
	public Ejercicio01(String dni, double saldo) {
		super();
		if(!dni.isBlank()) {
		this.dni = dni;
		}
		if(saldo >= 0) {
		this.saldo = saldo;
		}
	}
	
	public Ejercicio01(String dni, String nombre, double saldo) {
		super();
		if(!dni.isBlank()) {
		this.dni = dni;
		}
		if(!nombre.isBlank()) {
		this.nombre = nombre;
		}
		if(saldo >= 0) {
		this.saldo = saldo;
		}
	}
	
	public Ejercicio01(String dni, String nombre, double saldo, Nacionalidad nacionalidad) {
		super();
		if(!dni.isBlank()) {
		this.dni = dni;
		}
		if(!nombre.isBlank()) {
		this.nombre = nombre;
		}
		if(saldo >= 0) {
		this.saldo = saldo;
		}
		this.nacionalidad = nacionalidad;
	}
	
	//get y set
	public String getdni(){
		return dni;
	}
	public void setdni(String dni) {
		this.dni = dni;
	}
	
	public String getnombre() {
		return nombre;
	}
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getsaldo() {
		return saldo;
	}
	public void setsaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public Nacionalidad getnacionalidad() {
		return nacionalidad;
	}
	public void setnacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	//sacar dinero
	public boolean sacarDinero (double cantidad) {
		if(cantidad > 0 && saldo >= cantidad) {
			saldo -= cantidad;
			return true;
		}else {
			return false;
		}
	}
	
	//meter dinero
	public boolean meterDinero(double cantidad) {
		if(cantidad > 0) {
			saldo += cantidad;
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + 
				 " DNI: " + dni +
				 " Saldo " + saldo + " € " +
				 " Nacionalidad " + nacionalidad;
	}
	
	@Override
	public boolean equals(Object objeto) {
		if(this == objeto) return true;
		if (objeto == null || getClass() != objeto.getClass()) return false;
		Ejercicio01 otra = (Ejercicio01) objeto;
		return dni.equalsIgnoreCase(otra.dni) && nombre.equalsIgnoreCase(otra.nombre);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
