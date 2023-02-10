package modelo;

public class Empresa {
	private int id;
	private String nombre;
	
	public Empresa(String nombre, int id) {
		this.nombre=nombre;
		this.setId(id);
	}
	@Override
	public String toString() {
		return "ID: "+id+
				" nombre: "+nombre;
	}
	public boolean equals(String nombre) {
		return (this.nombre==nombre);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
