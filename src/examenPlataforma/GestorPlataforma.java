package examenPlataforma;

import java.util.ArrayList;

public class GestorPlataforma {
	
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<Contenido> listaContenidos;

	public GestorPlataforma() {
		this.listaUsuarios = new ArrayList<>();
		this.listaContenidos = new ArrayList<>();
	}

	// ================= GESTIÓN DE BÚSQUEDAS =================
	
	public Usuario buscarUsuario(String id) {
		for (Usuario u : listaUsuarios) {
			if (u.getIdUsuario().equals(id)) return u;
		}
		return null;
	}

	public Contenido buscarContenido(String id) {
		for (Contenido c : listaContenidos) {
			if (c.getIdContenido().equals(id)) return c;
		}
		return null;
	}

	// ================= GESTIÓN DE ALTAS Y LISTADOS =================

	public boolean anadirUsuario(Usuario u) {
		if (buscarUsuario(u.getIdUsuario()) != null) return false; // Evitar duplicados 
		this.listaUsuarios.add(u);
		return true;
	}

	public boolean anadirContenido(Contenido c) {
		if (buscarContenido(c.getIdContenido()) != null) return false;
		this.listaContenidos.add(c);
		return true;
	}

	public void listarUsuarios() {
		if (listaUsuarios.isEmpty()) {
			System.out.println("No hay usuarios registrados.");
			return;
		}
		for (Usuario u : listaUsuarios) System.out.println(u);
	}

	public void listarContenidos() {
		if (listaContenidos.isEmpty()) {
			System.out.println("No hay contenidos registrados.");
			return;
		}
		for (Contenido c : listaContenidos) System.out.println(c);
	}

	// ================= LÓGICA DE NEGOCIO =================

	/**
	 * Registra el consumo. 
	 * @return 1 (Éxito), -1 (Faltan datos), -2 (Restricción Premium)
	 */
	public int registrarVisualizacion(String idUsuario, String idContenido, int minutos) {
		Usuario u = buscarUsuario(idUsuario);
		Contenido c = buscarContenido(idContenido);

		if (u == null || c == null) return -1;
		
		// Validar restricción: Contenido premium requiere suscripción 
		if (c.isPremium() && !u.tieneSuscripcionActiva()) {
			return -2; 
		}

		// Si todo es correcto, sumamos datos a ambos
		u.anadirMinutos(minutos);
		c.registrarUnaVisualizacion();
		return 1;
	}

	/**
	 * Muestra todas las estadísticas económicas y de uso exigidas.
	 */
	public void mostrarEstadisticas() {
		System.out.println("--- ESTADÍSTICAS DE LA PLATAFORMA ---");
		
		// 1. Cálculos económicos
		double totalIngresos = 0.0, ingresosMensuales = 0.0, ingresosAnuales = 0.0;
		Usuario usuarioMasActivo = null;
		
		for (Usuario u : listaUsuarios) {
			double cuota = u.calcularCuota();
			totalIngresos += cuota;
			if (u.getTipoSuscripcion().equalsIgnoreCase("Mensual")) ingresosMensuales += cuota;
			if (u.getTipoSuscripcion().equalsIgnoreCase("Anual")) ingresosAnuales += cuota;
			
			// Calcular usuario más activo en el mismo bucle
			if (usuarioMasActivo == null || u.getMinutosConsumidos() > usuarioMasActivo.getMinutosConsumidos()) {
				usuarioMasActivo = u;
			}
		}

		// 2. Calcular contenido más consumido
		Contenido contenidoTop = null;
		for (Contenido c : listaContenidos) {
			if (contenidoTop == null || c.getVecesVisto() > contenidoTop.getVecesVisto()) {
				contenidoTop = c;
			}
		}

		// Mostrar resultados
		System.out.println("💰 Ingresos Totales: " + totalIngresos + "€");
		System.out.println("   -> Por plan Mensual: " + ingresosMensuales + "€");
		System.out.println("   -> Por plan Anual: " + ingresosAnuales + "€");
		
		if (usuarioMasActivo != null && usuarioMasActivo.getMinutosConsumidos() > 0) {
			System.out.println("🏆 Usuario más activo: " + usuarioMasActivo.getNombre() + " (" + usuarioMasActivo.getMinutosConsumidos() + " min)");
		}
		
		if (contenidoTop != null && contenidoTop.getVecesVisto() > 0) {
			System.out.println("🔥 Contenido más consumido: " + contenidoTop.getTitulo() + " (" + contenidoTop.getVecesVisto() + " visualizaciones)");
		}
	}
}