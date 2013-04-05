package com.codekata.datamunging.impl;

import com.codekata.datamunging.FileDataMunger;

public class SoccerDataMunger extends FileDataMunger {

	private int m_minGoalDifferential = -1;
	private int m_goalsFor = 0;
	private int m_goalsAgainst = 0;
	private String m_team;
	
	public SoccerDataMunger(String filePath) {
		super(filePath);
	}
	
	@Override
	protected void processData(String[] data) {
		int goalsFor = Integer.parseInt(data[6]);
		int goalsAgainst = Integer.parseInt(data[8]);
		int goalDifferential = Math.abs(goalsFor - goalsAgainst);
		
		if (goalDifferential < m_minGoalDifferential || m_minGoalDifferential == -1) {
			m_minGoalDifferential = goalDifferential;
			
			m_goalsFor = goalsFor;
			m_goalsAgainst = goalsAgainst;
			m_team = data[1];
		}
	}
	
	@Override
	public void printOutput() {
		System.out.println(m_team + " had " + m_goalsFor + " goals scored and " + m_goalsAgainst +
				" goals allowed, which is a differential of " + m_minGoalDifferential);
	}
}
