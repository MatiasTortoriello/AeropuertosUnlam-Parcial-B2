package aeropuerto.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

import aeropuerto.dominio.Vuelo;
import aeropuerto.dominio.Avion;
import aeropuerto.dominio.Cabina;
import aeropuerto.dominio.Ciudad;
import aeropuerto.dominio.Hangar;
import aeropuerto.dominio.Pasajero;
import aeropuerto.dominio.Piloto;
import aeropuerto.dominio.Ruta;
import aeropuerto.dominio.Tcp;
import aeropuerto.dominio.TipoAvion;
import aeropuerto.dominio.TipoDeVuelo;
import aeropuerto.dominio.TipoTripulante;

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
		Cabina cabina = null;
		Double peso = 40.0;
		Pasajero pasajero = new Pasajero(pasaporte, numeroPasajero, peso, cabina);
		
		pasajero.validarCabina();
		avion.agregarPasajero(pasajero);
		
		assertEquals(avion.getListaDePasajeros().size(), 1);
	}
	
	@Test

	public void queElPasajeroTengaTelefonoYPasaporteValido() {
		Integer pasaporte = 123123;
		String numeroPasajero = "+541134236477";
		Pasajero pasajero = new Pasajero(pasaporte,numeroPasajero,40.0,Cabina.CABINA_PASAJEROS);
		
		assertTrue(pasajero.validarPasaporte());
		assertTrue(pasajero.validarTelefono());
	}
	
	@Test
	public void queElPasajeroNoTengaTelefonoYPasaporteValido() {
		Integer pasaporte = 123123123;
		String numeroPasajero = "+5411342364";
		Pasajero pasajero = new Pasajero(pasaporte,numeroPasajero,40.0,Cabina.CABINA_PASAJEROS);
		
		assertFalse(pasajero.validarPasaporte());
		assertFalse(pasajero.validarTelefono());
	}
	
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
	public void queUnPasajeroEsteEnElLaCabinaDePasajeros() {
		Integer pasaporte = 123123;
		String numeroPasajero = "+541134236477";
		Cabina cabina = null;
		Pasajero pasajero1 = new Pasajero(pasaporte,numeroPasajero,500.0,cabina);
		
		Integer codigoAvion = 123;
		Integer capacidad = 100;
		String modelo = "123adw";
		String fabricante = "Casio";
		Hangar hangar = new Hangar(002, "Hangar Palomar", 5);
		Avion avion = new Avion(codigoAvion,capacidad,modelo,fabricante, hangar,500.0, TipoAvion.MILITAR);
		pasajero1.validarCabina();
		avion.agregarPasajero(pasajero1);
		
		
		assertEquals(pasajero1.getCabina(), Cabina.CABINA_PASAJEROS);
		assertNotEquals(pasajero1.getCabina(), Cabina.CABINA_VUELO);
	}
	
	@Test
	public void queUnPilotoYUnPersonalEstenEnLaCabinaCorrecta() {
		Integer legajo = 0001;
		String nombre= "Pilotencio";
		String apellido = "Volátil";
		Cabina cabina = null;
		Double peso = 50.0;
		Integer cantidadDeHoras = 24;
		
		Piloto piloto = new Piloto(legajo, nombre, apellido, cabina, peso, cantidadDeHoras);
		
		piloto.validarCabina();
		
		
		assertEquals(piloto.getCabina(), Cabina.CABINA_VUELO);
		assertNotEquals(piloto.getCabina(), Cabina.CABINA_PASAJEROS);
	}
	
	@Test
	public void queSiUnPilotoOUnPersonalEstanEnElLaCabinaDePasajerosQueLoCambieALaCabinaDeVuelo() {
		//Piloto de Cabina_Pasajeros a Cabina_Vuelo
		
		Integer legajo = 0001;
		String nombre= "Pilotencio";
		String apellido = "Volátil";
		Cabina cabina = Cabina.CABINA_PASAJEROS; // Se le asigna una cabina incorrecta al piloto
		Double peso = 50.0;
		Integer cantidadDeHoras = 24;
		
		Piloto piloto = new Piloto(legajo, nombre, apellido, cabina, peso, cantidadDeHoras);
		
		assertEquals(piloto.getCabina(), Cabina.CABINA_PASAJEROS);
		
		piloto.validarCabina();
		
		assertEquals(piloto.getCabina(), Cabina.CABINA_VUELO);
		
		//Tcp de Cabina_Vuelo a Cabina_Pasajeros
		
		Integer legajo2 = 0002;
		String nombre2= "Azafatencia";
		String apellido2 = "Servil";
		Cabina cabina2 = Cabina.CABINA_VUELO; // Se le asigna otra vez cabina incorrecta
		Double peso2 = 30.0;
		TipoTripulante tipoTripulante = TipoTripulante.AZAFATA;
		
		
		Tcp tcp = new Tcp(legajo2, nombre2, apellido2, cabina2, peso2, tipoTripulante);
		
		assertEquals(tcp.getCabina(), Cabina.CABINA_VUELO);
		
		tcp.validarCabina();
		
		assertEquals(tcp.getCabina(), Cabina.CABINA_PASAJEROS);
		
		
		
		
	}
}
