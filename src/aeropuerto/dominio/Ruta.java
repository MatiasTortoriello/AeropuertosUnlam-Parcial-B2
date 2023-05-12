package aeropuerto.dominio;

public class Ruta {

	private Integer codRuta;
	private Ciudad ciudadDestino;
	private Ciudad ciudadInicio;

	public Ruta(Integer codRuta,Ciudad ciudadDestino, Ciudad ciudadInicio) {
		this.codRuta = codRuta;
		this.ciudadDestino = ciudadDestino;
		this.ciudadInicio = ciudadInicio;
	}
	
	public Integer getCodRuta() {
		return codRuta;
	}

	public void setCodRuta(Integer codRuta) {
		this.codRuta = codRuta;
	}

	public Ciudad getCiudadDestino() {
		return ciudadDestino;
	}

	public void setCiudadDestino(Ciudad ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

	public Ciudad getCiudadInicio() {
		return ciudadInicio;
	}

	public void setCiudadInicio(Ciudad ciudadInicio) {
		this.ciudadInicio = ciudadInicio;
	}
	
	public Boolean validarCiudades() {
		if(this.ciudadInicio.equals(ciudadDestino)) {
			return false;
		}
		return true;
	}
	
	public Boolean validarCodigoCiudad() {
		if(this.ciudadInicio.getCodCiudad() != this.ciudadDestino.getCodCiudad()) {
			return true;
		}
		return false;
	}
}