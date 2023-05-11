package aeropuerto.dominio;

public class Hangar {

	private Integer codHangar;
	private String nombreHangar;
	private Integer capacidad;
	
	public Hangar(Integer codHangar, String nombreHangar, Integer capacidad) {
		this.codHangar = codHangar;
		this.nombreHangar = nombreHangar;
		this.capacidad = capacidad;
	}

	public Integer getCodHangar() {
		return codHangar;
	}

	public void setCodHangar(Integer codHangar) {
		this.codHangar = codHangar;
	}

	public String getNombreHangar() {
		return nombreHangar;
	}

	public void setNombreHangar(String nombreHangar) {
		this.nombreHangar = nombreHangar;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	
}
