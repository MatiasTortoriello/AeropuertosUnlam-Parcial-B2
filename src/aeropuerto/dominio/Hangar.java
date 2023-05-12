package aeropuerto.dominio;

import java.util.HashSet;

import unlam.edu.ar.dominio.Avion;

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
	
	public void agregarAvion(Avion avion) {
		listaDeAviones.add(avion);
	}
	
	
	
	/*public void eliminarAvionSiNoHayCapacidad(Avion avion) {
		if(!)
		
		}*/
	

	
}
