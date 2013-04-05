package com.codekata.datamunging;

import com.codekata.datamunging.impl.SoccerDataMunger;
import com.codekata.datamunging.impl.WeatherDataMunger;


public class Main {
	
	public static final String WEATHER_FILE_PATH = "/Users/mdavis/Desktop/Code Katas/4. Data Munging/weather.dat";
	public static final String SOCCER_FILE_PATH = "/Users/mdavis/Desktop/Code Katas/4. Data Munging/football.dat";

	public static void main(String[] args) {
		
		try {
			
			// Part 1: Weather Data
			processFileDataMunger(new WeatherDataMunger(WEATHER_FILE_PATH));
			
			// Part 2: Soccer Data
			processFileDataMunger(new SoccerDataMunger(SOCCER_FILE_PATH));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void processFileDataMunger(FileDataMunger munger) {
		munger.processFile();
		munger.printOutput();
	}
}
