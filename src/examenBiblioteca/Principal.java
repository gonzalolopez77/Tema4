package examenBiblioteca;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		GestorBiblioteca gestor = new GestorBiblioteca();
		int opcion = 0;

		do {
			System.out.println("\n===== SISTEMA DE BIBLIOTECA DIGITAL =====");
			System.out.println("1. Dar de alta nuevo libro");
			System.out.println("2. Dar de alta nuevo socio");
			System.out.println("3. Mostrar libros disponibles");
			System.out.println("4. Mostrar información de un socio");
			System.out.println("5. Registrar préstamo");
			System.out.println("6. Registrar devolución");
			System.out.println("7. Salir");
			System.out.print("Elige una opción: ");
			
			try {
				opcion = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				opcion = 0; 
			}

			switch (opcion) {
				case 1:
					System.out.print("ID del Libro: ");
					String idL = scanner.nextLine();
					System.out.print("Título: ");
					String tit = scanner.nextLine();
					System.out.print("Autor: ");
					String aut = scanner.nextLine();
					System.out.print("Ejemplares: ");
					int ejem = Integer.parseInt(scanner.nextLine());
					
					Libro nLibro = new Libro(idL, tit, aut, ejem);
					if (gestor.anadirLibro(nLibro)) {
						System.out.println("✅ Libro registrado con éxito.");
					} else {
						System.out.println("❌ Error: Ya existe un libro con ese ID.");
					}
					break;

				case 2:
					System.out.print("ID del Socio: ");
					String idS = scanner.nextLine();
					System.out.print("Nombre: ");
					String nom = scanner.nextLine();
					System.out.print("Teléfono: ");
					String tel = scanner.nextLine();
					
					Socio nSocio = new Socio(idS, nom, tel);
					if (gestor.anadirSocio(nSocio)) {
						System.out.println("✅ Socio registrado con éxito.");
					} else {
						System.out.println("❌ Error: Ya existe un socio con ese ID.");
					}
					break;

				case 3:
					gestor.listarLibrosDisponibles();
					break;

				case 4:
					System.out.print("Introduce el ID del socio a consultar: ");
					Socio socioBuscado = gestor.buscarSocio(scanner.nextLine());
					if (socioBuscado != null) {
						System.out.println(socioBuscado);
					} else {
						System.out.println("❌ Socio no encontrado.");
					}
					break;

				case 5:
					System.out.println("-- REGISTRAR PRÉSTAMO --");
					System.out.print("ID del Libro a prestar: ");
					String pLibro = scanner.nextLine();
					System.out.print("ID del Socio que lo solicita: ");
					String pSocio = scanner.nextLine();
					
					int resultado = gestor.registrarPrestamo(pLibro, pSocio);
					if (resultado == 1) System.out.println("✅ Préstamo realizado correctamente.");
					else if (resultado == -1) System.out.println("❌ Error: El libro no existe.");
					else if (resultado == -2) System.out.println("❌ Error: El socio no existe.");
					else if (resultado == -3) System.out.println("❌ Error: No quedan copias disponibles.");
					else if (resultado == -4) System.out.println("❌ Error: El socio ha alcanzado el límite de préstamos.");
					break;

				case 6:
					System.out.println("-- REGISTRAR DEVOLUCIÓN --");
					System.out.print("ID del Libro devuelto: ");
					String dLibro = scanner.nextLine();
					System.out.print("ID del Socio que lo devuelve: ");
					String dSocio = scanner.nextLine();
					
					if (gestor.registrarDevolucion(dLibro, dSocio)) {
						System.out.println("✅ Devolución registrada con éxito.");
					} else {
						System.out.println("❌ Error al procesar la devolución. Revisa los IDs.");
					}
					break;

				case 7:
					System.out.println("Cerrando sistema...");
					break;

				default:
					System.out.println("❌ Opción incorrecta.");
			}
		} while (opcion != 7);
		
		scanner.close();
	}
}