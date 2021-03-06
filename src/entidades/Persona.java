package entidades;

public class Persona extends Categoria {

	private int iD;
	private int dni;
	private String nombre;
	private String apellido;
	private String usuario;
	private String contraseña;
	private boolean habilitado;
	
	public Persona(int id, int dni, String nombre, String apellido, String usuario,	String contraseña, boolean habilitado) {
		this.iD = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.habilitado = habilitado;
		
	}

	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public boolean isHabilitado() {
		return habilitado;
	}
	
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
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
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
