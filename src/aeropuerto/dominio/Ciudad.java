package aeropuerto.dominio;

public class Ciudad {
	private Integer codCiudad;
	private String nombre;
	private String pais;
	
	public Ciudad(Integer codCiudad,String nombre,String pais) {
		this.codCiudad = codCiudad;
		this.nombre = nombre;
		this.pais = pais;
	}

	public Integer getCodCiudad() {
		return codCiudad;
	}

	public void setCodCiudad(Integer codCiudad) {
		this.codCiudad = codCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
}