package aeropuerto.dominio;

public class TripulanteCabina extends Personal {
		TipoTripulante tipoTripulante;
	public TripulanteCabina(Integer legajo, String nombre, String apellido, Cabina cabina, Double peso, TipoTripulante tipoTripulante) {
		super(legajo, nombre, apellido, cabina, peso);
		this.tipoTripulante = tipoTripulante;
	}
	
	public TipoTripulante getTipoTripulante() {
		return tipoTripulante;
		
	}
	public void setTipoTripulante(TipoTripulante tipoTripulante) {
		this.tipoTripulante = tipoTripulante;
		
	}
	
	public Boolean validarCabina() {
		if(getCabina() != Cabina.CABINA_PASAJEROS) {
			setCabina(Cabina.CABINA_PASAJEROS);
			return true;
		}
		return false;
	}
	
}
