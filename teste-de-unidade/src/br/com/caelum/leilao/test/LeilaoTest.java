package br.com.caelum.leilao.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class LeilaoTest {

	@Test
	public void deveReceverUmLance() {
		Leilao leilao = new Leilao("Macbook");
		assertEquals(0, leilao.getLances().size());

		leilao.propoe(new Lance(new Usuario("Carlos"), 5000));
		assertEquals(5000, leilao.getLances().get(0).getValor(), 0.00001);

	}

	@Test
	public void deveReceverVariosLances() {
		Leilao leilao = new Leilao("Macbook");

		leilao.propoe(new Lance(new Usuario("Carlos"), 5000));
		leilao.propoe(new Lance(new Usuario("Caio"), 3000));

		assertEquals(2, leilao.getLances().size());
		assertEquals(5000, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(3000, leilao.getLances().get(1).getValor(), 0.00001);

	}

	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook");

		Usuario usuario = new Usuario("Carlos");
		leilao.propoe(new Lance(usuario, 5000));
		leilao.propoe(new Lance(usuario, 6000));

		assertEquals(1, leilao.getLances().size());
		assertEquals(5000, leilao.getLances().get(0).getValor(), 0.00001);

	}

	@Test
	public void naoDeveAceitarMaisDeQueCincoLancesDeUmUsuario() {
		Leilao leilao = new Leilao("Macbook");

		Usuario carlos = new Usuario("Carlos");
		Usuario caio = new Usuario("Caio");

		leilao.propoe(new Lance(carlos, 1000));
		leilao.propoe(new Lance(caio, 2000));

		leilao.propoe(new Lance(carlos, 3000));
		leilao.propoe(new Lance(caio, 4000));

		leilao.propoe(new Lance(carlos, 5000));
		leilao.propoe(new Lance(caio, 6000));

		leilao.propoe(new Lance(carlos, 7000));
		leilao.propoe(new Lance(caio, 8000));

		leilao.propoe(new Lance(carlos, 9000));
		leilao.propoe(new Lance(caio, 10000));

		leilao.propoe(new Lance(carlos, 11000));

		assertEquals(10, leilao.getLances().size());
		assertEquals(10000, leilao.getLances().get(leilao.getLances().size() - 1).getValor(), 0.00001);

	}

}
