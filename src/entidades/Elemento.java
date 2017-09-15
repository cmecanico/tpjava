package entidades;

public class Elemento {

	private int iD;
	private String nombre;
	private TipoElemento tipo;
	
	public int getID() {
		return iD;
	}
	
	public void setID(int iD) {
		this.iD = iD;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoElemento getTipo() {
		return tipo;
	}

	public void setTipo(TipoElemento tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
		
	@Override
	public boolean equals(Object o){														//para que es este
		return (o instanceof Elemento && ((Elemento)o).getID()==this.getID());
	}
	
	@Override
	public int hashCode(){																	//para que es este
		return ((Integer)this.getID()).hashCode();
	}
}
