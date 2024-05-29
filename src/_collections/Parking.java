package _collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class Parking {

	private String nombre;
	private int plazasActual;
	private int totalPlazas;
	private int listaDePlazas;
	private ArrayList<Coche> listaDeCoches = new ArrayList<>();
	private Map<Color, Integer> mapColores = new HashMap<>();
	private Map<Marca, Integer> mapMarca = new HashMap<>();
	private Map<Coche, Integer> mapCoche = new HashMap<>();
	private Set<Coche> setCoches = new HashSet<>();
	
	public Parking(String nombre, int totalPlazas) {
		this.nombre = nombre;
		this.totalPlazas = totalPlazas;
	}

	private boolean estaDentro(Coche c) {
		for (Coche coche : listaDeCoches) {
			if (coche == c) {
				return true;
			}
		}
		return false;
	}
	
	private void sumaColor(Coche c) {
		if(mapColores.containsKey(c.getColorCoche())) {
			mapColores.put(c.getColorCoche(), mapColores.get(c.getColorCoche()) + 1 );
		} else {
			mapColores.put(c.getColorCoche(), 1);
		}
	}
	
	private void sumaMarca(Coche c) {
		if(mapMarca.containsKey(c.getMarcaCoche())) {
			mapMarca.put(c.getMarcaCoche(), mapMarca.get(c.getMarcaCoche()) + 1 );
		} else {
			mapMarca.put(c.getMarcaCoche(), 1);
		}
	}
	
	private void sumaIguales(Coche c) {
		if(mapCoche.containsKey(c)) {
			mapCoche.put(c, mapCoche.get(c) + 1 );
		} else {
			mapCoche.put(c, 1);
		}
	}
	/*
	private void restaIguales(Coche c) {
		if(mapCoche.containsKey(c.getColorCoche())) {
			mapCoche.put(c.getColorCoche(), mapCoche.get(c.getColorCoche()) - 1 );
		} else {
			mapCoche.put(c.getColorCoche(), 1);
		}
	}
*/
	
	public boolean entraCoche(Coche c) {
		if (estaDentro(c)) {
			System.out.println("Su coche ya está dentro");
			return false;
		}
		if (listaDeCoches.size() == totalPlazas) {
			System.out.println("Ya hay el máximo de plazas ocupadas");
			return false;
		}
		sumaColor(c);
		sumaMarca(c);
		sumaIguales(c);
		listaDeCoches.add(c);
		setCoches.add(c);
		System.out.println("Coche añadido");
		return true;
	}
	
	public boolean saleCoche(Coche c) {
		if (!estaDentro(c))
			return false;
		listaDeCoches.remove(c);
		setCoches.remove(c);
		System.out.println("El coche ha salido del parking");
		return true;

	}

	public boolean saleCocheAleatrorio() {
		Random randon = new Random();
		int numRandom = randon.nextInt(listaDeCoches.size());
		if (listaDeCoches.size() == 0) {
			System.out.println("Ya han salido todos los coches");
			return false;
		}
		listaDeCoches.remove(numRandom);
		setCoches.remove(numRandom);
		System.out.printf("El coche %s ha salido", listaDeCoches.get(numRandom));
		return false;
	}

	public boolean vaciaParking() {
		if (listaDeCoches.size() == 0) {
			System.out.println("No quedan coches dentro del parking, Parking Vacio");
			return false;
		}
		while (listaDeCoches.size() != 0) {
			for (int i = 0; i < listaDeCoches.size(); i++) {
				listaDeCoches.remove(i);
			}
		}
		System.out.println("Parking vacío");
		return false;
	}

	public void reportParking() {
		for (Coche coche : listaDeCoches) {
			System.out.println("  " + coche);
		}
		System.out.printf("Total coches: %d, plazas libres: %d%n%n", listaDeCoches.size(),
				totalPlazas - listaDeCoches.size());
	}

	private void totalNumeroPlazas() {
		System.out.printf("Total coches: %d%n%n", listaDeCoches.size(),
				totalPlazas - listaDeCoches.size());
	}

	public void reportColores() {
		System.out.printf("REPORT DE COLORES%n-----------------%nParking: %s%n", nombre);
		for (Map.Entry<Color, Integer> colorDeColores : mapColores.entrySet()) {
			System.out.printf("El coche de marca %s se repite %d ve%s%n", colorDeColores.getKey().getColor(),
					colorDeColores.getValue(), mapColores.get(colorDeColores.getKey()) > 1 ? "ces" : "z");
		}
		totalNumeroPlazas();
	}
	
	public void reportMarcas() {
		System.out.printf("REPORT DE MARCAS%n-----------------%nParking: %s%n", nombre);
		for (Map.Entry<Marca, Integer> marcaDelCoche : mapMarca.entrySet()) {
			System.out.printf("El coche de marca %s se repite %d ve%s%n", marcaDelCoche.getKey().getMarca(),
					marcaDelCoche.getValue(), mapMarca.get(marcaDelCoche.getKey()) > 1 ? "ces" : "z");
		}
		totalNumeroPlazas();
	}
	
	public void reportCochesIguales(){
		System.out.printf("REPORT DE COCHES IGUALES%n-----------------%nParking: %s%n", nombre);
		for (Map.Entry<Coche, Integer> cochesIguales : mapCoche.entrySet()) {
			System.out.printf("Coche: %s se repite %d ve%s%n", cochesIguales.getKey(),
					cochesIguales.getValue(), mapCoche.get(cochesIguales.getKey()) > 1 ? "ces" : "z");
		}
		totalNumeroPlazas();
	}
	
	public void reportSetCoches() {
		System.out.printf("REPORT SET DE COCHES%n-----------------%nParking: %s%n", nombre);
		for (Coche coche : setCoches) {
			System.out.println(coche);
		}
		totalNumeroPlazas();
	}
	
	@Override
	public String toString() {
		return String.format("LISTADO COCHES%n--------------%nParking: %s", nombre);
	}

}
