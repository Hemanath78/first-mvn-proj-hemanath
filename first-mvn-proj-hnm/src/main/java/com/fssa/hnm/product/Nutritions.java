package com.fssa.hnm.product;

/**
 * 
 * @author HemanathMuralikrishn
 *
 */

public class Nutritions { 

	private Protein protein;
	private Carbohydrates carbo;
	private double kcal;

//	get and set for kcal

	public double getKcal() {

		return kcal;
	}

	public void setKcal(double kcal) {

		this.kcal = kcal;
	}

	public Protein getProtein() {
		return protein;
	}

	public void setProtein(Protein protein) {
		this.protein = protein;
	}

	public Carbohydrates getCarbo() {
		return carbo;
	}

	public void setCarbo(Carbohydrates carbo) {
		this.carbo = carbo;
	}

}
