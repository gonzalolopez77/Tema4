package ejercicioB1;

import ejercicioB1.Punto;

public class Punto {
	int x;
	int y;

	Punto (int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public static void main(String[] args) {
		
		Punto punto1 = new Punto(5, 0);
		System.out.println(punto1.x + "  " + punto1.y);
		
		Punto punto2 = new Punto(10, 10);
		System.out.println(punto2.x + "  " + punto2.y);
		
		Punto punto3 = new Punto(-3, 7);
		System.out.println(punto3.x + "  " + punto3.y);
		
}
}
