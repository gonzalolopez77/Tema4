package examenBiblioteca;

public class Socio {
	
	private String idSocio;
	private String nombre;
	private String telefono;
	private int prestamosActivos; // Cuántos libros tiene en su casa ahora mismo
	private static final int LIMITE_PRESTAMOS = 3; // Límite estático y constante para todos

	public Socio(String idSocio, String nombre, String telefono) {
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.telefono = telefono;
		this.prestamosActivos = 0; // Al registrarse, no tiene ningún libro
	}

	public String getIdSocio() {
		return idSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getPrestamosActivos() {
		return prestamosActivos;
	}

	public void setPrestamosActivos(int prestamosActivos) {
		this.prestamosActivos = prestamosActivos;
	}
	
	/**
	 * Comprueba si el socio puede pedir más libros.
	 * @return true si NO ha superado el límite.
	 */
	public boolean puedePedirPrestamo() {
		return this.prestamosActivos < LIMITE_PRESTAMOS;
	}

	@Override
	public String toString() {
		return "Socio ID: " + idSocio + " | Nombre: " + nombre + " | Teléfono: " + telefono 
				+ " | Préstamos activos: " + prestamosActivos + "/" + LIMITE_PRESTAMOS;
	}
}