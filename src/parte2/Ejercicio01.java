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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
