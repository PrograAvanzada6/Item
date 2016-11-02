package items;

import personaje.Personaje;

public class Item {
	
	private Item equipamiento;
	//private int fuerza1=0;

	public Item(Personaje pers) {
		if (pers.equipamiento == null)
		this.equipamiento = pers.equipamiento;
	}

	protected int calcularPuntos(){
		return this.calcularPuntos();
	}
	
	public Item() {
	}
	
	
	public int obtenerPuntos(){
		return this.equipamiento.obtenerPuntos();
	}
}

