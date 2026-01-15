package ejercicioC1;

import ejercicioC1.Punto;

public class Punto {
	//private
	private int x;
	private int y;
	
	//constructor
	Punto (int x, int y){
		this.x = x;
		this.y = y;
	}
		
	//public
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	
	//
	public void setx(int x) {
		this.x = x;
	}
	public void sety(int y) {
		this.y = y;
	}
	
	//main
	public static void main(String[] args) {
		
		//
		Punto punto1 = new Punto(5, 0);
		System.out.println(punto1.getx()+ "  " + punto1.gety());
			
		Punto punto2 = new Punto(10, 10);
		System.out.println(punto2.getx() + "  " + punto2.gety());
			
		Punto punto3 = new Punto(-3, 7);
		System.out.println(punto3.getx() + "  " + punto3.gety());
		
		//modificar valores
		punto1.setx(20);
		punto1.sety(45);
		
		System.out.println("");
		System.out.println("Modificado");
		System.out.println(punto1.getx()+ "  " + punto1.gety());
	}
	}
