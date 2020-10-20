package com.bridgelabz.statecensus.StateCensus;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
	@CsvBindByName(column = "State")
    private  String stateName;

    @CsvBindByName(column = "Population")
    private static String population;

    @CsvBindByName(column = "AreaInSqKm")
    private static String areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm")
    private static String densityPerSqKm;

    @Override
    public String toString() {
        return  "stateName='" + stateName +  
                ", population=" + population +
                ", areaInSqKm=" + areaInSqKm +
                ", densityPerSqKm=" + densityPerSqKm ;
    }


	}
