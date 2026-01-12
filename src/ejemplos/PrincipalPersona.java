package ejemplos;

public class PrincipalPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persona daniel = new Persona();
		
		System.out.println(daniel);
		
		System.out.println(daniel.nombre);
		daniel.nombre = "Daniel";
		System.out.println(daniel.nombre);
		
		System.out.println(daniel.edad);
		daniel.edad = 18;
		System.out.println(daniel.edad);
		
		Persona p1 = new Persona();
		Persona p2 = new Persona();
		Persona p3 = p1;
	}

}
