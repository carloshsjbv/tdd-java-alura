package br.com.caelum.leilao.dominio;

public class Avaliador {

	private double maiorValor = Double.NEGATIVE_INFINITY;
	private double menorValor = Double.POSITIVE_INFINITY;

	public void avalia(Leilao leilao) {

		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() > maiorValor) {
				setMaiorValor(lance.getValor());
			}

			if (lance.getValor() < menorValor) {
				setMenorValor(lance.getValor());
			}
		}

	}

	private void setMenorValor(double valor) {
		this.menorValor = valor;
	}

	private void setMaiorValor(double valor) {
		this.maiorValor = valor;
	}

	public double getMaiorValor() {
		return maiorValor;
	}

	public double getMenorValor() {
		return menorValor;
	}

}
