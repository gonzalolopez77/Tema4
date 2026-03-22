package examenBiblioteca;

public class Libro {
	
	private String idLibro;
	private String titulo;
	private String autor;
	private int ejemplaresDisponibles; // Cuántas copias quedan en la estantería

	public Libro(String idLibro, String titulo, String autor, int ejemplaresDisponibles) {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.ejemplaresDisponibles = ejemplaresDisponibles;
	}

	public String getIdLibro() {
		return idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getEjemplaresDisponibles() {
		return ejemplaresDisponibles;
	}

	public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
		this.ejemplaresDisponibles = ejemplaresDisponibles;
	}
	
	/**
	 * Comprueba si hay copias disponibles para prestar.
	 * @return true si hay al menos 1 ejemplar, false si no.
	 */
	public boolean estaDisponible() {
		return this.ejemplaresDisponibles > 0;
	}

	@Override
	public String toString() {
		return "ID: " + idLibro + " | Título: " + titulo + " | Autor: " + autor 
				+ " | Ejemplares disponibles: " + ejemplaresDisponibles;
	}
}