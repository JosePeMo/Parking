package enume;

public class Fiesta {

	private WeekendDay dia;

	
	public Fiesta(WeekendDay dia) {
		this.dia = dia;
	}
	
	
	@Override
	public String toString() {
		return "Fiesta [dia=" + dia + "]";
	}


	public static void main(String[] args) {
		Fiesta f1 = new Fiesta(WeekendDay.DO);
		System.out.println(WeekendDay.SA.getLongNameEN());
		System.out.println(WeekendDay.SA.getLongNameSP());
		WeekendDay.SA.saludaSP();
		Fiesta f2 = new Fiesta (WeekendDay.SA);
	}
}
