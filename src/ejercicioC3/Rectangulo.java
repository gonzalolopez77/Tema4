package ejercicioC3;

import ejercicioC3.Rectangulo;

public class Rectangulo {
	//private
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	
	//constructor
	Rectangulo (int x1, int x2, int y1, int y2){
		
		if(x1<x2 && y1<y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		}
	}
	
	//public
	public int getx1() {
		return x1;
	}
	public int getx2() {
		return x2;
	}
	public int gety1() {
		return y1;
	}
	public int gety2() {
		return y2;
	}
	
	//set
	public void setx1(int x1) {
		this.x1 = x1;
	}
	public void setx2(int x2) {
		this.x2 = x2;
	}
	public void sety1(int y1) {
		this.y1 = y1;
	}
	public void sety2(int y2) {
		this.y2 = y2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangulo rectangulo1 = new Rectangulo(0, 5, 0, 5);
		
		int base = rectangulo1.getx2() - rectangulo1.getx1();
		int altura = rectangulo1.gety2() - rectangulo1.gety1();
		int perimetro = base + altura;
		int area = base * altura;
		System.out.println("Rectangulo1");
		System.out.println("Perimetro= " + perimetro);
		System.out.println("Area= " + area);
		
		
		Rectangulo rectangulo2 = new Rectangulo(7, 2, 9, 3);
		
		base = rectangulo2.getx1() - rectangulo2.getx2();
		altura = rectangulo2.gety1() - rectangulo2.gety2();
		perimetro = base + altura;
		area = base * altura;
		System.out.println("Rectangulo2");
		System.out.println("Perimetro= " + perimetro);
		System.out.println("Area= " + area);
	}

}
