package ejercicioC4;

public class Articulo {
	
	private String nombre = "SinNombre";
	private double precio;
	private int iva = 21;
	private int quedan;
	
	public Articulo(String nombre, double precio, int iva, int quedan) {
		
		if (!nombre.isBlank()) {
		this.nombre = nombre;
		}
		
		if (precio > 0) {
		this.precio = precio;
		}
		
		if (iva >= 0 && iva < 100) {
		this.iva = iva;
		}
		
		if (quedan >= 0) {
		this.quedan = quedan;
		}
	}

	public String getnombre() {
		return nombre;
	}
	public double getprecio() {
		return precio;
	}
	public int getiva() {
		return iva;
	}
	public int getquedan() {
		return quedan;
	}
	
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	public void setprecio(double precio) {
		this.precio = precio;
	}
	public void setiva(int iva) {
		this.iva = iva;
	}
	public void setquedan(int quedan) {
		this.quedan = quedan;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Articulo articulo1 = new Articulo("Pijama", 10, 21, 50);
		Articulo articulo2 = new Articulo("", -20, 210, -5);
		
		mostrar(articulo1);
		mostrar(articulo2);
		
	}

	
	static void mostrar(Articulo articulo) {
		System.out.println("Nombre: " + articulo.getnombre() + " | Precio: " + articulo.getprecio() + " | IVA: " + articulo.getiva() + "% | Quedan: " + articulo.getquedan());
	
	}
	
}

