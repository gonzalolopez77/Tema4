package ejercicioA2;

import java.util.Scanner;

public class Persona {

	String DNI;
	String nombre;
	String apellidos;
	int edad;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//persona1
		Persona persona1 = new Persona();
		System.out.println("Persona1");
		
		System.out.println("Nombre: ");
		persona1.nombre = sc.next();
		
		System.out.println("Apellido: ");
		persona1.apellidos = sc.next();
		
		System.out.println("DNI: ");
		persona1.DNI = sc.next();
		
		System.out.println("Edad: ");
		persona1.edad = sc.nextInt();
		
		if (persona1.edad >= 18) {
			System.out.println(persona1.nombre + " " + persona1.apellidos + " con DNI " + persona1.DNI + " es mayor de edad");
		} else {
			System.out.println(persona1.nombre + " " + persona1.apellidos + " con DNI " + persona1.DNI + " no es mayor de edad");
		}
		
		
		//persona2
		Persona persona2 = new Persona();
		System.out.println("Persona2");
		
		System.out.println("Nombre: ");
		persona2.nombre = sc.next();
		
		System.out.println("Apellido: ");
		persona2.apellidos = sc.next();
		
		System.out.println("DNI: ");
		persona2.DNI = sc.next();
		
		System.out.println("Edad: ");
		persona2.edad = sc.nextInt();
		
		if (persona2.edad >= 18) {
			System.out.println(persona2.nombre + " " + persona2.apellidos + " con DNI " + persona2.DNI + " es mayor de edad");
		} else {
			System.out.println(persona2.nombre + " " + persona2.apellidos + " con DNI " + persona2.DNI + " no es mayor de edad");
		}
	}

}
