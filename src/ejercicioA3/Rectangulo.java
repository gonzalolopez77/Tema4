package ejercicioA3;

public class Rectangulo {
	int x1;
	int x2;
	int y1;
	int y2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangulo rectangulo1 = new Rectangulo();
		rectangulo1.x1 = 0;
		rectangulo1.x2 = 5;
		rectangulo1.y1 = 0;
		rectangulo1.y2 = 5;
		
		int perimetro = rectangulo1.x1 + rectangulo1.x2 + rectangulo1.y1 + rectangulo1.y2;
		
		
		Rectangulo rectangulo2 = new Rectangulo();
		rectangulo2.x1 = 7;
		rectangulo2.x2 = 2;
		rectangulo2.y1 = 9;
		rectangulo2.y2 = 3;
	}

}
