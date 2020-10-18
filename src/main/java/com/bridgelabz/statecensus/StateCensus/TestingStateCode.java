package com.bridgelabz.statecensus.StateCensus;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

public class TestingStateCode {

	public static String StateCode_FilePath = "D:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\IndianStateCode.csv";

	  StateCodeAnalyzer stateCodeAnalyzer = new StateCodeAnalyzer();
	  Logger logger = Logger.getLogger(StateCodeAnalyzer.class.getName());

	  // Test to check number of entries in csv file using iterator
		@Test
		public void checkingNumberOfStates() throws ExceptionStateCensus
		{
			int count =  StateCodeAnalyzer.readingStateCensusFromCSV(StateCode_FilePath);
			logger.info("Count is : "+ count);
			Assert.assertEquals(37, count);
		}
		
		public static String Wrong_StateCensus_FilePath = "C:\\BridgeLabz-Fellowship\\IndianStatesCensus\\StateCensus\\IndianStateCode.csv";

		 // test to show that program throws exception when given wrong file path 
		@Test
		public void givenWrongFilePathShouldReturnException() throws ExceptionStateCensus
		{
			int count =  StateCensusAnalyzer.readingStateCensusFromCSV(Wrong_StateCensus_FilePath);
			logger.info("Count is : "+ count);
			Assert.assertEquals(28, count);
					}

}
