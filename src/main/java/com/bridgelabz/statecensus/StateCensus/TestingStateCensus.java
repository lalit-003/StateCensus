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
		public void checkingNumberOfStates() throws ExceptionStateCensus
		{
			int count =  StateCensusAnalyzer.readingStateCensusFromCSV(StateCensus_FilePath);
			logger.info("Count is : "+ count);
			Assert.assertEquals(28, count);
		}
		// Test to check number of entries in csv file using iterator
		  //Sad Test Case
			@Test
			public void checkingNumberOfStatesSadCase() throws ExceptionStateCensus
			{
				int count =  StateCensusAnalyzer.readingStateCensusFromCSV(StateCensus_FilePath);
				Assert.assertEquals(0,count);
			}

			//

				public static String Wrong_StateCensus_FilePath = "C:\\FileIO\\demo\\StateCensus.csv";
			 // test to show that program throws exception when given wrong file path 
			@Test
			public void givenWrongFilePathShouldReturnException() throws ExceptionStateCensus
			{
				int count =  StateCensusAnalyzer.readingStateCensusFromCSV(Wrong_StateCensus_FilePath);
				logger.info("Count is : "+ count);
				Assert.assertEquals(28, count);
						}
			
			public static String Wrong_StateCensus_FileType = "D:\\FileIO\\demo\\StateCensus.txt";
			 // test to show that program throws exception when given wrong file type
			@Test
			public void givenWrongFileTypeShouldReturnException() throws ExceptionStateCensus
			{
				int count =  StateCensusAnalyzer.readingStateCensusFromCSV(Wrong_StateCensus_FileType);
				logger.info("Count is : "+ count);
				Assert.assertEquals(28, count);
						}

}