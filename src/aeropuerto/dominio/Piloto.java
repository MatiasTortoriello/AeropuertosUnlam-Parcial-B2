package aeropuerto.dominio;

public class Piloto extends Personal {
	
	private Integer cantidadHoras;
	private TipoAvion tipoAvion;
	
	public Piloto(Integer legajo, String nombre, String apellido, Cabina cabina, Double peso, Integer cantidadHoras) {
		super(legajo, nombre, apellido, cabina, peso);
		this.cantidadHoras = cantidadHoras;
	}

	public Integer getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(Integer cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public TipoAvion getTipoAvion() {
		return tipoAvion;
	}

	public void setTipoAvion(TipoAvion tipoAvion) {
		this.tipoAvion = tipoAvion;
	}
	
	public Boolean validarCabina() {
		if(getCabina() != Cabina.CABINA_VUELO) {
			setCabina(Cabina.CABINA_VUELO);
			return true;
		}
		return false;
	}
}