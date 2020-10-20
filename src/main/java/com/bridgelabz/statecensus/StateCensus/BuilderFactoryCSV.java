package com.bridgelabz.statecensus.StateCensus;

public class BuilderFactoryCSV {

	public static ICSVBuilder generateBuilder()
	{
		return new  OpenCSVBuilder();
	}
}
