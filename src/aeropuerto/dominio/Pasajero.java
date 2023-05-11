package aeropuerto.dominio;

import java.util.Objects;

import aeropuerto.test.Cabina;

public class Pasajero {

	private Integer pasaporte;
	private String telefono;
	private Double peso;
	private Cabina cabina;

	public Pasajero(Integer pasaporte, String telefono, Double peso, Cabina cabina) {
		this.pasaporte = pasaporte;
		this.telefono = telefono;
		this.peso = peso;
		this.cabina = cabina;
	}

	public Integer getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(Integer pasaporte) {
		this.pasaporte = pasaporte;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Cabina getCabina() {
		return cabina;
	}

	public void setCabina(Cabina cabina) {
		this.cabina = cabina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pasaporte);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasajero other = (Pasajero) obj;
		return Objects.equals(pasaporte, other.pasaporte);
	}

	
	
}
