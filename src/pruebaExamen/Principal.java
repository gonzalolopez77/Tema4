package pruebaExamen;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		// 1. Inicializamos nuestras herramientas de trabajo
		Scanner scanner = new Scanner(System.in);
		ListaVehiculos miFlota = new ListaVehiculos(); 
		int opcion = 0;

		do {
			// 2. Imprimimos el menú visual
			System.out.println("\n===== GESTIÓN DE ALQUILER DE VEHÍCULOS =====");
			System.out.println("1. Añadir vehículo");
			System.out.println("2. Listar vehículos");
			System.out.println("3. Buscar vehículo por matrícula");
			System.out.println("4. Modificar días alquilados");
			System.out.println("5. Modificar recargo premium");
			System.out.println("6. Modificar precio seguro diario");
			System.out.println("7. Eliminar vehículo");
			System.out.println("8. Ver estadísticas");
			System.out.println("9. Salir");
			System.out.print("Elige una opción (1-9): ");
			
			// 3. Leemos la opción protegiéndonos de errores (si escribe letras)
			try {
				opcion = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				opcion = 0; // Forzamos un 0 para que salte el 'default' del switch
			}

			// 4. El Switch para repartir el trabajo
			switch (opcion) {
				case 1:
					System.out.println("\n-- AÑADIR NUEVO VEHÍCULO --");
					System.out.print("Matrícula: ");
					String matricula = scanner.nextLine();
					
					System.out.print("Modelo: ");
					String modelo = scanner.nextLine();
					
					System.out.print("Precio base por día: ");
					double precioBase = Double.parseDouble(scanner.nextLine());
					
					// Validación de la barrera del 0-25%
					double recargo;
					do {
						System.out.print("Porcentaje recargo premium (0-25): ");
						recargo = Double.parseDouble(scanner.nextLine());
						if(recargo < 0 || recargo > 25) {
							System.out.println("¡Error! El recargo debe estar entre 0 y 25.");
						}
					} while(recargo < 0 || recargo > 25);
					
					// Creamos el coche y se lo pasamos a la gestora
					Coche nuevoCoche = new Coche(matricula, modelo, precioBase, recargo);
					
					if (miFlota.anadirVehiculo(nuevoCoche)) {
						System.out.println("¡Vehículo añadido con éxito!");
					} else {
						System.out.println("Error: Ya existe un vehículo con la matrícula " + matricula);
					}
					break;

				case 2:
					System.out.println("\n-- LISTADO DE VEHÍCULOS --");
					miFlota.listarTodos();
					break;

				case 3:
					System.out.println("\n-- BUSCAR VEHÍCULO --");
					System.out.print("Introduce la matrícula a buscar: ");
					String matBuscar = scanner.nextLine();
					
					Coche cocheEncontrado = miFlota.buscarPorMatricula(matBuscar);
					
					if (cocheEncontrado != null) {
						System.out.println("Vehículo encontrado:");
						System.out.println(cocheEncontrado); // Llama automáticamente al toString()
					} else {
						System.out.println("No existe ningún vehículo con esa matrícula.");
					}
					break;

				case 4:
					System.out.println("\n-- MODIFICAR DÍAS ALQUILADOS --");
					System.out.print("Introduce la matrícula del vehículo: ");
					String matDias = scanner.nextLine();
					
					System.out.print("Introduce el nuevo número de días alquilado: ");
					int nuevosDias = Integer.parseInt(scanner.nextLine());
					
					if (miFlota.modificarDiasAlquilado(matDias, nuevosDias)) {
						System.out.println("Días actualizados correctamente.");
					} else {
						System.out.println("No se pudo modificar. El vehículo no existe.");
					}
					break;

				case 5:
					System.out.println("\n-- MODIFICAR RECARGO PREMIUM --");
					System.out.print("Introduce la matrícula del vehículo: ");
					String matRecargo = scanner.nextLine();
					
					// Validación otra vez para que no nos cuelen un 100%
					double nuevoRecargo;
					do {
						System.out.print("Introduce el nuevo porcentaje (0-25): ");
						nuevoRecargo = Double.parseDouble(scanner.nextLine());
						if(nuevoRecargo < 0 || nuevoRecargo > 25) {
							System.out.println("¡Error! El recargo debe estar entre 0 y 25.");
						}
					} while(nuevoRecargo < 0 || nuevoRecargo > 25);
					
					if (miFlota.modificarRecargoPremium(matRecargo, nuevoRecargo)) {
						System.out.println("Porcentaje actualizado correctamente.");
					} else {
						System.out.println("No se pudo modificar. El vehículo no existe.");
					}
					break;

				case 6:
					System.out.println("\n-- MODIFICAR PRECIO SEGURO DIARIO --");
					System.out.println("Aviso: Esto cambiará el seguro para TODOS los vehículos.");
					System.out.print("Introduce el nuevo precio del seguro: ");
					double nuevoSeguro = Double.parseDouble(scanner.nextLine());
					
					// Como es un atributo 'static', se llama a través de la CLASE Coche, no de un objeto
					Coche.setPrecioSeguroDiario(nuevoSeguro); 
					System.out.println("Precio del seguro global actualizado a " + nuevoSeguro + "€.");
					break;

				case 7:
					System.out.println("\n-- ELIMINAR VEHÍCULO --");
					System.out.print("Introduce la matrícula del vehículo a eliminar: ");
					String matEliminar = scanner.nextLine();
					
					// Detalle extra: Confirmación antes de borrar (queda muy profesional)
					System.out.print("¿Estás seguro de que quieres eliminarlo? (S/N): ");
					String confirmacion = scanner.nextLine();
					
					if (confirmacion.equalsIgnoreCase("S")) {
						if (miFlota.eliminarPorMatricula(matEliminar)) {
							System.out.println("Vehículo eliminado de la flota.");
						} else {
							System.out.println("Error: El vehículo no existe.");
						}
					} else {
						System.out.println("Operación cancelada.");
					}
					break;

				case 8:
					System.out.println("\n-- ESTADÍSTICAS DE LA EMPRESA --");
					
					// 1ª parte: Ingreso total de recargos
					double totalRecargos = miFlota.calcularIngresoTotalRecargos();
					System.out.println("Ingreso total por recargos premium: " + totalRecargos + "€\n");
					
					// 2ª parte: Listado de vehículos premium
					miFlota.listarVehiculosPremium();
					break;

				case 9:
					System.out.println("\nGracias por usar el sistema. ¡Hasta pronto!");
					break;

				default:
					System.out.println("Opción incorrecta. Por favor, elige un número del 1 al 9.");
			}

		} while (opcion != 9); // El bucle se repite hasta que el usuario pulse 9
		
		scanner.close(); // Cerramos el teclado
	}
}