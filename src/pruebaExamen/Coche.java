package pruebaExamen;

public class Coche {

	//Atributos de la clase
	String matricula;
	String modelo;
	double precioPorDia;
	double porcentaje;
	static double precioSeguroDiario;
	int diasAlquilado;
	
	//Getters y Setters
	public String getMatricula() {
		return matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public double getPrecioPorDia() {
		return precioPorDia;
	}

	public void setPrecioPorDia(double precioPorDia) {
		this.precioPorDia = precioPorDia;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public static double getPrecioSeguroDiario() {
		return precioSeguroDiario;
	}

	public static void setPrecioSeguroDiario(double precioSeguroDiario) {
		Coche.precioSeguroDiario = precioSeguroDiario;
	}

	public int getDiasAlquilado() {
		return diasAlquilado;
	}

	public void setDiasAlquilado(int diasAlquilado) {
		this.diasAlquilado = diasAlquilado;
	}
	
	// Constructores
	public Coche(String matricula, String modelo, double precioPorDia) {
		super();
		this.matricula = matricula;
		this.modelo = modelo;
		this.precioPorDia = precioPorDia;
	}
	
	public Coche(String matricula, String modelo, double precioPorDia, double porcentaje) {
		super();
		this.matricula = matricula;
		this.modelo = modelo;
		this.precioPorDia = precioPorDia;
		this.porcentaje = porcentaje;
	}
	
	public Coche(String matricula, String modelo, double precioPorDia, double porcentaje, int diasAlquilado) {
		super();
		this.matricula = matricula;
		this.modelo = modelo;
		this.precioPorDia = precioPorDia;
		this.porcentaje = porcentaje;
		this.diasAlquilado = diasAlquilado;
	}
	
	//Metodos
	/**
	 * Metodo que devuelve importe del recargo premium
	 * 
	 * @return importeRecargoPremium Devuelve el resultado de nuestra formula para saber el importe del racargo premium
	 */
	public double calculoRecargoPremium() {
		double importeRecargoPremium;
		importeRecargoPremium = (this.precioPorDia * this.porcentaje) /100;
		return importeRecargoPremium;
	}
	
	/**
	 * Metodo que devuelve el importe total del seguro
	 * 
	 * @return importeTotalSeguro Devuelve el importe total del seguro
	 */
	public double calcularImporteTotalSeguro(){
		double importeTotalSeguro = this.diasAlquilado * this.precioSeguroDiario;
		return importeTotalSeguro;
	}
	
	/**
	 * Metodo que devuelva el ingreso total generado por el vehiculo
	 * 
	 * @param recargoPremium Importe del recargo premium
	 * @param importeTotalSeguro Importe total del seguro
	 * 
	 * @return Devuelve el importe total generado por el vehiculo
	 */
	public double calcularIngresoTotal(double recargoPremium, double importeTotalSeguro) {
		double ingresoTotal = this.precioPorDia + recargoPremium + importeTotalSeguro;
		return ingresoTotal;
	}
	
	/**
	 * Imprime los atributos de nuestro objeto
	 * 
	 * @return Imprime los atributos de nuestro objeto
	 */
	public String toString() {
		double importeRecargoPremium = calculoRecargoPremium();
		double importeTotalSeguro = calcularImporteTotalSeguro();
		double ingresoTotal = calcularIngresoTotal(importeRecargoPremium, importeTotalSeguro);
		
		return this.matricula + " - " + this.modelo + "\n" +
		"Precio Base/Día: " + this.precioPorDia + " | Recargo Premium: " + importeRecargoPremium + " (" + this.porcentaje + "%)\n" +
	     "Días alquilado: " + this.diasAlquilado + " | Total generado: " + ingresoTotal;
	}
	
	/**
	 * Comparar el atributo matricula con otros objetos
	 * 
	 * @param otroCoche Otro objeto para comparar
	 * 
	 * @return true Si matricula es igual
	 * @return false Si matricula no es igual
	 */
	public boolean mismoCoche(Coche otroCoche) {
		if(this.matricula.equals(otroCoche.getMatricula())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Método que retorne true si el porcentaje de recargo premium es superior al 12%
	 * 
	 * @return true Si importeRecargoPremium es mayor que el 12%
	 * @return false Si importeRecargoPremium no es mayor que el 12%
	 */
	public boolean recargoPremiumSuperior() {
		if(this.porcentaje > 12) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Establecemos el precio del seguro para TODOS los vehículos (es estático)
	    Coche.setPrecioSeguroDiario(2.5);
	    
	    // 2. Creamos el vehículo del ejemplo del examen
	    Coche miVehiculo = new Coche("1234ABC", "Toyota Corolla", 45.0, 10.0, 6);
	    
	    // 3. Imprimimos el vehículo para ver si el toString coincide con el examen
	    System.out.println(miVehiculo);
		
	}

}
