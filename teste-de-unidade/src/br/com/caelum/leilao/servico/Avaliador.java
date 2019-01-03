package br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorValor = Double.NEGATIVE_INFINITY; // Maior número que cabe dentro do double
	private double menorValor = Double.POSITIVE_INFINITY; // Menor número que cabe dentro do double
	private double media = 0;
	private List<Lance> maiores;

	public void avalia(Leilao leilao) {

		double total = 0;
		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() > maiorValor) {
				setMaiorValor(lance.getValor());
			}

			if (lance.getValor() < menorValor) {
				setMenorValor(lance.getValor());
			}
			total += lance.getValor();
		}
		calculaMedia(leilao, total);

		maioresValores(leilao);
	}

	private void calculaMedia(Leilao leilao, double total) {
		if (total == 0) {
			media = 0;
			return;
		}

		media = total / leilao.getLances().size();
	}

	private void maioresValores(Leilao leilao) {

		this.maiores = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(this.maiores, new Comparator<Lance>() {
			public int compare(Lance l1, Lance l2) {
				if (l1.getValor() > l2.getValor())
					return -1;
				if (l1.getValor() < l2.getValor())
					return 1;
				return 0;
			}
		});

		this.maiores = this.maiores.subList(0, this.maiores.size() > 3 ? 3 : this.maiores.size());

	}

	public List<Lance> getTresMaiores() {
		return this.maiores;
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

	public double getMedia() {
		return media;
	}

}
