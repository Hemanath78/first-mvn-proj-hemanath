package com.fssa.hnm.product;

/**
 * 
 * @author HemanathMuralikrishn
 *
 */

public class Quantity {

	private double rs; 
	private String unit;
	private double weight;

//	get and set for weight

	public double getWeight() {

		return weight;
	}

	public void setWeight(float weight) {

		this.weight = weight;
	}

//	get and set for unit

	public String getUnit() {

		return unit;
	}

	public void setUnit(String unit) {

		this.unit = unit;
	}

//	get and set for rs

	public double getRs() {

		return rs;
	}

	public void setRs(float rs) {

		this.rs = rs;
	}

}