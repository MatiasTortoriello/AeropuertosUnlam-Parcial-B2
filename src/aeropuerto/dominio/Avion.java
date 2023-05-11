package aeropuerto.dominio;

import java.util.HashSet;

public class Avion {
	
	private Integer codigoAvion;
	private Integer capacidad;
	private String modelo;
	private String fabricante;
	private Hangar hangar;
	private Double pesoMaximo;
	private TipoAvion tipoAvion;
	private HashSet<Vuelo> listaDeVuelo = new HashSet<Vuelo>();
	private HashSet<Pasajero> listaDePasajeros = new HashSet<Pasajero>();
	private HashSet<Personal> listaDePersonal= new HashSet<Personal>();
	
	public Avion(Integer codigoAvion, Integer capacidad, String modelo, String fabricante, Hangar hangar,
			Double pesoMaximo, TipoAvion tipoAvion) {
		this.codigoAvion = codigoAvion;
		this.capacidad = capacidad;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.hangar = hangar;
		this.pesoMaximo = pesoMaximo;
		this.tipoAvion = tipoAvion;
		this.listaDeVuelo = new HashSet<Vuelo>();
		this.listaDePasajeros = new HashSet<Pasajero>();
		this.listaDePersonal= new HashSet<Personal>();
	}

	public Integer getCodigoAvion() {
		return codigoAvion;
	}

	public void setCodigoAvion(Integer codigoAvion) {
		this.codigoAvion = codigoAvion;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Hangar getHangar() {
		return hangar;
	}

	public void setHangar(Hangar hangar) {
		this.hangar = hangar;
	}

	public Double getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(Double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public TipoAvion getTipoAvion() {
		return tipoAvion;
	}

	public void setTipoAvion(TipoAvion tipoAvion) {
		this.tipoAvion = tipoAvion;
	}

	public HashSet<Vuelo> getListaDeVuelo() {
		return listaDeVuelo;
	}

	public void setListaDeVuelo(HashSet<Vuelo> listaDeVuelo) {
		this.listaDeVuelo = listaDeVuelo;
	}

	public HashSet<Pasajero> getListaDePasajeros() {
		return listaDePasajeros;
	}

	public void setListaDePasajeros(HashSet<Pasajero> listaDePasajeros) {
		this.listaDePasajeros = listaDePasajeros;
	}

	public HashSet<Personal> getListaDePersonal() {
		return listaDePersonal;
	}

	public void setListaDePersonal(HashSet<Personal> listaDePersonal) {
		this.listaDePersonal = listaDePersonal;
	}

	public void agregarPasajero(Pasajero pasajero) {
		listaDePasajeros.add(pasajero);
		
	}
	
	
	

}
