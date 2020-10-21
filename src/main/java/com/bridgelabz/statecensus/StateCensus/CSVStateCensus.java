package com.bridgelabz.statecensus.StateCensus;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
	@CsvBindByName(column = "State") String stateName;
	@CsvBindByName(column = "Population", required = true)
	private String population;
	@CsvBindByName(column = "AreaInSqKm")
	private String areaInSqKm;
	@CsvBindByName(column = "DensityPerSqKm", required = true)
	private String densityPerSqKm;

	public CSVStateCensus() {

	}

	public CSVStateCensus(String stateName, String population, String areaInSqKm, String densityPerSqKm) {
		super();
		this.stateName = stateName;
		this.population = population;
		this.areaInSqKm = areaInSqKm;
		this.densityPerSqKm = densityPerSqKm;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getAreaInSqKm() {
		return areaInSqKm;
	}

	public void setAreaInSqKm(String areaInSqKm) {
		this.areaInSqKm = areaInSqKm;
	}

	public String getDensityPerSqKm() {
		return densityPerSqKm;
	}

	public void setDensityPerSqKm(String densityPerSqKm) {
		this.densityPerSqKm = densityPerSqKm;
	}

	@Override
	public String toString() {
		return "stateName=" + stateName + ", population=" + population + ", areaInSqKm=" + areaInSqKm
				+ ", densityPerSqKm=" + densityPerSqKm;
	}
}
