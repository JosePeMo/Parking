package _collections;

public enum Marca {

	WV("Volskswagen"),HY("Hyundai"),CI("Citroen"),HO("Honda"),NI("Nissan");
	
	private String marca;

	private Marca(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

}
