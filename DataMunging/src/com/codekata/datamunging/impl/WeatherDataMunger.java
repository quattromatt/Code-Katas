package com.codekata.datamunging.impl;

import com.codekata.datamunging.FileDataMunger;

public class WeatherDataMunger extends FileDataMunger {

	private static final String EXTREME_TEMP_SUFFIX = "*";
	
	private int m_minTempSpread = -1;
	private int m_minTemp = 0;
	private int m_maxTemp = 0;
	private int m_day = 0;
	
	public WeatherDataMunger(String filePath) {
		super(filePath);
	}
	
	@Override
	protected void processData(String[] data) {
		int maxTemp = getTempFromString(data[1]);
		int minTemp = getTempFromString(data[2]);
		int tempSpread = maxTemp - minTemp;
		
		if (tempSpread < m_minTempSpread || m_minTempSpread == -1) {
			m_minTempSpread = tempSpread;
			
			m_minTemp = minTemp;
			m_maxTemp = maxTemp;
			m_day = Integer.parseInt(data[0]);
		}
	}
	
	@Override
	public void printOutput() {
		System.out.println("Min temp spread is " + m_minTempSpread + " (" + m_maxTemp + " - " + m_minTemp + "), and occurs on day " + m_day);
	}
	
	private int getTempFromString(String tempStr) {
		if (tempStr.endsWith(EXTREME_TEMP_SUFFIX)) {
			tempStr = tempStr.substring(0, tempStr.length() - 1);
		}
		
		return Integer.parseInt(tempStr);
	}
}
