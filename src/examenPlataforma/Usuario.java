package examenPlataforma;

public class Usuario {
	
	private String idUsuario;
	private String nombre;
	private String tipoSuscripcion; // "Gratuito", "Mensual", "Anual"
	private int minutosConsumidos; // Acumulador para saber si es el más activo

	public Usuario(String idUsuario, String nombre, String tipoSuscripcion) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.tipoSuscripcion = tipoSuscripcion;
		this.minutosConsumidos = 0; // Empieza a 0
	}

	public String getIdUsuario() { return idUsuario; }
	public String getNombre() { return nombre; }
	public String getTipoSuscripcion() { return tipoSuscripcion; }
	public int getMinutosConsumidos() { return minutosConsumidos; }

	/**
	 * Añade minutos al historial del usuario cuando ve algo.
	 */
	public void anadirMinutos(int minutos) {
		this.minutosConsumidos += minutos;
	}

	/**
	 * Verifica si el usuario tiene permiso para ver contenido premium.
	 * Un usuario sin suscripción activa no podrá acceder a contenido premium.
	 */
	public boolean tieneSuscripcionActiva() {
		return !this.tipoSuscripcion.equalsIgnoreCase("Gratuito");
	}

	/**
	 * Calcula cuánto paga este usuario (inventamos unas cuotas estándar).
	 */
	public double calcularCuota() {
		if (this.tipoSuscripcion.equalsIgnoreCase("Mensual")) return 9.99;
		if (this.tipoSuscripcion.equalsIgnoreCase("Anual")) return 99.99;
		return 0.0; // Gratuito
	}

	@Override
	public String toString() {
		return "ID: " + idUsuario + " | Nombre: " + nombre + " | Plan: " + tipoSuscripcion 
				+ " | Minutos vistos: " + minutosConsumidos + " min";
	}
}