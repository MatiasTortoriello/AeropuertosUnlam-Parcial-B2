package aeropuerto.dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Vuelo {

	
	private Integer nroVuelo;
	private Ruta rutaDeVuelo;
	private LocalTime hora;
	private LocalDate fecha;
	private TipoDeVuelo tipoDeVuelo;

	public Vuelo(Integer nroVuelo,Ruta rutaDeVuelo,LocalTime hora, LocalDate fecha) {
		this.nroVuelo = nroVuelo;
		this.rutaDeVuelo = rutaDeVuelo;
		this.hora = hora;
		this.fecha = fecha;
	}

	public Integer getNroVuelo() {
		return nroVuelo;
	}

	public void setNroVuelo(Integer nroVuelo) {
		this.nroVuelo = nroVuelo;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHoraLlegada(LocalTime hora) {
		this.hora = hora;
	}


	public Ruta getRutaDeVuelo() {
		return rutaDeVuelo;
	}

	public void setRutaDeVuelo(Ruta rutaDeVuelo) {
		this.rutaDeVuelo = rutaDeVuelo;
	}

	public TipoDeVuelo getTipoDeVuelo() {
		return tipoDeVuelo;
	}

	public void setTipoDeVuelo(TipoDeVuelo tipoDeVuelo) {
		this.tipoDeVuelo = tipoDeVuelo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public Boolean validarFecha() {
		if(this.fecha.isAfter(LocalDate.now())){
			return true;
		}
		return false;
	}
	
	public void validarTipoDeVuelo() {
		 if(getRutaDeVuelo().validarCodigoCiudad()) {
			if(this.getRutaDeVuelo().getCiudadInicio().getPais().equals(getRutaDeVuelo().getCiudadDestino().getPais())) {
				setTipoDeVuelo(tipoDeVuelo.CABOTAJE);
			}else {
				setTipoDeVuelo(tipoDeVuelo.INTERNACIONAL);
			}
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(nroVuelo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(nroVuelo, other.nroVuelo);
	}
	
	public Boolean validarRutaDeVuelo(Ruta ruta) {
		if(this.getRutaDeVuelo().getCodRuta().equals(ruta.getCodRuta())) {
			return true;
		}
		return false;
	}

}
