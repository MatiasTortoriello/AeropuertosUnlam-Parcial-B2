package aeropuerto.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Test;

import aeropuerto.dominio.Vuelo;
import aeropuerto.dominio.Avion;
import aeropuerto.dominio.Cabina;
import aeropuerto.dominio.Ciudad;
import aeropuerto.dominio.Hangar;
import aeropuerto.dominio.Pasajero;
import aeropuerto.dominio.Personal;
import aeropuerto.dominio.Piloto;
import aeropuerto.dominio.Ruta;
import aeropuerto.dominio.TripulanteCabina;
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
		Cabina cabina = Cabina.CABINA_PASAJEROS;
		Double peso = 40.0;
		Pasajero pasajero = new Pasajero(pasaporte, numeroPasajero, peso, cabina);
		
		avion.agregarPasajero(pasajero);
		
		assertEquals(avion.getListaDePasajeros().size(), 1);
	}
	
	@Test
	public void queSePuedaCrearUnHangarYNoSePuedaAgregarAvionesRepetidos() {
		Hangar hangar = new Hangar(0524, "Hangar Juan Domingo Per�n", 5);
		
		Avion avion1 = new Avion(01, 10, "747", "Boeing", hangar, 60.0, TipoAvion.COMERCIAL);
		Avion avion2 = new Avion(01, 30, "F-51", "Mustang", hangar, 26.0, TipoAvion.MILITAR);
		//Los aviones poseen el mismo c�digo (HashCode) y son agregados dentro de un HashSet.
		hangar.agregarAvion(avion1);
		hangar.agregarAvion(avion2);
		
		assertEquals(1, hangar.getListaDeAviones().size());
	}
	
	@Test
	public void queNoSeExcedaLaCapacidadDeUnHangar() {
Hangar hangar = new Hangar(002, "Hangar Palomar", 2);
		
		Integer codigoAvion = 122;
		Integer capacidad = 3;
		String modelo = "123adw";
		String fabricante = "Casio";
		Avion avion = new Avion(codigoAvion,capacidad,modelo,fabricante, hangar,500.0, TipoAvion.MILITAR);
		
		Integer codigoAvion2 = 123;
		Integer capacidad2 = 3;
		String modelo2 = "123adw";
		String fabricante2 = "Casio";
		Avion avion2 = new Avion(codigoAvion2,capacidad2,modelo2,fabricante2, hangar,500.0, TipoAvion.MILITAR);
		
		Integer codigoAvion3 = 124;
		Integer capacidad3 = 3;
		String modelo3 = "123adw";
		String fabricante3 = "Casio";
		Avion avion3 = new Avion(codigoAvion3,capacidad3,modelo3,fabricante3, hangar,500.0, TipoAvion.MILITAR);
		
		
		hangar.agregarAvion(avion);
		hangar.agregarAvion(avion2);
		hangar.agregarAvion(avion3);
		
		assertFalse(hangar.calcularCapacidad());
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
	public void queUnPasajeroNoEsteEnElLaCabinaDePasajerosYLoCambieDeCabina() {
		Integer pasaporte = 123123;
		String numeroPasajero = "+541134236477";
		Cabina cabina = Cabina.CABINA_VUELO;
		Pasajero pasajero1 = new Pasajero(pasaporte,numeroPasajero,500.0,cabina);
		
		Integer codigoAvion = 123;
		Integer capacidad = 100;
		String modelo = "123adw";
		String fabricante = "Casio";
		Hangar hangar = new Hangar(002, "Hangar Palomar", 5);
		Avion avion = new Avion(codigoAvion,capacidad,modelo,fabricante, hangar,500.0, TipoAvion.MILITAR);
		
		avion.agregarPasajero(pasajero1);
		
		pasajero1.validarCabina();
		
		assertEquals(pasajero1.getCabina(), Cabina.CABINA_PASAJEROS);
	}
	
	
	
	@Test
	public void queSeCreeUnAvionYSePuedaAgregarUnPersonalYUnPilotoEnLaMismaLista() {
		Integer codigoAvion = 123;
		Integer capacidad = 100;
		String modelo = "123adw";
		String fabricante = "Casio";
		Hangar hangar = new Hangar(002, "Hangar Palomar", 5);
		Avion avion = new Avion(codigoAvion,capacidad,modelo,fabricante, hangar,500.0, TipoAvion.MILITAR);
		
		
		Integer legajoPersonal = 12;
		String nombrePersonal = "edu";
		String apellidoPersonal = "garcia";
		Cabina cabinaPersonal = Cabina.CABINA_VUELO;
		Personal personal = new Personal(legajoPersonal, nombrePersonal, apellidoPersonal, cabinaPersonal ,40.0);
		
		Integer legajoPiloto = 13;
		String nombrePiloto = "Ramiro";
		String apellidoPiloto = "Wase";
		Cabina areaPiloto = Cabina.CABINA_VUELO;
		Piloto piloto = new Piloto(legajoPiloto, nombrePiloto, apellidoPiloto, areaPiloto,40.0,13);
		
		
		avion.agregarPersonal(personal);
		avion.agregarPersonal(piloto);
		
		assertEquals(avion.getListaDePersonal().size(), 2);
	}
	
	@Test
	public void queSeCreeUnAvionYNoSePuedaAgregarUnPasajeroRepetidoNiPersonalRepetido() {
		Integer codigoAvion = 123;
		Integer capacidad = 100;
		String modelo = "123adw";
		String fabricante = "Casio";
		Hangar hangar = new Hangar(002, "Hangar Palomar", 5);
		Avion avion = new Avion(codigoAvion,capacidad,modelo,fabricante, hangar,500.0, TipoAvion.MILITAR);
		
		Integer pasaporte = 123123;
		String numeroPasajero = "+541134236477";
		Pasajero pasajero = new Pasajero(pasaporte,numeroPasajero,40.0,Cabina.CABINA_PASAJEROS);
		Integer pasaporte2 = 123123;
		String numeroPasajero2 = "+541134236477";
		Pasajero pasajero2 = new Pasajero(pasaporte2,numeroPasajero2,40.0,Cabina.CABINA_PASAJEROS);
		
		Integer legajo = 12;
		String nombre = "edu";
		String apellido = "garcia";
		Cabina cabina = Cabina.CABINA_VUELO;
		
		Personal personal = new Personal(legajo, nombre, apellido, cabina,40.0);
		Personal personal2 = new Personal(legajo, nombre, apellido, cabina,40.0);
		
		
		avion.agregarPasajero(pasajero);
		avion.agregarPasajero(pasajero2);
		avion.agregarPersonal(personal);
		avion.agregarPersonal(personal2);
		
		assertEquals(avion.getListaDePasajeros().size(), 1);
		assertEquals(avion.getListaDePersonal().size(), 1);
	}
	
	@Test
	public void queElVueloTengaUnaFechaValida() {
		Integer nroVuelo = 001;
		LocalTime hora = LocalTime.of(23, 50);
		Ciudad ciudadInicio = new Ciudad(01, "Lima", "Peru");
		Ciudad ciudadDestino = new Ciudad(02, "Buenos Aires", "Argentina");
		LocalDate fecha = LocalDate.of(2024, 5, 10);
		
		Ruta ruta = new Ruta(3,ciudadInicio, ciudadDestino);
		Vuelo vuelo = new Vuelo(nroVuelo,ruta,hora,fecha);
		
		assertTrue(vuelo.validarFecha());
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
	public void queUnaRutaNoTengaMismoCodigoDeCiudadDeInicioQueDeDestino() {
		Ciudad ciudadInicio = new Ciudad(02, "Lima", "Peru");
		Ciudad ciudadDestino = new Ciudad(02, "Buenos Aires", "Argentina");
		
		Ruta ruta = new Ruta(3,ciudadInicio, ciudadDestino);
	
		assertFalse(ruta.validarCodigoCiudad());
	}

	@Test
	public void queSePuedaBuscarUnPasajeroEnElAvionATravesDeSuPasaporte() {
		Integer codigoAvion = 123;
		Integer capacidad = 100;
		String modelo = "123adw";
		String fabricante = "Casio";
		Hangar hangar = new Hangar(002, "Hangar Palomar", 5);
		Avion avion = new Avion(codigoAvion,capacidad,modelo,fabricante, hangar,500.0, TipoAvion.MILITAR);
	
		
		Integer pasaporte = 123123;
		String numeroPasajero = "+541134236477";
		Pasajero pasajero1 = new Pasajero(pasaporte,numeroPasajero,500.0,Cabina.CABINA_PASAJEROS);
		
		Integer pasaporte2 = 123124;
		String numeroPasajero2 = "+541134236477";
		Pasajero pasajero2 = new Pasajero(pasaporte2,numeroPasajero2,40.0,Cabina.CABINA_PASAJEROS);
		
		avion.agregarPasajero(pasajero1);
		avion.agregarPasajero(pasajero2);
		
		assertEquals(avion.buscarPasajero(pasaporte), pasajero1);
	}
	
	@Test
	public void queSeCreeUnAvionYNoSePuedanAgregarVuelosRepetidos() {
		Integer codigoAvion = 123;
		Integer capacidad = 100;
		String modelo = "123adw";
		String fabricante = "Casio";
		Hangar hangar = new Hangar(002, "Hangar Palomar", 5);
		Avion avion = new Avion(codigoAvion,capacidad,modelo,fabricante, hangar,500.0, TipoAvion.MILITAR);
		
		Integer nroVuelo = 001;
		LocalTime hora = LocalTime.of(23, 50);
		Ciudad ciudadInicio = new Ciudad(01, "Lima", "Peru");
		Ciudad ciudadDestino = new Ciudad(02, "Buenos Aires", "Argentina");
		LocalDate fecha = LocalDate.of(2023, 6, 17);
		Ruta ruta = new Ruta(3,ciudadInicio,ciudadDestino);
		Vuelo vuelo = new Vuelo(nroVuelo,ruta,hora,fecha);
		
		Integer nroVuelo2 = 001;
		LocalTime hora2 = LocalTime.of(23, 50);
		Ciudad ciudadInicio2 = new Ciudad(01, "Lima", "Peru");
		Ciudad ciudadDestino2 = new Ciudad(02, "Buenos Aires", "Argentina");
		LocalDate fecha2 = LocalDate.of(2023, 6, 17);
		Ruta ruta2 = new Ruta(3,ciudadInicio2,ciudadDestino2);
		Vuelo vuelo2 = new Vuelo(nroVuelo2,ruta2,hora2,fecha2);
		
		avion.agregarVuelo(vuelo);
		avion.agregarVuelo(vuelo2);
		
		assertEquals(avion.getListaDeVuelo().size(), 1);
	}
	
	@Test
	public void queHayaCapacidadSuficienteEnElAvion() {
		Integer codigoAvion = 123;
		Integer capacidad = 3;
		String modelo = "123adw";
		String fabricante = "Casio";
		Hangar hangar = new Hangar(002, "Hangar Palomar", 5);
		Avion avion = new Avion(codigoAvion,capacidad,modelo,fabricante, hangar,500.0, TipoAvion.MILITAR);
		
		Integer pasaporte = 123123;
		String numeroPasajero = "+541134236477";
		Pasajero pasajero = new Pasajero(pasaporte,numeroPasajero,40.0,Cabina.CABINA_PASAJEROS);
		
		Integer pasaporte2 = 123124;
		String numeroPasajero2 = "+541134236477";
		Pasajero pasajero2 = new Pasajero(pasaporte2,numeroPasajero2,40.0,Cabina.CABINA_PASAJEROS);
		
		avion.agregarPasajero(pasajero);
		avion.agregarPasajero(pasajero2);
		
		assertTrue(avion.hayCapacidad());
	}
	
	@Test
	public void queSiNoHayCapacidadSuficienteEnElAvionRemuevaUnPasajero() {
		Integer codigoAvion = 123;
		Integer capacidad = 1;
		String modelo = "123adw";
		String fabricante = "Casio";
		Hangar hangar = new Hangar(002, "Hangar Palomar", 5);
		Avion avion = new Avion(codigoAvion,capacidad,modelo,fabricante, hangar,500.0, TipoAvion.MILITAR);
		
		Integer pasaporte = 123123;
		String numeroPasajero = "+541134236477";
		Pasajero pasajero = new Pasajero(pasaporte,numeroPasajero,40.0,Cabina.CABINA_PASAJEROS);
		
		Integer pasaporte2 = 123124;
		String numeroPasajero2 = "+541134236477";
		Pasajero pasajero2 = new Pasajero(pasaporte2,numeroPasajero2,40.0,Cabina.CABINA_PASAJEROS);
		
		avion.agregarPasajero(pasajero);
		avion.agregarPasajero(pasajero2);
		
		assertFalse(avion.hayCapacidad());
		avion.eliminarPasajeroSiNoHayCapacidad(pasajero);
		assertTrue(avion.hayCapacidad());
	}
	
	@Test
	public void queUnPilotoConMasDe20HorasPuedaManejarUnAvionMilitar() {
		Integer legajo = 12;
		String nombre = "edu";
		String apellido = "garcia";
		Cabina area = Cabina.CABINA_VUELO;
		Integer cantidadHoras = 21;
		Piloto piloto = new Piloto(legajo,nombre,apellido,area,40.0,cantidadHoras);
		
		Integer codigoAvion = 123;
		Integer capacidad = 3;
		String modelo = "123adw";
		String fabricante = "Casio";
		Hangar hangar = new Hangar(002, "Hangar Palomar", 5);
		Avion avion = new Avion(codigoAvion,capacidad,modelo,fabricante, hangar,500.0, TipoAvion.MILITAR);
		
		avion.validarPiloto(piloto);
		
		assertEquals(piloto.getTipoAvion(), TipoAvion.MILITAR);
	}
	
	@Test
	public void queUnPilotoYUnPersonalEstenEnLaCabinaCorrecta() {
		Integer legajo = 0001;
		String nombre= "Pilotencio";
		String apellido = "Vol�til";
		Cabina cabina = null;
		Double peso = 50.0;
		Integer cantidadDeHoras = 24;
		
		Piloto piloto = new Piloto(legajo, nombre, apellido, cabina, peso, cantidadDeHoras);
		
		piloto.validarCabina();
		
		assertEquals(piloto.getCabina(), Cabina.CABINA_VUELO);
	}
	
	
	@Test
	public void queSiUnPilotoYUnPersonalEstanEnElLaCabinaDePasajerosQueLoCambieALaCabinaDeVuelo() {
		//Piloto
		
		Integer legajo = 0001;
		String nombre= "Pilotencio";
		String apellido = "Vol�til";
		Cabina cabina = Cabina.CABINA_PASAJEROS; // Se le asigna una cabina incorrecta al piloto
		Double peso = 50.0;
		Integer cantidadDeHoras = 24;
		
		//Azafata
		Integer legajo2 = 0002;
		String nombre2= "Azafatencia";
		String apellido2 = "Servil";
		Cabina cabina2 = Cabina.CABINA_VUELO; // Se le asigna otra vez cabina incorrecta
		Double peso2 = 30.0;
		TipoTripulante tipoTripulante = TipoTripulante.AZAFATA;
		
		Piloto piloto = new Piloto(legajo, nombre, apellido, cabina, peso, cantidadDeHoras);
		TripulanteCabina tripulanteCabina = new TripulanteCabina(legajo2, nombre2, apellido2, cabina2, peso2, tipoTripulante);
		
		assertEquals(piloto.getCabina(), Cabina.CABINA_PASAJEROS);
		assertEquals(tripulanteCabina.getCabina(), Cabina.CABINA_VUELO);
		
		piloto.validarCabina();
		tripulanteCabina.validarCabina();
		
		assertEquals(piloto.getCabina(), Cabina.CABINA_VUELO);
		assertEquals(tripulanteCabina.getCabina(), Cabina.CABINA_PASAJEROS);
		
	}
	
	@Test
	public void queElPesoDeLasPersonasNoSupereAlPesoPermitido() {
		
		
		Piloto piloto = new Piloto(01, "Pilotin", "Volador", Cabina.CABINA_VUELO, 40.0, 30);
		TripulanteCabina tripulanteCabina = new TripulanteCabina(02, "Comisario", "AmigoDeLaYuta", Cabina.CABINA_PASAJEROS, 30.0, TipoTripulante.COMISARIO_DE_ABORDO);
		Pasajero pasajero1 = new Pasajero(01, "+123456", 10.0, Cabina.CABINA_PASAJEROS);
		Pasajero pasajero2 = new Pasajero(02, "+1234563", 10.0, Cabina.CABINA_PASAJEROS);
		Pasajero pasajero3 = new Pasajero(03, "+1234562", 10.0, Cabina.CABINA_PASAJEROS);
		Pasajero pasajero4 = new Pasajero(04, "+1234565", 10.0, Cabina.CABINA_PASAJEROS);

		Hangar hangar = new Hangar(01, "Hangar", 1);
		Avion avion = new Avion(001, 10, "747", "Boeing", hangar, 120.0, TipoAvion.COMERCIAL);
		
		avion.agregarPasajero(pasajero1);
		avion.agregarPasajero(pasajero2);
		avion.agregarPasajero(pasajero3);
		avion.agregarPasajero(pasajero4);
		avion.agregarPersonal(piloto);
		avion.agregarPersonal(tripulanteCabina);
		
		
		assertTrue(avion.validarPesoVuelo());
			
	}
	
	@Test
	public void queSiElPesoDeLosPasajerosSuperaAlPesoPermitidoRemuevaPasajerosHastaLograrElPesoPermitido() {
		
		Hangar hangar = new Hangar(01, "Hangar", 1);
		Avion avion = new Avion(001, 10, "747", "Boeing", hangar, 30.0, TipoAvion.COMERCIAL);
		Pasajero pasajero1 = new Pasajero(01, "+123456", 10.0, Cabina.CABINA_PASAJEROS);
		Pasajero pasajero2 = new Pasajero(02, "+1234563", 10.0, Cabina.CABINA_PASAJEROS);
		Pasajero pasajero3 = new Pasajero(03, "+1234562", 10.0, Cabina.CABINA_PASAJEROS);
		Pasajero pasajero4 = new Pasajero(04, "+1234565", 10.0, Cabina.CABINA_PASAJEROS);

		avion.agregarPasajero(pasajero1);
		avion.agregarPasajero(pasajero2);
		avion.agregarPasajero(pasajero3);
		avion.agregarPasajero(pasajero4);
				
		assertFalse(avion.validarPesoVuelo());
		
		avion.eliminarPasajeroSiSeSuperaElPeso(pasajero4);
		
		assertTrue(avion.validarPesoVuelo());
		
	}
	
	@Test
	public void queSiSeExcedaLaCapacidadDeUnHangarElimineUnAvion() {
		Hangar hangar = new Hangar(002, "Hangar Palomar", 2);
		
		Integer codigoAvion = 122;
		Integer capacidad = 3;
		String modelo = "123adw";
		String fabricante = "Casio";
		Avion avion = new Avion(codigoAvion,capacidad,modelo,fabricante, hangar,500.0, TipoAvion.MILITAR);
		
		Integer codigoAvion2 = 123;
		Integer capacidad2 = 3;
		String modelo2 = "123adw";
		String fabricante2 = "Casio";
		Avion avion2 = new Avion(codigoAvion2,capacidad2,modelo2,fabricante2, hangar,500.0, TipoAvion.MILITAR);
		
		Integer codigoAvion3 = 124;
		Integer capacidad3 = 3;
		String modelo3 = "123adw";
		String fabricante3 = "Casio";
		Avion avion3 = new Avion(codigoAvion3,capacidad3,modelo3,fabricante3, hangar,500.0, TipoAvion.MILITAR);
		
		
		hangar.agregarAvion(avion);
		hangar.agregarAvion(avion2);
		hangar.agregarAvion(avion3);
		
		assertFalse(hangar.calcularCapacidad());
		hangar.eliminarAvionSiNoHayCapacidad(avion);
		assertTrue(hangar.calcularCapacidad());
	}
	
	@Test
	public void queSePuedaBuscarUnAvionEnElHangar() {
		Hangar hangar = new Hangar(002, "Hangar Palomar", 2);
		
		Integer codigoAvion = 122;
		Integer capacidad = 3;
		String modelo = "123adw";
		String fabricante = "Casio";
		Avion avion = new Avion(codigoAvion,capacidad,modelo,fabricante, hangar,500.0, TipoAvion.MILITAR);
		
		Integer codigoAvion2 = 123;
		Integer capacidad2 = 3;
		String modelo2 = "123adw";
		String fabricante2 = "Casio";
		Avion avion2 = new Avion(codigoAvion2,capacidad2,modelo2,fabricante2, hangar,500.0, TipoAvion.MILITAR);
		
		Integer codigoAvion3 = 124;
		Integer capacidad3 = 3;
		String modelo3 = "123adw";
		String fabricante3 = "Casio";
		Avion avion3 = new Avion(codigoAvion3,capacidad3,modelo3,fabricante3, hangar,500.0, TipoAvion.MILITAR);
		
		
		hangar.agregarAvion(avion);
		hangar.agregarAvion(avion2);
		hangar.agregarAvion(avion3);
		
		assertEquals(hangar.buscarAvion(codigoAvion), avion);
	}
	
	@Test
	public void queSePuedaBuscarVuelosPorCodigoDeRuta() {
		Integer nroVuelo = 001;
		LocalTime hora = LocalTime.of(04, 00);
		Ciudad ciudadInicio = new Ciudad(01, "Lima", "Peru");
		Ciudad ciudadDestino = new Ciudad(02, "Buenos Aires", "Argentina");
		LocalDate fecha = LocalDate.of(2025, 6, 17);
		Ruta ruta = new Ruta(3,ciudadInicio,ciudadDestino);
		Vuelo vuelo = new Vuelo(nroVuelo,ruta,hora,fecha);
		
		Integer nroVuelo2 = 002;
		LocalTime hora2 = LocalTime.of(05, 00);
		Ciudad ciudadInicio2 = new Ciudad(01, "Lima", "Peru");
		Ciudad ciudadDestino2 = new Ciudad(02, "Buenos Aires", "Argentina");
		LocalDate fecha2 = LocalDate.of(2025, 6, 17);
		Ruta ruta2 = new Ruta(3,ciudadInicio2,ciudadDestino2);
		Vuelo vuelo2 = new Vuelo(nroVuelo2,ruta2,hora2,fecha2);
		
	
		Hangar hangar = new Hangar(002, "Hangar Palomar", 2);
		Integer codigoAvion = 122;
		Integer capacidad = 3;
		String modelo = "123adw";
		String fabricante = "Casio";
		Avion avion = new Avion(codigoAvion,capacidad,modelo,fabricante, hangar,500.0, TipoAvion.MILITAR);
		
		avion.agregarVuelo(vuelo);
		avion.agregarVuelo(vuelo2);
		
		Integer codRuta = ruta.getCodRuta();
		ArrayList<Vuelo> listaDeVuelos = avion.buscarVueloPorCodigoDeRuta(codRuta);
		assertTrue(listaDeVuelos.contains(vuelo) && listaDeVuelos.contains(vuelo2));
	}
}