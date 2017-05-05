package dominio;

/**
 * La clase Asesino hereda de Casta e implementa los metodos abstractos de su clase
 * padre, habilidad 1, 2 y 3. Es un tipo especifico de Casta.
 * Tambien define sus habilidades que son el golpe critico, aumentar la evasion y robar.
 */

public class Asesino extends Casta {

	private static final int ENERGIA_MINIMA = 3;
	private static final double INCREMENTO_EVITAR_DA�O = 0.15;
	private static final double MAX_PROBABILIDAD_EVITAR_DA�O = 0.5;

	/**
	 * Constructor de asesinos con parámetros.
	 * @param prob_crit es la probabilidad de golpe critico
	 * @param evasion evasion
	 * @param da�o_crit es el da�o crítico
	 */

	public Asesino(final double prob_crit, final double evasion, final double da�o_crit) {
		super("Asesino", prob_crit, evasion, da�o_crit);
	}

	/**
	 * Constructor de asesinos por defecto. Asigna el nombre y las habilidades
	 * de esta casta.
	 */

	public Asesino() {
		super("Asesino", "Golpe Critico", "Aumentar Evasion", "Robar");
	}

	/**
	 * Sobreescribe la habilidad1 de la clase padre.
	 * @param caster es el personaje a traves del cual se obtiene el da�o y al que se
	 * le decrementa la energía.
	 * @param atacado es el objecto que será atacado.
	 * @return verdadero o falso para la utilización del golpe critico
	 * dependiendo del caster y el atacado.
	 */

	public boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDa�oCritico())) > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Sobreescribe la habilidad2 de la clase padre.
	 * @param caster es el personaje al cual se le decrementa la energía.
	 * @param atacado no es utilizado en este metodo
	 * @return verdadero o falso para la utilización de aumentar evasion
	 * dependiendo del caster y el atacado.
	 */

	public boolean habilidad2(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
			if (this.getProbabilidadEvitarDa�o() + INCREMENTO_EVITAR_DA�O < MAX_PROBABILIDAD_EVITAR_DA�O) {
				this.probabilidadEvitarDa�o += INCREMENTO_EVITAR_DA�O;
			} else {
				this.probabilidadEvitarDa�o = MAX_PROBABILIDAD_EVITAR_DA�O;
			}
			return true;
		}
		return false;
	}

	/**
	 * Sobreescribe la habilidad3 (robar) de la clase padre.
	 * @param caster no es utilizado
	 * @param atacado no es utilizado
	 * @return siempre falso.
	 */

	public boolean habilidad3(final Personaje caster, final Peleable atacado) {
		return false;
	}

	/**
	 * @param personaje sobre el cual se incrementa la destreza
	 */

	public void incrementarAtributoAlCrear(final Personaje personaje) {
		personaje.setDestreza(personaje.getDestreza() + INCREMENTO_POR_TIPO);
	}
}
