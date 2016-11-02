package personaje;

public class Enemigo1 extends Personaje {
	
	public Enemigo1() {
		this.salud=20;
		this.energia=20;
	}

	@Override
	protected boolean puedeAtacar() {
		return energia >= calcularPuntosDeAtaque();
	}

	@Override
	protected int calcularPuntosDeAtaque() {
		return getFuerza();
	}

	@Override
	protected int calcularPuntosDeDefensa() {
		return getDestreza();
	}

	@Override
	protected int calcularPuntosDeMagia() {
		return 0;
	}

	@Override
	protected int calcularPuntosDeInteligencia() {
		return calcularPuntosDeInteligencia();
	}

	@Override
	protected int calcularQuiteDeEnergia() {
		return 1;
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return calcularPuntosDeAtaque();
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		return calcularPuntosDeDefensa();
	}

	@Override
	public int obtenerPuntosDeMagia() {
		return 0;
	}

	@Override
	public int obtenerPuntosDeInteligencia() {
		return calcularPuntosDeInteligencia();
	}

	@Override
	public int obtenerPuntosDeExperiencia() {
		return 0;
	}

	@Override
	public int obtenerNivel() {
		return 0;
	}

	@Override
	public int obtenerQuiteDeEnergia() {
		return 1;
	}

}
