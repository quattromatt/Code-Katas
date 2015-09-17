package com.java8.domain;

public abstract class Car implements Vehicle {

	private String m_make;
	private String m_model;
	private String m_color;
	private int m_numDoors;
	private int m_maxMph;
	
	public Car(String make, String model, String color, int numDoors, int maxMph) {
		m_make = make;
		m_model = model;
		m_color = color;
		m_numDoors = numDoors;
		m_maxMph = maxMph;
	}
	
	public String getModel() {
		return m_model;
	}
	
	public String getMake() {
		return m_make;
	}

	public boolean hasWheels() {
		return true;
	}

	public String getColor() {
		return m_color;
	}
	
	public int getNumDoors() {
		return m_numDoors;
	}
	
	public int getMaxMph() {
		return m_maxMph;
	}
	
	@Override
	public String toString() {
		return m_make + " " + m_model + " (" + m_color + ")";
	}
}
