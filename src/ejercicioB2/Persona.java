package ejercicioB2;

import java.util.Scanner;

import ejercicioB2.Persona;

public class Persona {
	
	String DNI;
	String nombre;
	String apellidos;
	int edad;

	Persona (String DNI, String nombre, String apellidos, int edad){
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
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
			System.out.println(persona1.nombre + " " + persona1.apellidos + " con DNI " + persona1.DNI + " es mayor de edad");
		} else {
			System.out.println(persona1.nombre + " " + persona1.apellidos + " con DNI " + persona1.DNI + " no es mayor de edad");
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
			System.out.println(persona2.nombre + " " + persona2.apellidos + " con DNI " + persona2.DNI + " es mayor de edad");
		} else {
			System.out.println(persona2.nombre + " " + persona2.apellidos + " con DNI " + persona2.DNI + " no es mayor de edad");
		}
	}

}
