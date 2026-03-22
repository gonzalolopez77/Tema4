package examenPlataforma;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		GestorPlataforma gestor = new GestorPlataforma();
		int opcion = 0;

		do {
			System.out.println("\n===== E-LEARNING MASTER =====");
			System.out.println("1. Crear usuario");
			System.out.println("2. Crear contenido");
			System.out.println("3. Registrar visualización");
			System.out.println("4. Listar usuarios");
			System.out.println("5. Listar contenidos");
			System.out.println("6. Mostrar estadísticas");
			System.out.println("7. Salir");
			System.out.print("Elige una opción: ");
			
			try {
				opcion = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				opcion = 0; 
			}

			switch (opcion) {
				case 1:
					System.out.print("ID Usuario: ");
					String idU = scanner.nextLine();
					System.out.print("Nombre: ");
					String nom = scanner.nextLine();
					
					String tipo;
					do {
						System.out.print("Plan (Gratuito/Mensual/Anual): ");
						tipo = scanner.nextLine();
					} while (!tipo.equalsIgnoreCase("Gratuito") && !tipo.equalsIgnoreCase("Mensual") && !tipo.equalsIgnoreCase("Anual"));
					
					Usuario nUser = new Usuario(idU, nom, tipo);
					if (gestor.anadirUsuario(nUser)) System.out.println("✅ Usuario registrado.");
					else System.out.println("❌ Error: Ya existe ese ID.");
					break;

				case 2:
					System.out.print("ID Contenido: ");
					String idC = scanner.nextLine();
					System.out.print("Título: ");
					String tit = scanner.nextLine();
					System.out.print("Tipo (Curso/Clase/Masterclass): ");
					String tipoC = scanner.nextLine();
					System.out.print("Duración (minutos): ");
					int dur = Integer.parseInt(scanner.nextLine());
					System.out.print("Categoría: ");
					String cat = scanner.nextLine();
					System.out.print("Nivel (Básico/Intermedio/Avanzado): ");
					String niv = scanner.nextLine();
					System.out.print("¿Es Premium? (true/false): ");
					boolean prem = Boolean.parseBoolean(scanner.nextLine());
					
					Contenido nCont = new Contenido(idC, tit, tipoC, dur, cat, niv, prem);
					if (gestor.anadirContenido(nCont)) System.out.println("✅ Contenido registrado.");
					else System.out.println("❌ Error: Ya existe ese ID.");
					break;

				case 3:
					System.out.println("-- REGISTRAR CONSUMO --");
					System.out.print("ID Usuario: ");
					String vUser = scanner.nextLine();
					System.out.print("ID Contenido: ");
					String vCont = scanner.nextLine();
					System.out.print("Minutos visualizados: ");
					int mins = Integer.parseInt(scanner.nextLine());
					
					int resultado = gestor.registrarVisualizacion(vUser, vCont, mins);
					if (resultado == 1) System.out.println("✅ Visualización registrada.");
					else if (resultado == -1) System.out.println("❌ Error: Usuario o Contenido no encontrados.");
					else if (resultado == -2) System.out.println("❌ Acceso Denegado: Un usuario Gratuito no puede ver contenido Premium.");
					break;

				case 4:
					System.out.println("\n-- LISTADO DE USUARIOS --");
					gestor.listarUsuarios();
					break;

				case 5:
					System.out.println("\n-- LISTADO DE CONTENIDOS --");
					gestor.listarContenidos();
					break;

				case 6:
					gestor.mostrarEstadisticas();
					break;

				case 7:
					System.out.println("Cerrando la plataforma...");
					break;

				default:
					System.out.println("❌ Opción incorrecta.");
			}
		} while (opcion != 7);
		
		scanner.close();
	}
}