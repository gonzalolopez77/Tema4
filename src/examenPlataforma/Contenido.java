package examenPlataforma;

public class Contenido {
	
	private String idContenido;
	private String titulo;
	private String tipo; // Curso, Clase individual, Masterclass 
	private int duracion; // En minutos
	private String categoria;
	private String nivel; // básico, intermedio o avanzado 
	private boolean esPremium; 
	private int vecesVisto; // Acumulador para saber si es el más consumido

	public Contenido(String idContenido, String titulo, String tipo, int duracion, 
					 String categoria, String nivel, boolean esPremium) {
		this.idContenido = idContenido;
		this.titulo = titulo;
		this.tipo = tipo;
		this.duracion = duracion;
		this.categoria = categoria;
		this.nivel = nivel;
		this.esPremium = esPremium;
		this.vecesVisto = 0;
	}

	public String getIdContenido() { return idContenido; }
	public String getTitulo() { return titulo; }
	public boolean isPremium() { return esPremium; }
	public int getVecesVisto() { return vecesVisto; }

	/**
	 * Suma 1 cada vez que un usuario visualiza este contenido.
	 */
	public void registrarUnaVisualizacion() {
		this.vecesVisto++;
	}

	@Override
	public String toString() {
		String premiumText = esPremium ? "[PREMIUM]" : "[GRATIS]";
		return premiumText + " ID: " + idContenido + " | " + tipo + ": " + titulo 
				+ " | Nivel: " + nivel + " | Duración: " + duracion + " min | Visto: " + vecesVisto + " veces";
	}
}