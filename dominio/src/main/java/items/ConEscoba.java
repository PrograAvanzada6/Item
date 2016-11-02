package items;

import personaje.Personaje;

public class ConEscoba extends Item{
	
	public ConEscoba(Personaje pers) {
		super (pers);
	}
	public ConEscoba() {
		super ();
	}
	
	public int obtenerPuntos(){
		return super.obtenerPuntos()+ 5;
	}

}
