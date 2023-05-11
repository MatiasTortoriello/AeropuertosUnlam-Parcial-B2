package aeropuerto.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;



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
	
	public Boolean hayCapacidad() {
		if(this.getListaDePasajeros().size() <= this.capacidad) {
			return true;
		}
		return false;
	}
	

	public void eliminarPasajeroSiNoHayCapacidad(Pasajero pasajero) {
		if(!hayCapacidad()) {
			listaDePasajeros.remove(pasajero);
		}	
	}
	
	public Boolean validarPiloto(Piloto piloto) {
		if(this.tipoAvion.equals(TipoAvion.MILITAR) && piloto.getCantidadHoras() > 20) {
			piloto.setTipoAvion(TipoAvion.MILITAR);
			return true;
		}
		
		if(this.tipoAvion.equals(TipoAvion.COMERCIAL)){
			piloto.setTipoAvion(TipoAvion.COMERCIAL);
			return true;
		}
		return false;
	}
	
	public Double calcularPesoTotal() {
		Double pesoTotalPersonal = 0.0;
		Double pesoTotalPasajero = 0.0;
		
		for (Pasajero pasajero : listaDePasajeros) {
			pesoTotalPasajero += pasajero.getPeso();
		}
		for (Personal personal : listaDePersonal) {
			pesoTotalPersonal += personal.getPeso();
		}
		
		return pesoTotalPasajero + pesoTotalPersonal;
	}
	
	public Boolean validarPesoVuelo() {
		Double pesoTotalPersonas = calcularPesoTotal();
		if(pesoTotalPersonas <= this.pesoMaximo) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigoAvion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avion other = (Avion) obj;
		return Objects.equals(codigoAvion, other.codigoAvion);
	}
	
	public Pasajero buscarPasajero(Integer pasaporte) {
		for (Pasajero pasajero : listaDePasajeros) {
			if(pasajero.getPasaporte() == pasaporte) {
				return pasajero;
			}
		}
		return null;
	}

	public ArrayList<Vuelo> buscarVueloPorCodigoDeRuta(Integer codRuta) {
		ArrayList<Vuelo> listaDeVuelosConLaMismaRuta = new ArrayList<Vuelo>();
		for (Vuelo vuelo : listaDeVuelo) {
			if(vuelo.getRutaDeVuelo().getCodRuta() == codRuta) {
				listaDeVuelosConLaMismaRuta.add(vuelo);
			}
		}
		return listaDeVuelosConLaMismaRuta;
	}

	public void eliminarPersonalSiSeSuperaElPeso(Personal personal) {
		if(!validarPesoVuelo()) {
			listaDePersonal.remove(personal);
		}
		
	}

	public void agregarPersonal(Personal personal) {
		this.listaDePersonal.add(personal);
		
	}
	

}
