package items;

import personaje.Personaje;

public class ConArmadura extends Item {
	
		public ConArmadura(Personaje pers) {
			super (pers);
		}
		
		public ConArmadura() {
			super ();
		}
		
		public int getFuerza1() {
			return super.getFuerza1() + 2;
		}

		public int obtenerPuntos(){
			return super.obtenerPuntos() + 2;
		}

}
