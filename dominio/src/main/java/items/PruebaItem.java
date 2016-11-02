package items;

import org.junit.Assert;

import casta.Casta;
import casta.Guerrero;
import personaje.Humano;
import personaje.Personaje;

public class PruebaItem {
	
	public static void main (String [] args){
		Casta guerrero = new Guerrero();
		Personaje humano= new Humano(guerrero);
		Item item= new ConEscoba (humano);
		System.out.println("1 " + humano.obtenerPuntos());
		humano = new Humano (item);
        System.out.println("2 " + humano.obtenerPuntos());
        Item conArmadura = new ConArmadura();
        humano = new Humano (conArmadura);
        //System.out.println("3 " + item.obtenerPuntos());
        
	}

}
