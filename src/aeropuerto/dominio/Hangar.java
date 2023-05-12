package aeropuerto.dominio;

import java.util.HashSet;

public class Hangar {

	private Integer codHangar;
	private String nombreHangar;
	private Integer capacidad;
	private HashSet<Avion> listaDeAviones = new HashSet<Avion>();
	
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

	public HashSet<Avion> getListaDeAviones() {
		return listaDeAviones;
	}

	public void setListaDeAviones(HashSet<Avion> listaDeAviones) {
		this.listaDeAviones = listaDeAviones;
	}
	
	public void agregarAvion(Avion avion1) {
		listaDeAviones.add(avion1);
	}
	
	
	
	public void eliminarAvionSiNoHayCapacidad(Avion avion) {
		if(!calcularCapacidad()) {
			listaDeAviones.remove(avion);
		}	
	}
	
	public Boolean calcularCapacidad() {
		if(listaDeAviones.size() <= this.capacidad) {
			return true;
		}
		return false;
	}
	
	public Avion buscarAvion(Integer codAvion) {
		for (Avion avion : listaDeAviones) {
			if(avion.getCodigoAvion() == codAvion) {
				return avion;
			}
		}
		return null;
	}
	

}
