package ejercicioA4;

public class Articulo {

	String nombre;
	double precio;
	double iva = 1.21;
	int cuantosQuedan;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Articulo articulo1 = new Articulo();
		articulo1.nombre = "Pijama";
		articulo1.precio = 20;
		articulo1.cuantosQuedan = 15;
		double pvp = articulo1.precio * articulo1.iva;
		System.out.println(articulo1.nombre + " - Precio:" + articulo1.precio + " - IVA:" + articulo1.iva + " - PVP:" + pvp + " - En almacen:" + articulo1.cuantosQuedan);
		
		articulo1.precio = 55;
		pvp = articulo1.precio * articulo1.iva;
		System.out.println(articulo1.nombre + " - Precio:" + articulo1.precio + " - IVA:" + articulo1.iva + " - PVP:" + pvp + " - En almacen:" + articulo1.cuantosQuedan);
		
	}

}
