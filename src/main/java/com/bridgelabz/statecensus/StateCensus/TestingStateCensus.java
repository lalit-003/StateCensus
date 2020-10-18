package com.bridgelabz.statecensus.StateCensus;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;


public class TestingStateCensus {

	  public static String StateCensus_FilePath = "D:\\FileIO\\demo\\StateCensus.csv";

	  StateCensusAnalyzer stateCensusAnalyzer = new StateCensusAnalyzer();
	  Logger logger = Logger.getLogger(StateCensusAnalyzer.class.getName());

	  // Test to check number of entries in csv file using iterator
		@Test
		public void checkingNumberOfStates()
		{
			int count =  StateCensusAnalyzer.readingStateCensusFromCSV(StateCensus_FilePath);
			logger.info("Count is : "+ count);
			Assert.assertEquals(28, count);
		}
}