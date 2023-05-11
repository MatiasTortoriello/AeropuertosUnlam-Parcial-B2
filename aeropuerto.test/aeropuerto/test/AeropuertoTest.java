package aeropuerto.test;

import static org.junit.Assert.*;

import org.junit.Test;

import aeropuerto.dominio.Avion;
import aeropuerto.dominio.Cabina;
import aeropuerto.dominio.Hangar;
import aeropuerto.dominio.Pasajero;
import aeropuerto.dominio.TipoAvion;

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
		Pasajero pasajero = new Pasajero(pasaporte,numeroPasajero,40.0,Cabina.CABINA_PASAJERO);
		
		avion.agregarPasajero(pasajero);
		assertEquals(avion.getListaDePasajeros().size(), 1);
	}
	
	@Test
	public void queElPasajeroTengaTelefonoYPasaporteValido() {
		Integer pasaporte = 123123;
		String numeroPasajero = "+541134236477";
		Pasajero pasajero = new Pasajero(pasaporte,numeroPasajero,40.0,Cabina.CABINA_PASAJERO);
		
		assertTrue(pasajero.validarPasaporte());
		assertTrue(pasajero.validarTelefono());
	}
	
	@Test
	public void queElPasajeroNoTengaTelefonoYPasaporteValido() {
		Integer pasaporte = 123123123;
		String numeroPasajero = "+5411342364";
		Pasajero pasajero = new Pasajero(pasaporte,numeroPasajero,40.0,Cabina.CABINA_PASAJERO);
		
		assertFalse(pasajero.validarPasaporte());
		assertFalse(pasajero.validarTelefono());
	}

	
	@Test
	public void queUnPasajeroEsteEnElLaCabinaDePasajeros() {
		Integer pasaporte = 123123;
		String numeroPasajero = "+541134236477";
		Cabina cabina = Cabina.CABINA_PASAJERO;
		Pasajero pasajero1 = new Pasajero(pasaporte,numeroPasajero,500.0,cabina);
		
		Integer codigoAvion = 123;
		Integer capacidad = 100;
		String modelo = "123adw";
		String fabricante = "Casio";
		Hangar hangar = new Hangar(002, "Hangar Palomar", 5);
		Avion avion = new Avion(codigoAvion,capacidad,modelo,fabricante, hangar,500.0, TipoAvion.MILITAR);
		
		avion.agregarPasajero(pasajero1);
		
		assertEquals(pasajero1.getCabina(), Cabina.CABINA_PASAJERO);
	}
}
