package ejercicioA1;

public class Punto {
	int x;
	int y;
	
	public static void main(String[] args) {
		
		Punto punto1 = new Punto();
		punto1.x = 5;
		punto1.y = 0;
		System.out.println(punto1.x + "  " + punto1.y);
		
		Punto punto2 = new Punto();
		punto2.x = 10;
		punto2.y = 10;
		System.out.println(punto2.x + "  " + punto2.y);
		
		Punto punto3 = new Punto();
		punto3.x = -3;
		punto3.y = 7;
		System.out.println(punto3.x + "  " + punto3.y);
		
}
}
