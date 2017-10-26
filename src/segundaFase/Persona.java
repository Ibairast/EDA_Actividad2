package segundaFase;

public class Persona implements Comparable<Persona> {
	
	// atributos
	private String name;
    private String dni;
	
	public Persona(String pName, String pDni) { // Constructora
		name = pName;
		dni = pDni;
	}
	
	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getDni() { return dni; }

	public void setDni(String dni) { this.dni = dni; }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
			
	@Override
	public int compareTo(Persona arg0) {
		int x = name.compareToIgnoreCase(arg0.name);
		int resultado;
		if (x < 0){
			resultado = -1;
		}else if(x > 0){
			resultado = 1;
		}else{
			resultado = 0;
		}
		return resultado;
	}

	public String toString() {
		return name + " " + dni;
	}
	
} // end Persona
