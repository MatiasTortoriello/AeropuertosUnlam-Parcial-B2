package aeropuerto.test;

import static org.junit.Assert.*;

import org.junit.Test;

import aeropuerto.dominio.Avion;
import aeropuerto.dominio.Cabina;
import aeropuerto.dominio.Hangar;
import aeropuerto.dominio.Pasajero;
import unlam.edu.ar.dominio.TipoAvion;

public class AeropuertoTest{


	@Test
	public void queSeCreeUnAvionYSeAgregueUnPasajero() {
		Integer codigoAvion = 123;
		Integer capacidad = 100;
		String modelo = "123adw";
		String fabricante = "Casio";
		Hangar hangar = new Hangar(002, "Hangar Palomar", 5);
		Double pesoMaximo = 500.0;
		TipoAvion tipoAvion = TipoAvion.MILITAR;
		Avion avion = new Avion(codigoAvion, capacidad, modelo, fabricante, hangar, pesoMaximo, tipoAvion);
		
		Integer pasaporte = 123123;
		String numeroPasajero = "+541134236477";
		Pasajero pasajero = new Pasajero(pasaporte,numeroPasajero,40.0,Cabina.CABINA_PASAJEROS);
		
		avion.agregarPasajero(pasajero);
		assertEquals(avion.getListaDePasajeros().size(), 1);
	}

}
