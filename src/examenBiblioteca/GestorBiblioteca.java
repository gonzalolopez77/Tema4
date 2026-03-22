package examenBiblioteca;

import java.util.ArrayList;

public class GestorBiblioteca {
	
	private ArrayList<Libro> listaLibros;
	private ArrayList<Socio> listaSocios;

	public GestorBiblioteca() {
		this.listaLibros = new ArrayList<>();
		this.listaSocios = new ArrayList<>();
	}

	// ================= GESTIÓN DE LIBROS =================

	public Libro buscarLibro(String idLibro) {
		for (Libro l : this.listaLibros) {
			if (l.getIdLibro().equals(idLibro)) {
				return l;
			}
		}
		return null;
	}

	public boolean anadirLibro(Libro nuevoLibro) {
		if (buscarLibro(nuevoLibro.getIdLibro()) != null) {
			return false; // Ya existe [cite: 48]
		}
		this.listaLibros.add(nuevoLibro);
		return true;
	}
	
	public boolean eliminarLibro(String idLibro) {
		Libro l = buscarLibro(idLibro);
		if (l == null) return false;
		this.listaLibros.remove(l);
		return true;
	}

	public void listarLibrosDisponibles() {
		System.out.println("--- LIBROS DISPONIBLES PARA PRÉSTAMO ---");
		boolean hayDisponibles = false;
		for (Libro l : this.listaLibros) {
			if (l.estaDisponible()) {
				System.out.println(l);
				hayDisponibles = true;
			}
		}
		if (!hayDisponibles) System.out.println("No hay libros disponibles actualmente.");
	}

	// ================= GESTIÓN DE SOCIOS =================

	public Socio buscarSocio(String idSocio) {
		for (Socio s : this.listaSocios) {
			if (s.getIdSocio().equals(idSocio)) {
				return s;
			}
		}
		return null;
	}

	public boolean anadirSocio(Socio nuevoSocio) {
		if (buscarSocio(nuevoSocio.getIdSocio()) != null) {
			return false; // Ya existe [cite: 48]
		}
		this.listaSocios.add(nuevoSocio);
		return true;
	}

	public boolean eliminarSocio(String idSocio) {
		Socio s = buscarSocio(idSocio);
		if (s == null) return false;
		this.listaSocios.remove(s);
		return true;
	}

	// ================= GESTIÓN DE PRÉSTAMOS =================

	/**
	 * Registra un préstamo validando todas las restricciones[cite: 39, 49, 50].
	 * @return 1 (Éxito), -1 (Libro no existe), -2 (Socio no existe), -3 (No hay copias), -4 (Límite superado)
	 */
	public int registrarPrestamo(String idLibro, String idSocio) {
		Libro l = buscarLibro(idLibro);
		Socio s = buscarSocio(idSocio);

		if (l == null) return -1;
		if (s == null) return -2;
		if (!l.estaDisponible()) return -3;
		if (!s.puedePedirPrestamo()) return -4;

		// Si pasamos las barreras, actualizamos los datos
		l.setEjemplaresDisponibles(l.getEjemplaresDisponibles() - 1);
		s.setPrestamosActivos(s.getPrestamosActivos() + 1);
		return 1;
	}

	/**
	 * Registra la devolución de un libro[cite: 40].
	 */
	public boolean registrarDevolucion(String idLibro, String idSocio) {
		Libro l = buscarLibro(idLibro);
		Socio s = buscarSocio(idSocio);

		if (l == null || s == null) return false;
		
		if (s.getPrestamosActivos() > 0) {
			l.setEjemplaresDisponibles(l.getEjemplaresDisponibles() + 1);
			s.setPrestamosActivos(s.getPrestamosActivos() - 1);
			return true;
		}
		return false;
	}
}