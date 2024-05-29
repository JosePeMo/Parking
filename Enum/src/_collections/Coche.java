package _collections;

import java.util.Objects;
import java.util.Random;

public class Coche {
	
	private Color ColorCoche;
	private Marca MarcaCoche;
	
	public Coche(Color colorCoche, Marca marcaCoche) {
		ColorCoche = colorCoche;
		MarcaCoche = marcaCoche;
	}

	public static Color colorAleatorio() {
        Color[] colores = Color.values();
        Random random = new Random();
        return colores[random.nextInt(colores.length)];
    }
	
	public static Marca marcaAleatorio() {
		Marca[] marcas = Marca.values();
        Random random = new Random();
        return marcas[random.nextInt(marcas.length)];
    }
		
	public Coche() {
		ColorCoche = colorAleatorio();
		MarcaCoche = marcaAleatorio();
	}

	@Override
	public String toString() {
		return "Coche: " + ColorCoche + " " + MarcaCoche;
	}

	public Color getColorCoche() {
		return ColorCoche;
	}

	public Marca getMarcaCoche() {
		return MarcaCoche;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ColorCoche, MarcaCoche);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return ColorCoche == other.ColorCoche && MarcaCoche == other.MarcaCoche;
	}
	
	
}
