package aeropuerto.dominio;

import java.util.Objects;

public class Personal{
	
	private Integer legajo;
	private String nombre;
	private String apellido;
	private Cabina cabina;
	private Double peso;
	
	public Personal(Integer legajo, String nombre, String apellido, Cabina cabina, Double peso) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cabina = cabina;
		this.peso = peso;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Cabina getCabina() {
		return cabina;
	}

	public void setCabina(Cabina cabina) {
		this.cabina = cabina;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(legajo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personal other = (Personal) obj;
		return Objects.equals(legajo, other.legajo);
	}

	
	
}
