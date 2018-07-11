package br.com.caelum.leilao.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import junit.framework.Assert;

public class Testes {

	@Test
	public void testaValoresMenoresMaiores() {

		Usuario carlos = new Usuario("Carlos");
		Usuario caio = new Usuario("Caio");
		Usuario ana = new Usuario("Ana");

		Leilao leilao = new Leilao("Leilão Teste");

		leilao.propoe(new Lance(carlos, 500));
		leilao.propoe(new Lance(caio, 400));
		leilao.propoe(new Lance(ana, 1500));

		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);

		double maiorEsperado = 1500;
		double menorEsperado = 400;

		assertEquals(maiorEsperado, avaliador.getMaiorValor(), 0.0001);
		assertEquals(menorEsperado, avaliador.getMenorValor(), 0.0001);

	}

}
