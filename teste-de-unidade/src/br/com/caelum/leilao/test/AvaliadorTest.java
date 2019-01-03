package br.com.caelum.leilao.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class AvaliadorTest {

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {

		// parte 1: cenario
		Usuario carlos = new Usuario("Carlos");
		Usuario caio = new Usuario("Caio");
		Usuario ana = new Usuario("Ana");

		Leilao leilao = new Leilao("Playstation 4");

		leilao.propoe(new Lance(carlos, 500));
		leilao.propoe(new Lance(caio, 400));
		leilao.propoe(new Lance(ana, 1500));

		// parte 2: acao
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);

		double maiorEsperado = 1500;
		double menorEsperado = 400;

		// parte 3: validacao
		assertEquals(maiorEsperado, avaliador.getMaiorValor(), 0.0001); // ultimo parâmetro -> delta. utilizado para
																		// fins de arredondamento
		assertEquals(menorEsperado, avaliador.getMenorValor(), 0.0001);

	}

	@Test
	public void deveEntenderValorMedioDeLances() {
		// parte 1: cenario
		Usuario carlos = new Usuario("Carlos");
		Usuario caio = new Usuario("Caio");
		Usuario ana = new Usuario("Ana");

		Leilao leilao = new Leilao("Playstation 4");

		leilao.propoe(new Lance(carlos, 500));
		leilao.propoe(new Lance(caio, 400));
		leilao.propoe(new Lance(ana, 1500));

		// parte 2: acao
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);

		double valorMedioEsperado = 800;
		assertEquals(valorMedioEsperado, avaliador.getMedia(), 0.0001);

	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {

		Usuario carlos = new Usuario("Carlos");

		Leilao leilao = new Leilao("XBOX ONE");

		leilao.propoe(new Lance(carlos, 1200));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(1200, leiloeiro.getMaiorValor(), 0.00001);
		assertEquals(1200, leiloeiro.getMenorValor(), 0.00001);
	}

	@Test
	public void deveEntenderLeilaoEmOrdemAleatoria() {

		Usuario carlos = new Usuario("Carlos");

		Leilao leilao = new Leilao("XBOX ONE");

		leilao.propoe(new Lance(carlos, 200));
		leilao.propoe(new Lance(carlos, 450));
		leilao.propoe(new Lance(carlos, 120));
		leilao.propoe(new Lance(carlos, 700));
		leilao.propoe(new Lance(carlos, 630));
		leilao.propoe(new Lance(carlos, 230));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(700, leiloeiro.getMaiorValor(), 0.00001);
		assertEquals(120, leiloeiro.getMenorValor(), 0.00001);
	}

	@Test
	public void deveEntenderLeilaoEmOrdemDecrescente() {

		Usuario carlos = new Usuario("Carlos");

		Leilao leilao = new Leilao("XBOX ONE");

		leilao.propoe(new Lance(carlos, 400));
		leilao.propoe(new Lance(carlos, 300));
		leilao.propoe(new Lance(carlos, 200));
		leilao.propoe(new Lance(carlos, 100));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(400, leiloeiro.getMaiorValor(), 0.00001);
		assertEquals(100, leiloeiro.getMenorValor(), 0.00001);
	}

	@Test
	public void deveRetornarTresMaioresValores() {

		Usuario carlos = new Usuario("Carlos");

		Leilao leilao = new Leilao("XBOX ONE");

		leilao.propoe(new Lance(carlos, 1200));
		leilao.propoe(new Lance(carlos, 5200));
		leilao.propoe(new Lance(carlos, 200));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(3, leiloeiro.getTresMaiores().size());
		assertEquals(5200, leiloeiro.getTresMaiores().get(0).getValor(), 0.0001);
		assertEquals(1200, leiloeiro.getTresMaiores().get(1).getValor(), 0.0001);
		assertEquals(200, leiloeiro.getTresMaiores().get(2).getValor(), 0.0001);
	}

	@Test
	public void deveRetornarListaVazia() {

		Leilao leilao = new Leilao("XBOX ONE");

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(0, maiores.size());
	}

}
