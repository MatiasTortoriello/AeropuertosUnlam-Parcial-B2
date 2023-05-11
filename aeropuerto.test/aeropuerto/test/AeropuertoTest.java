package aeropuerto.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

import aeropuerto.dominio.Ciudad;
import aeropuerto.dominio.Ruta;
import aeropuerto.dominio.TipoDeVuelo;
import aeropuerto.dominio.Vuelo;
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
	public void queSiUnVueloTieneDistintosPaisesSeLeAsigneVueloInternacional() {
		Integer nroVuelo = 001;
		LocalTime hora = LocalTime.of(23, 50);
		Ciudad ciudadInicio = new Ciudad(01, "Lima", "Peru");
		Ciudad ciudadDestino = new Ciudad(02, "Buenos Aires", "Argentina");
		LocalDate fecha = LocalDate.of(2024, 5, 10);
		
		Ruta ruta = new Ruta(3,ciudadInicio, ciudadDestino);
		Vuelo vuelo = new Vuelo(nroVuelo,ruta,hora,fecha);
		
		vuelo.validarTipoDeVuelo();
		
		assertEquals(vuelo.getTipoDeVuelo(), TipoDeVuelo.INTERNACIONAL);
	}
	
	@Test
	public void queSiUnVueloTieneLosMismosPaisesSeLeAsigneVueloCabotaje() {
		Integer nroVuelo = 001;
		LocalTime hora = LocalTime.of(23, 50);
		Ciudad ciudadInicio = new Ciudad(01, "Cordoba", "Argentina");
		Ciudad ciudadDestino = new Ciudad(02, "Buenos Aires", "Argentina");
		LocalDate fecha = LocalDate.of(2024, 5, 10);
		
		Ruta ruta = new Ruta(3,ciudadInicio, ciudadDestino);
		Vuelo vuelo = new Vuelo(nroVuelo,ruta,hora,fecha);
		
		vuelo.validarTipoDeVuelo();
		
		assertEquals(vuelo.getTipoDeVuelo(), TipoDeVuelo.CABOTAJE);
	}
	
	@Test
	public void queUnPilotoYUnPersonalEstenEnLaCabinaCorrecta() {
		Integer legajo = 0001;
		
	}

}
