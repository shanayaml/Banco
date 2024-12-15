package banco;

public class usuario {
	
	private String nombre;
	private String contrasena;
	float saldo;
	
	
	public usuario(String nombre, String contrasena, float saldo) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.saldo = saldo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	
}

