# Aeropuerto
## PARCIAL PROGRAMACION BASICA II TM
### Herlein, Gonzalo. Tortoriello, Matías. Gauna, Gonzalo

## Ejercicio
Nos contratan de una aerolínea para crear un software que administre la información de los pasajeros, vuelos, aviones y personal. 

### Para los vuelos: 
-	Nro. de vuelo
-	Fecha
-	Hora
-	Ciudad de origen y de destino
-	Personal y pasajeros asignados
-	Avión asignado
- Tipo De Vuelo (Internacional o Cabotaje)
 
### Para los aviones se considera:
-	Modelo
-	Fabricante
-	Capacidad 
-	Hangar 
-	Tipo de avión(Comercial o Militar)
-	Peso Máximo

### Para el personal se tiene en cuenta:
-	Nombre y apellido
-	Área asignada
-	Legajo
- Peso

### Para los pilotos se conoce:
-	Cantidad de horas de vuelo.
-	Tipo de avión que pilotea.

### De los pasajeros nos interesa conocer:
-	Pasaporte: valor entero
-	Teléfono: compuesto por el código país + numero celular
-	Peso: valor decimal
-	Área Asignada
	
### Para verificar el correcto funcionamiento se incluyen los siguientes casos de prueba: 
1.	queSeCreeUnVueloYSeAgregueUnPasajero()
2.	queSePuedaCrearUnHangarYNoSePuedaAgregarAvionesRepetidos()
3.	queNoSeExcedaLaCapacidadDeUnHangar()
4.	queElPasajeroTengaTelefonoYPasaporteValido()
5.	queElPasajeroNoTengaTelefonoYPasaporteValido()
6.	queUnPasajeroSoloEsteEnElLaCabinaDePasajeros()
7.	queUnPasajeroNoEsteEnElLaCabinaDePasajerosYLoCambieDeCabina()
8.	queSeCreeUnAvionYSePuedaAgregarUnPersonalYUnPilotoEnLaMismaLista()
9.	queSeCreeUnAvionYNoSePuedaAgregarUnPasajeroRepetidoNiPersonalRepetido()
10.	queElVueloTengaUnaFechaValida()
11.	queSiUnVueloTieneDistintosPaisesSeLeAsigneVueloInternacional()
12.	queSiUnVueloTieneLosMismosPaisesSeLeAsigneVueloCabotaje()
13.	queUnaRutaNoTengaMismoCodigoDeCiudadDeInicioQueDeDestino()
14.	queSePuedaBuscarUnPasajeroEnElAvionATravesDeSuPasaporte()
15.	 queSeCreeUnAvionYNoSePuedanAgregarVuelosRepetidos()
16.	 queHayaCapacidadSuficienteEnElAvion()
17.	 queSiNoHayCapacidadSuficienteEnElAvionRemuevaUnPasajero()
18.	 queUnPilotoConMasDe20HorasPuedaManejarUnAvionMilitar()
19.	 queUnPilotoYUnPersonalEstenEnLaCabinaCorrecta()
20.	 queSiUnPilotoYUnPersonalEstanEnElLaCabinaDePasajerosQueLoCambieALaCabinaDeVuelo()
21.	 queElPesoDeLasPersonasNoSupereAlPesoPermitido()
22.	 queSiElPesoDeLosPasajerosSuperaAlPesoPermitidoRemuevaPasajerosHastaLograrElPesoPermitido()
23.	 queSiSeExcedaLaCapacidadDeUnHangarElimineUnAvion()
24.	 queSePuedaBuscarUnAvionEnElHangar()
25.	 queSePuedaBuscarVuelosPorCodigoDeRuta()

