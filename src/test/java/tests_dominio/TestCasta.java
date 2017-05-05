package tests_dominio;

import org.junit.Assert;
import org.junit.Test;
import dominio.Casta;
import dominio.Humano;
import dominio.Hechicero;

public class TestCasta {

	@Test
	public void testGettersYSetters(){
    Hechicero h = new Hechicero();

		h.setProbabilidadGolpeCritico(0.5);
		Assert.assertTrue(0.5 == h.getProbabilidadGolpeCritico());

		h.setProbabilidadEvitarDa�o(0.5);
		Assert.assertTrue(0.5 == h.getProbabilidadEvitarDa�o());

		h.setDa�oCritico(0.5);
		Assert.assertTrue(0.5 == h.getDa�oCritico());

		Assert.assertTrue("Hechicero" == h.getNombreCasta());
		Assert.assertTrue("Bola de Fuego" == h.getHabilidadesCasta()[0]);
	}

}
