package enume;

public enum WeekendDay {

	// El literal es la abreviatura
	VI("viernes", "friday",5), SA("sábado", "saturday",6), DO("domingo", "sunday",7);
	
	private String longNameSP;
	private String longNameEN;
	private int diaDeLaSemana;
	
	
	private WeekendDay(String longNameSP, String longNameEN, int diaDeLaSemana) {
		this.longNameSP = longNameSP;
		this.longNameEN = longNameEN;
		this.diaDeLaSemana = diaDeLaSemana;
	}


	public String getLongNameSP() {
		return longNameSP;
	}


	public String getLongNameEN() {
		return longNameEN;
	}


	public int getDiaDeLaSemana() {
		return diaDeLaSemana;
	}
	
	
	public String saludaSP() {
		System.out.printf("Hola soy %s y soy el dia %d", longNameSP, diaDeLaSemana);
		return null;
	}
	public String saludaEN() {
		System.out.printf("Hola soy %s y soy el dia %d", longNameEN, diaDeLaSemana);
		return null;
	}
}
