package br.com.caelum.leilao.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.servico.MatematicaMaluca;

public class MatematicaMalucaTest {

	@Test
	public void deveEntenderNumeroMaiorQue30() {

		MatematicaMaluca mat = new MatematicaMaluca();
		int resultado = mat.contaMaluca(50);
		
		assertEquals(200, resultado);
		
	}

	@Test
	public void deveEntenderNumeroMenorQue10() {

		MatematicaMaluca mat = new MatematicaMaluca();
		int resultado = mat.contaMaluca(9);
		
		assertEquals(18, resultado);
		
	}

	@Test
	public void deveEntenderNumeroMaiorQue10() {

		MatematicaMaluca mat = new MatematicaMaluca();
		int resultado = mat.contaMaluca(25);
		
		assertEquals(75, resultado);
		
	}

	@Test
	public void deveEntenderNumeroIgualA30() {

		MatematicaMaluca mat = new MatematicaMaluca();
		int resultado = mat.contaMaluca(30);
		
		assertEquals(90, resultado);
		
	}

	@Test
	public void deveEntenderNumeroIgualA10() {

		MatematicaMaluca mat = new MatematicaMaluca();
		int resultado = mat.contaMaluca(10);
		
		assertEquals(20, resultado);
		
	}

}
