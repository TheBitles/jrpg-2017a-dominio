package dominio;

import java.io.Serializable;

/**
 * La clase Casta posee una serie de atributos relacionados a la defensa y el
 * ataque del personaje y también a sus habilidades.
 * Define 3 métodos de habilidad abstractos.
 */

public abstract class Casta implements Serializable {

	protected static final int INCREMENTO_POR_TIPO = 5;
	protected static final int ENERGIA_MINIMA = 10;

	private static final int CANTIDAD_HABILIDADES = 3;
	private static final double PROBABILIDAD_POR_DEFECTO = 0.2;
	private static final double DA�O_CRITICO_POR_DEFECTO = 1.5;

	private double probabilidadGolpeCritico;
	protected double probabilidadEvitarDa�o;
	private double da�oCritico;
	protected String nombreCasta;

	protected String[] habilidadesCasta;

	/**
	 * Constructor de una casta con sus valores por defecto
	 */

	public Casta(final String nombreCasta, final String habilidad1,
		final String habilidad2, final String habilidad3) {

		this.probabilidadGolpeCritico = PROBABILIDAD_POR_DEFECTO;
		this.probabilidadEvitarDa�o = PROBABILIDAD_POR_DEFECTO;
		this.da�oCritico = DA�O_CRITICO_POR_DEFECTO;

		this.nombreCasta = nombreCasta;

		habilidadesCasta = new String[CANTIDAD_HABILIDADES];
		habilidadesCasta[0] = habilidad1;
		habilidadesCasta[1] = habilidad2;
		habilidadesCasta[2] = habilidad3;
	}

	/**
	 * Constructor de una casta con valores por parámetro.
	 * @param nombreCasta nombre de la casta
	 * @param prob_crit probabilidad de golpe critico.
	 * @param evasion probabilidad de evitar da�o.
	 * @param da�o_crit da�o critico.
	 */

	public Casta(final String nombreCasta, final double prob_crit, final double evasion, final double da�o_crit) {
		this.nombreCasta = nombreCasta;

		this.probabilidadGolpeCritico = prob_crit;
		this.probabilidadEvitarDa�o = evasion;
		this.da�oCritico = da�o_crit;
	}

	/**
	 * Habilidad 1 será sobreescrita en las clases que hereden de esta.
	 * @param caster caster
	 * @param atacado atacado
	 * @return verdadero o falso si se puede utilizar la habilidad1 o no.
	 */

	public abstract boolean habilidad1(Personaje caster, Peleable atacado);

	/**
	 * Habilidad 2 será sobreescrita en las clases que hereden de esta.
	 * @param caster caster
	 * @param atacado atacado
	 * @return verdadero o falso si se puede utilizar la habilidad2 o no.
	 */

	public abstract boolean habilidad2(Personaje caster, Peleable atacado);

	/**
	 * Habilidad 3 será sobreescrita en las clases que hereden de esta.
	 * @param caster caster
	 * @param atacado atacado
	 * @return verdadero o falso si se puede utilizar la habilidad2 o no.
	 */

	public abstract boolean habilidad3(Personaje caster, Peleable atacado);

	/**
	 * incrementarAtributoAlCrear será sobreescrita en las clases que hereden de esta.
	 * @param personaje sobre el cual se incrementa el atributo
	 */

	public abstract void incrementarAtributoAlCrear(Personaje personaje);

	/**
	 * @return el nombre de la casta
	 */

	public String getNombreCasta() {
		return this.nombreCasta;
	}

	/**
	 * @return las habilidades de la casta
	 */

	public String[] getHabilidadesCasta() {
		return habilidadesCasta;
	}

	/**
	 * @return la probabilidad del golpe crítico
	 */

	public double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}

	/**
	 * Asigna la probabilidad de golpe critico
	 * @param probabilidadGolpeCritico a asignar
	 */

	public void setProbabilidadGolpeCritico(final double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}

	/**
	 * @return la probabilidad del evitar da�o
	 */

	public double getProbabilidadEvitarDa�o() {
		return probabilidadEvitarDa�o;
	}

	/**
	 * Asigna la probabilidad de evitar da�o
	 * @param probabilidadEvitarDa�o a asignar
	 */

	public void setProbabilidadEvitarDa�o(final double probabilidadEvitarDa�o) {
		this.probabilidadEvitarDa�o = probabilidadEvitarDa�o;
	}

	/**
	 * @return el da�o critico
	 */

	public double getDa�oCritico() {
		return da�oCritico;
	}

	/**
	 * Asigna el da�o critico
	 * @param da�oCritico a asignar
	 */

	public void setDa�oCritico(final double da�oCritico) {
		this.da�oCritico = da�oCritico;
	}
}
