package testHistorias;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import alianza.Alianza;
import batalla.Batalla;
import batalla.BatallaVSNPC;
import casta.Casta;
import casta.Explorador;
import casta.Guerrero;
import casta.Mago;
import items.ConEscudoDeAcero;
import items.ConEscudoDeMadera;
import items.ConEspadaDeAcero;
import items.ConEspadaDeHierro;
import items.ConEspadaDeMadera;
import items.ConPapiroDeOz;
import personaje.Elfo;
import personaje.Enemigo1;
import personaje.Enemigo2;
import personaje.Enemigo3;
import personaje.Humano;
import personaje.NPC;
import personaje.Orco;
import personaje.Personaje;

public class HistoriaDeUsuario {
	
		/*
		 * Historia 1:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Asignar a mi personaje raza y casta
		 */
		
		@Test
	    public void Historia1() {
			Casta guerrero = new Guerrero();
			Personaje humano= new Humano(guerrero);
	        Assert.assertEquals(2, humano.obtenerPuntosDeAtaque());
	        Assert.assertEquals(1, humano.obtenerPuntosDeDefensa());
	        Assert.assertEquals(1, humano.obtenerPuntosDeInteligencia());
		}
		
		/*
		 * Historia 2:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * ingresar a un mundo con un personaje
		 */
		
		@Ignore
	    public void Historia2() {
		}
		
		/*
		 * Historia 3:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Obtener un item al ganar una batalla
		 * No se reflejan los cambios que se realizan dentro de la clase Batalla al agregar y quitar Items
		 */
		
		@Ignore
	    public void Historia3() {
			Casta guerrero = new Guerrero();
			Personaje humano= new Humano(guerrero);
			humano = new ConEspadaDeAcero(humano);
			Casta guerrero1 = new Guerrero();
			Personaje humano1= new Humano(guerrero1);
			humano1 = new ConEspadaDeMadera(humano1);
			humano1.setSalud(10);
			Batalla batalla= new Batalla ();
			batalla.agregarb1(humano);
			batalla.agregarb2(humano1);
			batalla.batalla();
			Assert.assertTrue(humano.tiene(ConEspadaDeAcero.class));
			Assert.assertEquals(7,humano.obtenerPuntosDeAtaque());
			Assert.assertEquals(3,humano1.obtenerPuntosDeAtaque());
		}
		
		/*
		 * Historia 4:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Aumento de experiencia al atacar enemigos
		 */
		
		@Test
	    public void Historia4() {
			Enemigo1 enemigo1 = new Enemigo1();
			Casta guerrero = new Guerrero();
			Personaje humano= new Humano(guerrero);		
			
			Assert.assertEquals(0, humano.obtenerPuntosDeExperiencia());
			humano.atacar(enemigo1);
			Assert.assertEquals(1, humano.obtenerPuntosDeExperiencia());

		}
		
		/*
		 * Historia 5:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Cambiar de nivel al aumentar mi experiencia 
		 */
		
		@Test
	    public void Historia5() {
			/*Elijo una casta y se la asigno a un Humano*/
			Casta explorador = new Explorador();
			Personaje humano= new Humano(explorador);
			
	        Casta guerrero = new Guerrero();
			Personaje humano2 = new Humano(guerrero);
	        
			/*Nivel inicial y puntos ganados iniciales*/
			Assert.assertEquals(0, humano.obtenerNivel());
			Assert.assertEquals(0, humano.obtenerPuntosDeExperiencia());
        	
			/*Ataco 100 veces hasta aumentar el nivel (curo y energizo para poder hacer el testeo)*/
	        for(int i = 0; i < 100 ; i++){
	        	Assert.assertEquals(i, humano.obtenerPuntosDeExperiencia());
	        	humano.atacar(humano2);
	        	humano2.serCurado();
	        	humano.serEnergizado();
	        }
	        
	        Assert.assertEquals(1, humano.obtenerNivel());
			Assert.assertEquals(0, humano.obtenerPuntosDeExperiencia());

		}
		
		/*
		 * Historia 6:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Al subir de nivel aumento mis habilidades
		 */
		
		@Test
	    public void Historia6() {
			/*Elijo una casta y se la asigno a un Humano*/
			Casta explorador = new Explorador();
			Personaje humano= new Humano(explorador);
			
	        Casta explorador2 = new Explorador();
			Personaje humano2 = new Humano(explorador2);
	        
			/*Nivel inicial y puntos ganados iniciales*/
			Assert.assertEquals(0, humano.obtenerNivel());
			Assert.assertEquals(0, humano.obtenerPuntosGanados());
        	
			/*Ataco 100 veces hasta aumentar el nivel (curo y energizo para poder hacer el testeo)*/
	        for(int i = 0; i<100 ; i++){
	        	humano.atacar(humano2);
	        	humano2.serCurado();
	        	humano.serEnergizado();
	        }
	        
	        Assert.assertEquals(1, humano.obtenerNivel());
			Assert.assertEquals(4, humano.obtenerPuntosGanados());
			
			/*Asigo algunos de los puntos ganados (no todos)*/
			humano.incrementarDestreza();
			humano.incrementarFuerza();
			humano.incrementarFuerza();
			
	        Assert.assertEquals(3, humano.obtenerPuntosDeAtaque());
	        Assert.assertEquals(3, humano.obtenerPuntosDeDefensa());
	        Assert.assertEquals(1, humano.obtenerPuntosDeInteligencia());
			
	        /*Vuelvo a atacar 100 veces*/
	        for(int i = 0; i<100 ; i++){
	        	humano.atacar(humano2);
	        	humano2.serCurado();
	        	humano.serEnergizado();
	        }
	        
	        Assert.assertEquals(2, humano.obtenerNivel());
			Assert.assertEquals(6, humano.obtenerPuntosGanados());
			
			/* Asigno todos los puntos ganados que tengo */
			humano.incrementarDestreza();
			humano.incrementarDestreza();
			humano.incrementarFuerza();
			humano.incrementarFuerza();
			humano.incrementarInteligencia();
			humano.incrementarInteligencia();
			
	        Assert.assertEquals(5, humano.obtenerPuntosDeAtaque());
	        Assert.assertEquals(5, humano.obtenerPuntosDeDefensa());
	        Assert.assertEquals(3, humano.obtenerPuntosDeInteligencia());
	        
		}
		
		/*
		 * Historia 7:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Equipar un personaje con una espada, potencia mi ataque
		 */
		
		@Test
	    public void Historia7() {
			//Elijo una casta y se la asigno a un Humano
			Casta guerrero = new Guerrero();
			Personaje humano= new Humano(guerrero);
	        Assert.assertEquals(2, humano.obtenerPuntosDeAtaque());
	        Assert.assertEquals(1, humano.obtenerPuntosDeDefensa());
	        Assert.assertEquals(1, humano.obtenerPuntosDeInteligencia());
	        
	        //Asigno una espada al personaje
	        humano = new ConEspadaDeMadera(humano);
	        Assert.assertEquals(3, humano.obtenerPuntosDeAtaque());
	        Assert.assertEquals(1, humano.obtenerPuntosDeDefensa());
	        Assert.assertEquals(1, humano.obtenerPuntosDeInteligencia());
		}
		
		/*
		 * Historia 8:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Equipar un personaje con un escudo, potencia mi defensa
		 */
		
		@Test
	    public void Historia8() {
			//Elijo una casta y se la asigno a un Orco
			Casta explorador = new Explorador();
			Personaje orco= new Orco(explorador);
	        Assert.assertEquals(1, orco.obtenerPuntosDeAtaque());
	        Assert.assertEquals(2, orco.obtenerPuntosDeDefensa());
	        Assert.assertEquals(1, orco.obtenerPuntosDeInteligencia());

	        //Asigno un escudo al personaje
	        orco = new ConEscudoDeMadera(orco);
	        Assert.assertEquals(1, orco.obtenerPuntosDeAtaque());
	        Assert.assertEquals(3, orco.obtenerPuntosDeDefensa());
	        Assert.assertEquals(1, orco.obtenerPuntosDeInteligencia());
		}
		
		/*
		 * Historia 9:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Equipar un personaje con una papiro, potencia mi inteligencia
		 */
		
		@Test
	    public void Historia9() {
			//Elijo una casta y se la asigno a un Elfo
			Casta mago = new Mago();
			Personaje elfo= new Elfo(mago);
	        Assert.assertEquals(1, elfo.obtenerPuntosDeAtaque());
	        Assert.assertEquals(1, elfo.obtenerPuntosDeDefensa());
	        Assert.assertEquals(2, elfo.obtenerPuntosDeInteligencia());

	        //Asigno un escudo al personaje
	        elfo = new ConPapiroDeOz(elfo);
	        Assert.assertEquals(1, elfo.obtenerPuntosDeAtaque());
	        Assert.assertEquals(1, elfo.obtenerPuntosDeDefensa());
	        Assert.assertEquals(3, elfo.obtenerPuntosDeInteligencia());
		}
		
		/*
		 * Historia 10:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Aliarme a otro personaje y combatir a su lado
		 */
		
		@Test
	    public void Historia10() {
			Casta mago = new Mago();
			Personaje elfo= new Elfo(mago);
			Casta guerrero = new Guerrero();
			Personaje humano= new Humano(guerrero);
			Alianza alianza=new Alianza();
			alianza.agregarAliado(humano);
			alianza.agregarAliado(elfo);
			Assert.assertEquals(2, alianza.getTamanio());
		}
		
		/*
		 * Historia 11:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Romper una alianza para generar una nueva, falta validar que un personaje no tenga mas de una alianza
		 */
		
		@Test
	    public void Historia11() {
			Casta mago = new Mago();
			Personaje elfo= new Elfo(mago);
			Casta guerrero = new Guerrero();
			Personaje humano= new Humano(guerrero);
			Casta explorador = new Explorador();
			Personaje orco= new Orco (explorador);
			Alianza alianza=new Alianza();
			alianza.agregarAliado(humano);
			alianza.agregarAliado(elfo);
			Assert.assertEquals(2, alianza.getTamanio());
			alianza.removerAliado(humano);
			Assert.assertEquals(1, alianza.getTamanio());
			Alianza alianza1=new Alianza();
			alianza1.agregarAliado(humano);
			alianza1.agregarAliado(orco);
			Assert.assertEquals(2, alianza1.getTamanio());
		}
		
		/*
		 * Historia 12:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Escapar de una batalla, siendo penalizado
		 * Falta realizar ajuste para desequipar un Item
		 */
		
		@Test
		public void Historia12() {
			Casta guerrero = new Guerrero();
			Personaje humano= new Humano(guerrero);
			humano = new ConEspadaDeAcero(humano);
			Casta guerrero1 = new Guerrero();
			Personaje humano1= new Humano(guerrero1);
			humano1 = new ConEspadaDeMadera(humano1);
			Batalla batalla= new Batalla ();
			batalla.agregarb1(humano);
			batalla.agregarb2(humano1);
			batalla.escaparBatalla(humano);
			Assert.assertEquals(0,batalla.consultaBatallon1());
			Assert.assertEquals(1,batalla.consultaBatallon2());
					
		}
		/*
		 * Historia 13:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Destrozar obstaculos
		 */
		
		@Ignore
	    public void Historia13() {
		}
		
		/*
		 * Historia 14:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Combatir NPC para aumentar experiencia
		 */
		
		@Test
	    public void Historia14() {
			
			//Elijo una casta y se la asigno a un Humano
			Casta guerrero = new Guerrero();
			Personaje humano= new Humano(guerrero);
		    humano = new ConEspadaDeAcero(humano);
		    NPC npc = new NPC ();
		    NPC npc1 = new NPC ();
		    Assert.assertEquals(7, humano.obtenerPuntosDeAtaque());
		    Assert.assertEquals(1, humano.obtenerPuntosDeDefensa());
		    Assert.assertEquals(1, humano.obtenerPuntosDeInteligencia());
		    Assert.assertEquals(0, humano.getExperiencia().getPuntoDeExperiencia());
		    Assert.assertEquals(5, npc.getSalud());
		    BatallaVSNPC batalla= new BatallaVSNPC();
			batalla.ataqueNPC(humano,npc);
			Assert.assertEquals(1, humano.getExperiencia().getPuntoDeExperiencia());
			Assert.assertEquals(0, npc.getSalud());
			BatallaVSNPC batalla1= new BatallaVSNPC();
			batalla1.ataqueNPC(humano,npc1);
			Assert.assertEquals(2, humano.getExperiencia().getPuntoDeExperiencia());
			Assert.assertEquals(0, npc.getSalud());
		}
}
