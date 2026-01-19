package ejercicioC2;

import java.util.Scanner;

import ejercicioC2.Persona;

public class Persona {
	
	//private
	private String DNI;
	private String nombre;
	private String apellidos;
	private int edad;

	//constructor
	Persona (String DNI, String nombre, String apellidos, int edad){
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	//public
	public String getDNI() {
		return DNI;
	}
	public String getnombre(){
		return nombre;
	}
	public String getapellidos() {
		return apellidos;
	}
	public int getedad() {
		return edad;
	}
	
	//set
	public void setDNI(String DNI) {
		if(!DNI.isBlank()) {
			this.DNI = DNI;
		}
	}
	
	public void setnombre(String nombre) {
		if(!nombre.isBlank()) {
			this.nombre = nombre;
		}
	}
	
	public void setapellidos(String apellidos) {
		if(!apellidos.isBlank()) {
			this.apellidos = apellidos;
		}
	}
	
	public void setedad(int edad) {
		if(edad > 0) {
			this.edad = edad;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//persona1
		System.out.println("Persona1");
		
		System.out.println("Nombre: ");
		String nombreAux = sc.next();
		
		System.out.println("Apellido: ");
		String apellidosAux = sc.next();
		
		System.out.println("DNI: ");
		String DNIAux = sc.next();
		
		System.out.println("Edad: ");
		int edadAux = sc.nextInt();
		
		Persona persona1 = new Persona(DNIAux, nombreAux, apellidosAux, edadAux);
		
		if (persona1.edad >= 18) {
			System.out.println(persona1.getnombre() + " " + persona1.getapellidos() + " con DNI " + persona1.getDNI() + " es mayor de edad");
		} else {
			System.out.println(persona1.getnombre() + " " + persona1.getapellidos() + " con DNI " + persona1.getDNI() + " no es mayor de edad");
		}
		
		
		//persona2
		System.out.println("Persona2");
		
		System.out.println("Nombre: ");
		String nombreAux2 = sc.next();
		
		System.out.println("Apellido: ");
		String apellidosAux2 = sc.next();
		
		System.out.println("DNI: ");
		String DNIAux2 = sc.next();
		
		System.out.println("Edad: ");
		int edadAux2 = sc.nextInt();
		
		Persona persona2 = new Persona(DNIAux2, nombreAux2, apellidosAux2, edadAux2);
		
		
		if (persona2.edad >= 18) {
			System.out.println(persona2.getnombre() + " " + persona2.getapellidos() + " con DNI " + persona2.getDNI() + " es mayor de edad");
		} else {
			System.out.println(persona2.getnombre() + " " + persona2.getapellidos() + " con DNI " + persona2.getDNI() + " no es mayor de edad");
		}
		
		sc.close();
	}

}