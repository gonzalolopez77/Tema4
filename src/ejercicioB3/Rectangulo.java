package ejercicioB3;

import ejercicioB3.Rectangulo;

public class Rectangulo {
	int x1;
	int x2;
	int y1;
	int y2;
	
	Rectangulo (int x1, int x2, int y1, int y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangulo rectangulo1 = new Rectangulo(0, 5, 0, 5);
		
		int base = rectangulo1.x2 - rectangulo1.x1;
		int altura = rectangulo1.y2 - rectangulo1.y1;
		int perimetro = base + altura;
		int area = base * altura;
		System.out.println("Rectangulo1");
		System.out.println("Perimetro= " + perimetro);
		System.out.println("Area= " + area);
		
		
		Rectangulo rectangulo2 = new Rectangulo(7, 2, 9, 3);
		
		base = rectangulo2.x1 - rectangulo2.x2;
		altura = rectangulo2.y1 - rectangulo2.y2;
		perimetro = base + altura;
		area = base * altura;
		System.out.println("Rectangulo2");
		System.out.println("Perimetro= " + perimetro);
		System.out.println("Area= " + area);
	}

}