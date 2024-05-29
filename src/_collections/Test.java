package _collections;

public class Test {

	public static void main(String[] args) {
		Coche c1 = new Coche(Color.AM,Marca.HY);
		System.out.println(c1);
		Coche c2 = new Coche(Color.AM,Marca.HY);
		Coche c3 = new Coche(Color.AZ,Marca.CI);
		Coche c4 = new Coche(Color.NA,Marca.WV);
		Coche c5 = new Coche(Color.AM,Marca.NI);
		Coche c6 = new Coche(Color.RO,Marca.CI);
		Parking p1 = new Parking("Mi primer parking", 10);
		p1.entraCoche(c1);
		p1.entraCoche(c2);
		p1.entraCoche(c3);
		p1.entraCoche(c4);
		p1.entraCoche(c5);
		p1.entraCoche(c6);
		System.out.println();
		System.out.println(p1);
		p1.reportParking();
		p1.reportColores();
		p1.reportMarcas();
		p1.reportCochesIguales();
		p1.reportSetCoches();
		}
}
